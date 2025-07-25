package com.softserve.academy.models

import com.softserve.academy.strategy.BasicAttackPowerStrategy
import com.softserve.academy.strategy.BasicAttackStrategy
import com.softserve.academy.strategy.BasicDefenseStrategy
import com.softserve.academy.strategy.PiercingAttackStrategy

object ModelProps {

    object Warrior {
        const val HEALTH = 50
        val ATTACK_POWER = BasicAttackPowerStrategy(5)
        val ATTACK_TYPE_STRATEGY = BasicAttackStrategy()
    }

    object Knight {
        const val HEALTH = 50
        val ATTACK_POWER = BasicAttackPowerStrategy(7)
        val ATTACK_TYPE_STRATEGY = BasicAttackStrategy()
    }

    object Defender {
        const val HEALTH = 60
        val ATTACK_POWER = BasicAttackPowerStrategy(3)
        val DEFENSE_STRATEGY = BasicDefenseStrategy(2)
        val ATTACK_TYPE_STRATEGY = BasicAttackStrategy()
    }

    object Vampire {
        const val HEALTH = 40
        val ATTACK_POWER = BasicAttackPowerStrategy(4)
        val ATTACK_TYPE_STRATEGY = BasicAttackStrategy()
        val VAMPIRISM_PERCENTAGE = 50
    }

    object Lancer {
        const val HEALTH = 50
        val ATTACK_POWER = BasicAttackPowerStrategy(6)
        val ATTACK_TYPE_STRATEGY = PiercingAttackStrategy(2, 50)
    }

    object Rookie {
        const val HEALTH = 50
        val ATTACK_POWER = BasicAttackPowerStrategy(1)
        val ATTACK_STRATEGY = BasicAttackStrategy()
    }
}