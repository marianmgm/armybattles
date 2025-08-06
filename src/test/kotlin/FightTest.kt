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
    @Test
    @DisplayName("2. Fight")
    fun `Knight wins against Warrior`() {
        val ramon = Knight()
        val slevin = Warrior()
        val result = fight(ramon, slevin)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("3. Fight")
    fun `One Warrior stays alive after fight`() {
        val bob = Warrior()
        val mars = Warrior()
        fight(bob, mars)
        assertTrue(bob.isAlive)
    }

    @Test
    @DisplayName("4. Fight")
    fun `Knight survives after fight with Warrior`() {
        val zeus = Knight()
        val godkiller = Warrior()
        fight(zeus, godkiller)
        assertTrue(zeus.isAlive)
    }

    @Test
    @DisplayName("5. Fight")
    fun `One Warrior dies after fighting another Warrior`() {
        val husband = Warrior()
        val wife = Warrior()
        fight(husband, wife)
        assertFalse(wife.isAlive)
    }

    @Test
    @DisplayName("6. Fight")
    fun `Knight survives after fighting Warrior`() {
        val dragon = Warrior()
        val knight = Knight()
        fight(dragon, knight)
        assertTrue(knight.isAlive)
    }

    @Test
    @DisplayName("7. Fight")
    fun `Knight dies after fighting two Warriors sequentially`() {
        val unit1 = Warrior()
        val unit2 = Knight()
        val unit3 = Warrior()
        fight(unit1, unit2)
        val result = fight(unit2, unit3)
        assertEquals(false, result)
    }
}
