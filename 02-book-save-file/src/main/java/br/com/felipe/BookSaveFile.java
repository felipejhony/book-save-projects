package br.com.felipe;

import br.com.felipe.service.BookService;
import br.com.felipe.ui.UiConsole;

public class BookSaveFile{

	public static void main(String[] args) {

		System.out.println("Bem Vindo!");

		while (true) {
			System.out.println("\n===============================================");
			int opcao = -1;
			while (opcao > 4 || opcao < 0) {
				System.out.println("Digite o numero correpondente a opção desejada:");
				System.out.println("1 - Ver livros cadastrados.");
				System.out.println("2 - Cadastrar um livro novo.");
				System.out.println("3 - Alterar um livro.");
				System.out.println("4 - Deletar um livro cadastrado.");
				System.out.println("0 - Sair.");

				opcao = UiConsole.getInt();
			}

			processOption(opcao);
		}

	}

	private static void processOption(int opcao) {

		switch (opcao) {

		case 1:
			System.out.println("Mostrando livros cadastrados...");
			BookService.show();
			break;

		case 2:
			System.out.println("Cadastrando novo livro...");
			BookService.add();
			break;

		case 3:
			System.out.println("Alterando um livro...");
			BookService.update();
			break;

		case 4:
			System.out.println("Deletando um livro...");
			BookService.delete();
			break;

		case 0:
			System.out.println("Saindo do programa...");
			System.exit(0);
			break;
		}

	}
}
