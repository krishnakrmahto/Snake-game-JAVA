// <applet code = "SnakeGame" width = "400" height = "400"></applet>

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;

public class SnakeGame extends Applet implements Runnable, KeyListener {

  // Setting up reference variables to support double buffer for graphics..\
  // rendering and updation.
  Graphics graphics;
  Image img;

  public void init() {
    this.resize(400, 400);
    img = createImage(400, 400);
    graphics = img.getGraphics(); // this graphics is currently not a part of Applet window
  }

  public void paint(Graphics g) {
    /* setColor() sets this graphics context's current color to the specified..\
     color. All subsequent graphics operations using this graphics context use..\
     this specified color. */
    graphics.setColor(Color.black);
    graphics.fillRect(0,0,400,400);

    g.drawImage(img, 0, 0, null); // g is the reference variable containing the context\
                                  // of the applet window.
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void repaint(Graphics g) {
    paint(g);
  }

  public void run() {

  }

  public void keyPressed(KeyEvent kEvent) {
    if(kEvent.getKeyCode() == KeyEvent.VK_UP)
    if(kEvent.getKeyCode() == KeyEvent.VK_DOWN)
    if(kEvent.getKeyCode() == KeyEvent.VK_LEFT)
    if(kEvent.getKeyCode() == KeyEvent.VK_RIGHT)
  }

  public void keyReleased(KeyEvent kEvent) {

  }

  public void keyTyped(KeyEvent kEvent) {

  }
}
