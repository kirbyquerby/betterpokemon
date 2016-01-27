package legindus.betterpokemon.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * The optimized actor adds efficiency by making certain assumptions.
 * 
 * List of assumptions:
 * All Optimized Actors will share a pool of Images and know of each other's
 * images. Developers should take extra care not to have image description
 * conflicts.
 * 
 * All Optimized Actors have the same image-scaling quality. Developers should 
 * keep in mind that all Optimized Actors will scale with the same strategy.
 * 
 * 
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public abstract class OptimizedActor extends Actor{
    
    static Map<String, BufferedImage> originals;
    static Map<String, Image> scaled;
    
    static int ratio;
    static int scaleType = BufferedImage.SCALE_FAST;
    
    
    static{
        originals = new HashMap<>();
        scaled = new HashMap<>();
        ratio = 1;
    }
    
    public OptimizedActor(int x, int y){
        super(x,y);
    }
    
    @Override
    public void scale(int newsize){
        if(ratio==newsize){
            return;
        }
        ratio=newsize;
        for(String s : originals.keySet()){
            scaled.put(s, originals.get(s).getScaledInstance(ratio, ratio, 
                    getScaleType()));
        }
    }
    
    
    protected static void addImage(BufferedImage i, String description){
        originals.put(description, i);
        scaled.put(description,i.getScaledInstance(ratio, ratio, 
                getScaleType()));
    }
    
    protected static Image getImage(String description){
        return scaled.get(description);
    }
    
    public static void setScaleType(int scaletype){
        scaleType = scaletype;
    }
    
    public static int getScaleType(){
        return scaleType;
    }
    
}
