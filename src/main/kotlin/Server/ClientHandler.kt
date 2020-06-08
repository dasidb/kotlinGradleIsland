package Server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.lang.Exception
import java.net.Socket

class ClientHandler(val socket : Socket,val serverToClientWriter: ServerToClientWriter,val id: Int, val producer: Producer) : Thread() {

    override fun run() {
        readFromClient(socket)
    }

    fun readFromClient(socket: Socket?) {


        try {


            val reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
            var s: String?
            for (line in reader.lines()) {

                println(line)

                if(line.startsWith("move")){
                    producer.writeToQueue(line)
                }
                if(line.startsWith("seed")){

                }


            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}