import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import softserve.academy.*

class BattleTest {
    @Test
    @DisplayName("1. Battle")
    fun `Army with 1 Warrior loses to Army with 2 Warriors`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(1) { Warrior() }
        army2.addUnits(2) { Warrior() }
        
        val result = fight(army1, army2)
        
        assertFalse(result)
    }
    
    @Test
    @DisplayName("2. Battle")
    fun `Army with 2 Warriors loses to Army with 3 Warriors`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Warrior() }
        army2.addUnits(3) { Warrior() }
        
        val result = fight(army1, army2)
        
        assertFalse(result)
    }
    
    @Test
    @DisplayName("3. Battle")
    fun `Army with 5 Warriors loses to Army with 7 Warriors`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Warrior() }
        army2.addUnits(7) { Warrior() }
        
        val result = fight(army1, army2)
        
        assertFalse(result)
    }
    
    @Test
    @DisplayName("4. Battle")
    fun `Army with 20 Warriors loses to Army with 21 Warriors`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }
        
        val result = fight(army1, army2)
        
        assertTrue(result)
    }
    
    @Test
    @DisplayName("5. Battle")
    fun `Army with 10 Warriors loses to Army with 11 Warriors`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Warrior() }
        army2.addUnits(11) { Warrior() }
        
        val result = fight(army1, army2)
        
        assertTrue(result)
    }
    
    @Test
    @DisplayName("6. Battle")
    fun `Army with 11 Warriors defeats Army with 7 Warriors`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(11) { Warrior() }
        army2.addUnits(7) { Warrior() }
        
        val result = fight(army1, army2)
        
        assertTrue(result)
    }
}