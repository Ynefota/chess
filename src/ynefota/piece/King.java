package ynefota.piece;

import ynefota.Board;
import ynefota.Piece;
import ynefota.Player;
import ynefota.PositionList;

public class King extends Piece {
	public King(String location, Player color) {
		super(location, color);
	}
	@Override
	public PositionList moves(Board board) {
		PositionList moves = new PositionList();
		String testingPosition = "";
		for(int i = -1;i < 2; i++) {
			for(int j = -1;j < 2; j++) {
				testingPosition = PositionList.combine((char) (positionX + i), positionY+j);
				next:{
					for(Piece piece : board) {
						if(testingPosition.equals(piece.getPosition())) {
							moves.add((char) (positionX + i), positionY+j);
							break next;
						}
					}
				}
				//System.out.println(PositionList.combine((char) (positionX + i), positionY+j));
			}
		}
		return moves;
	}
	@Override
	public String toString() {
		return color == Player.BLACK ? "\u265A" : "\u2654";
	}
}
