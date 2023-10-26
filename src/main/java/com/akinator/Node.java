package com.akinator;

public class Node{
    public Pergunta pergunta;
    public Node perguntaEsq;
    public Node perguntaDir;

    public Node(Pergunta pergunta){
        this.pergunta = pergunta;
    }
}
