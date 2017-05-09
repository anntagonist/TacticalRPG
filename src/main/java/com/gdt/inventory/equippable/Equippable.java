package com.gdt.inventory.equippable;

import com.gdt.inventory.InventoryItem;
import com.gdt.unit.Unit;

public abstract class Equippable extends InventoryItem{
    //Variables

    //Concrete Methods

    //Abstract Methods
    /**
     * Determines if this Equippable can be equipped by the given unit.
     * @param unit: Unit being passed in for inspection.
     * @return boolean: true if the unit can equip the Equippable, false otherwise.
     */
    public abstract boolean isEquipable(Unit unit);
}
