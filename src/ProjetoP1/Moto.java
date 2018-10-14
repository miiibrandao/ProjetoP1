/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoP1;

/**
 *
 * @author Michelle Pereira Brandão
 */
public class Moto extends Veiculo {

    private final String tipo;
 /**
  * 
  * @param m Mundo
  * @param x posição horizontal
  * @param y posição vertical
  * @param tipo determina o tipo da moto
  */
    public Moto(Mundo m, int x, int y, String tipo) {
        super(m, x, y, 3, 2, "\u001B[44m");
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
