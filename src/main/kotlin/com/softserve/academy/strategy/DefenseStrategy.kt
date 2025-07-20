package com.softserve.academy.strategy

interface DefenseStrategy {
    fun absorbDamage(damage: Int): Int
    fun getDefenseValue(): Int
}

class BasicDefenseStrategy(private val defense: Int) : DefenseStrategy {
    override fun absorbDamage(damage: Int): Int = maxOf(0, damage - defense)
    override fun getDefenseValue(): Int = defense
}
