import processing.core.PApplet
import processing.core.PImage
import processing.core.PVector


class GameMap(pApplet: PApplet){
   var tileMap : HashMap<PVector, Tile> = HashMap()
    var test : MutableMap<PVector, Tile> = HashMap();
    var pApplet = pApplet
  //  var  imageMap : MutableMap<String, PImage> = HashMap()

    init {
        tileMap = createGameMap(0F,0F)

    }


    //
    fun createGameMap(cordX : Float, cordY : Float) : HashMap<PVector, Tile>{
        val testCordX : Float =  cordX /40F
        val testCordY : Float  =   cordY/40F
        for(x in 0 until 40 ){
            for(y in 0 until 40){
                var cordVector : PVector = PVector(x.toFloat() + cordX, y.toFloat() + cordY)
                if(tileMap.containsKey(cordVector))
                    continue
               // val noiseValue : Float = useNoice((cordVector.x + x.toFloat() / 40F),(cordVector.y + y.toFloat() / 40F))
                val noiseValue : Float = useNoice((testCordX + x.toFloat() / 40F),(testCordY + y.toFloat() / 40F))


                tileMap.put(cordVector, addTileToMap(noiseValue,cordVector))

            }
        }
        return tileMap
        }

    fun useNoice(x : Float, y : Float) : Float{
        //TODO("Ask Server for Noise seed pApplet.noiseSeed(20L) so that every client has
        // the same seed (seed should be random generated)")

        var noise : Float = pApplet.noise(x * 2f, y * 2f) +
                0.5F * pApplet.noise(2F * x, 2F * y) +
                0.25F * pApplet.noise(3F * x, 3F * y)
        // var waterTile : WaterTile = WaterTile(3F,3F)

        return noise
    }

    fun addTileToMap(noise : Float, vector : PVector): Tile {

        if(noise < 0.76F)
            return WaterTile(vector.x, vector.y)
        else if(noise < 0.8F)
                return SandTile(vector.x,vector.y)
        else if(noise < 0.9F)
                return GrassTreeTile(vector.x,vector.y)
        else
            return GrassTile(vector.x, vector.y)
    }

    fun render(pApplet: PApplet, camera : PVector){
      //  println(gameMap.size)
    //gameMap.forEach{
      //  k,v ->
        for(x in 0 until 40) {
            for(y in 0 until 40)   {

                var tile = tileMap.get(PVector(x + camera.x, y + camera.y))


                var image: PImage
                if (tile is GrassTreeTile)
                    image = Game.imageMap.get("grassTreeTile")!!
                else if(tile is DustTile)
                    image = Game.imageMap.get("dustTile")!!
                else if (tile is GrassTile)
                    image = Game.imageMap.get("grassTile")!!

                   else if (tile is SandTile)
                    image = Game.imageMap.get("sandTile")!!
                 else
                    image = Game.imageMap.get("waterTile")!!



                if (tile != null) {
                    pApplet.image(image, x.toFloat() * 20, y.toFloat() * 20)
                }
            }
        }

    }






}

