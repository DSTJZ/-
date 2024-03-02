// [USACO2.1] 健康的荷斯坦奶牛 Healthy Holsteins
// https://www.luogu.com.cn/problem/P1460
// DFS

import java.util.Arrays;
import java.util.Scanner;

public class Main
{	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		res[G] = Integer.MAX_VALUE;
		v = scanner.nextInt();
		for(int i = 0; i < v; i++)
			need[i] = scanner.nextInt();
		g = scanner.nextInt();
		for(int i = 0; i < g; i++)
			for(int j = 0; j < v; j++)
				arr[i][j] = scanner.nextInt();
		dfs(0, 0);
		System.out.print(res[G] + " ");
		for(int i = 0; i < g; i++)
			if(res[i] > 0)
				System.out.print((i + 1) + " ");
	}
	static final int V = 30, G = 20;
	static int v, g;
	static int[] need = new int[V];
	static int[][] arr = new int[G][V];
	static int[] res = new int[G + 1];
	public static void dfs(int step, int cnt)
	{	if(step > g)
		{	if(judge())
				if(cnt < res[G])
				{	res[G] = cnt;
					Arrays.fill(res, 0, g, 0);
					for(int i = 0; i < g; i++)
						if(use[i])
							res[i] = 1;
				}
		return;
		}
		use[step] = true;
		dfs(step + 1, cnt + 1);
		use[step] = false;
		dfs(step + 1, cnt);
	}
	static boolean[] use = new boolean[G];
	static int[] temp = new int[V];
	public static boolean judge()
	{	Arrays.fill(temp, 0);
		for(int i = 0; i < g; i++)
			if(use[i])
				for(int j = 0; j < v; j++)
					temp[j] += arr[i][j];
		for(int i = 0; i < v; i++)
			if(temp[i] < need[i])
				return false;
		return true;
	}
}