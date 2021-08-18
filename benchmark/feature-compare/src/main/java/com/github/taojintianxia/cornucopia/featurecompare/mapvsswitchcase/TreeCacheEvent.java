package com.github.taojintianxia.cornucopia.featurecompare.mapvsswitchcase;


public class TreeCacheEvent
{
    private final Type type;

    public TreeCacheEvent(Type type)
    {
        this.type = type;
    }

    /**
     * Type of change
     */
    public enum Type
    {

        NODE_ADDED,

        NODE_UPDATED,

        NODE_REMOVED,

        CONNECTION_SUSPENDED,

        CONNECTION_RECONNECTED,

        CONNECTION_LOST,

        INITIALIZED
    }

    /**
     * @param type event type
     * @param data event data or null
     */

    /**
     * @return change type
     */
    public Type getType()
    {
        return type;
    }
}
