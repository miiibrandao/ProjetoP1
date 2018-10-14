/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoP1;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * CLASSE PRINCIPAL
 * @author Michelle Pereira Brandão
 */
public class Main {
    /**
     * 
     * @param args
     * @throws InterruptedException 
     * 
     * Iniciando com 30 linha, 60 colunas e 10 veiculos de cada tipo 
     * 
     */
    public static void main(String[] args) throws InterruptedException {
       
        Mundo mundo = new Mundo(30, 60);

        ArrayList<Veiculo> vetor = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            for (int tipo = 1; tipo < 5; tipo++) {
                mundo.criaVeiculo(vetor, tipo);
            }

        }

        for (int i = 0; i < 1500; i++) {
            mundo.contador(vetor);
            mundo.imprimeMundo(vetor);
            mundo.mover(vetor);
            mundo.colide(vetor);
            Thread.sleep(500);

        }

    }
}
