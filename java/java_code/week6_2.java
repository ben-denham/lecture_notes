import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Board extends JPanel implements MouseListener {

    private JFrame frame;

    public Board() {
	addMouseListener(this);
	frame = new JFrame();
	frame.setBounds(10, 10, 600, 600);
	Container container = frame.getContentPane();
	container.add(this);
	// Must be done before getting the graphics, otherwise getGraphics()
	// will return null.
	frame.setVisible(true);
	setBackground(Color.white);

	Graphics g = getGraphics();
	Ball ball;
	Thread ballThread;
	for (int i = 0; i < 10; i++) {
	    ball = new Ball(g, i * 10);
	    ball.setLocation((int)Math.random() * 100, (int)Math.random() * 100);
	    ball.setVelocity(i, 10 - i);
	    // If Ball extended Thread, we could use:
	    //ball.start();
	    ballThread = new Thread(ball);
	    ballThread.start();
	}
    }

    public void mouseClicked(MouseEvent me) {
	System.out.println(String.format("%s,%s", me.getX(), me.getY()));
    }

    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    public void mouseEntered(MouseEvent me) { }
    public void mouseExited(MouseEvent me) { }

}

class Ball implements Runnable {

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
	g.setColor(Color.blue);
	g.fillOval(x, y, diameter, diameter);
	try {
	    Thread.sleep(20);
	}
	catch (InterruptedException ex) {}
	g.setColor(Color.white);
	g.fillOval(x, y, diameter, diameter);
    }

    public void run() {
	while (true) {
	    move();
	    draw();
	}
    }

}

class Tester {

    public static void main(String[] args) {
	new Board();
    }

}
