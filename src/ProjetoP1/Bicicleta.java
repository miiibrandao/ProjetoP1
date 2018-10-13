
package ProjetoP1;

import java.util.Random;


/**
 *
 * @author Michelle
 */
public class Bicicleta extends Veiculo {

    public Bicicleta(Mundo m, int x, int y) {
        super(m, x, y, 1, 1, "\u001B[42m");//verde
        this.vaiAndar = false;
    }
    
    /**
     *
     * @param m
     */
    
    @Override
    public void moveVeiculo(Mundo m){
        if (!vaiAndar) {
             vaiAndar = true;
        }
        else {
            vaiAndar = false;
    
        Random rand = new Random();
        int posicao = rand.nextInt(4);
        switch (posicao) {
                case 0: //pra cima
                    setY(getY()-getVelocidade(), m.getyMundo());
                    break;
                case 1: //pra baixo
                    setY(getY()+getVelocidade(), m.getyMundo());
                    break;
                case 2: //esquerda
                    setX(getX()-getVelocidade(),m.getxMundo());
                    break;
                case 3: //direita
                    setX(getX()+getVelocidade(), m.getxMundo());
                    break;
                default:
                    break;
            }
    }
    }
   private boolean vaiAndar;

    
}
