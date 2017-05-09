package com.gdt.inventory;

import com.gdt.unit.Unit;

public class InventoryRecord {
    private final InventoryItem item;
    private final Unit owner;

    public InventoryRecord(InventoryItem item, Unit owner){
        this.item = item;
        this.owner = owner;
    }

    public boolean hasOwner(){
        return owner != null;
    }

    public InventoryItem getItem(){
        return item;
    }
}
