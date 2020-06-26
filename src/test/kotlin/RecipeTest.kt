//import kotlin.test.assertEquals
//import kotlin.test.assertTrue
import com.google.gson.Gson
//import junit.framework.Assert.assertEquals
//import junit.framework.Assert.assertTrue
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

        assertThat(inventory.playerItemMap.size).isEqualTo(1)
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

        assertThat(inventory.playerItemMap.size).isEqualTo(2)
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

        assertThat(inventory.playerItemMap.size).isEqualTo(3)
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

        assertThat(inventory.playerItemMap.size).isEqualTo(2)
    }
    @Test
    fun setup(){
        assertThat(true).isTrue()
    }

    @Test
    fun isItemMapSizeOf7(){
        assertThat(createItemMap1().size).isEqualTo(7)

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

    private fun createCraftingList() : MutableList<Recipe>{
        val craftingList: MutableList<Recipe> = ArrayList()
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("Tent", testList3, 301))
        val testList4: MutableList<CraftCost> = ArrayList()
        testList4.add(CraftCost(102, 5))
        testList4.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList4, 300))

        return craftingList
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


        assertThat(inventory.playerItemMap.containsKey(301)).isTrue()



    }
@Test
    fun CraftHouseByID(){
        val globalItemMap  = createItemMap1()

        val craftingList = createCraftingList()

        val inventory = Inventory()
        inventory.addItemToInventory(Item(102,"a","a",50,"a"),40)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),40)
        // inventory.addItemToInventory()

        // Craft.craft(inventory, "House"
        val craft = Craft(inventory,globalItemMap)
        craft.craftItemByID(craftingList.get(1))

       assertThat(inventory.playerItemMap.contains(300)).isTrue()

    }
@Test
    fun CraftTentByID(){
        val globalItemMap  = createItemMap1()

        val craftingList = createCraftingList()

        val inventory = Inventory()
        inventory.addItemToInventory(Item(103,"a","a",50,"a"),40)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),40)
        // inventory.addItemToInventory()

        // Craft.craft(inventory, "House"
        val craft = Craft(inventory,globalItemMap)
    todo { "Choose item by selector value" }
        craft.craftItemByID(craftingList.get(0))

        assertThat(inventory.playerItemMap.contains(301)).isTrue()

    }






}