import org.junit.jupiter.api.Test
import processing.core.PApplet
import processing.data.JSONObject
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RecipeTest {


    @Test
    fun craftItemWithNoRessourcesLeft(){
        val globalItemMap  = HashMap<Int, Item>()
        createItemMap(globalItemMap)
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
        val craft = Craft(inventory,globalItemMap)
        craft.craftItem("House")

        assertEquals(1,inventory.playerItemMap.size)
    }
    @Test
    fun craftItemWithOneRessourcesLeft(){
        val globalItemMap  = HashMap<Int, Item>()
        createItemMap(globalItemMap)
        val craftingList: MutableList<Recipe> = ArrayList()
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList3, 300))

        val inventory = Inventory()
        inventory.addItemToInventory(Item(102,"a","a",50,"a"),6)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),2)
        // inventory.addItemToInventory()

        // Craft.craft(inventory, "House"
        val craft = Craft(inventory,globalItemMap)
        craft.craftItem("House")

        assertEquals(2,inventory.playerItemMap.size)
    }

    @Test
    fun craftItemWithTwoRessourcesLeft(){
        val globalItemMap  = HashMap<Int, Item>()
        createItemMap(globalItemMap)
        val craftingList: MutableList<Recipe> = ArrayList()
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList3, 300))

        val inventory = Inventory()
        inventory.addItemToInventory(Item(102,"a","a",50,"a"),6)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),20)
        // inventory.addItemToInventory()

        // Craft.craft(inventory, "House"
        val craft = Craft(inventory,globalItemMap)
        craft.craftItem("House")

        assertEquals(3,inventory.playerItemMap.size)
    }

    @Test
    fun craftItemNotenougRessoruces(){
        val globalItemMap  = HashMap<Int, Item>()
        createItemMap(globalItemMap)
        val craftingList: MutableList<Recipe> = ArrayList()
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList3, 300))

        val inventory = Inventory()
        inventory.addItemToInventory(Item(102,"a","a",50,"a"),2)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),2)
        // inventory.addItemToInventory()

        // Craft.craft(inventory, "House"
        val craft = Craft(inventory,globalItemMap)
        craft.craftItem("House")

        assertEquals(2, inventory.playerItemMap.size)
    }



    private fun createItemMap(globalItemMap : HashMap<Int, Item>) {
        globalItemMap.put(102,Item(102,"Wasser","das ist eine description",5))
        globalItemMap.put(100,Item(100,"Gras","das ist eine description",5))
        globalItemMap.put(300,Item(300,"House","das ist eine description",5))

    }
@Test
     fun craftItemByNameItemIsTent(){
        val globalItemMap  = HashMap<Int, Item>()
        createItemMap(globalItemMap)
        val craftingList: MutableList<Recipe> = ArrayList()
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("Tent", testList3, 300))

        val inventory = Inventory()
        inventory.addItemToInventory(Item(102,"a","a",50,"a"),5)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),2)
        // inventory.addItemToInventory()

        // Craft.craft(inventory, "House"
        val craft = Craft(inventory,globalItemMap)
        craft.craftItem("Tent")

        assertTrue(inventory.playerItemMap.containsKey(301))
    }



}