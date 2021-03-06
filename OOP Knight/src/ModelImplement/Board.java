package ModelImplement;

import ModelInterface.IBoard;

public class Board implements IBoard {
	private int M, N, maxDepth;
	private int map[][];

	public Board(int M, int N) {
		this.M = M;
		this.N = N;
		map = new int[M][N];
		this.maxDepth = 0;
	}

	@Override
	public boolean isOutOfBoard(int y, int x) {
		return y < 0 || y >= M || x < 0 || x >= N;
	}

	@Override
	public boolean isAlreadyVisit(int y, int x) {
		return map[y][x] > 0;
	}
	
	@Override
	public int visit(int y, int x, int level) {
		return map[y][x] = level + 1;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	public void setMaxDepth(int depth) {
		maxDepth = depth;
	}
	
	public int getVisit(int y, int x) {
		return map[y][x];
	}
	
	public int getM() {
		return M;
	}
	
	public int getN() {
		return N;
	}

	public int getMaxDepth() {
		return maxDepth;
	}
}
