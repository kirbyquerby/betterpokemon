package legindus.betterpokemon.model;

import java.awt.Image;



/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public abstract class Actor{
    
    private int x, y;
    
    private CellMap map = null;
    
    public Actor(int x, int y){
        this.x=x;
        this.y=y;
    }
    
 
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

    public void setX(int x) {
        map.put(y, x, null);
        this.x = x;
        map.put(y, x, this);
    }

    public void setY(int y) {
        map.put(y, x, null);
        this.y = y;
        map.put(y, x, this);
    }
    
    public void enter(CellMap m){
        if(map!=null){
            map.put(y, x, null);
        }
        map=m;
        map.put(y, x, this);
        
    }
    
    public void leave(){
        map.put(y,x,this);
        map=null;
    }
    
    public CellMap map(){
        return map;
    }
    
    public abstract void scale(int newsize);
    
    public abstract Image getImage();
    
}
