import java.time.LocalDateTime

abstract class Tile(
    var cordX: Float,
    var cordY: Float) : TileUsage{

    var lasttimeHarvested : LocalDateTime? = null

fun setlastTimeHarvested(){
    lasttimeHarvested = LocalDateTime.now()
}

}