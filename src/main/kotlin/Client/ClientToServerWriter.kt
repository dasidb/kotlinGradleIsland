package Client

import java.io.PrintStream

class ClientToServerWriter (val printStream: PrintStream) {

    init {

    }
    fun writeToServer(msg : String){

        printStream.println(msg)


    }
}
