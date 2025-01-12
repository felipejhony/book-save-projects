package br.com.felipe.ui;

import java.util.Scanner;

public class UiConsole {

	private static final Scanner scanner = new Scanner(System.in);

	public static int getInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine()); // Tenta converter a entrada para inteiro
			} catch (NumberFormatException e) {
				System.out.println("Por favor, insira um número inteiro válido.");
			}
		}
	}

}
