package com.softserve.academy.strategy

interface Defensible {
    val defense: DefenseStrategy
}

interface DefenseStrategy {
    fun absorbDamage(damage: Int): Int
}

class BasicDefenseStrategy(private val defense: Int) : DefenseStrategy {
    override fun absorbDamage(damage: Int): Int = maxOf(0, damage - defense)
}
