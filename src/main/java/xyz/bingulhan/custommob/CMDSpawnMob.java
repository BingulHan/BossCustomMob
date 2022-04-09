package xyz.bingulhan.custommob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class CMDSpawnMob implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length>0) {
            try {
                int index = Integer.parseInt(args[0]);

                for (Mob mob : CustomMob.getInstance().mobs) {
                    if (index == CustomMob.getInstance().mobs.indexOf(mob)) {

                        if (sender instanceof Player) {


                            //Mob spawnlama
                            Location location = ((Player) sender).getLocation();
                            Entity entity = location.getWorld().spawnEntity(location, mob.type);
                            entity.setCustomName(mob.name);
                            LivingEntity e = (LivingEntity) entity;
                            e.setMaxHealth(mob.maxHealth);
                            e.setHealth(mob.health);

                            if (mob.helmet != null) e.getEquipment().setHelmet(mob.helmet);
                            if (mob.chesPlate != null) e.getEquipment().setChestplate(mob.chesPlate);
                            if (mob.leggings != null) e.getEquipment().setLeggings(mob.leggings);
                            if (mob.boots != null) e.getEquipment().setBoots(mob.boots);






                            sender.sendMessage(ChatColor.GREEN+"Canlı çağrıldı.");
                        }else {
                            sender.sendMessage(ChatColor.GREEN+"Sadece oyuncular çağırabilir.");
                        }
                        return true;
                    }
                }


                sender.sendMessage(ChatColor.RED+"Bu sırada bir canlı bulunamadı.");

            }catch (Exception exception) {

            }
        }else {
            for (Mob mob : CustomMob.getInstance().mobs) {
                sender.sendMessage(ChatColor.GREEN+""+CustomMob.getInstance().mobs.indexOf(mob)+" "+mob.name);
            }
        }

        return true;
    }
}
