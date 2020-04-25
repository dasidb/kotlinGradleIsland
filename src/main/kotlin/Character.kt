
import processing.core.PApplet
import processing.core.PImage
import processing.core.PVector
import kotlin.test.currentStackTrace
import kotlin.test.todo




class Character(image : PImage){
    var drawPosition : PVector
    var image = image
    var mapPosition : PVector
    val inventory = Inventory()


    init {
        drawPosition  = PVector(0F,0F)
        mapPosition = PVector(20F,20F)


    }


    fun moveUp(){

        mapPosition.y -=1
        println("kommt in der funktion an")
    }
    fun moveDown(){

        mapPosition.y +=1
    }
    fun moveLeft(){

        mapPosition.x -=1
    }
    fun moveRight(){

        mapPosition.x +=1
    }

    fun moveChameraPosition(camera: Camera){
        drawPosition.x = mapPosition.x * 20 - camera.position.x*20
        drawPosition.y = mapPosition.y* 20 - camera.position.y*20

        if(drawPosition.x > 600) {
            drawPosition.x = 600F
            camera.moveCameraRight()
        }
        if(drawPosition.x < 200) {
            drawPosition.x = 200F
            camera.moveCameraLeft()
        }
        if(drawPosition.y > 600) {
            drawPosition.y = 600F
            camera.moveCameraDown()
        }
        if(drawPosition.y < 200) {
            drawPosition.y = 200F
            camera.moveCameraUp()
        }
    }

    fun gatherResources(tile : Tile){
    if(tile is WaterTile)
        inventory.addItemToInventory(Item(102,"Wasser","",50),(Math.random() * 10).toInt())
        else if(tile is GrassTreeTile)
        inventory.addItemToInventory(Item(103,"Wood","",50),(Math.random() * 10).toInt())
        else if(tile is GrassTile)
        inventory.addItemToInventory(Item(100,"Gras","",50),(Math.random() * 10).toInt())
        else if(tile is SandTile)
        inventory.addItemToInventory(Item(101,"Sand","",50),(Math.random() * 10).toInt())
    }

    fun render(pApplet: PApplet, camera : Camera){
        moveChameraPosition(camera)
        pApplet.image(image, drawPosition.x, drawPosition.y)
        inventory.render(pApplet)
    }

}