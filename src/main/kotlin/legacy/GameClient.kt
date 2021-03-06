package legacy

import Server.ServerHandler
import Server.ServerToClientWriter
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintStream
import java.lang.Exception
import java.net.Socket

fun main() {
    var client = GameClient()
}
class GameClient(){
    val clientWriter  = ServerToClientWriter()
    init {
        connectToServer()
    }

    fun connectToServer(){
        var socket: Socket? = null
            try {


                socket = Socket("localhost", 8654)
                var t1 = ServerHandler(socket, clientWriter)
                t1.start()

                writeToServer(socket)
               // readFromServer(socket)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (socket != null) try {
                   // socket.close()
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
            println(line + " reads the line client")
        }
    }
    @Throws(IOException::class)
    fun writeToServer(socket : Socket){
            val writer = socket.getOutputStream()
            var ps = PrintStream(writer,true)
            while (true) {
                ps.println("move up")
                Thread.sleep(1000)
            }

    }



}