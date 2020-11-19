package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		method1();
		System.out.println("FINAL DO PROGRAMA");

	}

	public static void method1() {
		System.out.println("*****METODO 1 START****");
		Method2();
		System.out.println("*****METODO 1 END****");
	}

	public static void Method2() {
		System.out.println("*****METODO 2 START****");
		Scanner sc = new Scanner(System.in);
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();

			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Digite um valor valido");
			e.printStackTrace();
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("input erro");
		}
		System.out.println("METHOD2 END******");
		sc.close();
	}
}
