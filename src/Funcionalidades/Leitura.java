/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author escobar
 */
public class Leitura {

    String nome_arquivo;
    int numero_de_sudokus;
    int tamanho_sudoku;
    int[][][] sudoku;

    public Leitura(String nome_arquivo) {
        this.nome_arquivo = nome_arquivo;
    }

    public void run() {

        BufferedReader br = null;
        String linha = "";
        String csvDivisor = " ";

        try {

            br = new BufferedReader(new FileReader(this.nome_arquivo));
            linha = br.readLine();

            if (!linha.equals("")) {
                String[] ler = linha.split(csvDivisor);
                this.numero_de_sudokus = Integer.parseInt(ler[0]);
                linha = br.readLine();
                ler = linha.split(csvDivisor);
                this.sudoku = new int[this.numero_de_sudokus][ler.length][ler.length];
                this.tamanho_sudoku = ler.length;
                for (int i = 0; i < this.numero_de_sudokus; i++) {
                    for (int j = 0; j < ler.length; j++) {
                        for (int k = 0; k < ler.length; k++) {
                            this.sudoku[i][j][k] = Integer.parseInt(ler[k]);
                        }
                        if ((linha = br.readLine()) != null) {
                            ler = linha.split(csvDivisor);

                        }

                    }
                    if ((linha = br.readLine()) != null) {
                        ler = linha.split(csvDivisor);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getNumero_de_sudokus() {
        return numero_de_sudokus;
    }

    public int[][][] getSudoku() {
        return sudoku;
    }

    public int getTamanho_sudoku() {
        return tamanho_sudoku;
    }
}
