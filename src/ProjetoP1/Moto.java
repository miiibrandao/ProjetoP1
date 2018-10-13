/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoP1;


/**
 *
 * @author Michelle
 */
public class Moto extends Veiculo{
    private final String tipo;
    public Moto(Mundo m, int x, int y, String tipo) {
        super(m, x, y, 3,2,"\u001B[44m"); 
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
}