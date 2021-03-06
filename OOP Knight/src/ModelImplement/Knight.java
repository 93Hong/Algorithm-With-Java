package ModelImplement;

import ModelInterface.IKnight;

public class Knight implements IKnight {
	private int y, x, numOfDir;
	private int movingY[] = { 2, -2, 2, -2, 1, -1, 1, -1 };
	private int movingX[] = { 1, 1, -1, -1, 2, 2, -2, -2 };

	public Knight(int y, int x) {
		this.y = y;
		this.x = x;
		this.numOfDir = 8;
	}

	@Override
	public int nextLocation(int direction) {
		// TODO Auto-generated method stub
		return y + movingY[direction] + (x + movingX[direction]) * 100;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public int getNumOfDir() {
		return numOfDir;
	}
}
