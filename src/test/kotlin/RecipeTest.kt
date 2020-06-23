//import kotlin.test.assertEquals
//import kotlin.test.assertTrue
import com.google.gson.Gson
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test
import processing.data.JSONObject
import java.io.BufferedReader
import java.io.FileReader
import kotlin.test.todo
import org.assertj.core.api.Assertions.*


class RecipeTest {


    @Test
    fun craftItemWithNoRessourcesLeft(){
        val globalItemMap  = createItemMap1()

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
        val globalItemMap  = createItemMap1()

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
        val globalItemMap  = createItemMap1()

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
        val globalItemMap  = createItemMap1()

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
    @Test
    fun setup(){
        assertTrue(true)
    }

    @Test
    fun isItemMapSizeOf7(){
        assertEquals(7,createItemMap1().size)

    }

    private fun createItemMap1() : MutableMap<Int,Item> {
        val globalItemMap: MutableMap<Int, Item> = HashMap()
        val path = "resources/itemList.json"
        val bufferedReader = BufferedReader(FileReader(path))

        val gson = Gson()
        var jsonObjectList: Array<Item>? = gson.fromJson(bufferedReader, Array<Item>::class.java)
        jsonObjectList!!.asList()
        jsonObjectList.forEach {
            globalItemMap.put(it.id, it)
        }
    return globalItemMap
    }


@Test
     fun craftItemByNameItemIsTent(){
        val globalItemMap  = createItemMap1()

        val inventory = Inventory()
        // Ressourcetypes a Tent needs to craft
        inventory.addItemToInventory(Item(103,"a","a",50,"a"),30)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),30)


    val craft = Craft(inventory,globalItemMap)
        craft.craftItem("Tent")


        assertTrue(inventory.playerItemMap.containsKey(301))



    }



}