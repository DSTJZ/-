// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3503/learning/?page=1&first_category_id=1&tags=2023&status=1
// 区间dp，可双指针暴力

import java.util.Scanner;

public class Main
{   public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		String s =scanner.next();
		int n = s.length();
		int[][] dp = new int[n][n];//dp[i][j]为子串i~j是否符合翻转规则
		for(int i = 0; i < n - 1; i++)
			if(s.charAt(i) > s.charAt(i + 1))
				dp[i][i + 1] = 1;
		for(int len = 3; len <= n; len++)//子串为啥要包含字符串自身。。。
			for(int i = 0; i < n - len + 1; i++)
			{	int j = i + len - 1;//!!!起点、终点都不能少
				if(s.charAt(i) > s.charAt(j))
					dp[i][j] = 1;
				else if(s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i + 1][j - 1];
			}
		int res = 0;
		for(int i = 0; i < n - 1; i++)
			for(int j = i + 1; j < n; j++)
				res += dp[i][j];
		System.out.print(res);
	}
}
// 双指针
// import java.util.Scanner;

// public class Main
// {   public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		String s =scanner.next();
// 		int n = s.length();
// 		int res = 0;
// 		for(int i = 0; i < n; i++)
// 			for(int j = i + 1; j < n; j++)
// 			{	int l = i;
// 				int r = j;
// 				while(l < r)
// 				{	if(s.charAt(r) < s.charAt(l))
// 					{	res++;
// 						break;
// 					}else if(s.charAt(l) == s.charAt(r))
// 					{	l++;
// 						r--;
// 					}else
// 						break;
// 				}
// 			}
// 		System.out.print(res);
// 	}
// }