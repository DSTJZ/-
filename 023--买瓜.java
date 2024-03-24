// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3505/learning/?page=1&first_category_id=1&status=1&tags=2023
// DFS多种优化(回溯、剪枝、利用后缀和)

import java.util.Arrays;
import java.util.Scanner;
public class Main
{   static int n, m, weight[], res = 100;
    static long suf[];//后缀和
    public static void main(String[] args)
    {   Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        weight = new int[n];
        for (int i = 0; i < n; i++)
            weight[i] = scanner.nextInt();
        reverseSort(weight);//题目要求最小刀数，提前对重量组降序排列（剪枝），否则官网有三个样例过不了
        suf = new long[n + 1];// 后缀和，要开long不然会爆
        for (int i = n - 1; i >= 0; i--)
            suf[i] = suf[i + 1] + (long) weight[i];
        dfs(0, 0, 0);
        if (res == 100)
            System.out.println(-1);
        else
            System.out.println(res);
    }
    static void dfs(int pos, double sum, int cnt)//层数，重量和，刀数
    {   if(sum == m)
    {   res = Math.min(res, cnt);
        return;
    }
        if(pos >= n || cnt >= res || sum > m || sum + suf[pos] < m)
            return;
        for (int j = pos; j < n; j++)
        {   sum += weight[j];         //整个西瓜拿走
            dfs(j + 1, sum, cnt);
            sum -= weight[j] / 2.0;    //拿走一半
            dfs(j + 1, sum, cnt + 1);
            sum -= weight[j] / 2.0;    //不拿走
        }
    }
    static void reverseSort(int[] arr)
    {   Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while(i < j)
        {   int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}