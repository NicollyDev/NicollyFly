package me.nicolly.common.utils;

import net.md_5.bungee.api.ChatColor;

public class Text {

	public static String toString(Object text) {
		return ChatColor.translateAlternateColorCodes('&', text.toString());
	}
	
}
