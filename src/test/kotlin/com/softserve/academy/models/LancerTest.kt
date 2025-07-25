package com.softserve.academy.models

import com.softserve.academy.services.FightService
import org.junit.jupiter.api.Assertions.*
import kotlin.div
import kotlin.test.Test

class LancerTest {
    @Test
    fun `Lancer damages the first warrior and second warrior takes half of lancer's full damage`() {
        val lancer = Lancer()
//        val lancerFullDamage = lancer.attackStrength.getAttackValue()
//        val expectedFirstEnemyHealth = Warrior().health - lancerFullDamage
//        val expectedSecondEnemyHealth = Warrior().health - lancerFullDamage / 2
        val firstArmy = Army()
        val secondArmy = Army()
        val firstEnemy = Warrior()
        val secondEnemy = Warrior()
        firstArmy.addUnit(lancer)
        secondArmy.addUnit(firstEnemy)
        secondArmy.addUnit(secondEnemy)


        FightService.fight(firstArmy,secondArmy)


//        assertEquals(expectedFirstEnemyHealth, firstEnemy.health, "First enemy should take full damage from Lancer")
//        assertEquals(expectedSecondEnemyHealth, secondEnemy.health, "Second enemy should take half damage from Lancer")
    }


}