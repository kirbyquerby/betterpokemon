package legindus.betterpokemon.implementation.test;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import legindus.betterpokemon.model.Actor;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class SmileyActor extends Actor{
    
    static int SMILEY_RATIO = 1;
    
    static final Image SMILEY = new BufferedImage(32, 32, BufferedImage.TYPE_4BYTE_ABGR);
    
    static Image CURRENT = SMILEY;
    
    
    static{
        
        Graphics g = SMILEY.getGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0,0,32,32);
        
        g.setColor(Color.YELLOW);
        g.fill3DRect(4, 4, 24, 24, true);
        
        g.setColor(Color.BLACK);
        g.fillOval(10, 10, 2, 2);
        g.fillOval(16,10,2,2);
        
        g.drawArc(10, 12, 10, 5, 180, 180);
        
        
        
    }
    
    public SmileyActor(int x, int y){
        super(x,y);
    }
    
    
    //there shoudl be a bit(a lot) more optimization here - don't use this code
    @Override
    public void scale(int ratio) {
        if(SMILEY_RATIO==ratio){
            return;
        }
        CURRENT = SMILEY.getScaledInstance(ratio, ratio, BufferedImage.SCALE_SMOOTH);
        SMILEY_RATIO=ratio;
    }
    
    @Override
    public Image getImage(){
        return CURRENT;
    }
    
    
}
