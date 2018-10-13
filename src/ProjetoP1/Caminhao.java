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
public class Caminhao extends Veiculo {

    public Caminhao(Mundo m, int x, int y, int carga) {
        super(m, x, y, 1, 4,"\u001B[45m"); //rosa
        this.carga = carga;
        
    }
    
    public int getCarga(){
        return carga;
    }
    
    private final int carga;
}