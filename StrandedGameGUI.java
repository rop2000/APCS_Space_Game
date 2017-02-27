package AsteroidGame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import java.applet.*; 
import java.awt.*;
import java.awt.event.*;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder; 


public class StrandedGameGUI extends JFrame {
private JPanel contentPane;
Graphics d;		
AsteroidMain ast = new AsteroidMain();

	/**
	 * Create the frame.
	 */
	public StrandedGameGUI() {
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		 GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
	        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
		setBounds(100, 100, 1500, 1500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, "name_164263946698957");
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_1, "name_164264083377623");
		panel_1.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setForeground(new Color(0, 0, 0));
		contentPane.add(panel_2, "name_164264154886423");
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "name_164264209230791");
		 
		JLabel lblNewLabel = new JLabel("Stranded");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 90));
		lblNewLabel.setBounds(527, 157, 417, 79);
		panel.add(lblNewLabel);
		
		JLabel lblASpaceSurvival = new JLabel("A Space Survival Game");
		lblASpaceSurvival.setForeground(new Color(32, 178, 170));
		lblASpaceSurvival.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblASpaceSurvival.setBounds(560, 255, 352, 34);
		panel.add(lblASpaceSurvival);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setForeground(new Color(0, 0, 139));
		btnNewButton.setBounds(570, 358, 332, 59);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("C:/Users/UltraParikh/workspace/Asteroids/src/AsteroidGame/Stranded.ser");
				
				getContentPane().add(ast);
				ast.init();
				panel.setVisible(false);
				ast.setVisible(true);
                ast.setFocusable(true);
                ast.requestFocus();
                ast.requestFocusInWindow();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setBounds(570, 446, 332, 53);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("Credits");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_2.setBackground(new Color(124, 252, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 139));
		btnNewButton_2.setBounds(570, 530, 332, 53);
		panel.add(btnNewButton_2);
		
		JLabel lblByRohanParikh = new JLabel("By Rohan Parikh");
		lblByRohanParikh.setForeground(new Color(139, 0, 0));
		lblByRohanParikh.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblByRohanParikh.setBounds(632, 660, 208, 34);
		panel.add(lblByRohanParikh);
		btnNewButton_2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		
		
		JTextPane txtpnStoryOnA = new JTextPane();
		txtpnStoryOnA.setEditable(false);
		txtpnStoryOnA.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnStoryOnA.setForeground(new Color(139, 0, 0));
		txtpnStoryOnA.setText("Story: On a return trip from Jupiter, your spaceship's radar breaks down, leaving you stranded in the Asteroid Belt. Your job is to destroy all asteroids that approach in order to stay alive as long as possible.\r\n\r\nControls: Hit ENTER to Play/Pause. Use the arrow keys (Up, Down, Left, Right) to move your spaceship on the screen. Shoot lasers towards asteroids with the SPACE key. If your ship is hit, you lose a life. Lose all 5 lives and it's game over.");
		txtpnStoryOnA.setBackground(new Color(0, 0, 0));
		txtpnStoryOnA.setBounds(273, 229, 925, 372);
		panel_1.add(txtpnStoryOnA);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_3.setForeground(new Color(0, 0, 139));
		btnNewButton_3.setBackground(new Color(127, 255, 0));
		btnNewButton_3.setBounds(620, 666, 232, 52);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		
		
		JTextPane txtpnCreditsManyWebsites = new JTextPane();
		txtpnCreditsManyWebsites.setEditable(false);
		txtpnCreditsManyWebsites.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnCreditsManyWebsites.setText("Credits: Many websites and tutorials were used for the making of this game. ");
		txtpnCreditsManyWebsites.setBackground(new Color(0, 0, 0));
		txtpnCreditsManyWebsites.setForeground(new Color(139, 0, 0));
		txtpnCreditsManyWebsites.setBounds(273, 0, 925, 533);
		panel_2.add(txtpnCreditsManyWebsites);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setBackground(new Color(255, 140, 0));
		btnNewButton_4.setForeground(new Color(0, 0, 139));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_4.setBounds(623, 551, 225, 45);
		panel_2.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_2.setVisible(false);
			}
		});

		

	}
	//Code snippet from StackOverflow http://stackoverflow.com/questions/19771836/adding-and-opening-links-on-a-jbutton
	public void openWebPage(String url){
		   try {         
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		   }
		   catch (java.io.IOException e) {
		       System.out.println(e.getMessage());
		   }
		}
	public void openFile(File file)
	{
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					StrandedGameGUI frame = new StrandedGameGUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	}
}
