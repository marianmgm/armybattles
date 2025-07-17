package com.softserve.academy.strategy

import com.softserve.academy.models.Warrior


interface AttackStrategy {
    fun attackPower(attacker: Warrior):Int
}

class BasicAttack(private val power: Int) : AttackStrategy {
    override fun attackPower(attacker: Warrior): Int = power
}
