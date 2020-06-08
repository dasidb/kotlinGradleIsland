package Server

import java.io.*
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket

fun main() {
    var server : Server = Server()
    server.startServer()
}

class Server(){
    var serverSocket : ServerSocket
    init {
        serverSocket = ServerSocket(8654)

    }

    fun startServer(){
    while(true) {
        waitForClientsToConnect()
    }

    }

    fun waitForClientsToConnect(){
       // while(true) {
            var socket: Socket? = null

            try {
                socket = serverSocket.accept()
                println(socket.inetAddress)
                writeToClient(socket)

                readFromClient(socket)


            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (socket != null) try {
                      socket.close()
                    println("Server socket geschlossen")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
         //   }
        }


    }

    // this is written to the Client

    fun writeToClient(socket: Socket?) {
        println("kommt an")
    var writer = PrintStream(socket!!.getOutputStream())
        writer.println("Message from Server to CLient")
        writer.println("Message from Server to CLient")
        writer.println("Message from Server to CLient")
        writer.println("Message from Server to CLient")
        writer.flush()
    }
    @Throws(IOException::class)
    fun readFromClient(socket: Socket?){
        val writer = PrintStream(socket!!.getOutputStream())

        try {


            val reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
            var s: String?

            for (line in reader.lines()) {
                println(line.length)
                println(line)


            }

        }catch (e: Exception){
            println("nach methode")
        }



        println("nach methode")
    }
}
