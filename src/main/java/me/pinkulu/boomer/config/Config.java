package me.pinkulu.boomer.config;

import tk.npecode.config.annotation.ConfigurationClass;
import tk.npecode.config.annotation.Option;

@ConfigurationClass
public class Config {
    @Option
    public static boolean enabled = true;
}
