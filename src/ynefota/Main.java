package ynefota;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		board.move("a2", "a4");
		board.move("a4", "a5");
		board.move("a5", "a6");
		board.move("c2", "c4");
		board.move("c4", "c5");
		board.move("c5", "c6");;
		System.out.println(board);
		Piece pawn = board.getPiece("c6");
		Piece king = board.getPiece("e1");
		print(king.filterMoves(king.moves(board)));
		print(pawn.filterMoves(pawn.moves(board)));
		System.out.println(board);
	}
	static void print(Iterable list){
		for(Object o : list) {
			System.out.print(o);
			System.out.print(", ");
		}
	}
}
