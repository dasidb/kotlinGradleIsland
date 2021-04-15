class DustTile (cordX : Float, cordY : Float) : Tile(cordX,cordY) {

    override fun harvest(): Int {
        // TODO: 14.04.2021 create dust
        return 100

    }


    override fun changeTile(): Tile? {
        return null
    }

    override fun interaction() {
        //TODO("Not yet implemented")
    }
}