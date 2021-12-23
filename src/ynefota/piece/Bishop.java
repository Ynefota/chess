package ynefota.piece;

import ynefota.Board;
import ynefota.Piece;
import ynefota.Player;
import ynefota.PositionList;

public class Bishop extends Piece {
	public Bishop(String location, Player color) {
		super(location, color);
	}
	@Override
	public PositionList moves(Board board) {
		PositionList moves = new PositionList();
		String testingPosition = "";
		//right up
		end: {
			for(int i = 1; i <= 8 - Math.min(positionX - 'a' + 1, positionY); i++) {
				testingPosition = PositionList.combine((char) (positionX + 1), positionY + i);
				for(Piece piece : board) {
					if(piece.getPosition().equals(testingPosition)) {
						if(piece.color != this.color) {
							moves.add(testingPosition);
						}
						break end;
					}
				}
				moves.add(testingPosition);
			}
		}
		//left up
		end:{
			for(int i = 1; i <= 8 - Math.min(9 - positionX - 'a' + 1, positionY); i++) {
				testingPosition = PositionList.combine((char) (positionX - i), positionY + i);
				for(Piece piece : board) {
					if(piece.getPosition().equals(testingPosition)) {
						if(piece.color != this.color) {
							moves.add(testingPosition);
						}
						break end;
					}
				}
				moves.add(testingPosition);
			}
		}
		//right down
		end: {
			for(int i = 1; i <= 8 - Math.min(positionX - 'a' + 1, 9 - positionY); i++) {
				testingPosition = PositionList.combine((char) (positionX +  i), positionY - i);
				for(Piece piece : board) {
					if(piece.getPosition().equals(testingPosition)) {
						if(piece.color != this.color) {
							moves.add(testingPosition);
						}
						break end;
					}
				}
				moves.add(testingPosition);
			}
		}
		//left down
		end:{
			for(int i = 1; i <= 8 - Math.min(9 - positionX - 'a' + 1, 9 - positionY); i++) {
				testingPosition = PositionList.combine((char) (positionX - i), positionY - i);
				for(Piece piece : board) {
					if(piece.getPosition().equals(testingPosition)) {
						if(piece.color != this.color) {
							moves.add(testingPosition);
						}
						break end;
					}
				}
				moves.add(testingPosition);
			}
		}
		return moves;
	}
	@Override
	public String toString() {
		return color == Player.BLACK ? "\u265D" : "\u2657";
	}
}
