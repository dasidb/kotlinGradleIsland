class Item(
    val id : Int,
    val name : String,
    val description : String,
    var maxStackSize : Int,
    var image : String = name.toLowerCase()
){

}