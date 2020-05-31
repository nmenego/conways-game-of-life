package com.conway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

	public static final int PIXEL = 5;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 200;

	private final int DELAY = 1000;
	private Timer timer;
	private Board board;

	public GamePanel() {
		super();

		setFocusable(true);
		initialiseBoard();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	private void initialiseBoard() {
		this.board = new Board(WIDTH, HEIGHT);
		tenCellRow();
//		this.board.printBoard();
	}

	private void tenCellRow() {
		for (int i = 0 ; i < 5; i++) {
			this.board.setValue(WIDTH / 2, (HEIGHT / 2) + i, true);
		}

		for (int i = 0 ; i < 5; i++) {
			this.board.setValue(WIDTH / 2, (HEIGHT / 2) - i, true);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (board.getValue(i, j) > 0) {
					g.setColor(Color.BLUE);
					g.fillRect(j * PIXEL, i * PIXEL, PIXEL, PIXEL);
				} else {
					g.setColor(Color.GRAY);
					g.fillRect(j * PIXEL, i * PIXEL, PIXEL, PIXEL);
				}
			}
		}
		g.drawString("Conway's game of life", 400, 25);
//		this.board.printBoard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		board.getNextGeneration();
		repaint();
	}

}