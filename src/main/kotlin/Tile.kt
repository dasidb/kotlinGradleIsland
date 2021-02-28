import java.time.LocalDateTime

open abstract class Tile(


    var cordX: Float,
    var cordY: Float



){
    var lasttimeHarvested : LocalDateTime? = null

fun setlastTimeHarvested(){
    lasttimeHarvested = LocalDateTime.now()
}

}