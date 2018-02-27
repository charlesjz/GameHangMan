package guessWord;

import java.util.Scanner;

public class HangMan2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String secret="Hangman";
		secret=secret.toUpperCase();
		
		String current="______________________________";
		current=current.substring(0, secret.length());
//		System.out.println(secret);
		System.out.println(current);
		
		Scanner sc;
		
		do{
			System.out.println("***************************");
			System.out.println("*  Please guess a letter  *");
			System.out.println("***************************");
			sc= new Scanner(System.in);
			String str_in = sc.next();
			if(str_in.length()!=1){
				System.out.println("Only single letter permitted!\rTry again!\n");
				continue;
			}
			str_in=str_in.toUpperCase();
			if("A".compareTo(str_in)>0 | "Z".compareTo(str_in)<0){
				System.out.println("Only single letter permitted!\rTry again!\n");
				continue;
			}
			
			current=compare(secret,current,str_in);
			
			
		}while(!secret.equals(current));
		
		System.out.println("***************************");
		System.out.println("*         You win!        *");
		System.out.println("***************************");
	}

	private static String compare(String secret, String current, String str_in) {
		char[] ch=str_in.toCharArray();
		char[] cur=current.toCharArray();
		current="";
		for(int i=0;i<secret.length();i++){
			if(cur[i]=='_' & secret.charAt(i)==ch[0]){
				cur[i]=ch[0];
			}
			current+=cur[i];
		}
		System.out.println(current);
		return current;
	}

}
