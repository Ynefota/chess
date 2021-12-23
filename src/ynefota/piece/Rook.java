package ynefota.piece;

import ynefota.Board;
import ynefota.Piece;
import ynefota.Player;
import ynefota.PositionList;

public class Rook extends Piece {
	public Rook(String location, Player color) {
		super(location, color);
	}
	@Override
	public PositionList moves(Board board) {
		PositionList moves = new PositionList();
		String testingPosition = "";
		//left
		end: {
			for(int x = 1; x <= 'h' - positionX; x++) {
				testingPosition = PositionList.combine((char) (x + positionX), positionY);
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
		//right
		end:{
			for(int x = positionX - 1; x >= 'a'; x--) {
				testingPosition = PositionList.combine((char) (x), positionY);
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
		//up
		end: {
			for(int y = 1; y <= 8 - positionY; y++) {
				testingPosition = PositionList.combine(positionX, positionY + y);
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
		//down
		end:{
			for(int y = positionY - 1; y >= 1; y--) {
				testingPosition = PositionList.combine(positionX, y);
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
	public boolean canKillKing(Board board) {
		return false;
	}
	@Override
	public String toString() {
		return color == Player.BLACK ? "\u265C" : "\u2656";
	}
}
