package com.chimericdream.minekea.compat;

import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.extent.AbstractDelegateExtent;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.Vector3;
import com.sk89q.worldedit.math.transform.AffineTransform;
import com.sk89q.worldedit.math.transform.Transform;
import com.sk89q.worldedit.registry.state.DirectionalProperty;
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
        }
        return super.setBlock(location, result);
    }
}
