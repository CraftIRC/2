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
    private ConsoleCommandSender sender;

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
        sender.abandonConversation(conversation);
    }

    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        this.sender.abandonConversation(conversation, details);
    }

    public void acceptConversationInput(String input) {
        sender.acceptConversationInput(input);
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        return sender.addAttachment(plugin);
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return sender.addAttachment(plugin, ticks);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return sender.addAttachment(plugin, name, value);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return sender.addAttachment(plugin, name, value, ticks);
    }

    public boolean beginConversation(Conversation conversation) {
        return sender.beginConversation(conversation);
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return sender.getEffectivePermissions();
    }

    public String getName() {
        return sender.getName();
    }

    public Server getServer() {
        return sender.getServer();
    }

    public boolean hasPermission(Permission perm) {
        return sender.hasPermission(perm);
    }

    public boolean hasPermission(String name) {
        return sender.hasPermission(name);
    }

    public boolean isConversing() {
        return sender.isConversing();
    }

    public boolean isOp() {
        return this.op;
    }

    public boolean isPermissionSet(Permission perm) {
        return sender.isPermissionSet(perm);
    }

    public boolean isPermissionSet(String name) {
        return sender.isPermissionSet(name);
    }

    public boolean isPlayer() {
        return false;
    }

    public void recalculatePermissions() {
        sender.recalculatePermissions();
    }

    public void removeAttachment(PermissionAttachment attachment) {
        sender.removeAttachment(attachment);
    }

    public void sendMessage(String message) {
        try {
            ircConCmd.getPlugin().sendMessageToTag(">> " + message, ircConCmd.srcChannelTag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String[] messages) {
        try {
            for (String message : messages) {
                ircConCmd.getPlugin().sendMessageToTag(">> " + message, ircConCmd.srcChannelTag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendRawMessage(String message) {
        try {
            ircConCmd.getPlugin().sendMessageToTag(">> " + message, ircConCmd.srcChannelTag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOp(boolean value) {
        sender.setOp(value);
    }
}
