package com.softserve.academy.models

import com.softserve.academy.strategy.AttackPowerStrategy
import com.softserve.academy.strategy.AttackStrategy

open class Warrior(

    val stockHealth: Int = ModelProps.Warrior.HEALTH,
    val attackPower: AttackPowerStrategy = ModelProps.Warrior.ATTACK_POWER,
    val attackStrategy: AttackStrategy = ModelProps.Warrior.ATTACK_TYPE_STRATEGY

) {
    var health = stockHealth
        protected set

    val isAlive: Boolean
        get() = health > 0

    fun heal(healValue: Int) {

        health += healValue
        if (health > stockHealth) health = stockHealth
    }

    open fun acceptDamage(damage: Int) {
        health -= damage
        if (health <= 0) health = 0
    }

    open fun hits(opponent: WarriorNode) {
        println("Stats Before Attacking ${this.toString()}")
        attackStrategy.attack(this, opponent)
        println("Stats After Attacking ${this.toString()}")
    }

    override fun toString(): String {
        return "Name:${(this::class).simpleName} Health:$health AttackPower:${attackPower.attackPower(this)}"
    }
}



