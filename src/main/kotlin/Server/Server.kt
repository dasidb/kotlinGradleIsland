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


                readFromClient(socket)
                // writeToClient(socket)

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

    fun writeToClient(socket: Socket) {
    var writer = PrintStream(socket.getOutputStream())
        writer.println("Message from Server to CLient")



    }
    @Throws(IOException::class)
    fun readFromClient(socket: Socket?){
        val writer = PrintStream(socket!!.getOutputStream())


           val reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
           var s: String?
          //  println(reader.ready())
          // while (reader.h) {
        for(line in reader.lines()){
              // s = line
               println(line)
               //writer.println(s)

           }



    }
}
