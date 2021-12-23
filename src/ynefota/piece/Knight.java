package ynefota.piece;

import ynefota.Board;
import ynefota.Piece;
import ynefota.Player;
import ynefota.PositionList;

public class Knight extends Piece {
	public Knight(String location, Player color) {
		super(location, color);
	}
	@Override
	public PositionList moves(Board board) {
		PositionList moves = new PositionList();
		int aX = 0, aY = 0;
		String testingPosition = "";
		for(int i = 0; i < 4; i++) {
			switch(i) {
				case 0:
					aX = -2;
					break;
				case 3:
					aX = 2;
					break;
				case 1:
					aX = -1;
					break;
				case 2:
					aX = 1;
					break;
				default:
					aX = 0;
					break;
			}
			for(int j = 0; j < 2 ;j++) {
				aY = Math.abs(aX) == 2 ? -1 : -2; 
				if(j == 1)  {
					aY = Math.abs(aY);
				}
				for(Piece piece : board) {
					testingPosition = PositionList.combine((char) (positionX + aX), positionY + aY);
					if((piece.getPosition().equals(testingPosition)) && (piece.color == color)) {
						break;
					}
					moves.add(testingPosition);
				}
			}
		}
		return moves;
	}
	@Override
	public String toString() {
		return color == Player.BLACK ? "\u265E" : "\u2658";
	}
}
