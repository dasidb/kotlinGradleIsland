import processing.core.PImage

class GrassTile (cordX : Float, cordY : Float, ressourceID : Int = 100 ) : Tile(cordX,cordY)
{
    var ressourceAmount : Int

    init {
    ressourceAmount = (Math.random()*10).toInt()
    }




}