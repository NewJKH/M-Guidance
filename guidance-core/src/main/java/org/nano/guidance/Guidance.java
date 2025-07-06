package org.nano.guidance;

import org.bukkit.plugin.java.JavaPlugin;
import org.nano.guidance.infra.GuidanceCommand;

import java.util.Objects;

public final class Guidance extends JavaPlugin {
    /*
        길라잡이 기능

        command

        entity

        ...?
     */
    @Override
    public void onLoad(){
        super.onLoad();
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

    }
    @Override
    public void onEnable() {

        Objects.requireNonNull(getCommand("길라잡이")).setExecutor(new GuidanceCommand());

    }

    @Override
    public void onDisable() {

    }


}
