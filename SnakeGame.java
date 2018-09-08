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
  Thread thread;
  Snake snake;
  boolean gameOver;
  Token token;

  public void init() {
    this.resize(400, 400);
    boolean gameOver = false;
    img = createImage(400, 400);
    graphics = img.getGraphics(); // this graphics is currently not a part of Applet window
                                  // the graphics object is the graphics context for drawing an off-screen image

    this.addKeyListener(this);
    snake = new Snake();
    token = new Token(snake);
    thread = new Thread(this);
    thread.start();
  }

  public void paint(Graphics g) {
    /* setColor() sets this graphics context's current color to the specified..\
     color. All subsequent graphics operations using this graphics context use..\
     this specified color. */
    graphics.setColor(Color.black);
    graphics.fillRect(0,0,400,400);

    if(!gameOver) {
      snake.draw(graphics);
      token.draw(graphics);
    }
    else {
      graphics.setColor(Color.red);
      graphics.drawString("Game Over", 180, 150);
      graphics.drawString("Score: " + token.getScore(), 180, 170);
    }

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
    for(;;) {

      if(!gameOver) {
        snake.move();
        this.checkGameOver();
        token.snakeCollision();
      }
      this.repaint();

      try {
        Thread.sleep(40); // to allow our eyes to pick up that the snake moved
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  public void checkGameOver() {
    if(snake.getHeadX() < 0 || snake.getHeadX() > 396)
      gameOver = true;
    if(snake.getHeadY() < 0 || snake.getHeadY() > 396)
      gameOver = true;
    if(snake.snakeCollision())
      gameOver = true;
  }

  public void keyPressed(KeyEvent kEvent) {

    if(!snake.isMoving()) {
      if(kEvent.getKeyCode() == KeyEvent.VK_UP || kEvent.getKeyCode() == KeyEvent.VK_RIGHT || kEvent.getKeyCode() == KeyEvent.VK_DOWN) {
        snake.setIsMoving(true);
      }
    }

    if(kEvent.getKeyCode() == KeyEvent.VK_UP) {
      if(snake.getYDir() != 1) { // if the snake is not going down, then only it can go up
        snake.setYDir(-1);
        snake.setXDir(0); // while going up, snake can only go up. Not (up + left, ie, diagonally) or anything like that
      }
    }
    if(kEvent.getKeyCode() == KeyEvent.VK_DOWN) {
      if(snake.getYDir() != -1) {
        snake.setYDir(1);
        snake.setXDir(0);
      }
    }
    if(kEvent.getKeyCode() == KeyEvent.VK_LEFT) {
      if(snake.getXDir() != 1) {
        snake.setXDir(-1);
        snake.setYDir(0);
      }
    }
    if(kEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
      if(snake.getXDir() != -1) {
        snake.setXDir(1);
        snake.setYDir(0);
      }
    }
  }

  public void keyReleased(KeyEvent kEvent) {

  }

  public void keyTyped(KeyEvent kEvent) {

  }
}
