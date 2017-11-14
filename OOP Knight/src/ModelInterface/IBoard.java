package ModelInterface;

public interface IBoard {

	public boolean isOutOfBoard(int y, int x);
	
	public boolean isAlreadyVisit(int y, int x);
	
	public int visit(int y, int x, int level);
	
}
