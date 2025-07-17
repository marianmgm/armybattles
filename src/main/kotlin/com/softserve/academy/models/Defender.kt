package com.softserve.academy.models

import com.softserve.academy.strategy.BasicAttack
import com.softserve.academy.strategy.BasicDefenseStrategy
import com.softserve.academy.strategy.DefenseStrategy
import com.softserve.academy.strategy.Defensible

class Defender(
    override val defense: DefenseStrategy = BasicDefenseStrategy(2)
) : Warrior(stockHealth=60,attack = BasicAttack(3)), Defensible
