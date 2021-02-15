package me.nicolly;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import me.nicolly.commands.FlyCMD;
import me.nicolly.common.utils.Text;

public class NicollyFly extends JavaPlugin {

	private static NicollyFly instance;

	@Override
	public void onEnable() {
		logInfo("Iniciando plugin...");
		instance = this;
		registerCommand(new FlyCMD());
		logInfo("Plugin iniciado.");
	}

	@Override
	public void onDisable() {
	}

	public static NicollyFly getInstance() {
		return instance;
	}

	public static Server getBukkitServer() {
		return getInstance().getServer();
	}

	public static CraftServer getCraftServer() {
		return (CraftServer) getBukkitServer();
	}

	public static void registerCommand(Command command) {
		getCraftServer().getCommandMap().register("NicollyFly", command);
		logInfo("Comando registrado: " + command.getName());
	}

	public static void logInfo(Object text) {
		getBukkitServer().getConsoleSender().sendMessage(Text.toString("&f[INFO] " + text));
	}

	public static void logWarn(Object text) {
		getBukkitServer().getConsoleSender().sendMessage(Text.toString("&e[WARN] " + text));
	}

	public static void logError(Object text) {
		getBukkitServer().getConsoleSender().sendMessage(Text.toString("&c[ERROR] " + text));
	}
}
