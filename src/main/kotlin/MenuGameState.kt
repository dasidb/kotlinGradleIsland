import Client.GameClient
import processing.core.PApplet

class MenuGameState(pApplet: PApplet, gameManager: GameManager) : GameState(pApplet, gameManager) {
    override fun update() {

    }

    override fun render() {
        drawMenu()
    }

    fun drawMenu(){
        pApplet.background(0F,0F,0F)
        pApplet.fill(255F,255F,255F)
        pApplet.rect(390F,160F,200F,80F)
        pApplet.rect(390F,260F,200F,80F)
        pApplet.rect(390F,360F,200F,80F)

        pApplet.fill(255F,0F,0F)
        pApplet.text("Spiel Starten",400F,200F)
        pApplet.text("Mit einem Server verbinden",400F,300F)
        pApplet.text("Spiel beenden",400F,400F)

    }

    fun choosedServer(){
        gameManager.client = GameClient()
    }
}