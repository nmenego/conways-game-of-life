package com.conway;

public class Board {
	private final int width;
	private final int height;
	private int[][] board;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.board = new int[width][height];
	}

	public int getValue(int x, int y) {
		return board[x][y];
	}

	public int[][] setValue(int x, int y, boolean alive) {
		board[x][y] = alive ? 1 : 0;
		return board;
	}

	public int[][] getNextGeneration() {
		// rules taken from https://www.geeksforgeeks.org/program-for-conways-game-of-life/
		//		Any live cell with fewer than two live neighbors dies, as if caused by under population.
		//		Any live cell with two or three live neighbors lives on to the next generation.
		//		Any live cell with more than three live neighbors dies, as if by overpopulation.
		//		Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

		int[][] newBoard = new int[width][height];
		// Loop through every cell 
		for (int l = 1; l < width - 1; l++) {
			for (int m = 1; m < height - 1; m++) {
				// finding no Of Neighbours that are alive 
				int aliveNeighbours = 0;
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						aliveNeighbours += board[l + i][m + j];

				// The cell needs to be subtracted from 
				// its neighbours as it was counted before 
				aliveNeighbours -= board[l][m];

				// Implementing the Rules of Life 

				// Cell is lonely and dies 
				if ((board[l][m] == 1) && (aliveNeighbours < 2)) newBoard[l][m] = 0;

					// Cell dies due to over population 
				else if ((board[l][m] == 1) && (aliveNeighbours > 3)) newBoard[l][m] = 0;

					// A new cell is born 
				else if ((board[l][m] == 0) && (aliveNeighbours == 3)) newBoard[l][m] = 1;

					// Remains the same 
				else newBoard[l][m] = board[l][m];
			}
		}

		this.board = newBoard;
		return board;
	}

	public void printBoard() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (board[i][j] == 0) System.out.print(".");
				else System.out.print("*");
			}
			System.out.println();
		}
	}
}
