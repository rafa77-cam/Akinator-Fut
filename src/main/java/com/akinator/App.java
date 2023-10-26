package com.akinator;

import java.util.Scanner;

public class App{
	public static void main(String[] args){
		Arvore arvore = new Arvore();
		Scanner scanner = new Scanner(System.in);

		String estado = ((new Pergunta()).primeiraPergunta(scanner));
		arvore.criaArvore(estado);

		String resposta = (new Pergunta()).jogar(arvore, scanner);
		System.out.println("Seu time é o " + resposta);

		scanner.close();
	}
}