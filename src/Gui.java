import java.awt.FlowLayout;

import javax.swing.*;

public class Gui extends JFrame {

	public static void main(String[] args) {
		Gui g = new Gui();
	}

	Gui() {
		App a = new App();
		JFrame fram = new JFrame("App");
		fram.setSize(400, 300);
		fram.setLocationRelativeTo(null);
		JButton button = new JButton("Choose file for Encrypt");
		JButton button2 = new JButton("Choose file for Decrypt");
		JLabel lable = new JLabel("Enter Password:");

		JTextField tf = new JTextField(10);
		lable.setSize(tf.getSize());
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
				a.button_clicked_encrept(key);
				;
			} catch (Exception E) {
				JOptionPane.showMessageDialog(null, "Enter Password First!", "Warning", JOptionPane.WARNING_MESSAGE);
				E.printStackTrace();
			}

		});
		fram.add(button);
		button.setFocusable(false);
		button2.setFocusable(false);
		fram.add(button2);
		fram.add(lable);
		fram.setResizable(false);
		fram.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
		fram.add(tf);
		fram.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fram.setVisible(true);
	}

}
