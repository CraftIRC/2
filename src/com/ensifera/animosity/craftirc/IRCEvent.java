/**
 * 
 */
package com.ensifera.animosity.craftirc;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IRCEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    Minebot bot;
    public Mode eventMode;
    public RelayedMessage msgData;

    protected IRCEvent(Mode mode, RelayedMessage message) {
        this.eventMode = mode;
        this.msgData = message;
    }

    public enum Mode {
        JOIN, PART, QUIT, KICK, BAN, MSG, PRIVMSG, ACTION, COMMAND, AUTHED_COMMAND, NICKCHANGE, HANDLED
    }

    public void setHandled(boolean handled) {
        this.eventMode = Mode.HANDLED;
        // Also insert handler plugin's name as sender?
    }

    public boolean isHandled() {
        if (this.eventMode == Mode.HANDLED)
            return true;
        else
            return false;
    }
    
    @Override
    public HandlerList getHandlers() {
        return IRCEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return IRCEvent.handlers;
    }

}
