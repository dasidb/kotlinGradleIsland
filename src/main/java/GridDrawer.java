import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GridDrawer {

    private static GridDrawer instance;
    private PApplet pApplet;
    private HashMap<String, PImage> imageHashMap;

    public static GridDrawer getInstance() {
        if (instance == null) {
            instance = new GridDrawer();
        }
        return instance;
    }

    public void setPapplet(PApplet pApplet) {
        if (this.pApplet == null) {
            this.pApplet = pApplet;
        }
    }
    public void setImageMap(HashMap<String, PImage> imageMap) {
        this.imageHashMap = imageMap;
    }

    private GridDrawer(){
    }

    public void drawGrid(int selection, ArrayList<Renderable> stuffToRender) {
        for (float x = 0; x < 3; x++) {
            for (float y = 0; y < 3; y++) {
                 int tmpX = selection % 3;
                 int tmpY = selection / 3;
                if(tmpX == x && tmpY == y) {
                    pApplet.fill(255F, 0F, 0F);
                }else {
                    pApplet.fill(255F, 255F, 255F);
                }
                pApplet.rect((x + 1) * 160, (y + 1) * 160, x + 160F, y + 160F);
                String imageName = stuffToRender.get((int)x +((int)y*3)).imageName();
                pApplet.image(imageHashMap.get(imageName),(x + 1) * 160,(y + 1) * 160);
              //  displayCraftings();
            }
        }

    }
/*
    public void displayCraftings() {
        for (float y = 0; y < 3; y++) {
            for (float x = 0; x < 3; x++) {
                var itterator = x + y * 5;
                try {

                    var tmp = craftingList.get(itterator);
                    pApplet.fill(0F, 0F, 0F)
                    pApplet.text(tmp.name, (x + 1) * 160F + 60, (y + 1) * 160F + 60)
                    var tmpItterator = 0
                    tmp.craftCostList.forEach() {

                        pApplet.text(it.amount.toString() + " " + it.name, (x + 1) * 160F + 60F, (y + 1) * 160F + 80 + tmpItterator)
                        tmpItterator += 20
                    }

                } catch (e: IndexOutOfBoundsException) {

                }

            }

        }
    } */
}
