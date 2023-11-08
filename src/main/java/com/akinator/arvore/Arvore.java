package com.akinator.arvore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.akinator.pergunta.Pergunta;

public class Arvore{
    private Node raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void insere(Pergunta pergunta){
        Node node = new Node(pergunta);
        if(raiz == null) raiz = node;
        else insere(raiz, node);
    }

    private void insere(Node nodeAtual, Node node){
        if(node.getPergunta().getId() < nodeAtual.getPergunta().getId()){
            if(nodeAtual.getPerguntaEsq() == null) nodeAtual.setPerguntaEsq(node);
            else insere(nodeAtual.getPerguntaEsq(), node);
        }
        else{
            if(nodeAtual.getPerguntaDir() == null) nodeAtual.setPerguntaDir(node);
            else insere(nodeAtual.getPerguntaDir(), node);
        }
    }

    public void criaArvore(){ // le o arquivo csv e insere as perguntas na arvore
        if(raiz != null) return;
        String path = "/csv/perguntas/perguntas.csv"; // caminho da pasta com os arquivos

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
        if(pergunta.getId() == nodeAtual.getPergunta().getId()) return nodeAtual;
        if(pergunta.getId() < nodeAtual.getPergunta().getId()) return busca(nodeAtual.getPerguntaEsq(), pergunta);
        else return busca(nodeAtual.getPerguntaDir(), pergunta);
    }

    public void print(){
        if(raiz == null) return;
        print(raiz);
    }

    private void print(Node nodeAtual){
        if(nodeAtual == null) return;
        System.out.println(nodeAtual.getPergunta().getTexto());
        print(nodeAtual.getPerguntaEsq());
        print(nodeAtual.getPerguntaDir());
    }

    // getter setter
    public Node getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }
}
