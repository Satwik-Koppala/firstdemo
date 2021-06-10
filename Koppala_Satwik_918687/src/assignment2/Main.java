package assignment2;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the email to be validated:");
		String email=scan.nextLine();
		if(validateEmail(email)) {
			System.out.println("Email is valid");
		}
		else {
			System.out.println("Email is not valid");
		}
	}
	static Boolean validateEmail(String email) {
		//checking whether email is having "@"
		if(email.contains("@")==false) {
			return false;
		}
		String[] first=email.split("@");
		String username=first[0];
		
		//checking whether email is having "." after domain
		if(first[1].contains(".")==false) {
			return false;
		}
		
		String[] second=first[1].split("\\.");
		String domain=second[0];
		String TLD=second[1];
		
		//1st condition
		if(Character.isLowerCase(email.charAt(0))==false) {
			System.out.println("false1");
			return false;
		}
		
		//2nd and 3rd condition
		int count=0;
		for(int i=0;i<username.length();i++) {
			if(97<=  username.charAt(i) && username.charAt(i)<=122 ) {
				count++;
			}
			if(48<=  username.charAt(i) && username.charAt(i)<=57 ) {
				count++;
			}
			if(username.charAt(i) =='.' || username.charAt(i)=='_') {
				count++;
			}
		}
		if(count!=username.length()) {
			return false;
		}

		//4th condition
		if(email.charAt(username.length())!='@') {
			return false;
		}
		
		//5th condition
		count=0;
		for(int i=0;i<domain.length();i++) {
			if(97<=  domain.charAt(i) && domain.charAt(i)<=122 ) {
				count++;
			}
		}
		if(count!=domain.length()) {
			return false;
		}
		
		//6th condition
		if(email.charAt(username.length()+domain.length()+1)!='.') {
			return false;
		}
		
		//7th condition
		count=0;
		for(int i=0;i<TLD.length();i++) {
			if(97<=  TLD.charAt(i) && TLD.charAt(i)<=122 ) {
				count++;
			}
		}
		if(count!=TLD.length()) {
			return false;
		}
		if(2>count || count>6) {
			return false;
		}
		
		//Email is valid
		return true;
	}
}
