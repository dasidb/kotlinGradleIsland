import processing.core.PApplet
import processing.core.PImage
import processing.data.JSONArray
import processing.data.JSONObject
import processing.event.KeyEvent

fun main() {
    Game.main()

}

class Game : PApplet() {
    var gameManager: GameManager? = null
    var i: Int = 0
    var resolutionX: Int = 800;
    var resolutionY: Int = 800
    val globalItemMap : MutableMap<Int,Item> = HashMap()


    init {
        //gameManager = GameManager(null, this)
        //gameManager.changeGameState("playGameState", PlayGameState(this, gameManager,gameManager.character))
    }

    init {

    }

    companion object {
        @JvmStatic
        fun main() {
            main(Game::class.java)
        }
        var imageMap: MutableMap<String, PImage> = HashMap()
    }

    override fun settings() {
        super.settings()
        size(800, 800)
       // surface.setResizable(true)
    }

    override fun setup() {
        super.setup()
        loadAssets()
        gameManager = GameManager(null, this,globalItemMap)
        createItemMap()
        Renderer.getInstance().setPapplet(this)
        Renderer.getInstance().setImageMap(imageMap)
        GridDrawer.getInstance().setPapplet((this))
        GridDrawer.getInstance().setImageMap(imageMap as java.util.HashMap<String, PImage>?)

        gameManager?.changeGameState("playGameState", PlayGameState(this, gameManager!!,
                gameManager!!.character))
       // gameManager?.changeGameState("menuGameState", MenuGameState(this, gameManager!!))

        frameRate(60F)
        test()


        background(0F, 0F, 0F)
        loop()

        //gameManager = GameManager(gameState = GameState())
    }

    private fun createItemMap() {
       val jsonArrayList =  loadJSONArray("resources/itemList.json")
        for(x in 0 until jsonArrayList.size()){
            var item : JSONObject = jsonArrayList.getJSONObject(x)
            globalItemMap.put(item.getInt("id"),Item(item.getInt("id"),item.getString("name"),
                    item.getString("description"),item.getInt("maxStackSize"),item.getString("name")))
        }


    }

    override fun draw() {
        // super.draw()

        gameManager?.update()
        gameManager?.render()


    }

    override fun keyPressed(event: KeyEvent) {
        gameManager?.keyPressed(event)

    }

    override fun keyReleased(event: KeyEvent) {
        gameManager?.keyReleased(event)
    }

    fun loadAssets() {
        loadTileAssets()
        loadEntityAssets()
        loadItemAssets()
        loadMenuAssets()

    }

    fun loadMenuAssets(){
        var image = loadImage("assets/craftingBackground.png")
        imageMap.put("craftingBackground",image)
    }

    fun loadTileAssets(){
        var image = loadImage("assets/grassTile.png")
        imageMap.put("grassTile", image)
        image = loadImage("assets/waterTile.png")
        imageMap.put("waterTile", image)
        image = loadImage("assets/sandTile.png")
        imageMap.put("sandTile", image)
        image = loadImage("assets/grassTreeTile.png")
        imageMap.put("grassTreeTile", image)
        image = loadImage("assets/dustTile.png")
        imageMap.put("dustTile", image)
    }

    fun  loadEntityAssets(){
        var image = loadImage("assets/held_survival.png")
        imageMap.put("character",image)
    }

    fun loadItemAssets(){
        var image = loadImage("assets/wood.png")
        image.resize(50,50)
        imageMap.put("wood", image)
        image = loadImage("assets/water.jpg")
        image.resize(50,50)
        imageMap.put("wasser",image)
        image = loadImage("assets/gras.jpg")
        image.resize(50,50)
        imageMap.put("gras",image)
        image = loadImage("assets/sand.jpg")
        image.resize(50,50)
        imageMap.put("sand",image)
        image = loadImage("assets/axe.jpg")
        image.resize(50,50)
        imageMap.put("axe",image)
        image = loadImage("assets/house.jpg")
        image.resize(50,50)
        imageMap.put("house",image)
        image = loadImage("assets/tent.jpg")
        image.resize(50,50)
        imageMap.put("tent",image)
        image = loadImage("assets/boards.jpg")
        image.resize(50,50)
        imageMap.put("board",image)
        image = loadImage("assets/clay.jpg")
        image.resize(50,50)
        imageMap.put("clay",image)
        image = loadImage("assets/arrowRight.png")
        imageMap.put("arrowright",image)

    }

    fun test(){
        var json : JSONArray =  loadJSONArray("resources/itemList.json")


        var jsonTest = json.getJSONObject(1)

   //     json.setInt("id", 0);
     //   json.setString("species", "Panthera leo");
     //   json.setString("name", "Lion");

     //   saveJSONObject(json, "C:\\Users\\Lukas\\Desktop\\java\\Kotlin/new.json");
    }

}


