package Koch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 5777446597957598680L;
	JButton exit;
	
	public MainWindow(){
		//create frame
		super("Koch snowflake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		//add snowflake
		getContentPane().add(new Drawing());
		
		//add exit button
		exit = new JButton("Exit");
		exit.addActionListener(this);
		getContentPane().add(exit);
		
		//set frame visible
        pack();
		setVisible(true);
	}
	
	//event listener for exit button
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
