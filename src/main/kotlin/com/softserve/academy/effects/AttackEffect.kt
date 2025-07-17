package com.softserve.academy.effects

import com.softserve.academy.models.Warrior

interface AttackEffects {
    fun applyEffect(attacker:Warrior,defender: Warrior,damageDealt:Int)
}

class VampirismEffect(private val vampirismVal: Int) : AttackEffects {

    fun getVampirismVal(): Int = vampirismVal

    override fun applyEffect(attacker: Warrior, defender: Warrior, damageDealt: Int) {
        if (attacker.health != attacker.stockHealth) {
            val heal = (damageDealt * vampirismVal) / 100
            attacker.health += heal
        }
    }
}


