// 福建省夏令营
// https://www.luogu.com.cn/problem/P1331
//  DFS

import java.util.Scanner;

public class Main
{	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		for(int i = 0; i < n; i++)
			map[i] = scanner.next().toCharArray();
		for(int i = 0; i < n - 1; i++)
			for(int j = 0; j < m - 1; j++)
				if(!safe(i, j))
				{	System.out.print("Bad placement.");
					return;
				}
		int res = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
			{	if(map[i][j] == '#')
				{	res++;
					dfs(i, j);
				}
			}
		System.out.print("There are " + res + " ships.");
	}
	static int n, m;
	static char[][] map = new char[1005][1005];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void dfs(int x, int y)
	{	map[x][y] = '.';
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
			{	int tx = x + dx[i];
				int ty = y + dy[j];
				if(tx >= 0 && tx < n && ty >= 0 && ty < m && map[tx][ty] == '#')
					dfs(tx, ty);
			}
	}
	public static boolean safe(int x, int y)
	{	int cnt = 0;
		if(map[x][y] == '#')
			cnt++;
		if(map[x + 1][y] == '#')
			cnt++;
		if(map[x][y + 1] == '#')
			cnt++;
		if(map[x + 1][y + 1] == '#')
			cnt++;
		if(cnt == 3)
			return false;
		return true;
	}
}
