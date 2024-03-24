// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3502/learning/?page=1&first_category_id=1&tags=2023&status=1
// 数学推理

// 官网有数据超int范围了
// 推理：L <= x <= R
//      x = m^2-n^2 = (m+n)*(m-n)
//      设m+n=A，m-n=B
//      此时可以推出：m = (A+B)/2, m = (A-b)/2
//      因为题目要求m、n必须为正整数
//      则(A+B)、(A-B) 必须是偶数
//      再由m+n=A，m-n=B可推出
//      m、n必须奇偶性相同
//      所以这题是找数满足有两个奇偶性相同的因子，所以4的倍数为两偶，任何奇数为两奇（1的存在）

import java.util.Scanner;

public class Main
{   public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		long l = scanner.nextLong();
		long r = scanner.nextLong();
		long res = r / 4 + r / 2 - ((l - 1) / 4 + l / 2);//算4的倍数和（0~r的偶数个数和0~l的偶数个数差，感觉有点巧）
		System.out.print(res);
	}
}

// 该解法会有数据超时
// import java.util.Scanner;
 
// public class Main
// {   public static void main(String[] args)
//     {   Scanner scanner = new Scanner(System.in);
//         long l = scanner.nextLong();
//         long r = scanner.nextLong();
//         long res = 0;
//         for(long i = l; i <= r; i++)
//         {   if(i % 4 == 0 || (i & 1) == 1)
//                 res++;
//         }
//         System.out.print(res);
//     }
// }

