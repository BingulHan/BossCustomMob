package xyz.bingulhan.custommob;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Mob {

    String name;
    int maxHealth;
    int health;
    EntityType type;

    ItemStack helmet;
    ItemStack chesPlate;
    ItemStack leggings;
    ItemStack boots;

    public Mob(String name, int maxHealth, int health, EntityType type) {


        this.name=name;
        this.maxHealth=maxHealth;
        this.health=health;
        this.type=type;

    }

    public Mob(String name, int maxHealth, int health, EntityType type, ArrayList<ItemStack> items) {


        this.name=name;
        this.maxHealth=maxHealth;
        this.health=health;
        this.type=type;

        for (int i=0;i<4;i++) {
            if (i==0) helmet = items.get(i);
            if (i==1) chesPlate = items.get(i);
            if (i==2) leggings = items.get(i);
            if (i==3) boots = items.get(i);
        }
    }




}
