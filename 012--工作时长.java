// 蓝桥杯2023省赛
// https://www.lanqiao.cn/problems/3494/learning/?page=1&first_category_id=1&tags=2023&status=1
// 字符串、模拟、时间处理
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{	public static void main(String[] args)
	{	Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		try 
		{	InputStream in = new FileInputStream("C:\\in.out\\in.txt");
			InputStreamReader read = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(read);
			String strt = "";
			while((strt = br.readLine()) != null)
				list.add(strt);
		} catch (Exception e) {}
		Collections.sort(list);
		long res = 0;
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i = 1; i < list.size(); i += 2)
		{	String start = list.get(i - 1);
			String end = list.get(i);
			try 
			{	res += (format.parse(end).getTime() - format.parse(start).getTime()) / 1000;
			} catch (Exception e) {}
		}
		System.out.print(res);
	}
}
// java.text.SimpleDateFormat 是 Java 中用于日期和时间格式化的一个类，它允许您按照指定的模式将 java.util.Date 
// 或 java.time.LocalDate / LocalDateTime（在Java 8及以上版本中配合java.time.format.DateTimeFormatter更佳）对象转换为字符串，
// 同时也能解析字符串为日期对象。这个类遵循特定的模式字符串规则来进行格式化和解析操作。

// 特点：

// 格式化（date -> text）：通过调用 format(Date date) 方法，您可以将日期对象转换成符合预设格式的字符串。
// Java
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// Date date = new Date();
// String formattedDate = sdf.format(date);
// System.out.println(formattedDate);
// 解析（text -> date）：通过 parse(String source) 方法，您可以将符合格式的字符串解析成日期对象。
// Java
// String dateString = "2024-03-04 15:30:00";
// try {
//     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//     Date date = sdf.parse(dateString);
//     System.out.println(date);
// } catch (ParseException e) {
//     e.printStackTrace();
// }
// 模式字符串： 模式字符串包含一系列字母，每个字母代表日期或时间的一部分：

// yyyy 表示四位年份
// MM 表示月份（01-12）
// dd 表示月份中的日期（01-31）
// HH 表示24小时制小时数（00-23）
// hh 表示12小时制小时数（01-12）
// mm 表示分钟数（00-59）
// ss 表示秒数（00-59）
// SSS 或 S 表示毫秒数
// 还有许多其他的模式字符，如 E 表示星期几，a 表示上午/下午标记等。
// 注意事项：

// SimpleDateFormat 不是线程安全的，所以在多线程环境下应当避免共享单个实例，或者同步访问。
// 在处理日期时间时，由于时区问题，可能需要考虑设置其时区属性 TimeZone。
// SimpleDateFormat 类在处理非ISO-8601标准格式时可能会受到本地化设置的影响，因此在国际化的应用中需谨慎使用。
// 对于Java 8及更高版本，推荐使用 java.time 包下的 LocalDateTime 和 DateTimeFormatter 类，它们提供了更好
// 的性能、线程安全性以及对现代日期时间处理功能的支持。