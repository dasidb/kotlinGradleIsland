class GrassTile (cordX : Float, cordY : Float, ressourceID : Int = 100 ) : Tile(cordX,cordY)
{
    var ressourceAmount : Int

    init {
    ressourceAmount = (Math.random()*10).toInt()
    }

    fun harvest(tile : GrassTile) : DustTile{
        var tile1 = DustTile(tile.cordX,tile.cordY)
        return tile1
    }

    override fun harvest() {
        TODO("Not yet implemented")
    }

    override fun changeTile(): Tile {
        TODO("Not yet implemented")
    }


}