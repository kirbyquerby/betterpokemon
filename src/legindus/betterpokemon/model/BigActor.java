package legindus.betterpokemon.model;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public abstract class BigActor extends OptimizedActor{
    
    private int width, height;
    
    public BigActor(int x,int y, int width, int height){
        super(x,y);
        setWidth(width);
        setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
