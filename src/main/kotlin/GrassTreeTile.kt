class GrassTreeTile(cordX: Float, cordY: Float) : Tile(cordX, cordY) {


    fun chopTree(tile: GrassTreeTile): GrassTile {
        var tile1 = GrassTile(tile.cordX, tile.cordY)
        return tile1
    }

    override fun harvest(): Int {
        return 103
    }


    override fun changeTile(): Tile {
        return GrassTile(this.cordX, this.cordY)
    }

    override fun interaction() {
        //TODO("Not yet implemented")
    }
}