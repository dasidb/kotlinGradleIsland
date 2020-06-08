package Server

import legacy.GameServer
import java.io.*
import java.lang.Exception
import java.net.ServerSocket
import java.net.Socket
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap

fun main() {
    var gameServer : GameServerv2 = GameServerv2()
    gameServer.startServer()
}

class GameServerv2() {
    var serverSocket : ServerSocket

    var socketMap1 = HashMap<Int, ClientHandler>()

    var socketMap = HashMap<Int, Socket>()
    var playerID = 0;
    val noiseSeed = 20
    var queue : Queue<String> = ConcurrentLinkedQueue()
    var producer : Producer = Producer(queue, playerID.toString(), 50)
    lateinit var serverToClientWriter: ServerToClientWriter


    init {
        serverSocket = ServerSocket(8654)
    //    print("test")
        producer.start()

        this.startServer()
      //  print("test1")


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
            print("kommt an")
            socketMap.put(playerID, socket)

            socketMap1.put(playerID, ClientHandler(socket, ServerToClientWriter(), playerID,producer))
            socketMap1.get(playerID)?.start()

            var consumer : Consumer = Consumer(queue, playerID.toString(), 50,socket,socketMap)
            consumer.start()



            playerID++


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
}
