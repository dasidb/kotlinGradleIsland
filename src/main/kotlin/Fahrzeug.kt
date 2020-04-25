import com.sun.tools.javac.Main

fun main(){
    var fahrzeug : Fahrzeug = Fahrzeug(true,true,true,true,true,true,5)
    println(fahrzeug.zahl)
}
class Fahrzeug(
    var zweiReifen : Boolean,
    var vierReifen : Boolean,
    var farbeBlau : Boolean,
    var farbeGrün : Boolean,
    var extra : Boolean,
    var zusatz : Boolean,
    var zahl : Int

){

   init {
     //  id = zahl
   }


    fun test(){


    }


}





