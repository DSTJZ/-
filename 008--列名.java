// 蓝桥模拟赛
// https://www.lanqiao.cn/problems/2407/learning/?page=1&first_category_id=1&tags=2023
// 模拟、规律

// 解法1： 2022转26进制
//  2022/(26*26) = 2->B
//  2022/26%26 = 25->Y
//  2022%26 = 20->T

// 解法2：

import java.util.Scanner;

public class Main
{	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int num = 26 * 26 + 26;		//num是ZZ的值
		for(int i = 'A'; i <= 'Z'; i++)
			for(int j = 'A'; j <= 'Z'; j++)
				for(int k = 'A'; k <= 'Z'; k++)
				{	num++;
					if(num == 2022)
					{	System.out.printf("%c%c%c", i, j, k);
						return;
					}
				}
	}
}