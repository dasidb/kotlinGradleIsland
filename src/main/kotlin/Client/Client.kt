package Client

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintStream
import java.lang.Exception
import java.net.Socket

fun main() {
    var client = Client()
}
class Client(){

    init {
        startServer()
    }

    fun startServer(){
        var socket: Socket? = null
            try {


                socket = Socket("localhost", 8654)
                writeToServer(socket)
                readFromServer(socket)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (socket != null) try {
                    socket.close()
                    println("Client socket geschlossen")
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }

                }



    @Throws(IOException::class)
    fun readFromServer(socket : Socket){
        var reader = socket.getInputStream()
        var bufferedReader : BufferedReader = BufferedReader(InputStreamReader(reader))

        for(line in bufferedReader.lines()){
            println(line)
        }
    }
    @Throws(IOException::class)
    fun writeToServer(socket : Socket){
            val writer = socket.getOutputStream()
            var ps = PrintStream(writer,true)

            ps.println("Message from Client To Server")
            ps.println("Message from Client To Server")
            ps.println("Message from Client To Server")
            ps.println("Message from Client To Server")




    }

}