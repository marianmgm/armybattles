package com.softserve.academy.models



class Army {
    private val units: MutableList<Warrior> = mutableListOf()


    val isAlive: Boolean
        get() = units.any { it.isAlive }

    fun addUnit(unit: Warrior) {
        units.add(unit)
    }

    fun getFirstAliveUnit(): Warrior? {
        return units.firstOrNull { it.isAlive }
    }

    fun getAsWarriorNode(): WarriorNode?{
        val aliveUnits=units.filter{it.isAlive}

        return linkToNodes(aliveUnits)
    }

    fun linkToNodes(warriors: List<Warrior>): WarriorNode? {
        if (warriors.isEmpty()) return null
        var current: WarriorNode? = null
        for (warrior in warriors.reversed()) {
            current = WarriorNode(warrior, current)
        }
        return current
    }

}


fun Army.addUnits(n: Int, factory: () -> Warrior) {
    repeat(n) {
        addUnit(factory())
    }
}