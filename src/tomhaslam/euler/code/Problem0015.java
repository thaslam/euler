package tomhaslam.euler.code;

public class Problem0015 extends Problem {
	private long count = 0;
	
	public long solve(int size) 
	{
		return this.traversePath(size, size+1, 0, 1);
	}
	
	private long traversePath(int size, int paths, int path, int col)
	{		
		if (col==size) {
			count += (paths);
			return count;   
		}
		
		for (int p=0; p<paths; p++)
		{
			traversePath(size, paths-p, p, col+1);
		}
		
		return count;
	}
}
