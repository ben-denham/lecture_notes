import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ProductFrame extends JFrame {

    public ProductFrame() {
	setTitle("Product");
	setLayout(null);
	setBounds(10, 10, 400, 220);

	JLabel lblPcode = new JLabel("Pcode:");
	JLabel lblDescription = new JLabel("Description:");
	JLabel lblPrice = new JLabel("Price:");
	JTextField txtPcode = new JTextField();
	JTextField txtDescription = new JTextField();
	JTextField txtPrice = new JTextField();
	JButton btnAdd = new JButton("Add");
	JButton btnChange = new JButton("Change");
	JButton btnDelete = new JButton("Delete");

	lblPcode.setBounds(20, 20, 100, 20);
	lblDescription.setBounds(20, 60, 100, 20);
	lblPrice.setBounds(20, 100, 100, 20);
	txtPcode.setBounds(130, 20, 100, 20);
        txtDescription.setBounds(130, 60, 230, 20);
	txtPrice.setBounds(130, 100, 100, 20);
	btnAdd.setBounds(20, 140, 100, 20);
	btnChange.setBounds(140, 140, 100, 20);
	btnDelete.setBounds(260, 140, 100, 20);

	ActionListener listener = new ProductFrameListener();
	btnAdd.addActionListener(listener);
	btnChange.addActionListener(listener);
	btnDelete.addActionListener(listener);

	Container container = getContentPane();
	container.add(lblPcode);
	container.add(txtPcode);
	container.add(lblDescription);
	container.add(txtDescription);
	container.add(lblPrice);
	container.add(txtPrice);
	container.add(btnAdd);
	container.add(btnChange);
	container.add(btnDelete);

	setVisible(true);
    }

}

class ProductFrameListener implements ActionListener {

    public void actionPerformed(ActionEvent ae) {
	System.out.println("ProductListener: '" + ae.getActionCommand() + "' button was clicked.");
    }

}

class Tester {

    public static void main(String[] args) {
	JFrame frame = new ProductFrame();
    }

}
