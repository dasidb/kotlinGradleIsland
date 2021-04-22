import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class BuildManager {

    private ArrayList<PlayerItem> buildList = new ArrayList<>();
    private boolean buildstate = false;

    ArrayList<Renderable> testList;
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
        mockList();
    }
    public boolean build(PlayerItem playerItem, PVector pVector){
        buildList.add(playerItem);

        return false;
    }

    public void render(PApplet pApplet) {
        //if(buildstate) {
            drawBuildings();
            drawBuildOutlines();
           // System.out.println("test");

       // }
    }

    public
    void drawBuildOutlines() {

    }

    public void drawBuildings() {
        GridDrawer.getInstance().drawGrid(1,testList);
    }

    public void mockList(){
        testList = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            testList.add(new TestRenderableObject(5, 5, "tent"));
        }
    }
}
