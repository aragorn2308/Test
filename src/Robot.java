
public class Robot {
	private static int count = 0;
	public static void main(String[] args) {
		Robot robot = new Robot();
		int m = 5, n = 5;
		boolean Visited[][] = new boolean[5][5];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				Visited[i][j] = false;
		}
		robot.traverse(Visited, 0, 0, m, n);
		System.out.println(count);
	}
	/**
	 * 
	 * @param Visited array
	 * @param index i
	 * @param index j
	 * @param max Row m
	 * @param max column n
	 */
	private void traverse(boolean Visited[][], int i, int j, int m, int n){
		if(i==m-1&&j==n-1){
			count++;
			return;
		}
		if(isSafe(i, j, m, n, Visited)){
			Visited[i][j]=true;
			traverse(Visited, i, j+1, m, n);
			traverse(Visited, i+1, j, m, n);
			traverse(Visited, i-1, j, m, n);
			traverse(Visited, i, j-1, m, n);
			Visited[i][j] = false;
		}
	}
	/**
	 * 
	 * @param index i
	 * @param index j
	 * @param max Row m
	 * @param max Column n
	 * @param Visited array
	 * @return isSafe or not
	 */
	private boolean isSafe(int i, int j, int m, int n, boolean Visited[][]){
		if(i>=0&&j>=0&&i<m&&j<n&&!Visited[i][j])
			return true;
		else
			return false;
	}

}
