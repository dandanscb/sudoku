/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executar;

import Estrutura.*;
import Funcionalidades.*;

/**
 *
 * @author escobar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Leitura ler = new Leitura("instances.sudoku");

        ler.run();

        int[][][] sudoku = ler.getSudoku();

        CriaGrafo grafo2 = new CriaGrafo(2, ler);
        long start1 = System.nanoTime();
        PSR psr = new PSR(grafo2.getGrafo(), ler.getSudoku(), ler.getTamanho_sudoku());
        for (int i = 0; i < 95; i++) {
            int[][] matriz = psr.recursivo(0, sudoku[i]);
            
            System.out.println("SUDOKU "+i);
            
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    System.out.print(matriz[j][k] + " ");
                }
                System.out.println("");
            }
            
            System.out.println("");
        }
        
        long lista_adjacente = System.nanoTime() - start1;
        System.out.println("Tempo execucao para Lista: " + lista_adjacente / 1000000 + "ms");
     
        
    }

}
