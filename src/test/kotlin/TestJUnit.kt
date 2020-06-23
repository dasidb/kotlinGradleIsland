import org.junit.Test

class TestJUnit(){


    fun returnAString(msg : String) : String{
        var zahl1 = 8
        var neueZahl = 1232131
        return msg + "12"
    }

    @Test
    fun subString(){
        val msg ="abcdefg"
        var inc = 0
        msg.forEach {

            print(msg.substring(inc, inc))
            inc ++
        }
    }
}