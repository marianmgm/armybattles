package com.softserve.academy.models

import com.softserve.academy.strategy.BasicAttack

class Knight: Warrior(attack= BasicAttack(7))
