package br.com.felipe;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.entity.Book;
import br.com.felipe.ui.UiConsole;

public class Main {

	public static void main(String[] args) {
		
		//create list of Books
		List<Book> books = new ArrayList<>();
		
		//show options
		System.out.println("Bem Vindo!");
		
		int opcao = -1;
		
		while(opcao > 4 || opcao < 0) {
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

	private static void processOption(int opcao) {
		
		switch (opcao) {
		
		case 1:
			System.out.println("Mostrando livros cadastrados...");
			break;
			
		case 2:
			System.out.println("Cadastrando novo livro...");
			break;
			
		case 3:
			System.out.println("Alterando um livro...");
			break;
			
		case 4:
			System.out.println("Deletando um livro...");
			break;
			
		case 0:
			System.out.println("Saindo do programa...");
			System.exit(0);
			break;
		}
		
	}
}
