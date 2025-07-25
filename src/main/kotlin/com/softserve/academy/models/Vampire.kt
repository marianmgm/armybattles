package com.softserve.academy.models


class Vampire(val vampirismPercentage: Int = ModelProps.Vampire.VAMPIRISM_PERCENTAGE) : Warrior(
    stockHealth = ModelProps.Vampire.HEALTH,
    attackPower = ModelProps.Vampire.ATTACK_POWER,
) {

    override fun hits(opponent: WarriorNode) {
        val initialHealth = opponent.warrior.health
        super.hits(opponent)
        val damageDealt = (initialHealth - opponent.warrior.health).coerceAtLeast(0)
        this.heal((damageDealt*vampirismPercentage)/100)
    }
}
