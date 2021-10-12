package checkers;

public class Board {
	private int rowMax = 4, colMax = 4, maxPieces = 4;
	
	private Piece [][] board = new Piece[rowMax][colMax];
	private Piece [] pieces = new Piece[maxPieces];

	public Board() {
		
	}

	public Board(Piece [][] board, Piece [] pieces) {
		setBoard(board);
		setPieces(pieces);
	}

	public void setBoard(Piece [][] board) {
		this.board = board;
	}
	
	public void setPieces(Piece [] pieces) {
		this.pieces = pieces;
	}
	
	public Piece [][] getBoard() {
		return board;
	}
	
	public Piece [] getPieces() {
		return pieces;
	}
	
	// Out of bounds is tested on row and column entry for both the start position and the destination position, don't need to check again
	public boolean isLegal(int fromRow, int fromCol, int toRow, int toCol) {
		final String str = "Move not allowed. ";
		// Check to see that there is a piece on the square specified by the "from" coordinates
		if (board[fromRow][fromCol].getColor() == '-') {
			System.out.println(str+"There is no piece in the \"from\" position.");
			return false;
		}		
		// Make sure the "to" position is not occupied
		if (board[toRow][toCol].getColor() != '-') {
			System.out.println(str+"The \"to\" position is already occupied.");
			return false;
		}
		// Check toCol for diagonal (this also screens for same column moves
		if (toCol != fromCol + 1  && toCol != fromCol - 1) {
			System.out.println(str+"That's not a diagonal move.");
			return false;
		}
		// Check toRow for diagonal - red piece (this also screens for same row/same column moves and backward moves
		if (board[fromRow][fromCol].getColor() == 'R') {
			if (toRow != fromRow + 1) {
				System.out.println(str+"That's not a diagonal move.");
				return false;
			}
		}
		// Check toRow for diagonal - black piece (this also screens for same row moves and backward moves
		if (board[fromRow][fromCol].getColor() == 'B') {
			if (toRow != fromRow - 1) {
				System.out.println(str+"That's not a diagonal move.");
				return false;
			}
		} 
		return true;
	}// end isLegal
	
	public boolean move(int fromRow, int fromCol, int toRow, int toCol) {
		// Check for illegal move
		if (!isLegal(fromRow, fromCol, toRow, toCol)) {
//			System.out.println("Illegal move.");
			return false;
		}
		// Identify the piece being moved
		int pieceMovedID = board[fromRow][fromCol].getID();
		// "Empty" the "from" position
		board[fromRow][fromCol] = pieces[maxPieces];
		// Put the piece being moved in the "to" position
		board[toRow][toCol] = pieces[pieceMovedID];
		return true;
	}// end Move
	
	// Print the board
	static void printBoard(Board brd, int rowMax, int colMax) {
		Piece [][] array = brd.getBoard();
		System.out.println("");
		System.out.println("                    0    1    2    3");
		System.out.println("                 ---------------------- ");
		for (int i=0; i<rowMax; i++) {
			if (i>0) {
				System.out.println("                |                      |");
			}
			System.out.print("              "+i+" |   ");
			for (int j=0; j<colMax; j++) {
				if (j<colMax - 1) {
					System.out.print(array[i][j].getColor()+"    ");
				} else {
					System.out.print(array[i][j].getColor()+"   ");
				}
			}
			System.out.print("|");
			System.out.println("");
		}
		System.out.println("                 ---------------------- ");
		System.out.println("");
	}
	
	
}// end class
