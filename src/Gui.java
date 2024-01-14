import java.awt.FlowLayout;

import javax.swing.*;

public class Gui extends JFrame {

	public static void main(String[] args) {
		Gui g = new Gui();
	}

	Gui() {
		App a = new App();
		JFrame fram = new JFrame("App");
		fram.setSize(400, 400);
		fram.setLocationRelativeTo(null);
		JButton button = new JButton("Choose file for Encrypt");
		JButton button2 = new JButton("Choose file for Decrypt");
		JTextField tf = new JTextField(10);
		button2.addActionListener(e -> {
			String s = tf.getText();
			try {
				int key = Integer.parseInt(s);
				a.button_clicked_decrept(key);
			} catch (Exception E) {
				E.printStackTrace();
				JOptionPane.showMessageDialog(null, "Enter valid key", "", JOptionPane.WARNING_MESSAGE);
			}
		});

		button.addActionListener(e -> {
			String s = tf.getText();
			try {
				int key = Integer.parseInt(s);
				a.button_clicked_encrept(key);;
			} catch (Exception E) {
				JOptionPane.showMessageDialog(null, "Enter Password First!", "Warning", JOptionPane.WARNING_MESSAGE);
				E.printStackTrace();
			}

		});
		fram.add(button);
		fram.add(button2);
		fram.setLayout(new FlowLayout());
		fram.add(tf);
		fram.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fram.setVisible(true);
	}

}
