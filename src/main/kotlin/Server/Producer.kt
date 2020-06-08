package Server

import java.lang.Exception
import java.util.*
import java.util.concurrent.TimeUnit

class Producer(val queue : Queue<String>,  name : String, val sleepTime : Int = 50) : Thread(){
    var queueData = ""
    override fun run() {
        super.run()
        while (true){
            println(queueData)
            if(!queueData.equals("")) {
                fillQueue(queueData)
                queueData = ""
            }
            TimeUnit.MILLISECONDS.sleep((1+(Math.random() *sleepTime)).toLong());

        }
    }

    fun fillQueue(msg : String){
        try {
            println("producer filled")
            queue.offer(msg)
            println(queue.size)
            TimeUnit.MILLISECONDS.sleep((1+(Math.random() *sleepTime)).toLong());

        }catch (e : InterruptedException) {
            print(e)
            interrupt()
            print(this.name + " has stoped")

        }
    }
    fun writeToQueue(msg : String){
        println("writetoqueue")
        queueData = msg
        }

    }


