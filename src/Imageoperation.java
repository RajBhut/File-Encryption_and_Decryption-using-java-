import java.awt.FlowLayout;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.*;

public class Imageoperation extends JFrame {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		Imageoperation i = new Imageoperation();
		JFrame f = new JFrame("Image Operation");
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Font font = new Font("Roboto", Font.BOLD, 25);
		JButton b = new JButton("Open Image");
		b.setFont(font);

		b.setFocusable(false);
		JTextField textfield = new JTextField(10);
		textfield.setFont(font);
		f.setLayout(new FlowLayout());
		f.add(b);

		b.addActionListener(e -> {
			String text = textfield.getText();
			try {
				int tem = Integer.parseInt(text);

				i.operate(tem);

			} catch (Exception E) {
				E.printStackTrace();
				JOptionPane.showMessageDialog(null, "please enter valid key");
			}

		});

		f.add(textfield);

		f.setVisible(true);

	}

	public  void operate(int key) {
		
		byte[] x = { 75, 72, 85, 83, 72, 73,28};
		System.out.println(isEncrypted(x));
		
		JFileChooser filechooser = new JFileChooser();
		filechooser.showOpenDialog(null);
		File file = filechooser.getSelectedFile();
		try {
			byte[] check = { 75, 72, 85, 83, 72, 73 };
			FileInputStream filestrem = new FileInputStream(file);
			byte[] data = new byte[filestrem.available()];
			filestrem.read(data);
			filestrem.close();
		/ --------------------------------------------------------------------------------------------------------------------------------------
			System.out.println(data.length + "<- this i slenght");
			System.out.println(this.isEncrypted(data));
			if (this.isEncrypted(data)==true) {
				// Use Arrays.copyOfRange to remove the first 6 bytes (indicator bytes)
				byte[] encryptedData = Arrays.copyOfRange(data, check.length, data.length);
FileOutputStream fos = new FileOutputStream(file);

				// Decrypt the remaining data
				for (int i = 0; i < encryptedData.length; i++) {
					encryptedData[i] = (byte) (encryptedData[i] ^ key);
					fos.write(encryptedData[i]);
				}

				// Write the decrypted data back to the file
								
				fos.close();
				System.out.println("decrept");
				JOptionPane.showMessageDialog(null, "file is decrepted!");

			} else {

				// ------------------------------------------------------------------------------------------------------------------------------------------
				ByteArrayOutputStream output_stream = new ByteArrayOutputStream();

				try {
					output_stream.write(check);
					output_stream.write(data);

					byte[] encrypt_data = output_stream.toByteArray();
					
					
					output_stream.close();
					int i = 0;
					for (byte b : encrypt_data) {
						
						encrypt_data[i] = (byte) (b ^ key);
						i++;
					}
					

					

					FileOutputStream fos = new FileOutputStream(file);
					fos.write(encrypt_data);
					fos.close();

					JOptionPane.showMessageDialog(null, "Done");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  boolean isEncrypted(byte[] data) {
		byte[] check = { 75, 72, 85, 83, 72, 73 };
		if (data.length < check.length) {
		
	
		return false;
		}
		for (int i = 0; i < check.length; i++) {
			if (data[i] != check[i]) {
				return false;
			}
		}

		return true;
	}

}
