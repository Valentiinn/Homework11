package com.Karayvansky.HomeWork11;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Game started...");

		Board board = new Board();
		board.printBoard();

		while (!board.gameFinished()) {
			System.out.println();
			System.out.println("Player " + board.currentPlayer + "!" + " Moves...");
			System.out.print("Enter yout move: ");

			String move = sc.next();
			if (!board.makeMove(move)) {
				System.out.println("Input was incorect.Select your move. ");
			}
			board.printBoard();
		}
		System.out.println();
		board.calculateWinner();
		sc.close();
	}

}
