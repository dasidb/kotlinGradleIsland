
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TestInventory (){


    @Test
    fun addMoreThanMaxStackSize(){
        val inventory = Inventory()
        inventory.addItemToInventory(Item(0, "Wood", "", 29),35)
        assertEquals(29,inventory.playerItemMap.get(0)?.count)
    }
    
    @Test
    fun addItemToInventoryInASpecificAmount(){
        val inventory = Inventory()
        inventory.addItemToInventory(Item(0, "Wood", "", 20),5)
        assertEquals(5,inventory.playerItemMap.get(0)?.count)
    }

    @Test
    fun addItemToInventory(){
        val inventory = Inventory()
        inventory.addItemToInventory(Item(0, "Wood", "", 20),5)
        assertEquals(1,inventory.playerItemMap.size)
    }

    @Test
    fun returnsString(){
        var test : TestJUnit = TestJUnit()
        var msg = "hallo"
        var newMsg = test.returnAString(msg)
        assertEquals(msg +"12", newMsg)
    }

    @Test
    fun cantremoveItemFromInventory(){
        var inventory = Inventory()
        var item1 = Item(0, "Wood", "", 20)
        inventory.addItemToInventory(item1,20)
        inventory.removeItemFromInventory(item1,25)
        assertEquals(20,inventory.playerItemMap.get(0)?.count)
    }

    @Test
    fun removeItemFromInventory() {
        var inventory = Inventory()
        var item1 = Item(0, "Wood", "", 20)
        inventory.addItemToInventory(item1, 20)
        inventory.removeItemFromInventory(item1, 20)
        assertNull(inventory.playerItemMap.get(item1.id))
    }
    @Test
    fun removeItemAmountFromInventory(){
        var inventory = Inventory()
        var item1 = Item(0, "Wood", "", 20)
        inventory.addItemToInventory(item1,20)
        inventory.removeItemFromInventory(item1,15)
        assertEquals(5,inventory.playerItemMap.get(0)?.count)
    }

}