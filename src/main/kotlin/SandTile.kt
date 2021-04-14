class SandTile (cordX: Float, cordY: Float) : Tile(cordX, cordY){

    override fun harvest(): Int {
        return 101

    }


    override fun changeTile(): Tile? {
        return null
    }

    override fun interaction() {
        TODO("Not yet implemented")
    }
}