package com.gdt.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<InventoryRecord> equippable, consumables, materials;

    public Inventory(){
        equippable = new ArrayList<>();
        consumables = new ArrayList<>();
        materials = new ArrayList<>();
    }

    public void addEquippable(InventoryRecord record){
        equippable.add(record);
    }

    public void addConsumable(InventoryRecord record){
        consumables.add(record);
    }

    public void addMaterial(InventoryRecord record){
        materials.add(record);
    }

    public List<InventoryRecord> getEquippable(){
        return new ArrayList<>(equippable);
    }

    public List<InventoryRecord> getConsumables(){
        return new ArrayList<>(consumables);
    }

    public List<InventoryRecord> getMaterials(){
        return new ArrayList<>(materials);
    }


}
