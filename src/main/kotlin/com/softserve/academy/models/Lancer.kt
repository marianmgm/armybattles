package com.softserve.academy.models

import com.softserve.academy.strategy.BasicAttack

class Lancer : Warrior(attack= BasicAttack(6)){

    override fun performAttack(opponent: Warrior, ownArmy: Army?, enemyArmy: Army?) {
        this hits opponent

        if (enemyArmy != null) {
            val aliveEnemies = enemyArmy.getAliveWarriors()
            val index = aliveEnemies.indexOf(opponent)
            if (index != -1 && index + 1 < aliveEnemies.size) {
                val nextEnemy = aliveEnemies[index + 1]


                val halfDamage = this.attack.attackPower(this) / 2


                nextEnemy.health -= halfDamage
            }
        }
    }
}
