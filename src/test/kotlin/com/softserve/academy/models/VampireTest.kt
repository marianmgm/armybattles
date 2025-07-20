package com.softserve.academy.models

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class VampireTest {

    @Test
    fun `vampire heals for 50 percent of actual damage dealt`() {

        val vampire = WarriorNode(Vampire())
        val defender = WarriorNode(Defender())


        vampire.warrior.acceptDamage(13)

        val vampireHealthBeforeAttack = vampire.warrior.health
        val defenderHealthBefore = defender.warrior.health


        vampire.warrior.hits(defender)

        val defenderBlockingValue = (defender.warrior as Defender).defenseStrategy.getDefenseValue()
        val vampireAttackPower = vampire.warrior.attackPower.getAttackValue()

        // Actual damage done to defender
        val actualDamageDealt = vampireAttackPower - defenderBlockingValue
        val expectedDamage = maxOf(0, actualDamageDealt)

        val expectedVampireHeal = expectedDamage / 2

        val expectedVampireHealth = minOf(vampireHealthBeforeAttack + expectedVampireHeal, vampire.warrior.stockHealth)
        val expectedDefenderHealth = defenderHealthBefore - expectedDamage

        assertEquals(expectedDefenderHealth, defender.warrior.health)
        assertEquals(expectedVampireHealth, vampire.warrior.health)



    }


}