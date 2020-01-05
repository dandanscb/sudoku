/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import Estrutura.*;

/**
 *
 * @author escobar
 */
public class CriaGrafo {

    GrafoAbstrato Grafo;
    int[][] posicao_grafo;

    public CriaGrafo(int tipo, Leitura ler) {
        if (tipo == 1) {
            this.Grafo = new Grafo_MA(ler.getTamanho_sudoku() * ler.getTamanho_sudoku());
        } else {

            this.Grafo = new Grafo_LA(ler.getTamanho_sudoku() * ler.getTamanho_sudoku());
        }

        this.posicao_grafo = new int[ler.getTamanho_sudoku()][ler.getTamanho_sudoku()];
        int contador = 0;
        for (int i = 0; i < ler.getTamanho_sudoku(); i++) {
            for (int j = 0; j < ler.getTamanho_sudoku(); j++) {
                this.posicao_grafo[i][j] = contador++;
            }
        }

        for (int i = 0; i < ler.getTamanho_sudoku(); i++) {
            for (int j = 0; j < ler.getTamanho_sudoku(); j++) {
                for (int k = 0; k < ler.getTamanho_sudoku(); k++) {
                    if (i != k) {
                        this.Grafo.addAresta(posicao_grafo[j][i], posicao_grafo[j][k], 1);
                        this.Grafo.addAresta(posicao_grafo[i][j], posicao_grafo[k][j], 1);
                    }
                }
            }
        }

        for (int i = 0; i < ler.getTamanho_sudoku(); i++) {
            for (int j = 0; j < ler.getTamanho_sudoku(); j++) {
                for (int k = 3 * (j / 3); k < 3 * ((j / 3) + 1); k++) {
                    for (int l = 3 * (i / 3); l < 3 * ((i / 3) + 1); l++) {
                        if (j != k || i != l) {
                            this.Grafo.addAresta(posicao_grafo[j][i], posicao_grafo[k][l], 1);
                        }
                    }
                }
            }
        }

    }

    public GrafoAbstrato getGrafo() {
        return Grafo;
    }
}
