package com.softserve.academy.strategy

import com.softserve.academy.models.Warrior
import com.softserve.academy.models.WarriorNode

interface AttackStrategy {
    fun attack(attacker: Warrior, opponent: WarriorNode)

}

class BasicAttackStrategy : AttackStrategy {
    override fun attack(attacker: Warrior, opponent: WarriorNode) {
        opponent.warrior.acceptDamage(attacker.attackPower.getAttackValue())
    }
}

class PiercingAttackStrategy(
    private val piercingDepth: Int, // Setting piercingDepth to 1 hits only 1 opponent,it doesnt hit the next
    private val damageReductionPercent: Int
) : AttackStrategy {
    override fun attack(attacker: Warrior, opponent: WarriorNode) {
        var currentNode: WarriorNode? = opponent
        var currentDamage = attacker.attackPower.getAttackValue()
        var depth = 0

        while (currentNode != null && depth < piercingDepth && currentDamage > 0) {
            currentNode.warrior.acceptDamage(currentDamage)
            currentNode = currentNode.next
            println("This is the next guy stats:${currentNode?.warrior.toString()}")
            currentDamage = (currentDamage * damageReductionPercent)/100
            depth++
        }
    }
}