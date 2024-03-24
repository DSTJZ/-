// 蓝桥杯2018省赛
// https://www.lanqiao.cn/problems/175/learning/?page=1&first_category_id=1&name=%E8%88%AA%E7%8F%AD
// 字符串、处理时间

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{   static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws ParseException//日期时间格式的抛异常
	{	int n = scanner.nextInt();
		scanner.nextLine();
		while(n-- > 0)
		{	int to = getTime();
			int back = getTime();
			int res = (to + back) / 2;//飞去的时间时是：飞行时间-时差，回来的时间是：飞行时间+时差
			System.out.printf("%02d:%02d:%02d\n", res / 3600, res / 60 % 60, res % 60); //printf前置0，防空位
        }
	}
	static int getTime() throws ParseException
	{	String[] in = scanner.nextLine().split(" ");
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");//format类的自定义时间格式匹配
		Date start = format.parse(in[0]);
		Date end = format.parse(in[1]);
		int t = 0;
		if(in.length > 2)
			t = Integer.parseInt(in[2].substring(2, 3));
		return (int) ((end.getTime() - start.getTime()) / 1000 + t * 24 * 3600);//Date类返回的是纳秒
	}
}

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.Scanner;

// public class Main
// {   static Scanner scanner = new Scanner(System.in);
// 	public static void main(String[] args) throws ParseException//日期时间格式的抛异常
// 	{	int n = scanner.nextInt();
// 		scanner.nextLine();
// 		while(n-- > 0)
// 		{	int to = getTime();
// 			int back = getTime();
// 			int res = (to + back);//飞去的时间时是飞行时间-时差，回来的时间时飞行时间加时差
// 			System.out.printf("%02d:%02d:%02d\n", res / 3600, res / 60 % 60, res % 60); //printf前置0，防空位
// 		}
// 	}
// 	static int getTime() throws ParseException
// 	{	String[] in = scanner.nextLine().split(" ");
// 		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");//format类的自定义时间格式匹配
// 		Date start = format.parse(in[0]);
// 		Date end = format.parse(in[1]);
// 		int t = 0;
// 		if(in.length > 2)
// 			t = Integer.parseInt(in[2].substring(2, 3));
// 		return (int) ((end.getTime() - start.getTime()) / 1000 + t * 24 * 3600);//Date类获取毫秒
// 	}
// }