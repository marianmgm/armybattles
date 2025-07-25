package com.softserve.academy.services

import com.softserve.academy.models.Army
import com.softserve.academy.models.Warrior
import com.softserve.academy.models.WarriorNode


object FightService {

    fun fight(firstWarrior: Warrior, secondWarrior: Warrior): Boolean {
        while (firstWarrior.isAlive && secondWarrior.isAlive) {

            firstWarrior.hits(WarriorNode(secondWarrior))

            if (secondWarrior.isAlive) {

                secondWarrior.hits(WarriorNode(firstWarrior))

            }

        }
        return firstWarrior.isAlive
    }

    fun fight(firstArmy: Army, secondArmy: Army): Boolean {
        while (firstArmy.isAlive && secondArmy.isAlive) {
            val first = firstArmy.getFirstAliveUnit()
            val second = secondArmy.getFirstAliveUnit()

            if (first != null && second != null) {
                val secondNode = secondArmy.getAsWarriorNode()!!

                first.hits(secondNode)

                if (second.isAlive) {
                    val firstNode = firstArmy.getAsWarriorNode()!!
                    second.hits(firstNode)
                }
            }
        }
        return firstArmy.isAlive
    }
}