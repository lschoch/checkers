package checkers;

public class Piece {
	private char color;
	private int ID;
	
	// Piece colors: 'R' for red piece, 'B' for black piece
	public Piece(int ID, char color) {
		setID(ID);
		setColor(color);
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setColor(char color) {
		this.color = color;
	}
	
	public char getColor() {
		return color;
	}
	
	public int getID() {
		return ID;
	}
	
}
