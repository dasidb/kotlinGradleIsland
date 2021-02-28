package Server

import java.lang.NullPointerException
import java.net.Socket
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.HashMap

class Consumer(val queue: Queue<String>, name : String, val sleepTime : Int, var socket: Socket, var socketMap : HashMap<Int, Socket>) : Thread(){

    var serverToClientWriter = ServerToClientWriter()

    override fun run() {
        super.run()

        var value : String = ""
        while (true){

            try {

            if(!queue.isEmpty()) {

                validateMovement(queue.poll())

            }else{
                //print("Queue is empty")
            }


            TimeUnit.MILLISECONDS.sleep((1+(Math.random() *sleepTime)).toLong());
        }catch (e : InterruptedException){
          //      print(e)
                interrupt()
            //    print(name + " has closed")
            }catch (e : NullPointerException)   {
            //    print(e)
            }
        }

    }



    fun validateMovement(msg : String){
        println("validate move")
        var tmpMsg = msg
        setServerToClientWriter(tmpMsg)
        if(tmpMsg.startsWith("move up"))
            tmpMsg = "move is valid"
        else
            tmpMsg = "move is invalid"

        writeToClient(msg)

    }

    fun setServerToClientWriter(msg : String){
        socket = socketMap.get(0)!!
    }

    fun writeToClient(msg: String){
        print("kommt an")
        serverToClientWriter?.writeToClient(socket, msg)
    }
    }