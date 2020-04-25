class GrassTreeTile(cordX: Float, cordY: Float) : Tile(cordX, cordY){



    fun chopTree(tile : GrassTreeTile) : GrassTile{
        var tile1 = GrassTile(tile.cordX,tile.cordY)
        return tile1
    }
}