//NOIP2002 普及组
//https://www.luogu.com.cn/problem/P1036
// DFS

import java.util.Scanner;

public class Main
{	static int n, k;
	static int[] arr = new int[21];
	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		for(int i = 0; i < n; i++)
			arr[i] = scanner.nextInt();
		dfs(0, 0, 0);
		System.out.print(res);
	}
	static long res = 0;
	public static void dfs(int start, int cnt, int sum)
	{	if(cnt == k)
		{	if(isPrime(sum))
				res++;
			return;
		}
		for(int i = start; i < n; i++)
			dfs(i + 1, cnt + 1, sum + arr[i]);
	}
	public static boolean isPrime(int x)
	{	if(x < 2)
			return false;
		for(int i = 2; i * i < x; i++)
			if(x % i == 0)
				return false;
		return true;
	}
}
