package Client

import Server.ServerToClientWriter
import java.net.InetSocketAddress
import java.net.Socket
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel

fun main() {
    var client = GameClientv2()
}
class GameClientv2(){
    val clientWriter  = ServerToClientWriter()
    var socket : Socket? = null
   // lateinit var socket : SocketChannel
    var clientToServerWriter : ClientToServerWriter? = null
    init {
        connectToServer()
    }

    fun connectToServer(){

        try {
            val newData = "The new String is writing in a file ..." + System.currentTimeMillis()
            var byteBuffer : ByteBuffer = ByteBuffer.allocate(48)
            //socket = SocketChannel.open()

            //socket = Socket("localhost", 8654)
            //socket = Socket("localhost", 9999)
            val bytearray = newData.toByteArray()
            //byteBuffer.clear()
            byteBuffer = ByteBuffer.wrap(bytearray)
            //byteBuffer.flip()

        //    socket?.connect(InetSocketAddress("localhost", 9999))

         //   socket.write(byteBuffer)
            byteBuffer.clear()
         //   val bla = socket.read(byteBuffer)
           // println(bla)

          //  var t1 = ClientToServerReader(socket)
           // t1.start()
            //clientToServerWriter = ClientToServerWriter(PrintStream(socket?.getOutputStream(),true))

            //writeToServer("test write to server")


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

 /*   @Throws(IOException::class)
    fun writeToServer(msg : String){
        val writer = socket?.getOutputStream()
        var ps = PrintStream(writer,true)
            print(socket)
            ps.println(msg)


    } */



}