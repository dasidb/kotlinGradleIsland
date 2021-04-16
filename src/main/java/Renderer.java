import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Map;

public class Renderer {

    private static Renderer instance;
    private Map<String, PImage> imageMap;
    PApplet pApplet;
    private ArrayList<Renderable> buildList = new ArrayList<>();

    private Renderer() {
        test();
    }

    public void setImageMap(Map<String, PImage> imageMap) {
        this.imageMap = imageMap;
    }

    public static Renderer getInstance() {
        if (instance == null) {
            instance = new Renderer();
        }
        return instance;
    }

    public void setPapplet(PApplet pApplet) {
        if (this.pApplet == null) {
            this.pApplet = pApplet;
        }
    }

    public void render(Renderable renderable) {
        renderDifferentLayers(renderable);

    }

    public void renderDifferentLayers(Renderable renderable) {

    }

    public void renderFirstLayer(GameState gameState) {
        //pApplet.image(imageMap.get(renderable.getImgLink()), renderable.getPosX(), renderable.getPosY());
        gameState.render();
        if(gameState.isThereASecondLayer()) {
            renderSecondLayer();
        }
    }


    public void renderSecondLayer() {
        //todo render buildings
        PImage pImage = new PImage();

        for(Renderable building : buildList) {
            pApplet.image(pImage = imageMap.get(building.imageName()), building.getPosX(), building.getPosY());
        }

    }

    public void test(){
        buildList.add(new TestRenderableObject(0.0F, 0.0F, "arrowright"));
    }
}
