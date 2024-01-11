import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.*;

public class Imageoperation extends JFrame{

	public static void main(String[] args) {
	JFrame f = new JFrame("Image Operation");
	f.setSize(400,400);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	Font font = new Font("Roboto",Font.BOLD,25);
	JButton b = new JButton("Open Image");
	b.setFont(font);
	
	
	
	b.setFocusable(false);
	JTextField textfield = new JTextField(10);
	textfield.setFont(font);
	f.setLayout(new FlowLayout());
	f.add(b);
	
	b.addActionListener(e -> {
		String  text = textfield.getText();
	int tem = Integer.parseInt(text);
	operate(tem);
	});
	
	
	f.add(textfield);
	
	
	
	
	f.setVisible(true);
	
}
	public Imageoperation() {
		
	}
	public static void operate(int key)
	{
		JFileChooser filechooser =new JFileChooser();
		filechooser.showOpenDialog(null);
		File file =   filechooser.getSelectedFile();
		try
		{
			FileInputStream filestrem = new FileInputStream(file);
			byte[] data = new byte [filestrem.available()];
			filestrem.read(data);
			int i = 0;
			for(byte b:data)
			{
				System.out.print(b);
				data[i]=(byte)(b^key);
				i++;
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
			filestrem.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}


