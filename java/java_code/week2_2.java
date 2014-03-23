import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MainFrame extends JFrame implements ActionListener {

    JTextField txtCustomerName;

    public MainFrame() {

	setTitle("My First UI");
	// Don't use any automatic layout. If we used a layout, we wouldn't need to
	// specify all of bounds.
	setLayout(null);
	// Use setBounds(posX, posY, width, height) to position the Frame.
	setBounds(10, 10, 400, 600);

	// Create our form controls.
        JLabel lblCustomerName = new JLabel("Customer Name");
        txtCustomerName = new JTextField();
        JButton btnOkay = new JButton("Okay");
        JButton btnGet = new JButton("Get");

	// Use setBounds(posX, posY, width, height) to position the controls.
	lblCustomerName.setBounds(20, 20, 100, 20);
	txtCustomerName.setBounds(120, 20, 200, 20);
	btnOkay.setBounds(20, 60, 80, 20);
	btnGet.setBounds(120, 60, 80, 20);

	// Subscribe our Frame to the actions of the button.
        btnOkay.addActionListener(this);
        btnGet.addActionListener(this);

	// We add the items to the container instead of this object in order to avoid
	// conflicts with the JFrame superclass?
	Container con = getContentPane();
	con.add(lblCustomerName);
	con.add(txtCustomerName);
	con.add(btnOkay);
	con.add(btnGet);

	// Show the frame.
	setVisible(true);
    }

    // Implements the ActionListener interface. Handles actions this Frame is listening to.
    public void actionPerformed(ActionEvent ae) {
	String msg = ae.getActionCommand();
        txtCustomerName.setText(msg);
    }

}

class Tester {

    public static void main(String[] args) {
	// Create a new frame object.
	JFrame f = new MainFrame();
    }

}
