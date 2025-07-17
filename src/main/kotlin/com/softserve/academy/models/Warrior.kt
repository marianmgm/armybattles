package com.softserve.academy.models

import com.softserve.academy.effects.AttackEffects
import com.softserve.academy.strategy.AttackStrategy
import com.softserve.academy.strategy.BasicAttack
import com.softserve.academy.strategy.Defensible

open class Warrior(

    val stockHealth: Int = 50,
    val effects: MutableList<AttackEffects> = mutableListOf(),
    val attack: AttackStrategy = BasicAttack(5),

    var isAlive: Boolean = true

) {
    var health=stockHealth

    open fun performAttack(opponent: Warrior, ownArmy: Army? = null, enemyArmy: Army? = null) {
        this hits opponent
    }

    override fun toString(): String {
        return "${this::class.simpleName}(health=$health, isAlive=$isAlive , effects=$effects ,attack=${attack.attackPower(this)})"
    }
}

fun Warrior.markAsDead() {
    this.isAlive = false
}

fun Warrior.revive() {
    this.health = this.stockHealth
    this.isAlive = true
}

infix fun Warrior.hits(other: Warrior) {
    val damage = this.attack.attackPower(this)
    val finalDamage = if (other is Defensible) {
        other.defense.absorbDamage(damage)
    } else {
        damage
    }
    other.health -= finalDamage
    if (other.health <= 0) {
        other.markAsDead()
    }

    this.effects.forEach { it.applyEffect(attacker = this, defender = other, damageDealt = finalDamage) }

}
