// 蓝桥杯2018省赛
// https://www.lanqiao.cn/problems/172/learning/?page=1&first_category_id=1&name=%E9%80%92%E5%A2%9E
// 枚举、双指针
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{   public static void main(String[] args) throws IOException
	{	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(read.readLine().split(" ")[0]);
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		String[] in1 = read.readLine().split(" ");
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(in1[i]);
		String[] in2 = read.readLine().split(" ");
		for(int i = 0; i < n; i++)
			b[i] = Integer.parseInt(in2[i]);
		String[] in3 = read.readLine().split(" ");
		for(int i = 0; i < n; i++)
			c[i] = Integer.parseInt(in3[i]);
		
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		long res = 0;
		int p = 0;
		int q = 0;
		for(int i = 0; i < n; i++)//枚举b数组的值
		{	while(p < n && a[p] < b[i])
				p++;
			while(q < n && c[q] <= b[i])
				q++;
			res += (long)p * (n - q);
		}
		System.out.print(res);
	}
}