import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Tester {

    public static void main(String[] args) {
	try {
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    Connection connection = DriverManager.getConnection("jdbc:odbc:tennis_access","","");
	    PlayerForm playerForm = new PlayerForm(connection);
	    // We should really close the connection at some point.
	} catch (Exception e) {
	    System.out.println(e);
	}
    }

}

class PlayerForm extends JFrame implements ActionListener {

    JTextField txtPlayerNo;
    JTextField txtName;
    JTextField txtInitials;
    JTextField txtTown;
    Connection connection;

    public PlayerForm(Connection connection) {
	this.connection = connection;

	setTitle("Players");
	setBounds(10, 10, 400, 600);

	JLabel lblPlayerNo = new JLabel("Player no:");
	txtPlayerNo = new JTextField();
	JLabel lblName = new JLabel("Name:");
	txtName = new JTextField();
	JLabel lblInitials = new JLabel("Initials:");
	txtInitials = new JTextField();
	JLabel lblTown = new JLabel("Town:");
	txtTown = new JTextField();
	JButton btnSearch = new JButton("Search");
	
	lblPlayerNo.setBounds(10, 10, 100, 20);
	txtPlayerNo.setBounds(130, 10, 100, 20);
	lblName.setBounds(10, 70, 100, 20);
	txtName.setBounds(130, 70, 100, 20);
	lblInitials.setBounds(10, 100, 100, 20);
	txtInitials.setBounds(130, 100, 100, 20);
	lblTown.setBounds(10, 130, 100, 20);
	txtTown.setBounds(130, 130, 100, 20);
	btnSearch.setBounds(10, 40, 100, 20);

	btnSearch.addActionListener(this);

	Container container = getContentPane();
	// We have to set layout on the container because this is java 1.4.
	container.setLayout(null);
	container.add(lblPlayerNo);
	container.add(txtPlayerNo);
	container.add(btnSearch);
	container.add(lblName);
	container.add(txtName);
	container.add(lblInitials);
	container.add(txtInitials);
	container.add(lblTown);
	container.add(txtTown);

	setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
	Player p = new Player(connection);
	int playerno = Integer.parseInt(txtPlayerNo.getText());
	String[] player = new String[3];
	try {
	    player = p.getPlayer(playerno);
	} catch (Exception e) {
	    System.out.println(e);
	}
	txtName.setText(player[0]);
	txtInitials.setText(player[1]);
	txtTown.setText(player[2]);
    }

}

class Player {

    private Connection connection;

    public Player(Connection connection) {
	this.connection = connection;
    }

    public String[] getPlayer(int playerno) throws SQLException{
	Statement statement = connection.createStatement();
	String query = "select name, initials, town from players where playerno = " + playerno;
	ResultSet result = statement.executeQuery(query);

	if (result.next()) {
	    return new String[] {result.getString(1), result.getString(2), result.getString(3)};
	}

	return null;
    }

}
