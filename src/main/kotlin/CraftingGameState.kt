import processing.core.PApplet
import java.lang.IndexOutOfBoundsException

class CraftingGameState(pApplet: PApplet, gameManager: GameManager) : GameState(pApplet,
    gameManager
){
    val craftingList : MutableList<Recipe>
    init {
         craftingList = ArrayList()
        createRecipeList()
    }


    override fun update() {

    }

    override fun render() {
       // pApplet.image(Game.imageMap.get("craftingBackground"),0F,0F)
        craftingMenu()

        //inventory.render(pApplet)

    }

    fun createRecipeList(){
        val testList : MutableList<CraftCost> = ArrayList()
        testList.add(CraftCost(103,5))
        testList.add(CraftCost(100,4))
        craftingList.add(Recipe("Tent",testList))
        val testList2 : MutableList<CraftCost> = ArrayList()
        testList2.add(CraftCost(103,5))
        testList2.add(CraftCost(100,1))
        craftingList.add(Recipe("Log",testList2))
        val testList3 : MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(103,5))
        testList3.add(CraftCost(100,2))
        craftingList.add(Recipe("House",testList3))

    }

    fun craftItem(){

    }

    fun craftingMenu(){
        for(x in 0 until 5){
            for(y in 0 until 5){
                pApplet.fill(255F,255F,255F)
                pApplet.rect(x.toFloat()*160,y.toFloat()*160,x+ 160F,y+ 160F)
                displayCraftings()
            }
        }

    }

    fun displayCraftings(){
        for (y in 0 until 5){
            for(x in 0 until 5){
                var itterator = x + y*5
               try {

                   var tmp = craftingList.get(itterator)
                   pApplet.fill(0F, 0F, 0F)
                   pApplet.text(tmp.name, x * 160F + 60, y * 160F + 60 )
                   var tmpItterator = 0
                   tmp.craftCost.forEach(){

                       pApplet.text(it.amount.toString(),x*160F + 60F,y *160F + 80 + tmpItterator)
                       tmpItterator += 20
                   }

               }catch (e : IndexOutOfBoundsException){

               }

            }

        }
    }
}