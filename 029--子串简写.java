// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3514/learning/?page=1&first_category_id=1&tags=2023&status=3

// 前缀和
import java.util.Scanner;
public class Main
{   public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		char[] s = scanner.next().toCharArray();
		char ll = scanner.next().charAt(0);
		char rr = scanner.next().charAt(0);
		scanner.close();
		int n = s.length;
		long res = 0;
		int[] prefix = new int[n + 1];//prefix[i]是字符串索引i-1的ll字符出现的次数
		for(int i = 1; i <= n; i++)
		{	if(s[i - 1] == ll)
				prefix[i]++;
			prefix[i] += prefix[i - 1];
			if(s[i - 1] == rr && i >= k)
				res += prefix[i - k + 1];
		}
		System.out.print(res);
	}
}
//暴力，一个样例没过
// import java.util.Scanner;
// public class Main
// {   public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		int k = scanner.nextInt();
// 		char[] s = scanner.next().toCharArray();
// 		char ll = scanner.next().charAt(0);
// 		char rr = scanner.next().charAt(0);
// 		int n = s.length;
// 		long res = 0;
// 		for(int i = 0; i < n - k + 1; i++)
// 		{	if(s[i] != ll)
// 				continue;
// 			for(int j = i + k - 1; j < n; j++)
// 			{	if(s[j] == rr)
// 					res++;
// 			}
// 		}
// 		System.out.print(res);
// 	}
// }