// 蓝桥模拟赛
// https://www.lanqiao.cn/problems/2410/learning/?page=1&first_category_id=1&tags=2023
// DFS

import java.util.Scanner;

public class Main
{	static char[][] map = new char[30][60];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int max = 0;
	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < 30; i++)
			map[i] = scanner.next().toCharArray();
		scanner.close();
		for(int i = 0; i < 30; i++)
			for(int j = 0; j < 60; j++)
			{	if(map[i][j] == '1')
				{	max = Math.max(max, dfs(i, j));
				}
			}
		System.out.print(max);
	}
	public static int dfs(int x, int y)
	{	map[x][y] = '0';
		int current = 1;
		for(int i = 0; i < 4; i++)
		{	int tx = x + dx[i];
			int ty = y + dy[i];
			if(tx >= 0 && tx < 30 && ty >= 0 && ty < 60 && map[tx][ty] == '1')
				current += dfs(tx, ty);
		}
		return current;
	}
}