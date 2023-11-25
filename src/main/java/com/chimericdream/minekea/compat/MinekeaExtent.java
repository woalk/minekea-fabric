package com.chimericdream.minekea.compat;

import com.chimericdream.minekea.block.building.beams.GenericBeamBlock;
import com.chimericdream.minekea.block.furniture.shutters.OpenShutterHalf;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.extent.AbstractDelegateExtent;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.transform.AffineTransform;
import com.sk89q.worldedit.math.transform.Transform;
import com.sk89q.worldedit.registry.state.BooleanProperty;
import com.sk89q.worldedit.registry.state.DirectionalProperty;
import com.sk89q.worldedit.registry.state.EnumProperty;
import com.sk89q.worldedit.registry.state.Property;
import com.sk89q.worldedit.util.Direction;
import com.sk89q.worldedit.world.block.BlockStateHolder;

public class MinekeaExtent extends AbstractDelegateExtent {
    private final Transform mTransform;

    protected MinekeaExtent(Extent extent, Transform transform) {
        super(extent);
        this.mTransform = transform;
    }

    @Override
    public <T extends BlockStateHolder<T>> boolean setBlock(BlockVector3 location, T block) throws WorldEditException {
        T result = block;
        if (block.getBlockType().getId().contains("/stairs/vertical") &&
                mTransform instanceof AffineTransform &&
                ((AffineTransform) mTransform).isHorizontalFlip()) {
            for (Property<?> property : block.getBlockType().getProperties()) {
                if (property instanceof final DirectionalProperty dirProp) {
                    final Direction value = (Direction) block.getState(property);
                    if (value != null) {
                        Direction newDirection = switch (value) {
                            case NORTH -> Direction.WEST;
                            case WEST -> Direction.SOUTH;
                            case SOUTH -> Direction.EAST;
                            default -> Direction.NORTH;
                        };
                        result = block.with(dirProp, newDirection);
                    }
                }
            }
        } else if (block.getBlockType().getId().contains("furniture/shutters/") &&
                mTransform instanceof AffineTransform &&
                ((AffineTransform) mTransform).isHorizontalFlip()) {
            boolean normalFlip = false;
            for (Property<?> property : block.getBlockType().getProperties()) {
                if (property instanceof final DirectionalProperty dirProp &&
                        dirProp.getName().equals(OpenShutterHalf.WALL_SIDE.getName())) {
                    final Direction value = block.getState(dirProp);
                    if (value.toVector().equals(mTransform.apply(value.toVector()))) {
                        normalFlip = true;
                    }
                    break;
                }
            }
            if (normalFlip) {
                for (Property<?> property : block.getBlockType().getProperties()) {
                    if (property.getName().equals(OpenShutterHalf.HALF.getName())) {
                        final EnumProperty halfProp = (EnumProperty) property;
                        final String value = block.getState(halfProp);
                        if (value != null) {
                            String newValue = value.equals("left") ? "right" : "left";
                            result = block.with(halfProp, newValue);
                        }
                        break;
                    }
                }
            }
        } else if (block.getBlockType().getId().contains("building/beams/") && mTransform instanceof AffineTransform) {
            for (Direction direction : Direction.valuesOf(Direction.Flag.CARDINAL | Direction.Flag.UPRIGHT)) {
                Direction newDir = Direction.findClosest(mTransform.apply(direction.toVector()),
                        Direction.Flag.CARDINAL | Direction.Flag.UPRIGHT);
                if (newDir != null) {
                    result = result.with(directionToBeamProp(newDir), block.getState(directionToBeamProp(direction)));
                }
            }
        }
        return super.setBlock(location, result);
    }

    private BooleanProperty directionToBeamProp(Direction direction) {
        net.minecraft.state.property.BooleanProperty fabricProp = switch (direction) {
            case NORTH -> GenericBeamBlock.CONNECTED_NORTH;
            case SOUTH -> GenericBeamBlock.CONNECTED_SOUTH;
            case EAST -> GenericBeamBlock.CONNECTED_EAST;
            case WEST -> GenericBeamBlock.CONNECTED_WEST;
            case UP -> GenericBeamBlock.CONNECTED_DOWN;
            case DOWN -> GenericBeamBlock.CONNECTED_UP;
            default -> null;
        };
        if (fabricProp != null) {
            return new BooleanProperty(fabricProp.getName(), fabricProp.getValues().stream().toList());
        } else return null;
    }
}
