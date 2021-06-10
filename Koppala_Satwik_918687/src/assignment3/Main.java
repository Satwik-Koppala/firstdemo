package assignment3;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws ParseException {
		Call c=new Call();
		System.out.println("Enter no of calls : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		List<Call> callist = new ArrayList<Call>();
		String line;
		for (int i = 0; i < n; i += 1) {
			line = scan.nextLine();
			callist.add(c.createCall(line));
		}
		System.out.println("Month\tCount");
		Map<String, Integer> calls = c.monthCount(callist);
		calls.forEach((x, y) -> {System.out.printf("%-10s %s\n",x,y); });
	}
}