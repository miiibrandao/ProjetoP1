/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoP1;

import java.util.Random;

/**
 *
 * @author Michelle Pereira Brandão
 */
public abstract class Veiculo {
    /**
     * 
     * @param m
     * @param x
     * @param y
     * 
     * @param velocidade determina a velocidade de cada veículo, pois a 
     * classe Veiculo é abstrata.
     * 
     * @param forca a forca mostra a prioridade na hora de colisão entre dois veículos
     * os que forem mais fortes prevalecem.
     * 
     * @param cor determina a cor do veiculo para diferenciar dos demais
     */
    public Veiculo(Mundo m, int x, int y, int velocidade, int forca, String cor) {
        setX(x, m.getxMundo());
        setY(y, m.getyMundo());
        this.velocidade = velocidade;
        setCor(cor);
        this.forca = forca;
    }
    /**
     * 
     * @param m 
     * 
     * Esta função tem por objetivo determinar posições aleatórias para os veículos 
     * a cada iteração
     */
    public void moveVeiculo(Mundo m) {

        Random rand = new Random();
        int posicao = rand.nextInt(4);
        switch (posicao) {
            case 0: //pra cima
                setY(y - velocidade, m.getyMundo());
                break;
            case 1: //pra baixo
                setY(y + velocidade, m.getyMundo());
                break;
            case 2: //esquerda
                setX(x - velocidade, m.getxMundo());
                break;
            case 3: //direita
                setX(x + velocidade, m.getxMundo());
                break;
            default:
                break;
        }
    }
    /**
     * GET correspondente a <b>cor</b> do veículo
     * @return 
     */
    public String getCor() {
        return cor;
    }
    /**
     * SET correspondente a <b>cor</b> do veículo
     * @param cor 
     */
    public void setCor(String cor) {
        this.cor = cor;
    }
    /**
     * <b>GET</b> GET da velocidade do veículo
     * @return 
     */
    public int getVelocidade() {
        return velocidade;
    }
    /**
     * <b>SET</b> da velocidade.
     * @param velocidade 
     */
    public void setVelocidade(int velocidade) {
        
        this.velocidade = velocidade;
    }
    /** 
     * GET da posicao <u>X</u>
     * @return 
     */
    public int getX() {
        return x;
    }
    /**
     * SET que torna o mundo ciclico (x)
     * @param x
     * @param limite 
     */
    public void setX(int x, int limite) {
        while (x < 0) {
            x += limite;
        }
        this.x = (int) (x % limite);
    }
    /**
     * GET da posicao <u>Y</u>
     * @return 
     */
    public int getY() {
        return y;
    }
    /**
     * SET que torna o mundo ciclico (y)
     * @param y
     * @param limite 
     */
    public void setY(int y, int limite) {
        while (y < 0) {
            y += limite;
        }
        this.y = (int) (y % limite);
    }
    /**
     * GET da forca do veiculo
     * @return 
     */
    public int getForca() {
        return forca;
    }
    private int x, y;
    private int velocidade;
    private String cor;
    private int forca;

}
