// [USACO23JAN] Air Cownditioning II B
// https://www.luogu.com.cn/problem/P9011
// DFS

import java.util.Arrays;
import java.util.Scanner;

public class Main
{	final static int N = 103, M = 13;
	static int n, m;
	static int[] s = new int[N];
	static int[] a = new int[M];
	static int[] b = new int[M];
	static int[] t = new int[M];
	static int[] p = new int[M];
	static boolean[] use = new boolean[M];
	
	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		for(int i = 0; i < n; i++)
		{	int l = scanner.nextInt();
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			for(int j = l; j <= r; j++)
				s[j] = c;
		}
		for(int i = 0; i < m; i++)
		{	a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
			t[i] = scanner.nextInt();
			p[i] = scanner.nextInt();
		}
		dfs(0);
		System.out.print(res);
	}
	public static int res = Integer.MAX_VALUE;
	public static void dfs(int start)
	{	if(start > m)
		{	int money = judge();
			if(money > 0)
				res = Math.min(res, money);
			return;
		}
		use[start] = true;
		dfs(start + 1);
		use[start] = false;
		dfs(start + 1);
	}
	public static int[] temp = new int[N];
	public static int judge()
	{	Arrays.fill(temp, 0);
		int sum = 0;
		for(int i = 0; i < m; i++)
		{	if(use[i])
			{	for(int j = a[i]; j <= b[i]; j++)
					temp[j] += t[i];
				sum += p[i];
			}
		}
		for(int i = 0; i < N; i++)
			if(temp[i] < s[i])
				return -1;
		return sum;
	}
}
