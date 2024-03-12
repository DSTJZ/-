// 洛谷P1886 滑动窗口 /【模板】单调队列
// https://www.luogu.com.cn/problem/P1886
// 
// 第一版代码(TLE):
// import java.util.Deque;
// import java.util.LinkedList;
// import java.util.Scanner;

// public class Main
// {	static int n, k;
// 	static int[] min, max, in;
// 	public static void main(String[] args)
// 	{	Scanner scanner = new Scanner(System.in);
// 		n = scanner.nextInt();
// 		k = scanner.nextInt();
// 		in = new int[n];
// 		min = new int[n];
// 		max = new int[n];
// 		for(int i = 0; i < n; i++)
// 			in[i] = scanner.nextInt();
// 		scanner.close();

// 		Deque<Integer> q = new LinkedList<>();
// 		for(int i = 0; i < n; i++)
// 		{	while(!q.isEmpty() && in[q.getLast()] >= in[i])
// 				q.removeLast();
// 			q.addLast(i);
// 			min[i] = in[q.getFirst()];
// 			if(q.getFirst() <= i - k + 1 && i >= k - 1) 
// 				q.removeFirst();
// 		}
// 		for(int i = k - 1; i < n; i++)
// 			System.out.print(min[i] + " ");
// 		System.out.println();
// 		q.clear();
// 		for(int i = 0; i < n; i++)
// 		{	while(!q.isEmpty() && in[q.getLast()] <= in[i])
// 				q.removeLast();
// 			q.addLast(i);
// 			max[i] = in[q.getFirst()];
// 			if(q.getFirst() <= i - k + 1 && i >= k - 1)
// 				q.removeFirst();
// 		}
// 		for(int i = k - 1; i < n; i++)
// 			System.out.print(max[i] + " ");
// 	}
// }
// 第二版代码, java io优化, 速度略有提升(仍然TLE):

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int n, k;
    static int[] min, max, in;

    public static void main(String[] args) 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = new String[2];
        try 
        {
            nk = read.readLine().split(" ");
        } catch (Exception e) 
        {
        }
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        in = new int[n];
        min = new int[n];
        max = new int[n];
        String[] intemp = null;
        try 
        {
            intemp = read.readLine().split(" ");
        } catch (Exception e) {
        }
        for (int i = 0; i < n; i++)
            in[i] = Integer.parseInt(intemp[i]);

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) 
        {
            while (!q.isEmpty() && in[q.getLast()] >= in[i])
                q.removeLast();
            q.addLast(i);
            min[i] = in[q.getFirst()];
            if (q.getFirst() <= i - k + 1 && i >= k - 1)
                q.removeFirst();
        }
        for (int i = k - 1; i < n; i++)
            System.out.print(min[i] + " ");
        System.out.println();
        q.clear();
        for (int i = 0; i < n; i++) 
        {
            while (!q.isEmpty() && in[q.getLast()] <= in[i])
                q.removeLast();
            q.addLast(i);
            max[i] = in[q.getFirst()];
            if (q.getFirst() <= i - k + 1 && i >= k - 1)
                q.removeFirst();
        }
        for (int i = k - 1; i < n; i++)
            System.out.print(max[i] + " ");
    }
}
// 这道题对Java不友好，相同逻辑用c++直接过
// #include<iostream>
// #include<cstdio>
// #include<deque>
// using namespace std;

// int main()
// {   int n, k;
//     cin >> n >> k;
//     int in[n], max[n], min[n];
//     for(int i = 0; i < n; i++)
//     cin >> in[i];
//     deque<int> qmin, qmax;
//     // deque<int> qmax;
//     for(int i = 0; i < n; i++)
//     {   while(!qmin.empty() && in[qmin.back()] >= in[i])
//             qmin.pop_back();
//         qmin.push_back(i);
//         min[i] = in[qmin.front()];
//         if(qmin.front() <= i - k + 1 && i >= k - 1)
//             qmin.pop_front();

//         while(!qmax.empty() && in[qmax.back()] <= in[i])
//         qmax.pop_back();
//             qmax.push_back(i);
//         max[i] = in[qmax.front()];
//         if(qmax.front() <= i - k + 1 && i >= k - 1)
//             qmax.pop_front();
//     }
//     for(int i = k - 1; i < n; i++)
//     { cout << min[i] << " ";
//     }
//     cout << endl;
//     for(int i = k - 1; i < n; i++)
//     { cout << max[i] << " ";
//     }
// }