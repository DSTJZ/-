// 蓝桥双周赛
// https://www.lanqiao.cn/problems/17035/learning/?contest_id=177
// 关于lambda表达式的自定义排序

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main
{   public static void main(String[] args)
    {    Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.next();
        scanner.close();
        Arrays.sort(arr, new Comparator<String>() {
    		public int compare(String o1, String o2)
    		{	return (o1 + o2).compareTo(o2 + o1);
    		}
        });
        for(String s: arr)
        	System.out.print(s);
    }
}