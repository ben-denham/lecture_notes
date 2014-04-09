import java.awt.*;
import javax.swing.*;

class Board extends JPanel {

    private JFrame frame;

    public Board() {
	frame = new JFrame();
	frame.setBounds(10, 10, 600, 600);
	Container container = frame.getContentPane();
	container.add(this);
	// Must be done before getting the graphics, otherwise getGraphics()
	// will return null.
	frame.setVisible(true);
	setBackground(Color.white);

	Graphics g = getGraphics();
	Ball ball = new Ball(g, 50);
	ball.setLocation(50, 80);
	ball.setVelocity(1, 2);
	while (true) {
	    ball.move();
	    ball.draw();
	}
    }

}

class Ball {

    private Graphics g;
    private int diameter;
    private int x;
    private int y;
    private int xVelocity = 1;
    private int yVelocity = 1;

    public Ball(Graphics g, int diameter) {
	this.g = g;
	this.diameter = diameter;
    }

    public void setLocation(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public void setVelocity(int xVelocity, int yVelocity) {
	this.xVelocity = xVelocity;
	this.yVelocity = yVelocity;
    }

    public void move() {
	x += xVelocity;
	y += yVelocity;

	if (x > 500 || x < 0) {
	    xVelocity = -xVelocity;
	}

	if (y > 500 || y < 0) {
	    yVelocity = -yVelocity;
	}
    }

    public void draw() {
	g.setColor(Color.red);
	g.fillOval(x, y, diameter, diameter);
	try {
	    Thread.sleep(20);
	}
	catch (InterruptedException ex) {}
	g.setColor(Color.white);
	g.fillOval(x, y, 50, 50);
    }

}

class Tester {

    public static void main(String[] args) {
	new Board();
    }

}
