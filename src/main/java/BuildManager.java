import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class BuildManager {

    private ArrayList<PlayerItem> buildList = new ArrayList<>();

    public ArrayList<PlayerItem> getBuildList() {
        return buildList;
    }

    public void setBuildList(ArrayList<PlayerItem> buildList) {
        this.buildList = buildList;
    }

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
