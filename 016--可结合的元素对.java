// 蓝桥算法双周赛
// https://www.lanqiao.cn/problems/17021/learning/?contest_id=174
// 差分思想

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main
{   public static void main(String[] args)throws IOException
    {   BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        String[] in = read.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(in[i]);

        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;//！！！！！！！！！！！！！！！！！！！！！！！！
        for(int i = 0; i < n; i++)
        {	//lowbit(arr[i] + arr[j]) == arr[i] + arr[j]就是
            //arr[j] = 2^k - arr[i]
            //枚举k即可
            for(int k = 1; k < 31; k++)
        	{	int arrj = (1 << k) - arr[i];
        		if(map.containsKey(arrj))
        			res += map.get(arrj);
        	}
        	if(map.containsKey(arr[i]))
        		map.replace(arr[i], map.get(arr[i]) + 1);
        	else
        		map.put(arr[i], 1);
        }
        System.out.print(res);
    }
}