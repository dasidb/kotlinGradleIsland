import org.junit.Test;
import processing.core.PApplet;
import processing.core.PVector;

import static org.assertj.core.api.Assertions.*;

public class TestBuildItem {


    @Test
    public void placeHouseWithHousesLeft() {
        Inventory inventory = new Inventory();
        inventory.addItemToInventory(new Item(300, "House", "a", 50, "a"), 2);
        inventory.addItemToInventory(new Item(300, "House", "a", 50, "a"), 2);
        inventory.placeItem(inventory.getPlayerItemMap().get(300));


        assertThat(inventory.getPlayerItemMap().size()).isEqualTo(1);
    }

    @Test
    public void placeHouseWithNOHousesLeft() {
        Inventory inventory = new Inventory();
        inventory.addItemToInventory(new Item(300, "House", "a", 50, "a"), 1);
        inventory.placeItem(inventory.getPlayerItemMap().get(300));
        BuildManager buildManager = new BuildManager();
        buildManager.build(inventory.getPlayerItemMap().get(300), new PVector(50, 50));
        assertThat(inventory.getPlayerItemMap().size()).isEqualTo(0);

    }

@Test
    public void placeHouseBuildListEqual1() {
        Inventory inventory = new Inventory();
        PlayGameState playGameState = new PlayGameState(new PApplet(),null, new Character(null));
        inventory.addItemToInventory(new Item(300, "House", "a", 50, "a"), 1);
        inventory.placeItem(inventory.getPlayerItemMap().get(300));

        playGameState.getBuildManager().build(inventory.getPlayerItemMap().get(300), new PVector(50, 50));

        assertThat(playGameState.getBuildManager().getBuildList.size()).isEqualTo(1);
    }
}