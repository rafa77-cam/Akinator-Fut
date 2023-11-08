package com.akinator.pergunta;

import java.util.Scanner;

import com.akinator.arvore.Arvore;
import com.akinator.arvore.Node;

public class Pergunta {
    private int id;
    private String texto;
    private String respostaSim;
    private String respostaNao;

    public Pergunta(){
    }

    public Pergunta(int id, String texto, String respostaSim, String respostaNao) {
        this.id = id;
        this.texto = texto;
        this.respostaSim = respostaSim;
        this.respostaNao = respostaNao;
    }

    private boolean perguntar(Node node, Scanner scanner){
        char resposta = 69;
        System.out.println(node.getPergunta().getTexto());
        while(resposta != 'S' && resposta != 'N'){
            System.out.println("S: para Sim\nN: para Nao");
            resposta = scanner.next().charAt(0);
            resposta = Character.toUpperCase(resposta);
        }
        if(resposta == 'S') return true;
        else return false;
    }

    public String jogar(Arvore arvore, Scanner scanner){
        Node curNode = new Node(null);
        curNode = arvore.getRaiz();
        Boolean resposta = false;
        while(true){
            resposta = perguntar(curNode, scanner);
            if(curNode.getPergunta().getResposta(resposta).equals("null")){
                if(resposta == true) curNode = curNode.getPerguntaDir();
                else curNode = curNode.getPerguntaEsq();
            }
            else return curNode.getPergunta().getResposta(resposta);
        }
    }

    public String getResposta(Boolean resposta){
        if(resposta == true) return respostaSim;
        else return respostaNao;
    }

    //getter setter
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRespostaSim() {
        return this.respostaSim;
    }

    public void setRespostaSim(String respostaSim) {
        this.respostaSim = respostaSim;
    }

    public String getRespostaNao() {
        return this.respostaNao;
    }

    public void setRespostaNao(String respostaNao) {
        this.respostaNao = respostaNao;
    }

}
