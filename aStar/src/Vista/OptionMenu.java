package Vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionMenu extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public OptionMenu() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Numero de filas");
		add(btnNewButton);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Numero de columnas");
		add(btnNewButton_1);
		
		textField_2 = new JTextField();
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Set Tablero");
		add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VistaPrincipal.getInstance().setTablero(new Tablero(4, 5));
			}
		});
		
	}

}
