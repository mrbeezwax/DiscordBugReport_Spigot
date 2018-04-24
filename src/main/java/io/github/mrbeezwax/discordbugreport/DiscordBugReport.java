package io.github.mrbeezwax.discordbugreport;

import org.bukkit.plugin.java.JavaPlugin;
import github.scarsz.discordsrv.DiscordSRV;

public final class DiscordBugReport extends JavaPlugin {

    private DiscordSRVListener discordsrvListener = new DiscordSRVListener();

    @Override
    public void onEnable() {
        // Plugin startup logic
        DiscordSRV.api.subscribe(discordsrvListener);
        getCommand("bugreport").setExecutor(new BugReportCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        DiscordSRV.api.unsubscribe(discordsrvListener);
    }
}
