package com.akinator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Arvore{
    public Node raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void insere(Pergunta pergunta){
        Node node = new Node(pergunta);
        if(raiz == null) raiz = node;
        else insere(raiz, node);
    }

    private void insere(Node nodeAtual, Node node){
        if(node.pergunta.id < nodeAtual.pergunta.id){
            if(nodeAtual.perguntaEsq == null) nodeAtual.perguntaEsq = node;
            else insere(nodeAtual.perguntaEsq, node);
        }
        else{
            if(nodeAtual.perguntaDir == null) nodeAtual.perguntaDir = node;
            else insere(nodeAtual.perguntaDir, node);
        }
    }

    public void criaArvore(String estado){ // le o arquivo csv e insere as perguntas na arvore
        if(raiz != null) return;

        String path = "csv/perguntas/"; // caminho da pasta com os arquivos
        if(estado == "SP") path = path.concat("sp.csv"); // seta o caminho do .csv
        else if(estado == "RJ") path = path.concat("rj.csv");
        else if(estado == "MG") path = path.concat("mg.csv");
        else path = path.concat("rs.csv");

		try{
            BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			String split = ",";
			while((line = br.readLine()) != null){ // le o .csv
				String[] pergunta = line.split(split);
				insere(new Pergunta(Integer.parseInt(pergunta[0]), pergunta[1], pergunta[2], pergunta[3])); // insere as perguntas na arvore
			}
			br.close();
		}
		catch(IOException ioe){
            ioe.printStackTrace();
		}
    }

    public Node busca(Pergunta pergunta){
        if(raiz == null) return null;
        return busca(raiz, pergunta);
    }

    private Node busca(Node nodeAtual, Pergunta pergunta){
        if(nodeAtual == null) return null;
        if(pergunta.id == nodeAtual.pergunta.id) return nodeAtual;
        if(pergunta.id < nodeAtual.pergunta.id) return busca(nodeAtual.perguntaEsq, pergunta);
        else return busca(nodeAtual.perguntaDir, pergunta);
    }

    public void print(){
        if(raiz == null) return;
        print(raiz);
    }

    private void print(Node nodeAtual){
        if(nodeAtual == null) return;
        System.out.println(nodeAtual.pergunta.texto);
        print(nodeAtual.perguntaEsq);
        print(nodeAtual.perguntaDir);
    }
}
