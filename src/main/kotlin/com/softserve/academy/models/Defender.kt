package com.softserve.academy.models

import com.softserve.academy.strategy.DefenseStrategy

class Defender(
    val defenseStrategy: DefenseStrategy = ModelProps.Defender.DEFENSE_STRATEGY
) : Warrior(
    stockHealth = ModelProps.Defender.HEALTH,
    attackPower = ModelProps.Defender.ATTACK_POWER
) {

    override fun acceptDamage(damage: Int) {
        super.acceptDamage(defenseStrategy.absorbDamage(damage))
    }

    override fun toString(): String {
        return "Name:${(this::class).simpleName} Health:$health AttackPower:${attackPower.getAttackValue()} Defense:${defenseStrategy.getDefenseValue()}"
    }
}
