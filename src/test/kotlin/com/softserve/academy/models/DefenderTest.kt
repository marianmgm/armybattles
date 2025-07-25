package com.softserve.academy.models

import com.softserve.academy.services.FightService
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class DefenderTest {
    @Test
    fun `Check for defender to not heal himself when defending from Unit that has attack power under the Defense Value`() {
        val defender = Defender()
        val rookie = Rookie()
        val defenderInitialHealth = defender.health


        FightService.fight(defender, rookie)

        assertTrue(defenderInitialHealth == defender.health) {
            """Defender should not heal
                    himself when defending from Unit 
                    that has attack power under the Defense Value"""
        }

    }

    @Test
    fun `Defender fights Rookie then Defender fights Warrior and wins`() {
        val defender = Defender()
        val rookie = Rookie()
        val warrior = Warrior()


        FightService.fight(defender, rookie)
        val res = FightService.fight(defender, warrior)

        assertTrue(res) { "Defender should win against Rookie and after that Defender should win against Warrior" }
    }

}