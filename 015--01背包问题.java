// 经典01背包问题
// https://www.lanqiao.cn/problems/303/learning/?page=1&first_category_id=1&second_category_id=6
// dp、dfs记忆化

// 二维数组dp
// 时间复杂度：O(n * capacity)（两层循环）
// 空间复杂度：O(n * capacity)（申请的dp数组）
// import java.util.Scanner;

// public class Main
// {	public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		int capacity = scanner.nextInt();
// 		int n = scanner.nextInt();
// 		int[] price = new int[n + 1];
// 		int[] volume = new int[n + 1];
// 		for(int i = 1; i <= n; i++)
// 		{	volume[i] = scanner.nextInt();
// 			price[i] = scanner.nextInt();
// 		}
// 		int[][]dp = new int[n + 1][capacity + 1];
// 		for(int i = 1; i <= n; i++)
// 			for(int j = 1; j <= capacity; j++)
// 			{	if(volume[i] > j)
// 					dp[i][j] = dp[i - 1][j];
// 				else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volume[i]] + price[i]);
// 			}
// 		System.out.print(dp[n][capacity]);
// 	}
// }


// 一维数组dp
// 空间复杂度节省

import java.util.Scanner;

public class Main
{	static int capacity, n, price[], volume[], dp[];
	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		capacity = scanner.nextInt();
		n = scanner.nextInt();
		price = new int[n + 1];
		volume = new int[n + 1];
		dp = new int[capacity + 1];
		for(int i = 1; i <= n; i++)
		{	volume[i] = scanner.nextInt();
			price[i] = scanner.nextInt();
		}
		for(int i = 1; i <= n; i++)
			for(int j = capacity; j >= volume[i]; j--)
				dp[j] = Math.max(dp[j], dp[j - volume[i]] + price[i]);
		System.out.print(dp[capacity]);
	}
}


// 极简DFS
// 时间复杂度：n个物品，每个物品都有两种选择：要么放入背包，要么不放。
// 因此，总共有2^n种不同的组合。所以，DFS的时间复杂度是O(2^n)。
// 空间复杂度：在最坏的情况下，递归深度达到n（即考虑了所有物品的所有可能组合）。
// 因此，空间复杂度是O(n)。
// import java.util.Scanner;

// public class Main
// {	static int capacity, n, price[], volume[], res;
// 	public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		capacity = scanner.nextInt();
// 		n = scanner.nextInt();
// 		price = new int[n + 1];
// 		volume = new int[n + 1];
// 		for(int i = 1; i <= n; i++)
// 		{	volume[i] = scanner.nextInt();
// 			price[i] = scanner.nextInt();
// 		}
// 		dfs(0, 0, 0);//最初状态
// 		System.out.print(res);
// 	}
// 	public static void dfs(int step, int sumv, int sump)//背包容量为sumv时前step个物品的价值为sump
// 	{	if(step > n)
// 		{	if(sumv <= capacity && sump > res)
// 				res = sump;
// 			return;
// 		}
// 		dfs(step + 1, sumv, sump);
// 		dfs(step + 1, sumv + volume[step], sump + price[step]);
// 	}
// }


// DFS加剪枝（当目前总重量超过背包最大容量时，不再继续遍历）
// 空间复杂度和时间复杂度与上一个相比有小提升，但总体优化不大
// import java.util.Scanner;

// public class Main
// {	static int capacity, n, price[], volume[], res;
// 	public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		capacity = scanner.nextInt();
// 		n = scanner.nextInt();
// 		price = new int[n + 1];
// 		volume = new int[n + 1];
// 		for(int i = 1; i <= n; i++)
// 		{	volume[i] = scanner.nextInt();
// 			price[i] = scanner.nextInt();
// 		}
// 		dfs(0, 0, 0);
// 		System.out.print(res);
// 	}
// 	public static void dfs(int step, int sumv, int sump)
// 	{	if(step > n)
// 			return;
// 		dfs(step + 1, sumv, sump);//不选第step件物品
// 		if(sumv + volume[step] <= capacity)//剪枝，如果如果当前步骤的物品体积加上已选择的物品体积超过了背包容量，那么就没有必要继续考虑这个分支
// 		{	res = Math.max(res, sump + price[step]);
// 			dfs(step + 1, sumv + volume[step], sump + price[step]);
// 		}
// 	}
// }