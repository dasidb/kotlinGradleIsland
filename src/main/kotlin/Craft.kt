import com.google.gson.Gson
import java.io.BufferedReader
import java.io.FileReader
import java.lang.Exception
import java.lang.IndexOutOfBoundsException

class Craft (val inventory: Inventory,
             val globalItemMap: MutableMap<Int, Item>){
    val craftingList: MutableList<Recipe>
    var enougMats = true


    init {
        craftingList = createRecipeList1()
        //createRecipeList()
    }

    fun craftItem(itemName: String) {
        craftingList.forEach {
            if (it.name.equals(itemName)) {

                enougMats = true
                checkIfEnougMats(it)
                if(enougMats) {
                    inventory.addItemToInventory(globalItemMap.get(it.itemID)!!, 1)
                    println("added 1 " + itemName)
                }
            }
        }

    }

    private fun checkIfEnougMats(recipe: Recipe) {
        recipe.craftCostList.forEach {
            if (inventory.playerItemMap.containsKey(it.itemId) && inventory.playerItemMap.get(it.itemId)?.count!! >= it.amount)
            else {
                enougMats = false
            }
        }
        if(enougMats){
            recipe.craftCostList.forEach{
                println(it.itemId)
                println(globalItemMap.get(it.itemId))
                inventory.removeItemFromInventory(globalItemMap.get(it.itemId)!!,it.amount)
            }
        }
    }

    fun createRecipeList()  {
        val testList: MutableList<CraftCost> = ArrayList()
        testList.add(CraftCost(103, 5))
        testList.add(CraftCost(100, 4))
        craftingList.add(Recipe("Tent", testList, 301))
        val testList2: MutableList<CraftCost> = ArrayList()
        testList2.add(CraftCost(103, 5))
        testList2.add(CraftCost(100, 1))
        craftingList.add(Recipe("Axe", testList2, 400))
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList3, 300))

    }

     fun createRecipeList1() : MutableList<Recipe> {
        val globalRecipeList: MutableList<Recipe> = ArrayList()
        val path = "resources/recipeList.json"
        val bufferedReader = BufferedReader(FileReader(path))

        val gson = Gson()
        var jsonObjectList = gson.fromJson(bufferedReader, Array<Recipe>::class.java)
        jsonObjectList!!.asList()
        jsonObjectList.forEach {
            globalRecipeList.add(it)
            print(it)
        }
        return globalRecipeList
    }

    fun craftItemByID(selector: Int) {
        try {
            craftItem(craftingList.get(selector).name)

        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}