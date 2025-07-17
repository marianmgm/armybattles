package com.softserve.academy.models

import org.junit.jupiter.api.Assertions.*
import kotlin.div
import kotlin.test.Test

class LancerTest {
    @Test
    fun `Lancer damages the first warrior and second warrior takes half of lancer's full damage`() {
        val lancer = Lancer()
        val lancerFullDamage = lancer.attack.attackPower(lancer)
        val expectedFirstEnemyHealth = Warrior().health - lancerFullDamage
        val expectedSecondEnemyHealth = Warrior().health - lancerFullDamage / 2
        val firstArmy = Army()
        val secondArmy = Army()
        firstArmy.addUnit(lancer)
        val firstEnemy = Warrior()
        val secondEnemy = Warrior()
        secondArmy.addUnit(firstEnemy)
        secondArmy.addUnit(secondEnemy)


        lancer.performAttack(firstEnemy, firstArmy, secondArmy)


        assertEquals(expectedFirstEnemyHealth, firstEnemy.health, "First enemy should take full damage from Lancer")
        assertEquals(expectedSecondEnemyHealth, secondEnemy.health, "Second enemy should take half damage from Lancer")
    }


}