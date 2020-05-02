package Server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.lang.Exception
import java.net.Socket
import kotlin.test.todo

class ServerHandler(val socket : Socket,val serverToClientWriter: ServerToClientWriter) : Thread() {

    override fun run() {
        readFromClient(socket)
    }

    fun readFromClient(socket: Socket?) {
        val writer = PrintStream(socket!!.getOutputStream())

        try {


            val reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
            var s: String?
            for (line in reader.lines()) {

                println(line)

                if(line.startsWith("canMoveUP")){
                    canMove()
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun canMove(){
        todo { "kann sich bewegen" }
    }
}