/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import Estrutura.*;
import java.util.LinkedList;

/**
 *
 * @author escobar
 */
public class PSR {

    GrafoAbstrato Grafo;
    int[][][] sudoku;
    int[][] erro;
    int[][] teste;
    int tamanho;

    public PSR(GrafoAbstrato Grafo, int[][][] sudoku, int tamanho) {
        this.Grafo = Grafo;
        this.sudoku = sudoku;
        this.tamanho = tamanho;

        teste = new int[9][9];

        erro = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                erro[i][j] = 0;
            }
        }
    }

    public LinkedList<Integer> Dominios(int vertice, int[][] matriz) {
        LinkedList<Integer> Dominios = new LinkedList<Integer>();

        for (int i = 1; i < 10; i++) {
            Dominios.add(i);
        }

        for (Integer i : this.Grafo.getAdjacentes(vertice)) {
            if(Dominios.contains((Object) matriz[i / 9][i % 9])){
                Dominios.remove((Object) (matriz[i / 9][i % 9]));
            }      
        }

        return Dominios;
    }

    public int[][] recursivo(int vertice, int[][] matriz) {

        if (vertice == this.tamanho*this.tamanho) {
            return matriz;
        }

        if (matriz[vertice / tamanho][vertice % tamanho] != 0) {
            teste = recursivo((vertice + 1), matriz);
            if (teste == this.erro) {
                return this.erro;
            } else {
                return teste;
            }
        }

        LinkedList<Integer> dominio = Dominios(vertice, matriz);

        for (Integer i : dominio) {
            matriz[vertice / tamanho][vertice % tamanho] = i;
            teste = recursivo((vertice + 1), matriz);
            if (teste != this.erro) {
                return teste;
            }else{
                matriz[vertice / tamanho][vertice % tamanho] = 0;
            }
        }

        return this.erro;

    }

}
