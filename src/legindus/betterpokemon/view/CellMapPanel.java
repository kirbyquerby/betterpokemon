package legindus.betterpokemon.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import legindus.betterpokemon.model.Actor;
import legindus.betterpokemon.model.CellMap;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class CellMapPanel extends JPanel {

    private int cellsize;
    //whole number scale x and y
    private int x, y;
    //don't make this larger than the size of a cell
    private int offx, offy;
    //approximate
    private int area;

    BufferedImage buffer;
    CellMap map;

    //width in pixels, height in pixels, cell size in pixels, (smallest)image 
    //width in pixels
    public CellMapPanel(int w, int h, int cs, CellMap m) {
        super(null);
        map = m;
        x = y = offx = offy = 0;
        scale(cs);
        setDimensions(w, h);
    }

    public void scale(int cs) {
        if(cs<=0){
            return;
        }
        for (Actor a : map.actors()) {
            a.scale(cs);
        }
        setCellsize(cs);
    }

    void setDimensions(int w, int h) {
        setSize(w, h);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        //super crude, sorry I'll fix later maybe
        //pls don't use super random big offsets :3
        int wid = offx == 0 ? getWidth() : getWidth() + 1;
        int hig = offy == 0 ? getHeight() : getHeight() + 1;
        area = wid * hig;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics bg = buffer.getGraphics();
        paintBuffer(bg);
        g.drawImage(buffer, 0, 0, null);

    }

    void paintBuffer(Graphics g) {
        g.setColor(java.awt.Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (area > map.actors().size()) {
            pSmall(g);
        } else {
            pLarge(g);
        }

    }

    //todo: add math optimization
    void pSmall(Graphics g) {
        for (Actor a : map.actors()) {
            if (a.getX() >= x - 1 && a.getX() <= x + 1 + getWidth()) {

                if (a.getY() >= y - 1 && a.getY() <= y + 1 + getHeight()) {
                    g.drawImage(a.getImage(), (a.getX() - x) * cellsize - offx, (a.getY() - y) * cellsize - offy, null);
                }

            }
        }
    }

    void pLarge(Graphics g) {
        int wid = offx == 0 ? getWidth() : getWidth() + 2;
        int hig = offy == 0 ? getHeight() : getHeight() + 2;

        for (int col = x - 1; col < wid; col++) {

            for (int row = y - 1; row < hig; row++) {
                Actor a = map.get(row, col);
                if (a != null) {
                    g.drawImage(a.getImage(), a.getX() * cellsize, a.getY() * cellsize, null);
                }
            }

        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void setCamera(int x, int y) {
        System.out.println(x + " " + y);
        this.x = x;
        this.y = y;
    }

    public void setCamera(int x, int y, int offx, int offy) {
        setCamera(x, y);
        setOffset(offx, offy);
    }

    public void setOffset(int offx, int offy) {
        if (offx < 0) {
            this.offx = -offx < cellsize ? offx : -cellsize + 1;
        } else {
            this.offx = offx < cellsize ? offx : cellsize - 1;
        }
        if (offy < 0) {
            this.offy = -offy < cellsize ? offy : -cellsize + 1;
        } else {
            this.offy = offy < cellsize ? offy : cellsize - 1;
        }
    }

    public int getCameraX() {
        return x;
    }

    public int getCameraY() {
        return y;
    }

    public int getOffX() {
        return offx;
    }

    public int getOffY() {
        return offy;
    }

    public int getCellsize() {
        return cellsize;
    }

    public void setCellsize(int cellsize) {
        this.cellsize = cellsize;
    }

}
