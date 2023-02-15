package com.chimericdream.minekea.compat;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.event.extent.EditSessionEvent;
import com.sk89q.worldedit.math.transform.Transform;
import com.sk89q.worldedit.util.eventbus.Subscribe;

public class WorldEditCompat {
    private static WorldEditCompat INSTANCE;

    private WorldEditCompat() {
    }

    public static WorldEditCompat getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorldEditCompat();
        }
        return INSTANCE;
    }

    public void register() {
        WorldEdit.getInstance().getEventBus().register(this);
    }

    @Subscribe
    public void onEditSessionEvent(EditSessionEvent event) {
        if (event.getStage() == EditSession.Stage.BEFORE_CHANGE) try {
            LocalSession sessionManager = WorldEdit.getInstance().getSessionManager().get(event.getActor());
            Transform transform = sessionManager.getClipboard().getTransform();
            if (!transform.isIdentity()) {
                event.setExtent(new MinekeaExtent(event.getExtent(), transform));
            }
        } catch (EmptyClipboardException e) {
        }
    }
}
