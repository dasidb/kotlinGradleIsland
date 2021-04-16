public class TestRenderableObject implements Renderable{

    float posX;
    float posY;
    String imageName;

    @Override
    public float getPosX() {
        return this.posX;
    }

    @Override
    public float getPosY() {
        return this.posY;
    }

    @Override
    public String imageName() {
        return this.imageName;
    }

    public TestRenderableObject(float posX, float posY, String imageName){
        this.posX = posX;
        this.posY = posY;
        this.imageName = imageName;
    }
}
