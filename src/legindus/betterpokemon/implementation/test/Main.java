package legindus.betterpokemon.implementation.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import legindus.betterpokemon.model.CellMap;
import legindus.betterpokemon.view.CellMapPanel;

/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class Main {

    public static void main(String[] args) {
        smileyActor();
//        optimizedSmiley();

    }

    static void smileyActor() {
        CellMap map = new CellMap();

        SmileyActor a, b, c, d;

        a = new SmileyActor(1, 1);

        b = new SmileyActor(2, 2);

        c = new SmileyActor(3, 3);

        d = new SmileyActor(0, 0);
        
        a.enter(map);
        b.enter(map);
        c.enter(map);
        d.enter(map);

        CellMapPanel p = new CellMapPanel(600, 400, 32, map);
        p.setBounds(50, 25, 600, 400);

        //System.out.println("I like big bundles of cash and I just can't lie");

        //p.resize(10);
        p.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '+') {
                    p.scale(p.getCellsize() * 2);
                } else if (e.getKeyChar() == '-') {
                    p.scale(p.getCellsize() / 2);
                } else if (e.getKeyChar() == 'd') {
                    p.setCamera(p.getCameraX() + 1, p.getCameraY());
                } else if (e.getKeyChar() == 's') {
                    p.setCamera(p.getCameraX(), p.getCameraY() + 1);
                } else if (e.getKeyChar() == 'a') {
                    p.setCamera(p.getCameraX() - 1, p.getCameraY());
                } else if (e.getKeyChar() == 'w') {
                    p.setCamera(p.getCameraX(), p.getCameraY() - 1);
                } else if (e.getKeyChar() == 'D') {
                    p.setOffset(p.getOffX() + 1, p.getOffY());
                } else if (e.getKeyChar() == 'S') {
                    p.setOffset(p.getOffX(), p.getOffY() + 1);
                } else if (e.getKeyChar() == 'A') {
                    p.setOffset(p.getOffX() - 1, p.getOffY());
                } else if (e.getKeyChar() == 'W') {
                    p.setOffset(p.getOffX(), p.getOffY() - 1);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JFrame frame = new JFrame("smiley test");

        frame.setLayout(null);
        frame.setSize(700, 500);

        frame.add(p);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                frame.repaint();
            }
        }).start();
    }

    static void optimizedSmiley() {

        CellMap m = new CellMap();

        CellMapPanel p = new CellMapPanel(800, 500, 32, m);

        p.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '+') {
                    p.scale(p.getCellsize() * 2);
                } else if (e.getKeyChar() == '-') {
                    p.scale(p.getCellsize() / 2);
                } else if (e.getKeyChar() == 'd') {
                    p.setCamera(p.getCameraX() + 1, p.getCameraY());
                } else if (e.getKeyChar() == 's') {
                    p.setCamera(p.getCameraX(), p.getCameraY() + 1);
                } else if (e.getKeyChar() == 'a') {
                    p.setCamera(p.getCameraX() - 1, p.getCameraY());
                } else if (e.getKeyChar() == 'w') {
                    p.setCamera(p.getCameraX(), p.getCameraY() - 1);
                } else if (e.getKeyChar() == 'D') {
                    p.setOffset(p.getOffX() + 1, p.getOffY());
                } else if (e.getKeyChar() == 'S') {
                    p.setOffset(p.getOffX(), p.getOffY() + 1);
                } else if (e.getKeyChar() == 'A') {
                    p.setOffset(p.getOffX() - 1, p.getOffY());
                } else if (e.getKeyChar() == 'W') {
                    p.setOffset(p.getOffX(), p.getOffY() - 1);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        
        p.setBounds(100, 100, 800, 600);

        OptimizedSmiley a, b, c, d;
        
        a = new OptimizedSmiley(1, 1);
        b = new OptimizedSmiley(4, 9);
        c = new OptimizedSmiley(2, 3);
        d = new OptimizedSmiley(1, 5);
        
        a.enter(m);
        b.enter(m);
        c.enter(m);
        d.enter(m);
        p.scale(p.getCellsize());
        
        OptimizedSmiley.setScaleType(BufferedImage.SCALE_SMOOTH);
        
        JFrame frame = new JFrame("optimized smiley test");
        frame.setLayout(null);
        frame.setSize(1000, 700);
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                frame.repaint();
            }
        }).start();
    }

}
