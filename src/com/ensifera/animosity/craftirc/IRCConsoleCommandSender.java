/**
 * 
 */
package com.ensifera.animosity.craftirc;

import java.util.Set;

import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

/**
 * @author Animosity
 * 
 */
public class IRCConsoleCommandSender implements ConsoleCommandSender {
    private Boolean op = false;
    private RelayedMessage ircConCmd = null;
    private final ConsoleCommandSender sender;

    /**
     * 
     * @param server
     *            - Server
     * @param ircConCmdMsg
     *            - RelayedMessage
     * @param isOp
     *            - Boolean
     */
    public IRCConsoleCommandSender(Server server, RelayedMessage ircConCmd, Boolean isOp, ConsoleCommandSender sender) {
        this.sender = sender;
        this.ircConCmd = ircConCmd;
        this.op = isOp;
    }

    public void abandonConversation(Conversation conversation) {
        this.sender.abandonConversation(conversation);
    }

    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        this.sender.abandonConversation(conversation, details);
    }

    public void acceptConversationInput(String input) {
        this.sender.acceptConversationInput(input);
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        return this.sender.addAttachment(plugin);
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return this.sender.addAttachment(plugin, ticks);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return this.sender.addAttachment(plugin, name, value);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return this.sender.addAttachment(plugin, name, value, ticks);
    }

    public boolean beginConversation(Conversation conversation) {
        return this.sender.beginConversation(conversation);
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return this.sender.getEffectivePermissions();
    }

    public String getName() {
        return this.sender.getName();
    }

    public Server getServer() {
        return this.sender.getServer();
    }

    public boolean hasPermission(Permission perm) {
        return this.sender.hasPermission(perm);
    }

    public boolean hasPermission(String name) {
        return this.sender.hasPermission(name);
    }

    public boolean isConversing() {
        return this.sender.isConversing();
    }

    public boolean isOp() {
        return this.op;
    }

    public boolean isPermissionSet(Permission perm) {
        return this.sender.isPermissionSet(perm);
    }

    public boolean isPermissionSet(String name) {
        return this.sender.isPermissionSet(name);
    }

    public boolean isPlayer() {
        return false;
    }

    public void recalculatePermissions() {
        this.sender.recalculatePermissions();
    }

    public void removeAttachment(PermissionAttachment attachment) {
        this.sender.removeAttachment(attachment);
    }

    public void sendMessage(String message) {
        try {
            this.ircConCmd.getPlugin().sendMessageToTag(">> " + message, this.ircConCmd.srcChannelTag);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String[] messages) {
        try {
            for (final String message : messages) {
                this.ircConCmd.getPlugin().sendMessageToTag(">> " + message, this.ircConCmd.srcChannelTag);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void sendRawMessage(String message) {
        try {
            this.ircConCmd.getPlugin().sendMessageToTag(">> " + message, this.ircConCmd.srcChannelTag);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void setOp(boolean value) {
        this.sender.setOp(value);
    }
}
