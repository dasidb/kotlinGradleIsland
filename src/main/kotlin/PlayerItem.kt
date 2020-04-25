class PlayerItem(
    val item : Item,
    var count : Int = 0
){

    fun addItem(count : Int){
        if(item != null)
            this.count += count
        else
            println("Error kein item vorhanden")
    }

    fun removeItem(count : Int) : Boolean{
        if(this.count < count)
            return false
        this.count -= count
        return true

    }
}