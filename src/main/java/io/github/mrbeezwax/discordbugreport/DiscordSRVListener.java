package io.github.mrbeezwax.discordbugreport;

import github.scarsz.discordsrv.api.ListenerPriority;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.*;
import org.bukkit.Bukkit;

public class DiscordSRVListener {
    @Subscribe(priority = ListenerPriority.MONITOR)
    public void discordMessageReceived(DiscordGuildMessageReceivedEvent event) {
        // Bukkit.getLogger().info("Received a chat message on Discord: " + event.getMessage());
    }

    @Subscribe(priority = ListenerPriority.MONITOR)
    public void aMessageWasSentInADiscordGuildByTheBot(DiscordGuildMessageSentEvent event) {
        // Bukkit.getLogger().info("A message was sent to Discord: " + event.getMessage());
    }

    @Subscribe
    public void accountsLinked(AccountLinkedEvent event) {
        Bukkit.broadcastMessage(event.getPlayer().getName() + " just linked their MC account to their Discord user " + event.getUser() + "!");
    }

    @Subscribe
    public void discordMessageProcessed(DiscordGuildMessagePostProcessEvent event) {
        // event.setProcessedMessage(event.getProcessedMessage().replace("cat", "dog")); // dogs are superior to cats, obviously
    }
}
