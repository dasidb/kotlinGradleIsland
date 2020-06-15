import org.junit.jupiter.api.Test
import processing.core.PApplet

class RecipeTest {


    @Test
    fun craftItemWithNoRessourcesLeft(){
        val craftingList: MutableList<Recipe> = ArrayList()
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList3, 300))

        val inventory = Inventory()
        inventory.addItemToInventory(Item(102,"a","a",50,"a"),5)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),2)
       // inventory.addItemToInventory()

        // Craft.craft(inventory, "House"


        assert(inventory.playerItemMap.size == 1)
    }
    @Test
    fun craftItemWithRessourcesLeft(){
        val craftingList: MutableList<Recipe> = ArrayList()
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList3, 300))

        val inventory = Inventory()
        inventory.addItemToInventory(Item(102,"a","a",50,"a"),20)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),20)
    }


}