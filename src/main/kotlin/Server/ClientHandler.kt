package Server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.lang.Exception
import java.net.Socket

class ClientHandler(val socket : Socket,val serverToClientWriter: ServerToClientWriter,val id: Int) : Thread() {

    override fun run() {
        readFromClient(socket)
    }

    fun readFromClient(socket: Socket?) {
        val writer = PrintStream(socket!!.getOutputStream())

        try {


            val reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
            var s: String?
            for (line in reader.lines()) {

                println(line + " Client Handler")

                if(line.startsWith("move")){
                    checkIfCanMove()
                }
                if(line.startsWith("seed"))
                    sendSeed()

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun checkIfCanMove(){
        serverToClientWriter.writeToClient(socket, "canMoveUP" + id)
    }

    fun sendSeed(){

    }
}