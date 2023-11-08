package com.akinator;

import java.util.Scanner;

import com.akinator.arvore.Arvore;
import com.akinator.pergunta.Pergunta;

public class App{
	public static void main(String[] args){
		Arvore arvore = new Arvore();
		Scanner scanner = new Scanner(System.in);

		arvore.criaArvore();

		String resposta = (new Pergunta()).jogar(arvore, scanner);
		System.out.println("Seu time é o " + resposta);

		scanner.close();
	}
}