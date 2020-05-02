package Server

import java.io.*
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket

fun main() {
    var gameServer : GameServer = GameServer()
    gameServer.startServer()
}

class GameServer() : Runnable{
    var serverSocket : ServerSocket

    var socketMap = HashMap<Int, ClientHandler>()
    var playerID = 0;
    val noiseSeed = 20
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

              //  var t1 = ClientHandler(socket, ServerToClientWriter(), playerID)
                //t1.start()
                //socketMap.put(playerID, t1)
                socketMap.put(playerID, ClientHandler(socket, ServerToClientWriter(), playerID))
                socketMap.get(playerID)?.start()
                playerID++


              //  readFromClient(socket)




                writeToClient(socket)

            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (socket != null) try {
                    //  socket.close()
                    //println("Server socket geschlossen")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
         //   }
        }


    }

    // this is written to the Client

    fun writeToClient(socket: Socket?) {
        println("kommt an")
    var writer = PrintStream(socket!!.getOutputStream(),true)
        writer.println("Message from Server to CLient")
        writer.println("Message from Server to CLient")
        writer.println("Message from Server to CLient")
        writer.println("Message from Server to CLient")




    }
    @Throws(IOException::class)
    fun readFromClient(socket: Socket?){
        val writer = PrintStream(socket!!.getOutputStream())

        try {


            val reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
            var s: String?
            for (line in reader.lines()) {

                println(line)



            }
        }catch (e: Exception){
            e.printStackTrace()
        }
       // writeToClient(socket)



    }

    override fun run() {
       // while (true) {
            println("hallo")
        //}
    }
}
