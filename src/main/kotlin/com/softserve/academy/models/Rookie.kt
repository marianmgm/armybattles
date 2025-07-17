package com.softserve.academy.models

import com.softserve.academy.strategy.BasicAttack


class Rookie: Warrior(attack = BasicAttack(1)) {
}