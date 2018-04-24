package io.github.mrbeezwax.discordbugreport;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BugReportCommand implements CommandExecutor{
    DiscordSRV plugin = DiscordSRV.getPlugin();
    DiscordBugReport mainPlugin;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("bugreport")) {
            if (args.length >= 1) {
                if (sender instanceof Player) {
                    // DiscordUtil.sendMessage(DiscordSRV.getPlugin().getMainTextChannel(), String.join(" ", args));
                    DiscordUtil.sendMessage(plugin.getMainTextChannel(), "**:bust_in_silhouette:Player Name:** " + player.getName() + "\n:triangular_flag_on_post:**Bug:** " + String.join(" ", args));
                    player.sendMessage("Your bug report has been submitted.");
                    return true;
                }
                mainPlugin.getLogger().info("Only players can send bug reports.");
                return true;
            }
            player.sendMessage("The bug report cannot be empty.");
            return true;
        }
        return false;
    }
}
