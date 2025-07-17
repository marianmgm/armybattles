package com.softserve.academy.models



class Army {
    private val aliveTroops = ArrayDeque<Warrior>()
    private val deadTroops = ArrayDeque<Warrior>()

    fun addUnit(warrior: Warrior) = aliveTroops.addLast(warrior)

    fun markFrontlinerIfDead() {
        if (aliveTroops.isNotEmpty() && !aliveTroops.first().isAlive) {
            val deadWarrior = aliveTroops.removeFirst()
            deadTroops.addLast(deadWarrior)
        }
    }


    val isAlive: Boolean
        get() = aliveTroops.isNotEmpty()


    val champion: Warrior
        get() = aliveTroops.firstOrNull() ?: throw Exception("No champion found")


    fun getAliveWarriors(): List<Warrior> = aliveTroops.toList()


    fun revive(amount: Int) {
        repeat(amount) {
            val revived = deadTroops.removeFirstOrNull() ?: return
            revived.revive()
            aliveTroops.addLast(revived)
        }
    }

}


fun Army.addUnits(n: Int, factory: () -> Warrior) {
    repeat(n) {
        addUnit(factory())
    }
}