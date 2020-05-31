package com.conway;

import javax.swing.*;
import java.awt.*;

public class ConwaysGameOfLife extends JFrame {

	public static final int X_BOUND = 1000;
	public static final int Y_BOUND = 1000;

	public ConwaysGameOfLife() {
		add(new GamePanel());
		setResizable(false);
		pack();

		setTitle("Conway's game of Life");
		setLocationRelativeTo(null);
		setSize(X_BOUND, Y_BOUND);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			JFrame ex = new ConwaysGameOfLife();
			ex.setVisible(true);
		});
	}
}
