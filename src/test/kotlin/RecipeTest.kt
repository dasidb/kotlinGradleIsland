//import kotlin.test.assertEquals
//import kotlin.test.assertTrue
import org.json.simple.parser.JSONParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.FileReader
import kotlin.test.todo

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
        todo { "read data from json" }
        val jsonParser =JSONParser().parse(FileReader("resources/itemList.json"))
        var jsonArray : org.json.simple.JSONArray = jsonParser as org.json.simple.JSONArray
      //  print(jsonArray)
        val iterator  = jsonArray.iterator()

        while (iterator.hasNext()) {
           val itr1 = (iterator.next() as Map<*, *>)//.entries.iterator()
            println(itr1.get("id"))
            //val test : Long = itr1.get("id")
          //  val test1 : Int =
            print("success")

                //println(pair.key.toString() + " : " + pair.value)
          //   globalItemMap.put(itr1.get("id") as Int,Item(itr1.get("id") as Int, itr1.get("name") as String, itr1.get("description") as String, itr1.get("maxStackSize") as Int))

        }
        println(globalItemMap.size)
        globalItemMap.put(102,Item(102,"Wasser","das ist eine description",5))
        globalItemMap.put(100,Item(100,"Gras","das ist eine description",5))
        globalItemMap.put(103,Item(103,"Holz","das ist eine description",5))
        globalItemMap.put(300,Item(300,"House","das ist eine description",5))
        globalItemMap.put(301,Item(301,"Tent","das ist eine description",5))


    }
@Test
     fun craftItemByNameItemIsTent(){
        val globalItemMap  = HashMap<Int, Item>()
        createItemMap(globalItemMap)
        val inventory = Inventory()
        // Ressourcetypes a Tent needs to craft
        inventory.addItemToInventory(Item(103,"a","a",50,"a"),30)
        inventory.addItemToInventory(Item(100,"a","a",50,"a"),30)


    val craft = Craft(inventory,globalItemMap)
        craft.craftItem("Tent")


        assertTrue(inventory.playerItemMap.containsKey(301))



    }



}