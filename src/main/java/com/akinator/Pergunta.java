package com.akinator;

import java.util.Scanner;

public class Pergunta {
    public int id;
    public String texto;
    public String respostaSim;
    public String respostaNao;

    public Pergunta(){
        this.id = 0;
        this.texto = null;
        this.respostaSim = null;
        this.respostaNao = null;
    }

    public Pergunta(int id, String texto) {
        this.id = id;
        this.texto = texto;
        this.respostaSim = null;
        this.respostaNao = null;
    }

    public Pergunta(int id, String texto, String respostaSim, String respostaNao) {
        this.id = id;
        this.texto = texto;
        this.respostaSim = respostaSim;
        this.respostaNao = respostaNao;
    }

    public String primeiraPergunta(Scanner scanner){
        char resposta = '\0';
        while(resposta!='A' && resposta!='B' && resposta!='C' && resposta!='D'){
            System.out.println("A qual estado seu time pertence?");
            System.out.println(" (a) - São Paulo\n (b) - Minas Gerais\n (c) - Rio de Janeiro\n (d) - Rio Grande do Sul");
            resposta = scanner.next().charAt(0);
            resposta = Character.toUpperCase(resposta);
        }
        switch(resposta){
            case 'A': return "SP";
            case 'B': return "MG";
            case 'C': return "RJ";
            case 'D': return "RS";
        }
        return null;
    }

    private boolean perguntar(Node node, Scanner scanner){
        char resposta = 69;
        System.out.println(node.pergunta.getPergunta());
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
        curNode = arvore.raiz;
        Boolean resposta = false;
        while(true){
            resposta = perguntar(curNode, scanner);
            if(curNode.pergunta.getResposta(resposta).equals("null")){
                if(resposta == true) curNode = curNode.perguntaDir;
                else curNode = curNode.perguntaEsq;
            }
            else return curNode.pergunta.getResposta(resposta);
        }
    }

    public String getPergunta(){
        return texto;
    }

    public String getResposta(Boolean resposta){
        if(resposta == true) return respostaSim;
        else return respostaNao;
    }

}
