class WaterTile(cordX : Float, cordY : Float ) : Tile(cordX,cordY) {

    init {

    }


    override fun harvest(): Int {
        return 102

    }


    override fun changeTile(): Tile? {
        return null
    }

    override fun interaction() {
        TODO("Not yet implemented")
    }
}