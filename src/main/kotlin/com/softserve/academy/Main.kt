package com.softserve.academy

import com.softserve.academy.models.Army
import com.softserve.academy.models.Defender
import com.softserve.academy.models.Knight
import com.softserve.academy.models.Lancer
import com.softserve.academy.models.Vampire
import com.softserve.academy.models.Warrior
import com.softserve.academy.models.addUnits
import com.softserve.academy.services.FightService.fight


fun main() {

    // Warrior and Knight smoke test
    val warriorA = Warrior()
    val warriorB = Warrior()
    check(fight(warriorA, warriorB) == true) { "Warrior should win Warrior" }
    check(warriorA.isAlive) { "Warrior winner should be alive" }
    check(!warriorB.isAlive) { "Warrior defeated should not be alive" }

    val warriorC = Warrior()
    val knightA = Knight()
    check(fight(warriorC, knightA) == false) { "Warrior should lose to Knight" }
    check(knightA.isAlive) { "Knight winner should be alive" }
    check(!warriorC.isAlive) { "Warrior defeated should not be alive" }
    println("Warrior and Knight smoke test-OK")

    // Defender Smoke test
    val warriorD = Warrior()
    val warriorE = Warrior()
    val knightB = Knight()
    val warriorF = Warrior()
    val warriorG = Warrior()
    val defenderA = Defender()
    val knightC = Knight()
    val warriorH = Warrior()
    val defenderB = Defender()

    check(fight(warriorD, warriorE) == true)
    check(fight(warriorF, knightB) == false)
    check(warriorD.isAlive)
    check(!warriorE.isAlive)
    check(knightB.isAlive)
    check(!warriorF.isAlive)
    check(fight(knightB, warriorG) == false)
    check(!knightB.isAlive)
    check(fight(defenderA, knightC) == false)
    check(fight(defenderB, warriorH) == true)

    val myArmyDefender = Army()
    myArmyDefender.addUnits(1) { Defender() }

    val enemyArmyDefender = Army()
    enemyArmyDefender.addUnits(2) { Warrior() }

    val armyDefender1 = Army()
    armyDefender1.addUnits(1) { Warrior() }
    armyDefender1.addUnits(1) { Defender() }

    val armyDefender2 = Army()
    armyDefender2.addUnits(2) { Warrior() }

    check(fight(myArmyDefender, enemyArmyDefender) == false)
    check(fight(armyDefender1, armyDefender2) == true)
    println("Defender Smoke test-OK")

    // Vampire smoke test
    val warriorI = Warrior()
    val warriorJ = Warrior()
    val knightD = Knight()
    val warriorK = Warrior()
    val warriorL = Warrior()
    val defenderC = Defender()
    val knightE = Knight()
    val warriorM = Warrior()
    val defenderD = Defender()
    val vampireA = Vampire()
    val vampireB = Vampire()
    val defenderE = Defender()
    val warriorN = Warrior()

    check(fight(warriorI, warriorJ) == true)
    check(fight(warriorK, knightD) == false)
    check(warriorI.isAlive)
    check(!warriorJ.isAlive)
    check(knightD.isAlive)
    check(!warriorK.isAlive)
    check(fight(knightD, warriorL) == false)
    check(!knightD.isAlive)
    check(fight(defenderC, knightE) == false)
    check(fight(defenderD, warriorM) == true)
    check(fight(vampireA, defenderE) == false)
    check(fight(warriorN, vampireB) == true)

    val myArmyVampire = Army().apply {
        addUnits(2) { Defender() }
        addUnits(2) { Vampire() }
        addUnits(1) { Warrior() }
    }

    val enemyArmyVampire = Army().apply {
        addUnits(2) { Warrior() }
        addUnits(2) { Defender() }
        addUnits(3) { Vampire() }
    }

    val armyVampire1 = Army().apply {
        addUnits(1) { Warrior() }
        addUnits(4) { Defender() }
    }

    val armyVampire2 = Army().apply {
        addUnits(3) { Vampire() }
        addUnits(2) { Warrior() }
    }

    check(fight(myArmyVampire, enemyArmyVampire) == false)
    check(fight(armyVampire1, armyVampire2) == true)
    println("Vampire smoke test-OK")


    // Lancer smoke test
    val chuck = Warrior()
    val bruce = Warrior()
    val carl = Knight()
    val dave = Warrior()
    val mark = Warrior()
    val bob = Defender()
    val mike = Knight()
    val rog = Warrior()
    val lancelot = Defender()
    val eric = Vampire()
    val adam = Vampire()
    val richard = Defender()
    val ogre = Warrior()
    val freelancer = Lancer()
    val vampire = Vampire()

    check(fight(chuck, bruce) == true)
    check(fight(dave, carl) == false)
    check(chuck.isAlive == true)
    check(bruce.isAlive == false)
    check(carl.isAlive == true)
    check(dave.isAlive == false)
    check(fight(carl, mark) == false)
    check(carl.isAlive == false)
    check(fight(bob, mike) == false)
    check(fight(lancelot, rog) == true)
    check(fight(eric, richard) == false)
    check(fight(ogre, adam) == true)
    check(fight(freelancer, vampire) == true)
    check(freelancer.isAlive == true)

    val myArmy = Army()
    myArmy.addUnits(2) { Defender() }
    myArmy.addUnits(2) { Vampire() }
    myArmy.addUnits(4) { Lancer() }
    myArmy.addUnits(1) { Warrior() }

    val enemyArmy = Army()
    enemyArmy.addUnits(2) { Warrior() }
    enemyArmy.addUnits(2) { Lancer() }
    enemyArmy.addUnits(2) { Defender() }
    enemyArmy.addUnits(3) { Vampire() }

    val army3 = Army()
    army3.addUnits(1) { Warrior() }
    army3.addUnits(1) { Lancer() }
    army3.addUnits(2) { Defender() }

    val army4 = Army()
    army4.addUnits(3) { Vampire() }
    army4.addUnits(1) { Warrior() }
    army4.addUnits(2) { Lancer() }

    check(fight(myArmy, enemyArmy) == true)
    check(fight(army3, army4) == false)
    println("Lancer smoke test-OK")

}
