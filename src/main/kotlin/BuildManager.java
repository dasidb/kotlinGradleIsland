import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class BuildManager {
    private ArrayList<PlayerItem> buildList;
    public BuildManager(){
        this.buildList = buildList;
    }
    public boolean build(PlayerItem playerItem, PVector pVector){
        buildList.add(playerItem);

        return false;
    }

    public void render(PApplet pApplet) {

    }
}
