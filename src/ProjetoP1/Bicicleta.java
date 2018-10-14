package ProjetoP1;

import java.util.Random;

/**
 * Classe Bicicleta 
 * @author Michelle Pereira Brandao
 */
public class Bicicleta extends Veiculo {

    /**
     * 
     * @param m matriz principal
     * @param x da a posicao na horizontal da bicicleta
     * @param y da a posicao na vertical da bicicleta
     */
    public Bicicleta(Mundo m, int x, int y) {
        super(m, x, y, 1, 1, "\u001B[42m");//verde
        this.vaiAndar = false;
    }

    /**
     *
     * @param m manda como parâmetro a matriz principal da classe Mundo
     * 
     * Os dois if's correspondem a velocidade da bicicleta pois, ela passa
     * uma iteração andando e outra não.
     * 
     * Para ser 0.5 espaco por iteração
     * 
     * Quando TRUE entra no switch case para determinar a posição randomica
     */
    
    
    
    @Override
    public void moveVeiculo(Mundo m) {
        if (!vaiAndar) {
            vaiAndar = true;
        } else {
            vaiAndar = false;

            Random rand = new Random();
            int posicao = rand.nextInt(4);
            switch (posicao) {
                case 0: //pra cima
                    setY(getY() - getVelocidade(), m.getyMundo());
                    break;
                case 1: //pra baixo
                    setY(getY() + getVelocidade(), m.getyMundo());
                    break;
                case 2: //esquerda
                    setX(getX() - getVelocidade(), m.getxMundo());
                    break;
                case 3: //direita
                    setX(getX() + getVelocidade(), m.getxMundo());
                    break;
                default:
                    break;
            }
        }
    }
    private boolean vaiAndar;

}
