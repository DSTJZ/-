//蓝桥小白入门赛
//https://www.lanqiao.cn/problems/16982/learning/?contest_id=171

import java.util.Scanner;

public class Main
{	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-- > 0)
		{	int k = scanner.nextInt();
			int m = scanner.nextInt();
			int left = 0;
			int right = Integer.MAX_VALUE;
			while(left < right)
			{	int middle = left + (right - left) / 2;
				if(expression(middle, k, m))
					right = middle;
				else
					left = middle + 1;
			}
			System.out.println(left);
		}
	}
	public static boolean expression(int x, int k, int m)//判断当前的x是否满足条件
	{	return Math.sqrt(x) + log(k, x) - m > 0;
	}
	public static int log(int k, int x)
	{	return (int)(Math.log(x) / Math.log(k));
	}
}