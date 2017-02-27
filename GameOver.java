package AsteroidGame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Canvas;
import javax.swing.JEditorPane;

public class GameOver extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameOver() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 90));
		lblGameOver.setBounds(116, 13, 504, 137);
		add(lblGameOver);
		
		JLabel lblRestartingIn = new JLabel("Restarting in 10 seconds......");
		lblRestartingIn.setForeground(new Color(0, 0, 139));
		lblRestartingIn.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblRestartingIn.setBounds(136, 163, 478, 43);
		add(lblRestartingIn);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setForeground(new Color(0, 0, 139));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(116, 289, 197, 43);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBounds(423, 289, 197, 43);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
			}
		});

	}
}
