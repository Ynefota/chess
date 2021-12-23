package ynefota.piece;

import ynefota.Board;
import ynefota.Piece;
import ynefota.Player;
import ynefota.PositionList;

public class Pawn extends Piece {
	public Pawn(String location, Player color) {
		super(location, color);
	}
	@Override
	public PositionList moves(Board board) {
		PositionList moves = new PositionList();
		String[] attackPlaces;
		switch (this.color) {
		case BLACK:
			attackPlaces = new String[] {
				String.valueOf((char) (this.positionX + 1)) + String.valueOf(this.positionY - 1),
				String.valueOf((char) (this.positionX - 1)) + String.valueOf(this.positionY - 1)
			};
			hasPlace: {
				for(int i = 1; i < (this.positionY == 7 ? 3 : 2); i++) {
					for (Piece piece : board) {
						if((piece.positionY == this.positionY - i) && (piece.positionX == this.positionX)) {
							break hasPlace;
						}
					}
					moves.add(this.positionX, this.positionY - i);
				}
			}
			break;
		case WHITE:
			attackPlaces = new String[] {
				String.valueOf((char) (this.positionX + 1)) + String.valueOf(this.positionY + 1),
				String.valueOf((char) (this.positionX - 1)) + String.valueOf(this.positionY + 1)
			};
			hasPlace: {
				for(int i = 1; i < (this.positionY == 2 ? 3 : 2); i++) {
					for (Piece piece : board) {
						if((piece.positionY == this.positionY + i) && (piece.positionX == this.positionX)) {
							break hasPlace;
						}
					}
					moves.add(this.positionX, this.positionY + i);
				}
			}
			break;
		default:
			System.out.println("default");
			return null;
		}
		for(String attackPlace: attackPlaces) {
			canAttack: {
				for (Piece piece : board) {
					if(piece.getPosition().equals(attackPlace)) {
						if(piece.color != this.color) {
							System.out.println(String.format("att: %s", attackPlace));
							break canAttack;
						}
					}
				}
				moves.add(attackPlace);
			}
		}
		return moves;
	}
	@Override
	public String toString() {
		return color == Player.BLACK ? "\u265F" : "\u2659";
	}
}
