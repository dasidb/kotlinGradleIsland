import org.junit.Test;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class TestBuildItem {

@Test
    public void placeHouseBuildListEqual1() {
        Inventory inventory = new Inventory();
        BuildManager buildManager = new BuildManager();
        inventory.addItemToInventory(new Item(300, "House", "a", 50, "a"), 1);
        inventory.placeItem(inventory.getPlayerItemMap().get(300));
        buildManager.build(inventory.getPlayerItemMap().get(300), new PVector(50, 50));

        assertThat(buildManager.getBuildList().size()).isEqualTo(1);
    }
}