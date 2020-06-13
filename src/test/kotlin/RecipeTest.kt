import org.junit.jupiter.api.Test

class RecipeTest {


    @Test
    fun craftItem(){
        val testList3: MutableList<CraftCost> = ArrayList()
        testList3.add(CraftCost(102, 5))
        testList3.add(CraftCost(100, 2))
        craftingList.add(Recipe("House", testList3, 300))

        val inventory = Inventory()
        inventory.addItemToInventory()


        assert()
    }
}