// 蓝桥杯2016国赛
// https://www.lanqiao.cn/problems/89/learning/?page=1&first_category_id=1&name=%E8%B7%AF%E5%BE%84
// DFS、回溯

import java.util.LinkedList;
import java.util.Scanner;

public class Main
{	static int N;
	static boolean[][] flag;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[] crosswise, lengthways;
	static LinkedList<Integer> res = new LinkedList<>();
	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		flag = new boolean[N][N];
		crosswise = new int[N];
		lengthways = new int[N];
		for(int i = 0; i < N; i++)
			crosswise[i] = scanner.nextInt();
		for(int i = 0; i < N; i++)
			lengthways[i] = scanner.nextInt();
		scanner.close();
		dfs(0, 0);
	}
	public static void dfs(int x, int y)
	{	crosswise[y]--;
		lengthways[x]--;
		res.add(sign(x, y));
		flag[x][y] = true;
		if(x == N - 1 && y == N - 1)
		{	if(judge())
			{	for(int temp: res)
					System.out.print(temp + " ");
				System.exit(0);
			}
			return;
		}
		for(int i = 0; i < 4; i++)
		{	int tx = x + dx[i];
			int ty = y + dy[i];
			if(tx >= 0 && tx < N && ty >= 0 && ty < N && !flag[tx][ty] && crosswise[ty] > 0 && lengthways[tx] > 0)
			{	dfs(tx, ty);
				crosswise[ty]++;
				lengthways[tx]++;
				res.remove(res.size() - 1);
				flag[tx][ty] = false;
			}
		}
	}
	public static boolean judge()
	{	for(int i = 0; i < N; i++)
			if(crosswise[i] != 0 || lengthways[i] != 0)
				return false;
		return true;
	}
	public static int sign(int x, int y)
	{	return x * N + y;
	}
}