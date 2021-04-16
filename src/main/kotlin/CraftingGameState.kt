import processing.core.PApplet
import processing.event.KeyEvent
import java.lang.IndexOutOfBoundsException

class CraftingGameState(pApplet: PApplet, gameManager: GameManager, val inventory: Inventory) : GameState(pApplet,
    gameManager
) {
    var selection: Int = 0
    val craftingList: MutableList<Recipe>

    val craft = Craft(inventory, gameManager.globalItemMap)

    init {

        craftingList = craft.craftingList


    }


    override fun update() {

    }

    override fun render() {
        isThereASecondLayer = true
        // pApplet.image(Game.imageMap.get("craftingBackground"),0F,0F)
        craftingMenu()

        //inventory.render(pApplet)

    }



    fun craftingMenu() {
        for (x in 0 until 5) {
            for (y in 0 until 5) {
                var tmpX = selection % 5
                var tmpY : Int = selection / 5
                if(tmpX == x && tmpY == y) {
                    pApplet.fill(255F, 0F, 0F)
                }else {
                    pApplet.fill(255F, 255F, 255F)
                }
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

                        pApplet.text(it.amount.toString() + " " + it.name, x * 160F + 60F, y * 160F + 80 + tmpItterator)
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
        if (keyPressed) {

            if (key == 'w' && selection < 30) {
                selection += 1
            }
            if(key == 's' && selection > 0) {
                selection -= 1
            }
            if(key == PApplet.ENTER){
                if(craft.craftItemByID(selection))
                    println("Crafted")
                else
                    println("Kein Platz oder nicht genug Ressourcen")

            }
            if (key == 'b') {
                gameManager.currentGameState = gameManager.gameStateMap.get("playGameState")
            }
        }
    }
}