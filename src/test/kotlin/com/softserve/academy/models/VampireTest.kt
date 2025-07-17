package com.softserve.academy.models

import com.softserve.academy.effects.VampirismEffect
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test
import kotlin.times

class VampireTest {

    @Test
    fun `vampire heals for 50 percent of actual damage dealt`() {

        val vampire = Vampire()
        val defender = Defender()

        // vampire takes damage
        defender.performAttack(vampire)
        val initialHealthAfterTakingDamage = vampire.health

        // vamp attacks defender
        vampire.performAttack(defender)

        // expected damage after defender defense absorbs it
        val vampireAttackPower = vampire.attack.attackPower(vampire)
        val expectedDamageToDefender = defender.defense.absorbDamage(vampireAttackPower)

        val vampirismEffect = vampire.effects.find { it is VampirismEffect } as? VampirismEffect
        requireNotNull(vampirismEffect) { "vampirism not found on vampire effects" }

        val vampirismPercentage = vampirismEffect.getVampirismVal()
        val expectedHeal = (expectedDamageToDefender * vampirismPercentage) / 100

        val expectedVampireHealth = initialHealthAfterTakingDamage + expectedHeal

        println("expected heal: $expectedHeal")
        println("expected vampire health: $expectedVampireHealth")
        println("actual vampire health: ${vampire.health}")

        assertEquals(expectedVampireHealth, vampire.health)
//
//        val vampire = Vampire()
//        val defender = Defender()
//
//        defender.performAttack(vampire)
//        val initialHealthAfterTakingDamage = vampire.health
//        vampire.performAttack(defender)
//        val vampireAttackPower = vampire.attack.attackPower(vampire)
//        val expectedDamageToDefender = defender.defense.absorbDamage(vampireAttackPower)
//        val vampirismEffect = vampire.effects.find { it is VampirismEffect } as? VampirismEffect
//        requireNotNull(vampirismEffect) { "vampirism not found on vampire effects" }
//        val vampirismPercentage = vampirismEffect.getVampirismVal()
//        val expectedHeal = (expectedDamageToDefender * vampirismPercentage) / 100
//        val expectedVampireHealth = initialHealthAfterTakingDamage + expectedHeal
//
//        assertEquals(expectedVampireHealth, vampire.health)

    }


}