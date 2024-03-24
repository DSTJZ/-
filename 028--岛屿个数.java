// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3513/learning/?page=1&first_category_id=1&tags=2023&status=1
// BFS

// 初始化是真TM重要，被折磨死了
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main
{   static int N = 55;
    static int m, n;
    static boolean vis[][] = new boolean[N][N], used[][] = new boolean[N][N];
    static char[][] map = new char[N][N];
    public static void main(String[] args)
    {   Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0)
        {   m = scanner.nextInt();
            n = scanner.nextInt();
            for(int i = 0; i < m; i++)
                map[i] = scanner.next().toCharArray();
            int res = 0;
            for(int i = 0; i < m; i++)
                for(int j = 0; j < n; j++)
                    if(!vis[i][j] && map[i][j] == '1')
                    {   bfs_island(i, j);
                        if(bfs_sea(i, j))//每次去对岛屿进行bfs，然后再去对周围的海水bfs，判断海水是否能流到地图边界
                            res++;
                    }
            System.out.println(res);
            for(boolean[] t: vis)
                Arrays.fill(t, false);
        }
    }
    static int dx[]={1,-1,0,0,1,1,-1,-1}, dy[]={0,0,1,-1,1,-1,1,-1};;
    static void bfs_island(int x, int y)
    {   Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        vis[x][y] = true;
        while(!queue.isEmpty())
        {   int[] t = queue.remove();
            for(int i = 0; i < 4; i++)
            {   int tx = t[0] + dx[i];
                int ty = t[1] + dy[i];
                if(tx >= 0 && tx < m && ty >= 0 && ty < n && !vis[tx][ty] && map[tx][ty] == '1')
                {   vis[tx][ty] = true;
                    queue.add(new int[]{tx, ty});
                }
            }
        }
    }
    static boolean bfs_sea(int x, int y)
    {   for(boolean[] t: used)
            Arrays.fill(t, false);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        used[x][y] = true;
        while(!queue.isEmpty())
        {   int[] t = queue.remove();
            if(t[0] == 0 || t[0] == m - 1 || t[1] == 0 || t[1] == n - 1)
                return true;
            for(int i = 0; i < 8; i++)
            {   int tx = t[0] + dx[i];
                int ty = t[1] + dy[i];
                if(tx >= 0 && tx < m && ty >= 0 && ty < n && !used[tx][ty] && map[tx][ty] == '0')
                {   queue.add(new int[]{tx, ty});
                    used[tx][ty] = true;
                }
            }
        }
        return false;
    }
}