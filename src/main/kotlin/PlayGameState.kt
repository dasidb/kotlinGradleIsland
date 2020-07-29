import processing.core.PApplet
import processing.core.PVector
import processing.event.KeyEvent



class PlayGameState(pApplet: PApplet, gameManager: GameManager, character: Character) : GameState(pApplet, gameManager){
    val character : Character = character
    val buildManager : BuildManager = BuildManager()
    init {

    }

    override fun update() {
     //   changeCameraPositionX()
      //  changeCameraPositionY()

    }

    override fun render() {
        character.render(pApplet, gameManager.camera)
        buildManager.render(pApplet)
    }

    fun changeCameraPositionX(){
        if(character.drawPosition.x < 200) {
            gameManager.camera.moveCameraLeft()
            character.mapPosition.x -=1
            character.moveRight()
        }
        if(character.drawPosition.x > 600){
            gameManager.camera.moveCameraRight()
            character.mapPosition.x +=1
            character.moveLeft()
        }
    }

    fun changeCameraPositionY(){
        if(character.drawPosition.y < 200) {
            gameManager.camera.moveCameraUp()
            character.mapPosition.y -=1
            character.moveDown()
        }
        if(character.drawPosition.y > 600) {
            gameManager.camera.moveCameraDown()
            character.mapPosition.y +=1
            character.moveUp()
        }


    }

    override fun keyPressed(event : KeyEvent){
        super.keyPressed(event)
        keyInput(event.key, event.keyCode, false)
    }

    override fun keyReleased(event: KeyEvent) {
        super.keyReleased(event)
        keyInput(event.key, event.keyCode, true)

    }

    fun keyInput(key : Char, keyCode: Int, keyPressed: Boolean){
        if(keyPressed){

            if(key == 'w') {
                character.moveUp()
                gameManager.gameClientv2.clientToServerWriter?.writeToServer("move up can try")
                //gameManager.gameClientv2.writeToServer("move up can try")

            }

            if(key == 's')
                character.moveDown()
            if(key == 'a')
                character.moveLeft()
            if(key == 'd')
                character.moveRight()
            if(key == 'q')
                interactionDependingOnTile()
            if(key == 'b')
                gameManager.currentGameState = CraftingGameState(pApplet, gameManager,character.inventory)

            if(key == 'e') {
                character.gatherResources(gameManager.gameMap.gameMap.get(character.mapPosition)!!, gameManager.globalItemMap )
                character.inventory.playerItemMap.forEach { k, v ->
                    println(v.count.toString() + " " + v.item.name)
                }
            }
        }

    }

    fun interactionDependingOnTile(){
        println(character.mapPosition)
        var  tmpVec = PVector(character.mapPosition.x, character.mapPosition.y)
       var tile =  gameManager.gameMap.gameMap.get(tmpVec)


        if(tile is GrassTreeTile) {
            tile = tile.chopTree(tile)
            gameManager.gameMap.gameMap.put(tmpVec, tile!!)

        }
       else if(tile is WaterTile)
            println("bla")
        else if(tile is GrassTile)
            println("blabla")
        else if(tile is SandTile)
            println("blablabla")
        else
            println("no usable tile")
    }



}