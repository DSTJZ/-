// 蓝桥模拟赛
// https://www.lanqiao.cn/problems/2415/learning/?page=1&first_category_id=1&tags=2023&status=1
// 滑动窗口

// 初始化最初的单调队列，滑动该窗口，更新，控制结束条件

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;//优先队列

public class Main
{	public static void main(String[] args) throws IOException
	{	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] in1, in2, in3;
		in1 = read.readLine().split(" ");
		in2 = read.readLine().split(" ");
		in3 = read.readLine().split(" ");
		read.close();
		int n = Integer.parseInt(in1[0]);
		int[] arr = new int[n];
		arr = Arrays.stream(in2).mapToInt(Integer::parseInt).toArray();
		int k = Integer.parseInt(in3[0]);
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for(int i = 0; i <= k; i++)
			q.add(new int[]{arr[i], i});
		int[] res = new int[n];
		for(int i = 0; i < n; i++)
		{	if(i < n - k)
				q.add(new int[]{arr[i + k], i + k});
			while(!q.isEmpty() && q.peek()[1] < i - k)
				q.poll();
			res[i] = q.peek()[0];
		}
		for(int i = 0; i < n; i++)
			System.out.print(res[i] + " ");
	}
}