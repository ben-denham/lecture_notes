import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Board extends JPanel implements MouseListener {

    private JFrame frame;
    private BoardObserver observer;

    public Board() {
	observer = new BoardObservable();
	addMouseListener(this);
	frame = new JFrame();
	frame.setBounds(10, 10, 600, 600);
	Container container = frame.getContentPane();
	container.add(this);
	// Must be done before getting the graphics, otherwise getGraphics()
	// will return null.
	frame.setVisible(true);
	setBackground(Color.white);

	Ball ball;
	Thread ballThread;
	for (int i = 0; i < 10; i++) {
	    ball = new Ball(this, 30 + i * 10);
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
	observer.boardClicked(me.getX(), me.getY());
    }

    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    public void mouseEntered(MouseEvent me) { }
    public void mouseExited(MouseEvent me) { }

}

class BoardObservable extends Observable {

    private int x;
    private int y;

    public boardClicked(int x, int y) {
	this.x = x;
	this.y = y;
	setChanged();
    }

    public void notifyObservers() {

    }

}

class Ball implements Runnable, Observer {

    private static int idCounter;
    private int id;
    private boolean alive = true;
    private Board board;
    private Graphics g;
    private int diameter;
    private int x;
    private int y;
    private int xVelocity = 1;
    private int yVelocity = 1;

    public Ball(Board board, int diameter) {
	id = idCounter++;
	this.board = board;
	board.addMouseListener(this);
	g = board.getGraphics();
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
	g.setColor(Color.white);
	int radius = diameter/2;
	g.drawString(String.format("%d", id), x + radius, y + radius);
	try {
	    Thread.sleep(20);
	}
	catch (InterruptedException ex) {}
	clear();
    }

    public void run() {
	while (alive) {
	    move();
	    draw();
	}
    }

    public void clear() {
	g.setColor(Color.white);
	g.fillOval(x, y, diameter, diameter);
    }

    public void delete() {
	System.out.println(String.format("Deleted ball %d", id));
	alive = false;
	clear();
	board.removeMouseListener(this);
    }

    public boolean contains(int xc, int yc) {
	return (xc > x && xc < x + diameter &&
		yc > y && yc < y + diameter);
    }

    public void update(Observable o, Object arg) {
	if (contains(me.getX(), me.getY())) {
	    delete();
	}
    }

    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    public void mouseEntered(MouseEvent me) { }
    public void mouseExited(MouseEvent me) { }

}

class Tester {

    public static void main(String[] args) {
	new Board();
    }

}
