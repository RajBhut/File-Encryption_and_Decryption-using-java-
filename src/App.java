import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.*;

public class App extends JFrame {
	static int key = 75;
	static int private_key = 28;
	static byte[] encrept_const = { 75, 76, 82 };

	public static void main(String[] args) {

	}

	private static boolean is_Encrepted(byte[] data) {

		if (data.length < encrept_const.length)
			return false;

		for (int i = 0; i < encrept_const.length; i++) {
			if (encrept_const[i] != data[i])
				return false;
		}
		return true;
	}

	public static byte[] encrept_file(byte[] data, int key) {

		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		try {

			bis.write(encrept_const);
			bis.write(key^28);
			for (int i = 0; i < data.length; i++) {
				byte b = (byte) (data[i] ^ key);
				bis.write(b);
			}
			byte[] encrypted_data = bis.toByteArray();

			bis.close();
			return encrypted_data;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return new byte[0];
	}

	public static byte[] decrept_file(int key, byte[] data) {
		
			
		byte[] encrypted_data = Arrays.copyOfRange(data, encrept_const.length+1, data.length);
		for (int i = 0; i < encrypted_data.length; i++) {
			encrypted_data[i] = (byte) (encrypted_data[i] ^ key);

		}
		return encrypted_data;
	
	}

	public static byte[] read_file(File file) {
		try {
			FileInputStream is = new FileInputStream(file);

			byte[] data = new byte[is.available()];
			is.read(data);
			is.close();
			return data;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[0];
	}

	public static void write_file(String path, byte[] data) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void button_clicked_encrept(int key) {
		JFileChooser jf = new JFileChooser();
		jf.showOpenDialog(null);
		File file = jf.getSelectedFile();
		System.out.println("Reading File...");
		byte[] data = read_file(file);
		if (is_Encrepted(data)) {
			/*System.out.println("Decrepting File...");
			byte[] decrepted_data = decrept_file(key, data);
			write_file(file.getPath(), decrepted_data);
			JOptionPane.showMessageDialog(null, "Decreption done!");*/
JOptionPane.showMessageDialog(null, "File is alredy Encrepted", "Warning", JOptionPane.WARNING_MESSAGE);

		} else {
			System.out.println("Encrepting File...");
			byte[] encrepted_data = encrept_file(data, key);
			write_file(file.getPath(), encrepted_data);
			JOptionPane.showMessageDialog(null, "Encreption Done!...");

		}

	}
	public static void button_clicked_decrept(int key) {
		JFileChooser jf = new JFileChooser();
		jf.showOpenDialog(null);
		File file = jf.getSelectedFile();
		System.out.println("Reading File...");
		byte[] data = read_file(file);
		byte check = data[3];
		if((check^28)!=key)
		{JOptionPane.showMessageDialog(null, "Enter Correct Password","Warning",JOptionPane.WARNING_MESSAGE);
			return ;}
		if (is_Encrepted(data)) {
			System.out.println("Decrepting File...");
			byte[] decrepted_data = decrept_file(key, data);
			write_file(file.getPath(), decrepted_data);
			JOptionPane.showMessageDialog(null, "Decreption done!");
		} else {
			/* 
			System.out.println("Encrepting File...");
			byte[] encrepted_data = encrept_file(data, key);
			write_file(file.getPath(), encrepted_data);
			JOptionPane.showMessageDialog(null, "Encreption Done!...");
*/
JOptionPane.showMessageDialog(null, "File is alredy Encrepted", "Warning", JOptionPane.WARNING_MESSAGE);
		}

	}

}
