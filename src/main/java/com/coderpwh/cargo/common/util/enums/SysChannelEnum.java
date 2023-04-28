package com.coderpwh.cargo.common.util.enums;

/**
 * @author coderpwh
 * @date 2023/4/28 11:10
 */
public enum SysChannelEnum {
    APP(1),
    BPAPP(2),
    WEB(3),
    VM(4),
    WXMINI(5);

    private Integer channel;

    private SysChannelEnum(Integer channel) {
        this.channel = channel;
    }

    public static SysChannelEnum getByChannel(Integer channel) {
        SysChannelEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SysChannelEnum sysChannelEnum = var1[var3];
            if (sysChannelEnum.getChannel().equals(channel)) {
                return sysChannelEnum;
            }
        }

        return null;
    }

    public static SysChannelEnum matchChannel(String channelName) {
        SysChannelEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SysChannelEnum sysChannel = var1[var3];
            if (sysChannel.name().equalsIgnoreCase(channelName)) {
                return sysChannel;
            }
        }

        return null;
    }

    public Integer getChannel() {
        return this.channel;
    }
}
