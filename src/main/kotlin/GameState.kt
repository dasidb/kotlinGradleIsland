import processing.core.PApplet
import processing.event.KeyEvent


open abstract class  GameState(val pApplet: PApplet,
                     val gameManager: GameManager
                ){
   // val pApplet = pApplet
   // val gameManager: GameManager = gameManager
init {

}
    abstract fun update()



    abstract fun render()

    open fun keyPressed(event : KeyEvent){

    }

    open fun keyReleased(event : KeyEvent){

    }

}