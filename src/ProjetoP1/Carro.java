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
public class Carro extends Veiculo{

    public Carro(Mundo m, int x, int y,int passageiros) {
        super(m, x, y, 2,3, "\u001B[41m");//vermelho
        this.passageiros = passageiros;
        
    }

   

    
    public int getPassageiros(){
        return passageiros;
    }
    private final int passageiros;
}
