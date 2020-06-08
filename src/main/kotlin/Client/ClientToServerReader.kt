package Server

import java.io.*
import java.net.Socket

class ClientToServerReader(val socket: Socket?) : Thread(){


    override fun run() {
        super.run()
        readFromServer(socket)
    }

    fun readFromServer(socket: Socket?) {
        var reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
        for(line in reader.lines())
            println(line)
    }
}