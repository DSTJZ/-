// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3511/learning/?page=1&first_category_id=1&tags=2023&status=1
// DFS

import java.util.Arrays;
import java.util.Scanner;
public class Main
{   static int[] t = new int[15];//到达时间
	static int[] d = new int[15];//盘旋时间
	static int[] l = new int[15];//降落时间
	static boolean[] vis = new boolean[15];
	static int n;
	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T-- > 0)
		{	n = scanner.nextInt();
			for(int i = 1; i <= n; i++)
			{	t[i] = scanner.nextInt();
				d[i] = scanner.nextInt();
				l[i] = scanner.nextInt();
			}
			Arrays.fill(vis, false);
			if(dfs(1, 0))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	static boolean dfs(int step, int time)//第step架飞机，time是此前所有飞机降落所需要的时间
	{	if(step > n)
			return true;
		for(int i = 1; i <= n; i++)
		{	if(!vis[i] && t[i] + d[i] >= time)
            {   vis[i] = true;
                if(dfs(step + 1, Math.max(time, t[i]) + l[i]))
                    return true;
                vis[i] = false;
            }
		}
		return false;
	}
}