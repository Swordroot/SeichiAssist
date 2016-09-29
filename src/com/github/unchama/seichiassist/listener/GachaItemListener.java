package com.github.unchama.seichiassist.listener;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.unchama.seichiassist.SeichiAssist;
import com.github.unchama.seichiassist.data.Mana;
import com.github.unchama.seichiassist.data.PlayerData;

public class GachaItemListener implements Listener {
	HashMap<UUID,PlayerData> playermap = SeichiAssist.playermap;
	private SeichiAssist plugin = SeichiAssist.plugin;
	@EventHandler
	public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent e){
		Player player = e.getPlayer();
		PlayerData playerdata = playermap.get(player.getUniqueId());
		int level = playerdata.level;
		Mana mana = playerdata.activeskilldata.mana;
		ItemStack i = e.getItem();
		Material m = i.getType();
		ItemMeta itemmeta = i.getItemMeta();
		if(!itemmeta.hasLore())return;
		List<String> lore = itemmeta.getLore();


		if(itemmeta.getLore().contains("マナ完全回復")){
		mana.fullMana(player,level);
		player.playSound(player.getLocation(),Sound.ENTITY_WITCH_DRINK, 1.0F, 1.2F);
		}

	}
}
