package com.gdt.inventory;

import com.gdt.inventory.consumable.Consumable;
import com.gdt.inventory.equippable.Equippable;
import com.gdt.inventory.material.Material;

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
        if(record.getItem().getClass().equals(Equippable.class) && !equippable.contains(record))
            equippable.add(record);
    }

    public InventoryItem removeEquippable(InventoryRecord record){
       return getItem(equippable, record);
    }

    public void addConsumable(InventoryRecord record){
        if(record.getItem().getClass().equals(Consumable.class) && !consumables.contains(record))
            consumables.add(record);
    }

    public InventoryItem removeConsumable(InventoryRecord record){
        return getItem(consumables, record);
    }

    public void addMaterial(InventoryRecord record){
        if(record.getItem().getClass().equals(Material.class) && !materials.contains(record))
            materials.add(record);
    }

    public InventoryItem removeMaterial(InventoryRecord record){
        return getItem(materials, record);
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

    private InventoryItem getItem(List<InventoryRecord> records, InventoryRecord record){
        int index = records.indexOf(record);
        return records.remove(index).getItem();
    }
}
