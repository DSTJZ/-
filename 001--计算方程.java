//蓝桥小白入门赛
//https://www.lanqiao.cn/problems/16982/learning/?contest_id=171
// 数论、二分

import java.util.Scanner;

公共 class Main
{	公共 static void main(String[] args)
	{	Scanner scanner = 新建 Scanner(System.in);
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
	公共 static boolean expression(int x, int k, int m)//判断当前的x是否满足条件
	{	return Math.sqrt(x) + log(k, x) - m > 0;
	}
	公共 static int log(int k, int x)
	{	return (int)(Math.log(x) / Math.log(k));
	}
}
