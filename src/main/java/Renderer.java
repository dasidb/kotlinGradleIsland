import processing.core.PApplet;
import processing.core.PImage;

import java.util.HashMap;
import java.util.Map;

public class Renderer {

    private static Renderer instance;
    private Map<String, PImage> imageMap;
    PApplet pApplet;

    private Renderer() {
    }

    public void setImageMap(Map<String, PImage> imageMap) {
        this.imageMap = imageMap;
    }

    public static Renderer getInstance() {
        if (instance == null) {
            instance = new Renderer();
        }
        return  instance;
    }

    public void setPapplet(PApplet pApplet){
        if (this.pApplet == null) {
            this.pApplet = pApplet;
        }
    }

    public void render(Renderable renderable) {
    pApplet.image(imageMap.get(renderable.getImgLink()),renderable.getPosX(),renderable.getPosY());
    }
}
