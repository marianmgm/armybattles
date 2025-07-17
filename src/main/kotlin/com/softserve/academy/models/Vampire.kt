package com.softserve.academy.models

import com.softserve.academy.effects.VampirismEffect
import com.softserve.academy.strategy.BasicAttack


class Vampire : Warrior(
    stockHealth = 40,
    attack = BasicAttack(4),
    effects = mutableListOf(VampirismEffect(50))
)
