import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

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
        assertThat(inventory.getPlayerItemMap().size()).isEqualTo(0);
    }

    @Test
    public void trueFromBuildManager() {
        BuildManager buildManager = new BuildManager();
        Inventory inventory = new Inventory();
        inventory.addItemToInventory(new Item(300, "House", "a", 50, "a"), 1);

        assertThat(buildManager.build(inventory.getPlayerItemMap().get(300))).isEqualTo(true);
    }
}
