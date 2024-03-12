// https://www.luogu.com.cn/problem/P1359
// 简单dp
import java.util.Arrays;
import java.util.Scanner;

public class Main
{   public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] value = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
			for(int j = i + 1; j <= n; j++)
				value[i][j] = scanner.nextInt();
		scanner.close();
		
		int[] dp = new int[n + 1];//dp[i]为1到i的最小花费
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for(int i = 2; i <= n; i++)
			for(int j = 1; j < i; j++)
				dp[i] = Math.min(dp[i], dp[j] + value[j][i]);//value[i][j]为i到j的花费,此时j在变！
		System.out.print(dp[n]);
	}
}
