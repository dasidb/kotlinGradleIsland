import processing.core.PApplet

//import kotlin.test.currentStackTrace
//import kotlin.test.todo


class Inventory(val playerItemMap : MutableMap<Int, PlayerItem> = HashMap(),
                var itemSlots : Int = 10
                ){



    fun addItemToInventory(item : Item, amount : Int){



        if(playerItemMap.containsKey(item.id)) {
            if ((playerItemMap.get(item.id)?.count?.plus(amount))!! > playerItemMap.get(item.id)!!.item.maxStackSize) {
                val amountChange = item.maxStackSize - playerItemMap.get(item.id)!!.count
                playerItemMap?.get(item.id)!!.addItem(amountChange)
            }else
            //playerItemMap.get(item.id)?.addItem(item.maxStackSize)
            playerItemMap.get(item.id)?.addItem(amount)
        }
        else {
            if(item.maxStackSize < amount){
                playerItemMap.put(item.id, PlayerItem(item, item.maxStackSize))

            }else
            playerItemMap.put(item.id, PlayerItem(item, amount))
        }

    }

    fun removeItemFromInventory(item : Item, amount : Int) : Boolean{

        if(playerItemMap.containsKey(item.id)) {
            //var item = playerItemMap.get(item.id)
            if(playerItemMap.get(item.id)!!.count == amount) {
                playerItemMap.remove(item.id)
                return true
            }else if (playerItemMap.get(item.id)!!.count > amount)
            playerItemMap.get(item.id)?.removeItem(amount)
            else
                println("Item konnte nicht entfernt werden")
                return false
               // println("Item konnte nicht entfernt werden" + currentStackTrace()[0])
        }

        return false
    }

    fun render(pApplet: PApplet){
        drawInventory(pApplet)


    }
    fun drawInventory(pApplet: PApplet){
        var x = 0
        playerItemMap.forEach{k, v ->
            println(k)

            println(v.item.image + " das ist der name")
            pApplet.image(Game.imageMap.get(v.item.image.toLowerCase()), (x*50F), 600F)
            if(v.item.image.equals("Wasser"))
                pApplet.fill(0F,0F,0F)
            
            pApplet.text(v.count, (x*50F), 650F)
            pApplet.fill(255F,255F,255F)
            pApplet.textSize(24F)

            x++
        }
    }


}