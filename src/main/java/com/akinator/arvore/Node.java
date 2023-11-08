package com.akinator.arvore;

import com.akinator.pergunta.Pergunta;

public class Node{
    private Pergunta pergunta;
    private Node perguntaEsq;
    private Node perguntaDir;

    public Node(Pergunta pergunta){
        this.pergunta = pergunta;
    }

    //getter setter
    public Pergunta getPergunta() {
        return this.pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Node getPerguntaEsq() {
        return this.perguntaEsq;
    }

    public void setPerguntaEsq(Node perguntaEsq) {
        this.perguntaEsq = perguntaEsq;
    }

    public Node getPerguntaDir() {
        return this.perguntaDir;
    }

    public void setPerguntaDir(Node perguntaDir) {
        this.perguntaDir = perguntaDir;
    }
}
