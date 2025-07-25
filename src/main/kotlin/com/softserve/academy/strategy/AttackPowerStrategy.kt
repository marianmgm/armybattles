package com.softserve.academy.strategy

import com.softserve.academy.models.Warrior


interface AttackPowerStrategy {
    fun attackPower(attacker: Warrior): Int
    fun getAttackValue(): Int
}

class BasicAttackPowerStrategy(private val power: Int) : AttackPowerStrategy {

    override fun attackPower(attacker: Warrior): Int = power

    override fun getAttackValue(): Int = power

}
