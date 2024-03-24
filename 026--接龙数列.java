// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3512/learning/?page=1&first_category_id=1&status=1&tags=2023
// 线性dp

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main
{   public static void main(String[] args) throws IOException
	{	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(read.readLine().split(" ")[0]);
		String[] in = read.readLine().split(" ");
		int[] dp = new int[10];//dp[i]为以i为结尾的数的最长接龙子序列长度
		int max = 0;
		for(int i = 0; i < n; i++)
		{	int l = in[i].charAt(0) - '0';
			int r = in[i].charAt(in[i].length() - 1) - '0';
			dp[r] = Math.max(dp[l] + 1, dp[r]);//对于枚举到的in[i]，有两种选择，选与不选取最优
			max = Math.max(dp[r], max);
		}
		System.out.print(n - max);
	}
}