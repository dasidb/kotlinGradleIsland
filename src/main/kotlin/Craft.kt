import com.google.gson.Gson
import java.io.BufferedReader
import java.io.FileReader
import java.lang.IndexOutOfBoundsException

class Craft(
    val inventory: Inventory,
    val globalItemMap: MutableMap<Int, Item>
) {
    val craftingList: MutableList<Recipe>
    var enougMats = true


    init {
        craftingList = createRecipeList1()
        //createRecipeList()
    }

    fun craftItem(itemName: String) {
        craftingList.forEach {
            if (it.name.equals(itemName)) {
                if (checkIfMaxStackSize(it)) {
                    if (checkIfEnougMats(it)) {
                        inventory.addItemToInventory(globalItemMap.get(it.itemID)!!, 1)
                        println("added 1 " + itemName)
                    }
                }
            }
        }

    }

    private fun checkIfMaxStackSize(recipe: Recipe): Boolean {
        if (inventory.playerItemMap.containsKey(recipe.itemID)) {
            return inventory.playerItemMap.get(recipe.itemID)?.item?.maxStackSize!! >
                    inventory.playerItemMap.get(recipe.itemID)?.count!!
        } else
            return true


    }

    private fun checkIfEnougMats(recipe: Recipe): Boolean {
        recipe.craftCostList.forEach {
            if (inventory.playerItemMap.containsKey(it.itemId) && inventory.playerItemMap.get(it.itemId)?.count!! >= it.amount)
            else {
                return false
            }
        }
        if (enougMats) {
            recipe.craftCostList.forEach {
                inventory.removeMatsFromInventory(globalItemMap.get(it.itemId)!!, it.amount)
            }
        }
        return true
    }

    fun createRecipeList1(): MutableList<Recipe> {
        val globalRecipeList: MutableList<Recipe> = ArrayList()
        val path = "resources/recipeList.json"
        val bufferedReader = BufferedReader(FileReader(path))

        val gson = Gson()
        var jsonObjectList = gson.fromJson(bufferedReader, Array<Recipe>::class.java)
        jsonObjectList!!.asList()
        jsonObjectList.forEach {
            globalRecipeList.add(it)

        }
        return globalRecipeList
    }

    fun craftItemByID(selector: Int) {
        try {
            craftItem(craftingList.get(selector).name)

        } catch (e: IndexOutOfBoundsException) {
            e.printStackTrace()
        }
    }
}