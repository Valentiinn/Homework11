package com.Karayvansky.HomeWork11;

import java.util.Arrays;

public class Board {

	char[][] board = new char[3][3];
	char currentPlayer;

	public Board() {
		for (int i = 0; i < 3; i++) {
			Arrays.fill(board[i], '|');
		}
		currentPlayer = 'O';
	}

	public void printBoard() {
		System.out.println(" 0 1 2 ");
		System.out.println("");
		int number = -1;
		for (int i = 0; i < 3; i++) {
			number++;
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + board[i][j]);
			}

			System.out.println("   " + number);
		}

	}

	// если currentplayer будет равен "X" elem = O
	// ≈сли currentPlayer будет не "X", то elem будет равен "X"
	public boolean gameFinished() {
		char elem = (currentPlayer == 'X') ? 'O' : 'X';
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == elem && board[1][i] == elem && board[2][i] == elem
					|| board[i][0] == elem && board[i][1] == elem && board[i][2] == elem)
				return true;
		}
		if (board[0][0] == elem && board[1][1] == elem && board[2][2] == elem)
			return true;

		if (board[2][0] == elem && board[1][1] == elem && board[0][2] == elem)
			return true;
		return false;
	}

	public boolean makeMove(String move) {
		int x = Character.getNumericValue(move.charAt(0));
		int y = Character.getNumericValue(move.charAt(1));

		if (!isMoveValid(x, y) || !isEmployed(x, y))
			return false;

		board[x][y] = currentPlayer;
		changeCurrentPlayer();

		return true;
	}

	private void changeCurrentPlayer() {
		if (currentPlayer == 'X') {
			currentPlayer = 'O';
		} else {
			currentPlayer = 'X';
		}
	}

	private boolean isMoveValid(int x, int y) {
		if (x > 2 || y > 2 || x < 0 || y < 0) {
			return false;
		}
		return true;
	}

	public void calculateWinner() {
		if (gameFinished()) {
			char winner = (currentPlayer == 'X') ? 'O' : 'X';
			System.out.println("The winner is " + winner + " !!!");
		}
	}

	private boolean isEmployed(int x, int y) {
		if (board[x][y] != '|') {
			return false;
		}
		return true;
	}
}