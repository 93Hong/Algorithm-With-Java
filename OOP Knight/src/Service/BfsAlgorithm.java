package Service;

import java.util.LinkedList;
import java.util.Queue;

import ModelImplement.Board;
import ModelImplement.Knight;

public class BfsAlgorithm {
	public int solveKnight(int startY, int startX, Board board) {
		int numOfVisitedSpace = 0, depthOfKnight = 0;
		Queue<Knight> queue = new LinkedList<>();
		
		board.visit(startY, startX, 0);
		queue.add(new Knight(startY, startX));

		while (!queue.isEmpty()) {
			Knight knight = queue.peek();
			int knightY = knight.getY();
			int knightX = knight.getX();
			queue.poll();
			numOfVisitedSpace++;

			for (int i = 0; i < knight.getNumOfDir(); i++) {
				int nextLocation = knight.nextLocation(i);
				int nextKnightY = nextLocation % 100;
				int nextKnightX = nextLocation / 100;

				if (board.isOutOfBoard(nextKnightY, nextKnightX))
					continue;

				if (!board.isAlreadyVisit(nextKnightY, nextKnightX)) {
					queue.add(new Knight(nextKnightY, nextKnightX));
					depthOfKnight = board.visit(nextKnightY, nextKnightX, board.getVisit(knightY, knightX));
				}
			}
		}
		
		board.setMaxDepth(depthOfKnight - 1);
		return numOfVisitedSpace;
	}
}
