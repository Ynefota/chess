package ynefota;

import java.util.ArrayList;
import java.util.Iterator;

import ynefota.piece.Bishop;
import ynefota.piece.King;
import ynefota.piece.Knight;
import ynefota.piece.Pawn;
import ynefota.piece.Queen;
import ynefota.piece.Rook;

public class Board implements Iterable<Piece> {
	public ArrayList<Piece> pieces;
	public Player activePlayer;
	public Board() {
		pieces = new ArrayList<>();
		activePlayer = Player.WHITE;
		for(int i = 0; i < 8; i++) {
			pieces.add(new Pawn(PositionList.combine((char) ('a' + i), 7), Player.BLACK));
		}
		pieces.add(new Rook("a8", Player.BLACK));
		pieces.add(new Rook("h8", Player.BLACK));
		pieces.add(new Knight("b8", Player.BLACK));
		pieces.add(new Knight("g8", Player.BLACK));
		pieces.add(new Bishop("c8", Player.BLACK));
		pieces.add(new Bishop("f8", Player.BLACK));
		pieces.add(new Queen("d8", Player.BLACK));
		pieces.add(new King("e8", Player.BLACK));
		for(int i = 0; i < 8; i++) {
			pieces.add(new Pawn(PositionList.combine((char) ('a' + i), 2), Player.WHITE));
		}
		pieces.add(new Rook("a1", Player.WHITE));
		pieces.add(new Rook("h1", Player.WHITE));
		pieces.add(new Knight("b1", Player.WHITE));
		pieces.add(new Knight("g1", Player.WHITE));
		pieces.add(new Bishop("c1", Player.WHITE));
		pieces.add(new Bishop("f1", Player.WHITE));
		pieces.add(new Queen("d1", Player.WHITE));
		pieces.add(new King("e1", Player.WHITE));
	}
	public void changePlayer() {
		activePlayer = activePlayer.equals(Player.BLACK) ? Player.WHITE : Player.BLACK;
	}
	public void move(Piece piece, String position) {
		piece.move(position, this, piece);
		doKillFrom(piece);
	}
	public void move(String from, String to) {
		Piece piece = getPiece(from);
		if(piece == null) return;
		move(piece, to);
	}
	public void doKillFrom(Piece moved) {
		int size = pieces.size();
		for(int i = 0; i < size; i++) {
			if((pieces.get(i).getPosition().equals(moved)) && (pieces.get(i) != moved)) {
				pieces.remove(i);
			}
		}
	}
	@Override
	public Iterator<Piece> iterator() {
		return pieces.iterator();
	}
	public Piece getPiece(String position) {
		for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).getPosition().equals(position)) {
				return pieces.get(i);
			}
		}
		return null;
	}
	public String toString() {
		String field = "";
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				lookForSymbol: {
					for (Piece piece : pieces) {
						if((piece.positionX == 'a' + x) && (piece.positionY == 8 - y)) {
							field += piece;
							break lookForSymbol;
						}
					}
					field += "  ";
				}
			}
			field += "\n";
		}
		return field;
	}
}
