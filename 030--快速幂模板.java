// https://www.luogu.com.cn/problem/P1226

import java.math.BigInteger;
import java.util.Scanner;

public class Main
{   public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		BigInteger a = scanner.nextBigInteger();
		BigInteger b = scanner.nextBigInteger();
		BigInteger p = scanner.nextBigInteger();
		String res = a.modPow(b, p).toString();
//		long a = scanner.nextLong();
//		long b = scanner.nextLong();
//		long p = scanner.nextLong();
//		long res = modPow(a % p, b, p);//先对a进行一次取余
		System.out.print(a + "^" + b + " mod "+ p + "=" + res);
	}
//	递归
//	public static long modPow(long a, long b, long p) 
//	{	if(b == 0)
//			return 1;
//		boolean isOdd = (b & 1) == 1;
//		long res = modPow(a, b >> 1, p);
//		if(isOdd)
//			return (res * res % p * a % p) % p;
//		else
//			return res * res % p;
//	}
//	迭代方法
//	public static long modPow(long a, long b, long p)
//	{	long res = 1;
//		while(b > 0)
//		{	if((b & 1) == 1)
//				res *= a;
//			a *= a;
//			res %= p;
//			a %= p;
//			b >>= 1;
//		}
//		return res;
//	}
}