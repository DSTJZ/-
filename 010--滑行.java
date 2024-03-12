// 蓝桥模拟赛
// https://www.lanqiao.cn/problems/2414/learning/?page=1&first_category_id=1&tags=2023
// DFS、记忆化搜索

//第一版代码：
// import java.util.Scanner;

// public class Main
// {	static int n, m;
// 	static int[][] high, max;
// 	static boolean[][] sign;
// 	public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		n = scanner.nextInt();
// 		m = scanner.nextInt();
// 		high = new int[n][m];
// 		sign = new boolean[n][m];
// 		max = new int[n][m];
// 		for(int i = 0; i < n; i++)
// 			for(int j = 0; j < m; j++)
// 				high[i][j] = scanner.nextInt();
// 		scanner.close();
// 		int res = 0;
// 		for(int i = 0; i < n; i++)
// 			for(int j = 0; j < m; j++)
// 			{	res = Math.max(res, dfs(i, j));
// 			}
// 		System.out.print(res);
// 	}
// 	static int[] dx = {-1, 0, 1, 0};
// 	static int[] dy = {0, -1, 0, 1};
// 	public static int dfs(int x, int y)
// 	{	sign[x][y] = true;
// 		max[x][y] = 1;
// 		for(int i = 0; i < 4; i++)
// 		{	int tx = x + dx[i];
// 			int ty = y + dy[i];
// 			if(tx >= 0 && tx < n && ty >= 0 && ty < m && !sign[tx][ty] && high[tx][ty] < high[x][y])
// 			{	max[x][y] = Math.max(max[x][y], dfs(tx, ty) + 1);
// 				sign[tx][ty] = false;
// 			}
// 		}
// 		return max[x][y];
// 	}
// }
// 第二版代码(答案正确，仍然超时)：
// import java.util.Scanner;

// public  class Main
// {   static int n, m;
//     static int[][] high, max;
//     static boolean[][] sign;
//     public static void main(String[] args)
//     {   Scanner scanner = new Scanner(System.in);
//         n = scanner.nextInt();
//         m = scanner.nextInt();
//         high = new int[n][m];
//         sign = new boolean[n][m];
//         max = new int[n][m];
//         for(int i = 0; i < n; i++)
//             for(int j = 0; j < m; j++)
//                 high[i][j] = scanner.nextInt();
//         scanner.close();
//         int res = 0;
//         for(int i = 0; i < n; i++)
//             for(int j = 0; j < m; j++)
//             {   dfs(i, j);
//                 res = Math.max(res, max[i][j]);
//             }
//         System.out.print(res);
//     }
//     static int[][] ddd = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
//     public static int dfs(int x, int y)
//     {   sign[x][y] = true;
//         int temp = 0;
//         for(int i = 0; i < 4; i++)
//         {   int tx = x + ddd[i][0];
//             int ty = y + ddd[i][1];

//             if(tx >= 0 && tx < n && ty >= 0 && ty < m && high[tx][ty] < high[x][y])
//             {   temp = Math.max(temp, choose(tx, ty));
//                 sign[tx][ty] = false;
//             }
//         }
//         return max[x][y] = temp + 1;
//     }
//     public static int choose(int x, int y)
//     {   return sign[x][y] ? max[x][y] : dfs(x, y);
//     }
// }
// 正确：
import java.util.Arrays;
import java.util.Scanner;

public  class Main
{   static int n, m;
    static int[][] high, max;
    static boolean[][] sign;
    public static void main(String[] args)
    {   Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        high = new int[n][m];
        sign = new boolean[n][m];
        max = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                high[i][j] = scanner.nextInt();
        scanner.close();
        int res = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
            {   for(int k = 0 ; k < n; k++)
                    Arrays.fill(sign[k], false);
                dfs(i, j);
                res = Math.max(res, max[i][j]);
            }
        System.out.print(res);
    }
    static int[][] ddd = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static int dfs(int x, int y)
    {   sign[x][y] = true;
        int temp = 0;
        for(int i = 0; i < 4; i++)
        {   int tx = x + ddd[i][0];
            int ty = y + ddd[i][1];

            if(tx >= 0 && tx < n && ty >= 0 && ty < m && high[tx][ty] < high[x][y])
            {   temp = Math.max(temp, choose(tx, ty));
            }
        }
        return max[x][y] = temp + 1;
    }
    public static int choose(int x, int y)
    {   return sign[x][y] ? max[x][y] : dfs(x, y);
    }
}