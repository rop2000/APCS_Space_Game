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

import javax.swing.AbstractAction;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder; 


public class StrandedGameGUI extends JFrame implements ActionListener{
private JPanel contentPane;
Graphics d;		
AsteroidMain ast = new AsteroidMain();
JPanel panel_4;
JPanel panel;
	/**
	 * Create the frame.
	 */
	public StrandedGameGUI() {
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		ast.setShipColor(Color.cyan);
		// Escape key thign nto working yet
		 GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
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
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
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
		 
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setForeground(new Color(0, 0, 0));
		contentPane.add(panel_4, "name_164264154886423");
		panel_4.setLayout(null);
		panel_4.setFocusable(true);
		panel_4.requestFocusInWindow();
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setForeground(new Color(0, 0, 0));
		contentPane.add(panel_5, "name_164264154886423");
		panel_5.setLayout(null);
		
		
		
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
		
		JButton btnNewButton_5 = new JButton("Customize");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_5.setBackground(new Color(51, 153, 255));
		btnNewButton_5.setForeground(new Color(0, 0, 139));
		btnNewButton_5.setBounds(570, 614, 332, 53);
		panel.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		
		JButton btnNewButton_6 = new JButton("Ship Color");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_6.setBackground(new Color(220, 20, 60));
		btnNewButton_6.setForeground(new Color(0, 0, 139));
		btnNewButton_6.setBounds(570, 200, 332, 59);
		panel_4.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);
				panel_5.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_7 = new JButton("Red");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_7.setBackground(new Color(220, 20, 60));
		btnNewButton_7.setForeground(new Color(0, 0, 139));
		btnNewButton_7.setBounds(570, 200, 332, 59);
		panel_5.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ast.setShipColor(Color.red);
			}
		});
		
		JButton btnNewButton_10 = new JButton("Blue");
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_10.setBackground(new Color(51, 153, 255));
		btnNewButton_10.setForeground(new Color(0, 0, 139));
		btnNewButton_10.setBounds(570, 350, 332, 59);
		panel_5.add(btnNewButton_10);
		btnNewButton_10.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ast.setShipColor(Color.blue);
			}
		});
		
		JButton btnNewButton_11 = new JButton("Green");
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_11.setBackground(new Color(50, 205, 50));
		btnNewButton_11.setForeground(new Color(0, 0, 139));
		btnNewButton_11.setBounds(570, 500, 332, 59);
		panel_5.add(btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ast.setShipColor(Color.green);
			}
		});
		
		
		
		
		JButton btnNewButton_8 = new JButton("Back");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_8.setBackground(new Color(220, 20, 60));
		btnNewButton_8.setForeground(new Color(0, 0, 139));
		btnNewButton_8.setBounds(100, 750, 332, 59);
		panel_5.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(true);
				panel_5.setVisible(false);
				
			}
		});
		
		JButton btnNewButton_9 = new JButton("Back");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_9.setBackground(new Color(220, 20, 60));
		btnNewButton_9.setForeground(new Color(0, 0, 139));
		btnNewButton_9.setBounds(100, 750, 332, 59);
		panel_4.add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_4.setVisible(false);
				
			}
		});
			
		
		
		JLabel lblByRohanParikh = new JLabel("");
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

		ast.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"escape");
		ast.getActionMap().put("escape", new AbstractAction()
		{
			
			  @Override
		        public void actionPerformed(ActionEvent e){
		            ast.setVisible(false);
		            panel.setVisible(true);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
