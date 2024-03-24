// https://leetcode.cn/problems/number-of-islands/description/

// BFS
class Solution 
{	static int n, m;
	public int numIslands(char[][] grid) 
	{	n = grid.length;
		m = grid[0].length;
		int res = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
			{	if(grid[i][j] == '1')
				{	res++;
					bfs(grid, i, j);
				}
			}
		return res;
    }
	public void bfs(char[][] grid, int x, int y)
	{	Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		while(!queue.isEmpty())
		{	int[] t = queue.remove();
			x = t[0];
			y = t[1];
			if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1')
			{	grid[x][y] = '0';
                queue.add(new int[] {x + 1, y});
				queue.add(new int[] {x - 1, y});
				queue.add(new int[] {x, y + 1});
				queue.add(new int[] {x, y - 1});
			}
		}
	}
}
//DFS
class Solution 
{	static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[] {-1, 0, 1, 0};
    static int n, m;
	public int numIslands(char[][] grid) 
	{	n = grid.length;
		m = grid[0].length;
		int res = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
			{	if(grid[i][j] == '1')
				{	res++;
					dfs(grid, i, j);
				}
			}
		return res;
    }
	public void dfs(char[][] grid, int x, int y)
	{	grid[x][y] = '0';
		for(int i = 0; i < 4; i++)
			{	int tx = x + dx[i];
				int ty = y + dy[i];
				if(tx >= 0 && tx < n && ty >= 0 && ty < m && grid[tx][ty] == '1')
					dfs(grid, tx, ty);
			}
	}
}