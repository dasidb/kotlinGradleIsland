import processing.core.PApplet
import processing.core.PVector
import processing.event.KeyEvent


class PlayGameState(pApplet: PApplet, gameManager: GameManager, character: Character) :
    GameState(pApplet, gameManager) {
    val character: Character = character
    val buildManager: BuildManager = BuildManager()

    init {

    }

    override fun update() {
        //   changeCameraPositionX()
        //  changeCameraPositionY()

    }

    override fun render() {
        isThereASecondLayer = false
        character.render(pApplet, gameManager.camera)
        buildManager.render(pApplet)
    }

    fun changeCameraPositionX() {
        if (character.drawPosition.x < 200) {
            gameManager.camera.moveCameraLeft()
            character.mapPosition.x -= 1
            character.moveRight()
        }
        if (character.drawPosition.x > 600) {
            gameManager.camera.moveCameraRight()
            character.mapPosition.x += 1
            character.moveLeft()
        }
    }

    fun changeCameraPositionY() {
        if (character.drawPosition.y < 200) {
            gameManager.camera.moveCameraUp()
            character.mapPosition.y -= 1
            character.moveDown()
        }
        if (character.drawPosition.y > 600) {
            gameManager.camera.moveCameraDown()
            character.mapPosition.y += 1
            character.moveUp()
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

            if (key == 'w') {
                character.moveUp()
                gameManager.gameClientv2.clientToServerWriter?.writeToServer("move up can try")
                //gameManager.gameClientv2.writeToServer("move up can try")

            }

            if (key == 's')
                character.moveDown()
            if (key == 'a')
                character.moveLeft()
            if (key == 'd')
                character.moveRight()
            if (key == 'q')
                interactionDependingOnTile(character.mapPosition)
            if (key == 'c')
                gameManager.currentGameState = CraftingGameState(pApplet, gameManager, character.inventory)
            if (key == 'b'){
                buildManager.render(pApplet);
                // TODO: 22.04.2021 set a variable in buildmanager instead calling it here make the grid smaller/other Position
            }

            if (key == 'e') {
                gatherRessources()

            }
        }

    }

    private fun gatherRessources() {
        var tmpRessourceID = gameManager.gameMap.tileMap.get(character.mapPosition)!!.harvest()
        if (tmpRessourceID != null) {
            var tmpTile = gameManager.gameMap.tileMap.get(character.mapPosition)!!.changeTile()
            if (tmpTile != null) {
                gameManager.gameMap.tileMap.set(character.mapPosition, tmpTile)
            }
            character.inventory.addItemToInventory(gameManager.globalItemMap.get(tmpRessourceID)!!, 3)
            // interactionDependingOnTile()
            character.inventory.playerItemMap.forEach { k, v ->
                println(v.count.toString() + " " + v.item.name)
            }
        } else {
            println("Du kannst hier nichts sammeln")
        }
    }

    fun interactionDependingOnTile(tilePosition: PVector) {
        var tile = gameManager.gameMap.tileMap.get(tilePosition)
        tile!!.interaction()

    }
}