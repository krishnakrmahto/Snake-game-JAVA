import java.awt.Graphics;
import java.awt.Color;

public class Token {
  private int x, y, score;

  private Snake snake;

  public Token(Snake s) {
    x = (int)(Math.random() * 395);
    y = (int)(Math.random() * 395);
    snake = s;
  }

  public void changePosition() {
    x = (int)(Math.random() * 395);
    y = (int)(Math.random() * 395);
  }

  public int getScore() {
    return score;
  }

  public void draw(Graphics g) {
    g.setColor(Color.green);
    g.fillRect(x, y, 6, 6);
  }

  public boolean snakeCollision() {
    int snakeX = snake.getHeadX() + 2; // x coordinate of centre of the head of the snake
    int snakeY = snake.getHeadY() + 2; // y coordinate of centre of the head of the snake
    if(snakeX >= x-1 && snakeX <= (x+7)) // this ....(continues below)
      if(snakeY >= y-1 && snakeY <= (y+7)) { // and this make sure that any portion of snake's head hits any portion of the token
        changePosition();
        score++;
        snake.setElongate(true);
        return true;
      }

    return false;

  }
}
