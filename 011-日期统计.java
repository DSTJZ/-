// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3492/learning/?page=1&first_category_id=1&tags=2023
// 枚举

import java.util.Scanner;

public class Main
{	
	static int[] arr = {5,6,8,6,9,1,6,1,2,4,9,1,9,8,2,3,6,4,7,7,5,9,5,0,3,8,7,5,8,1,5,8,6,1,8,3,0,3,7,9,2,7,0,5,8,8,5,7,0,9,9,1,9,4,4,6,8,6,3,3,8,5,1,6,3,4,6,7,0,7,8,2,7,6,8,9,5,6,5,6,1,4,0,1,0,0,9,4,8,0,9,1,2,8,5,0,2,5,3,3};
	static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30,31, 30, 31};
	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int res = 0;
		for(int i = 0; i < 12; i++)
			for(int day = 1; day <= month[i]; day++)
			{	int[] date = {2, 0, 2, 3, i / 10 % 10, i % 10, day / 10 % 10, day % 10};
				int index = 0;
				for(int j = 0; j < 100; j++)
				{	if(date[index] == arr[j])
						index++;
					if(index == 8)
					{	res++;
						break;
					}
				}
			}
		System.out.print(res);
	}
}