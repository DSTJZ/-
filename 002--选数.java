//NOIP2002 普及组
//https://www.luogu.com.cn/problem/P1036

import java.util.Scanner;

公共 class Main
{	static int n, k;
	static int[] arr = 新建 int[21];
	公共 static void main(String[] args)
	{	Scanner scanner = 新建 Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		for(int i = 0; i < n; i++)
			arr[i] = scanner.nextInt();
		dfs(0, 0, 0);
		System.out.print(res);
	}
	static long res = 0;
	公共 static void dfs(int start, int cnt, int sum)
	{	if(cnt == k)
		{	if(isPrime(sum))
				res++;
			return;
		}
		for(int i = start; i < n; i++)
			dfs(i + 1, cnt + 1, sum + arr[i]);
	}
	公共 static boolean isPrime(int x)
	{	if(x < 2)
			return false;
		for(int i = 2; i * i < x; i++)
			if(x % i == 0)
				return false;
		return true;
	}
}
