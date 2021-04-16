import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class BuildManager {

    private ArrayList<PlayerItem> buildList = new ArrayList<>();
    private boolean buildstate = false;

    public ArrayList<PlayerItem> getBuildList() {
        return buildList;
    }

    public void setBuildList(ArrayList<PlayerItem> buildList) {
        this.buildList = buildList;
    }

    public void setBuildState(){
        this.buildstate = !buildstate;
    }
    public BuildManager(){
        this.buildList = buildList;
    }
    public boolean build(PlayerItem playerItem, PVector pVector){
        buildList.add(playerItem);

        return false;
    }

    public void render(PApplet pApplet) {
        if(buildstate) {
            drawBuildOutlines();
            drawBuildings();
        }
    }

    private void drawBuildOutlines() {

    }

    private void drawBuildings() {

    }
}
