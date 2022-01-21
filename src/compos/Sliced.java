package compos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sliced extends JPanel {

	private static final String OPEN = ">";
	private static final String CLOSE = "<";

	private int X, Y;
	private int W, H;
	private JButton Copen;

	/**
	 * Create the panel.
	 */
	public Sliced(int heith) {
		init(heith);
	}

	private void setWidth(int wid) {
		setSize(wid,H);
	}
	
	private void paint() {
		setBottonspace();
		repaint();
	}

	/** Slide panel to smooth movement : Action to botton */
	private void AddMovement() {
		Copen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						Copen.setVisible(false);
						int caset = (W > 60) ? 60 : 300;
						int move = ((caset==60)? -2 : 2);
						

						while(W != caset) {
							
							setWidth(W += move);
							
							try {
								sleep(5);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
						Copen.setVisible(true);
						paint();
					}
				}.start();
			}
		});
	}

	private void init(int heith) {
		setLayout(null);
		setBackground(Color.CYAN);
		X = 0;
		Y = 0;
		W = 60;
		H = heith;
		setBounds(X, Y, W, H);

		addButton();
		AddMovement();
	}

	private void addButton() {
		Copen = new JButton(OPEN);

		Copen.setFont(new Font("Tahoma", Font.BOLD, 11));
		Copen.setBounds(W - 55, H / 2, 50, 40);
		add(Copen);
	}
	
	private void setBottonspace() {
		Copen.setBounds(W - 55, H / 2, 50, 40);
	}
}
