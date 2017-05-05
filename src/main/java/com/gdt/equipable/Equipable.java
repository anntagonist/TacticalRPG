package com.gdt.equipable;

import com.gdt.interfaces.Requireable;
import com.gdt.unit.Unit;

public abstract class Equipable implements Requireable<Unit> {
    //Variables
    protected boolean isEquipped;
    protected Unit equippedBy;

    //Concrete Methods

    /**
     *
     * @param unit
     */
    public void equip(Unit unit){
        //Consider Throwing Exception for not being able to equip.
        if(isEquipable(unit)){
            equippedBy = unit;
        }
    }

    //Abstract Methods
    /**
     * Determines if this Equipable can be equipped by the given unit.
     * @param unit: Unit being passed in for inspection.
     * @return boolean: true if the unit can equip the Equipable, false otherwise.
     */
    public abstract boolean isEquipable(Unit unit);
}
