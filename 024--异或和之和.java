// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3507/learning/?page=2&first_category_id=1&tags=2023
// 位运算
// 异或和：一个字段的异或和，就是一个字段的所有数都异或

// 将异或分解到位上的操作
import java.util.Scanner;
public class Main
{   public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n + 1];
		for(int i = 1; i <= n; i++)
			arr[i] = scanner.nextInt();
		scanner.close();
		int[] xorSum = new int[n + 1];//求异或和需要i-1位，第0位用的到
		for(int i = 1; i <= n; i++)
			xorSum[i] = xorSum[i - 1] ^ arr[i];
		int[][] bit = new int[25][2];//存每个二进制位的贡献
		for(int i = 0; i <= n; i++)
			for(int j = 0; j <= 20; j++)
				bit[j][(int) ((xorSum[i] >> j) & 1)]++;
		long res = 0;
		for(int i = 0; i <= 20; i++)
			res += (1L << i) * bit[i][0] * bit[i][1];//long long!!
		System.out.print(res);
	}
}
//一个样例超时
// import java.util.Scanner;
// public class Main
// {   public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		int n = scanner.nextInt();
// 		int[] arr = new int[n];
// 		for(int i = 0; i < n; i++)
// 			arr[i] = scanner.nextInt();
// 		long res = 0;
// 		long sum = 0;
// 		for(int i = 0; i < n; i++)
// 		{	sum = 0;
// 			for(int j = i; j < n; j++)
// 			{	sum ^= arr[j];
// 			    res += sum;
// 			}
// 		}
// 		System.out.print(res);
// 	}
// }