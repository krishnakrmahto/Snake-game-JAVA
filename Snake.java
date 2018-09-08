// Our Snake is going to be a list of points.
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;

public class Snake {
  List<Point> snakePoints;
  int xDir, yDir; // if xDir == -1,snake heads towards the left, if xDir == 1, snake moves towards the right
                  // if yDir == -1, snake moving up..........." " "
                  // if xDir == 0, snake not moving in xDir, if yDir == 0, snake not moving in y direction.
  boolean isMoving, elongate;
  final int STARTSIZE = 20, STARTX = 150, STARTY = 150;

  public Snake() {
    snakePoints = new ArrayList<Point>();

    // Snake not moving initially
    xDir = 0;
    yDir = 0;
    isMoving = false;
    elongate = false;
    snakePoints.add(new Point(STARTX, STARTY));
    for(int i=1; i<STARTSIZE; i++)
      snakePoints.add(new Point(STARTX-i * 4, STARTY));
  }

  public void draw(Graphics g) {
    g.setColor(Color.white);
    for(Point p: snakePoints)
      g.fillRect(p.getX(), p.getY(), 4, 4);
  }

  public void move() {
    if(isMoving) {
      Point head = snakePoints.get(0);
      Point last = snakePoints.get(snakePoints.size() - 1);
      Point newHead = new Point(head.getX() + xDir * 4, head.getY() + yDir * 4);
      for(int i = snakePoints.size()-1; i >= 1; i--) {
        snakePoints.set(i, snakePoints.get(i - 1));
      }
      snakePoints.set(0, newHead);
    }
  }

  public boolean isMoving() {
    return isMoving;
  }

  public void setIsMoving(boolean b) {
    isMoving = b;
  }

  public int getXDir() {
    return this.xDir;
  }

  public int getYDir() {
    return this.yDir;
  }

  public void setXDir(int x) {
    this.xDir = x;
  }

  public void setYDir(int y) {
    this.yDir = y;
  }

  // X position of the head of snake
  public int getHeadX() {
    return this.snakePoints.get(0).getX(); // invokes getX() method defined in Point class
                                          // since 0th element is a Point object
  }
}
