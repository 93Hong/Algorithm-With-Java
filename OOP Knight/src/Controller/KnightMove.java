package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ModelImplement.Board;
import Service.BfsAlgorithm;

public class KnightMove {

	public void solveKnight() {
		try {
			String input[] = readData();
			Board chessBoard = new Board(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			int numOfVisitedSpace = new BfsAlgorithm().solveKnight(0, 0, chessBoard);

			boolean isAllVisited = numOfVisitedSpace == chessBoard.getM() * chessBoard.getN();

			printData(isAllVisited, chessBoard.getMaxDepth());
			
		} catch (StrangeInputException e) {
			System.err.println("Wrong Input!");
		}
	}

	public String[] readData() {
		String sub[] = null;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			sub = br.readLine().split(" ");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sub;
	}

	public void printData(boolean isAllVisited, int maxDepth) throws StrangeInputException {
		if (maxDepth < 1) {
			throw new StrangeInputException();
		}

		if (isAllVisited) {
			System.out.println("T" + maxDepth);
		} else {
			System.out.println("F" + maxDepth);
		}
	}

	public class StrangeInputException extends Exception {

	}
}
