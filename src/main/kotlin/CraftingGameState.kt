import processing.core.PApplet
import processing.event.KeyEvent
import java.lang.IndexOutOfBoundsException

class CraftingGameState(pApplet: PApplet, gameManager: GameManager, val inventory: Inventory) : GameState(pApplet,
    gameManager
) {
    var selection: Int = 0
    val craftingList: MutableList<Recipe>
    var enougMats = true

    init {
        craftingList = ArrayList()
        createRecipeList()
    }


    override fun update() {

    }

    override fun render() {
        // pApplet.image(Game.imageMap.get("craftingBackground"),0F,0F)
        craftingMenu()

        //inventory.render(pApplet)

    }

    fun createRecipeList() {
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

    fun craftItem(itemName: String) {
        craftingList.forEach {
            if (it.name == itemName) {
                enougMats = true
                checkIfEnougMats(it)
                if(enougMats) {
                    inventory.addItemToInventory(gameManager.globalItemMap.get(it.itemID)!!, 1)
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
    }
    fun craftingMenu() {
        for (x in 0 until 5) {
            for (y in 0 until 5) {
                pApplet.fill(255F, 255F, 255F)
                pApplet.rect(x.toFloat() * 160, y.toFloat() * 160, x + 160F, y + 160F)
                displayCraftings()
            }
        }

    }

    fun displayCraftings() {
        for (y in 0 until 5) {
            for (x in 0 until 5) {
                var itterator = x + y * 5
                try {

                    var tmp = craftingList.get(itterator)
                    pApplet.fill(0F, 0F, 0F)
                    pApplet.text(tmp.name, x * 160F + 60, y * 160F + 60)
                    var tmpItterator = 0
                    tmp.craftCostList.forEach() {

                        pApplet.text(it.amount.toString(), x * 160F + 60F, y * 160F + 80 + tmpItterator)
                        tmpItterator += 20
                    }

                } catch (e: IndexOutOfBoundsException) {

                }

            }

        }
    }

    override fun keyPressed(event: KeyEvent) {
        super.keyPressed(event)
        keyInput(event.key, event.keyCode, false)
    }

    override fun keyReleased(event: KeyEvent) {
        super.keyReleased(event)
        keyInput(event.key, event.keyCode, true)

    }

    fun keyInput(key: Char, keyCode: Int, keyPressed: Boolean) {
        println("kommt an")
        if (keyPressed) {
            if (key == 'w' && selection < 9) {
                craftItem("House")
                selection += 1
                println("kommt in an ")
            }
            if(key == 's' && selection > 0) {
                selection -= 1
            }
        }
    }
}