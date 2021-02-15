package me.nicolly.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nicolly.common.utils.Text;

public class FlyCMD extends Command {

	public FlyCMD() {
		super("fly");
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Text.toString("&cSomente jogadores podem usar esse comando."));
			return false;
		}
		Player player = (Player) sender;
		if (!player.hasPermission("nicolly.fly")) {
			sender.sendMessage(Text.toString("&cNão tens permissão para usar este comando."));
			return false;
		}
		Player target = player;
		if (args.length == 1) {
			Player find = Bukkit.getPlayer(args[0]);
			if (find != null && find.isOnline())
				target = find;
		}
		target.setAllowFlight(!target.getAllowFlight());
		target.setFlying(!target.isFlying());
		target.sendMessage(Text.toString("&aFly " + (target.getAllowFlight() ? "Ativado" : "Desativado")
				+ (target == player ? "" : (" por " + player.getName()))));
		if (player != target)
			target.sendMessage(Text.toString(
					"&aFly " + (target.getAllowFlight() ? "Ativado" : "Desativado") + " para " + target.getName()));
		return false;
	}

}
