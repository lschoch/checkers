package checkers;

import java.util.Scanner;

public class Application {
	
	public static void main(String [] args) {
		int rowMax = 4, colMax = 4, maxPieces = 4;
		int ID, fromRow, fromCol, toRow, toCol;
		char color;
		String temp = "";
		String stop = "y";
		Scanner s = new Scanner(System.in);
		Piece [][] boardArray = new Piece[rowMax][colMax];
		Piece [] pieces = new Piece[maxPieces + 1]; // Add 1 for the "empty" piece
		
		// Create pieces
		for (int i=0; i<maxPieces; i++) {
			ID = i;
			if (i<2) {
				color = 'R';
			} else {
			 	color = 'B';
			}// end if
			pieces[i] = new Piece(ID, color);
		}// end for
		// Create a piece for empty squares
		pieces[maxPieces] = new Piece(4, '-');
		
		// Initialize boardArray putting red pieces on row 0 and black pieces on row 3. Ready to play!"
		int pieceCounter = 0;
		for (int i=0; i<rowMax; i++) {
			for (int j=0; j<colMax; j++) {
				if (i == 0) {
					if (j%2 == 0) {
						// Put red pieces on the squares where j is even
						boardArray[i][j] = pieces[pieceCounter];
						pieceCounter++;
					} else {
						// Put empties on the rest of the squares in row 0
						boardArray[i][j] = pieces[maxPieces];
					}
				} else if (i==rowMax-1) {
					if (j%2 != 0) {
						// Put black pieces on the squares where j is odd
						boardArray[i][j] = pieces[pieceCounter];
						pieceCounter++;
					} else {
						// Put empties on the rest of the squares in row rowMax-1
						boardArray[i][j] = pieces[maxPieces];
					}
				// Fill the remaining rows with empties
				} else {
					boardArray[i][j] = pieces[maxPieces];
				}
			}// end j for
		}// end i for
		
		Board board = new Board(boardArray, pieces);
		
		// Begin the game.
		Board.printBoard(board, 4, 4);
		System.out.printf("           Welcome to the ultimate checkers game!\n");
		System.out.println("");
		System.out.printf("  You can play both sides, red and black. Illegal moves will be caught and\n"+
		"  dealt with severely. Refer to the board above for row and column coordinates.\n");
		System.out.println("");			
		while (stop.toLowerCase().equals("y")) {	
			System.out.println("  At the prompts, enter the row and column coordinates of the piece you want to move. Row>>");
			temp = s.nextLine();
			System.out.println(temp);
			fromRow = Integer.parseInt(temp);
			while (fromRow < 0 || fromRow >= rowMax) {
			 	System.out.println("That row is out of bounds, please enter another.");
			 	temp = s.nextLine();
				fromRow = Integer.parseInt(temp);
			}
			System.out.println("Column>> ");
			temp = s.nextLine();
			System.out.println(temp);
			fromCol = Integer.parseInt(temp);
			while (fromCol < 0 || fromCol >= colMax) {
				System.out.println("That column is out of bounds, please enter another.");
				fromCol = Integer.parseInt(s.nextLine());
			}
			System.out.println("Where do you want to move this piece? Row>> ");
			toRow = Integer.parseInt(s.nextLine());
		
			while (toRow < 0 || toRow >= rowMax) {
				System.out.println("That row is out of bounds, please enter another.");
				toRow = Integer.parseInt(s.nextLine());
			}
			System.out.println("Column>> ");
			temp = s.nextLine();
			toCol = Integer.parseInt(temp);
			while (toCol < 0 || toCol >= colMax) {
				System.out.println("That column is out of bounds, please enter another.");
				toCol = Integer.parseInt(s.nextLine());
			}
			if (board.move(fromRow, fromCol, toRow, toCol)) {
				System.out.println("Success! Here's the board after your move: ");
				Board.printBoard(board,  4,  4);
			} 
			System.out.println("Want to move again? Enter \"Y\" for Yes, \"N\" for No.");
			stop = s.nextLine();
		}//end while
		System.out.println("Good-bye, thanks for playing.");
		s.close();
	}// end main

}// end class
