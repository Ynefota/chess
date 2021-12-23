package ynefota;

import java.util.ArrayList;

public class PositionList extends ArrayList<String>{
	public static String combine(char x, int y) {
		return String.valueOf(x) + String.valueOf(y);
	}
	public void add(char x, int y) {
		add(combine(x, y));
	}
}
