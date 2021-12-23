package ynefota;

import ynefota.piece.King;

public abstract class Piece {
	public Player color;
	public char positionX;
	public int positionY;
	public abstract PositionList moves(Board board);
	public Piece(String location, Player color) {
		char[] pos = location.toCharArray();
		positionX = pos[0];
		positionY = Character.getNumericValue(pos[1]);
		this.color = color;
	}
	public PositionList filterMoves(PositionList positions) {
		char x;
		int y;
		char[] pos;
		PositionList list = new PositionList();
		for(int i = 0; i < positions.size(); i++) {
			pos = positions.get(i).toCharArray();
			x = pos[0];
			y = Character.getNumericValue(pos[1]);
			if((x >= 'a' && x <= 'h') && (y >= 1 && y <= 8)) {
				list.add(positions.get(i));
			}
		}
		return list;
	}
	public void move(String location, Board board, Piece self) {
		char[] pos = location.toCharArray();
		if(filterMoves(self.moves(board)).contains(location)) {
			positionX = pos[0];
			positionY = Character.getNumericValue(pos[1]);
		}
	}
	public boolean canKillKing(Board board, Piece self) {
		PositionList posList = filterMoves(self.moves(board));
		String otherKingPosition;
		for(Piece piece : board) {
			if((piece instanceof King) && (piece.color != this.color)) {
				otherKingPosition = piece.getPosition();
				for (String pos : posList) {
					if(otherKingPosition.equals(pos)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public void onKill() {
		
	}
	public String getPosition() {
		return String.valueOf(positionX) + String.valueOf(positionY);
	}
	public String toString() {
		return " ";
	}
}
