import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import softserve.academy.Knight
import softserve.academy.Warrior
import softserve.academy.fight
import softserve.academy.isAlive

class FightTest {
    @Test
    fun `Warrior should win over Warrior`() {
        val chuck = Warrior()
        val bruce = Warrior()

        val res = fight(chuck, bruce)

        assertTrue(res) { "Warrior should win Warrior" }
        assertTrue(chuck.isAlive) { "Warrior winner should be alive" }
        assertFalse(bruce.isAlive) { "Warrior defeated should not be alive" }
    }

    @Test
    fun `Warrior should loose to Knight`() {
        val dave = Warrior()
        val carl = Knight()

        val res = fight(dave, carl)

        assertFalse(res) { "Warrior should lose to Knight" }
        assertTrue(carl.isAlive) { "Knight winner should be alive" }
        assertFalse(dave.isAlive) { "Warrior defeated should not be alive" }
    }

    @Test
    @DisplayName("1. Fight")
    fun `Warrior loses when fights against Knight`() {
        val carl = Warrior()
        val jon = Knight()

        val res = fight(carl, jon)

        assertFalse(res) { "Warrior should lose to Knight" }
    }
}