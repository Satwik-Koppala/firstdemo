package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ItemDAO dao=new ItemDAO();
		List<Item> items= new ArrayList<>();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of items");
		int n=scan.nextInt();
		scan.nextLine();
		
		for(int i=0;i<n;i++) {
			String input[] =scan.nextLine().split(",",0);
			Item item=new Item(input[0],Double.parseDouble(input[1]),input[2]);
			items.add(item);
		}dao.bulkCopy(items);
		
		System.out.println("Enter a search type:");
		System.out.println("1.By Type");
		System.out.println("2.By Price");
		n=scan.nextInt();
		
		if(n==1) {
			System.out.println("Enter the type");
			scan.nextLine();
			String type=scan.nextLine();
			List<Item> types= dao.findItem(type);
			display(types);
		}
		
		else if(n==2) {
			System.out.println("Enter the price");
			double price=scan.nextDouble();
			List<Item> prices=dao.finditem(price);
			display(prices);
		}	
		else {
			System.out.println("Invalid choice");
		}
	}

	public static void display(List<Item> items) {
		
		System.out.println("Name\t\tPrice\tType");
		items.forEach((ee)->{System.out.println(ee.getName()+"\t\t"+ee.getPrice()+"\t"+ee.getType());});
	
	}

}