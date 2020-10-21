package com.synagames.plugins.hnt;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class HNT extends JavaPlugin implements Listener {

    private Scoreboard score;

    @Override
    public void onEnable() {
        score = Bukkit.getScoreboardManager().getMainScoreboard();
        if(score.getTeam("hnt") == null) {
            score.registerNewTeam("hnt");
            score.getTeam("hnt").setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
        }
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Enabled!");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(!score.getTeam("hnt").getEntries().contains(e.getPlayer().getName())) score.getTeam("hnt").addEntry(e.getPlayer().getName());
    }
}
