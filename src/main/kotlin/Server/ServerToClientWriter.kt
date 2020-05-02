package Server

import java.io.PrintStream
import java.net.Socket

class ServerToClientWriter{


    fun writeToClient(socket: Socket?, msg : String) {
        var writer = PrintStream(socket!!.getOutputStream(),true)
        writer.println(msg)
    }
}