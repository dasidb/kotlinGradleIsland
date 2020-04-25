import processing.core.PVector

class Camera(var position : PVector = PVector(0F,0F)
){


    fun moveCameraUp(){
        position.y = position.y - 1F

    }

    fun moveCameraDown(){
        position.y = position.y + 1F

    }

    fun moveCameraLeft(){
        position.x = position.x - 1
    }

    fun moveCameraRight(){
        position.x = position.x + 1

    }


}