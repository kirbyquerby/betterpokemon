package legindus.betterpokemon.implementation.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import legindus.betterpokemon.model.OptimizedActor;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class OptimizedSmiley extends OptimizedActor{
    
    final static String SMILEY_FACE = "smiles for days!";
    
    
    
    static{
        BufferedImage SMILEY = new BufferedImage(
                32, 32, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = SMILEY.getGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0,0,32,32);
        
        g.setColor(Color.YELLOW);
        g.fill3DRect(4, 4, 24, 24, true);
        
        g.setColor(Color.BLACK);
        g.fillOval(10, 10, 2, 2);
        g.fillOval(16,10,2,2);
        
        g.drawArc(10, 12, 10, 5, 180, 180);
        
        addImage(SMILEY, SMILEY_FACE);
    }
    
    public OptimizedSmiley(int x, int y){
        super(x,y);
    }
    
    @Override
    public Image getImage(){
        return getImage(SMILEY_FACE);
    }
    
    
    
}
