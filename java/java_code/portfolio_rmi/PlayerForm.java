import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.rmi.*;

class PlayerForm extends JFrame implements ActionListener {

    private JTextField txtPlayerNo;
    private JTextField txtName;
    private JTextField txtTown;

    private PlayerRemote playerRemote;

    public PlayerForm() {
	setTitle("Players");
	setBounds(10, 10, 400, 600);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	JLabel lblPlayerNo = new JLabel("Player no:");
	txtPlayerNo = new JTextField();
	JLabel lblName = new JLabel("Name:");
	txtName = new JTextField();
	JLabel lblTown = new JLabel("Town:");
	txtTown = new JTextField();
	JButton btnGet = new JButton("Get");
	txtTown = new JTextField();
	JButton btnExit = new JButton("Exit");

	lblPlayerNo.setBounds(10, 10, 100, 20);
	txtPlayerNo.setBounds(130, 10, 100, 20);
	lblName.setBounds(10, 70, 100, 20);
	txtName.setBounds(130, 70, 100, 20);
	lblTown.setBounds(10, 100, 100, 20);
	txtTown.setBounds(130, 100, 100, 20);
	btnGet.setBounds(10, 40, 100, 20);
	btnExit.setBounds(130, 40, 100, 20);

	btnGet.addActionListener(this);
	btnExit.addActionListener(this);

	Container container = getContentPane();
	// We have to set layout on the container because this is java 1.4.
	container.setLayout(null);
	container.add(lblPlayerNo);
	container.add(txtPlayerNo);
	container.add(lblName);
	container.add(txtName);
	container.add(lblTown);
	container.add(txtTown);
	container.add(btnGet);
	container.add(btnExit);

	setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
	String command = ae.getActionCommand();
	if (command == "Get") {
	    Player player;
	    int id = Integer.parseInt(txtPlayerNo.getText());
	    try {
		if (playerRemote == null) {
		    Remote remote = Naming.lookup("rmi://127.0.0.1/PlayerService");
		    playerRemote = (PlayerRemote) remote;
		}
		player = playerRemote.get(id);
		txtName.setText(player.getName());
		txtTown.setText(player.getTown());
	    } catch (Exception e) {
		System.out.println(e);
	    }
	}
	else if (command == "Exit") {
	    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
    }

    public static void main(String[] args) {
	new PlayerForm();
    }

}
