package xyz.bingulhan.custommob;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CustomMob extends JavaPlugin {

    private static CustomMob instance;

    //Sunucudaki aktif olan mob türlerini tutan liste.
    public ArrayList<Mob> mobs =new ArrayList<>();

    @Override
    public void onEnable() {
        instance=this;



        //Örnek bir mob.
        ArrayList<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(Material.CHAINMAIL_HELMET));
        items.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        items.add(new ItemStack(Material.DIAMOND_LEGGINGS));
        items.add(new ItemStack(Material.DIAMOND_BOOTS));
        mobs.add(new Mob(ChatColor.RED +"Zindan İskeleti", 100, 75, EntityType.SKELETON, items));

        //


        getCommand("spawnmob").setExecutor(new CMDSpawnMob());




        /*

        Test etmek için oluşturulan bir listener.

        getServer().getPluginManager().registerEvents(new Listener() {

            @EventHandler
            public void event(EntityDamageByEntityEvent e) {
                if (e.getDamager() instanceof Player) {
                    LivingEntity er = (LivingEntity) e.getEntity();

                    e.getDamager().sendMessage("Entity tipi: "+e.getEntity().getType()+" Canı: "+er.getHealth()+" Max Canı: "+er.getMaxHealth());


                }
            }
        }, this); */

    }

    public static CustomMob getInstance() {
        return instance;
    }
}
