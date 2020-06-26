class Craft (val inventory: Inventory,
val globalItemMap: MutableMap<Int, Item>){
    val craftingList: MutableList<Recipe>
    var enougMats = true


    init {
        craftingList = ArrayList()
        createRecipeList()
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

    fun craftItemByID(recipe: Recipe) {
   // inventory.addItemToInventory(globalItemMap.get(recipe.itemID)!!,5)
        craftItem(recipe.name)

    }
}