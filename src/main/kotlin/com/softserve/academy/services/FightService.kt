package com.softserve.academy.services

import com.softserve.academy.models.Army
import com.softserve.academy.models.Warrior


object FightService {

    fun fight(first: Warrior, second: Warrior, firstArmy: Army? = null, secondArmy: Army? = null): Boolean {
        while (first.isAlive && second.isAlive) {
            println("first attacker stats before attacking-${first.toString()}")
            first.performAttack(second, firstArmy, secondArmy)
            println("first attacker stats after attacking-${first.toString()}")
            if (second.isAlive) {
                println("second attacker stats before attacking-${second.toString()}")
                second.performAttack(first, secondArmy, firstArmy)
                println("second attacker stats after attacking-${second.toString()}")
            }
        }
        return first.isAlive
    }

    fun fight(firstArmy: Army, secondArmy: Army): Boolean {
        while (firstArmy.isAlive && secondArmy.isAlive) {
            val firstChampion = firstArmy.champion
            val secondChampion = secondArmy.champion

            fight(firstChampion, secondChampion, firstArmy, secondArmy)

            println("First Army status:")
            firstArmy.getAliveWarriors().forEach { println(it) }

            println("Second Army status:")
            secondArmy.getAliveWarriors().forEach { println(it) }

            firstArmy.markFrontlinerIfDead()
            secondArmy.markFrontlinerIfDead()
        }

        return firstArmy.isAlive
    }
}