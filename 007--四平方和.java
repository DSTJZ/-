// 蓝桥杯2016四平方和
// https://www.lanqiao.cn/problems/122/learning/?page=1&first_category_id=1&second_category_id=3&tags=2016
// 暴力

import java.util.Scanner;

public class Main
{	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0; i * i < n; i++)
			for(int j = i; j * j < n; j++)
				for(int k = j; k * k < n; k++)
				{	int temp = n - i * i - j * j - k * k;
					double temp2 = Math.sqrt(temp);
					if(temp2 == (int)temp2)
					{	System.out.print(i + " " + j + " " + k + " " + (int)temp2);
						return;
					}
				}
	}
}
// 对于时间复杂度分析：

// 外层循环：对于给定的n，i从0遍历到√n（因为i * i < n），所以外层循环的时间复杂度为O(√n)。
// 中层循环：对于每个i值，j从i遍历到√n，因此中层循环平均情况下大约有O(√n/2)次迭代。
// 内层循环：对于每个i和j组合，k从j遍历到√n，同理，内层循环平均情况下大约有O(√n/2)次迭代。
// 因此，总的时间复杂度是三层循环的时间复杂度之积，即T(n) = O(√n * √n/2 * √n/2) = O(n)。

// 但实际上在最坏的情况下（例如当n是一个完全平方数时），所有三层循环都可能达到其最大迭代次数，此时时间复杂度为T(n) = O(√n * √n * √n) = O(n^(3/2))。

// 考虑到实际情况和代码中的提前返回机制（找到一个解就立即返回），实际运行时的时间复杂度通常会低于O(n^(3/2))，但无法给出精确的上界。