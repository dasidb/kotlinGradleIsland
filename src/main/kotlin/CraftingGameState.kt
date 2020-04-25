import processing.core.PApplet

class CraftingGameState(val inventory: Inventory, pApplet: PApplet, gameManager: GameManager) : GameState(pApplet,
    gameManager
){


    override fun update() {

    }

    override fun render() {
        pApplet.image(Game.imageMap.get("craftingBackground"),0F,0F)
        inventory.render(pApplet)

    }


}