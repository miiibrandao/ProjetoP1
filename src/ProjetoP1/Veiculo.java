/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoP1;

import java.util.Random;
/**
 *
 * @author Michelle
 */
public abstract class Veiculo {
     public Veiculo(Mundo m, int x,int y, int velocidade, int forca,String cor){
         setX(x,m.getxMundo());
         setY(y, m.getyMundo());
         this.velocidade = velocidade;
         setCor(cor);
         this.forca = forca;
     }
    public void moveVeiculo(Mundo m){
        
        Random rand = new Random();
        int posicao = rand.nextInt(4);
        switch (posicao) {
                case 0: //pra cima
                    setY(y-velocidade, m.getyMundo());
                    break;
                case 1: //pra baixo
                    setY(y+velocidade, m.getyMundo());
                    break;
                case 2: //esquerda
                    setX(x-velocidade,m.getxMundo());
                    break;
                case 3: //direita
                    setX(x+velocidade, m.getxMundo());
                    break;
                default:
                    break;
            }
    }
    
     
    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public int getVelocidade(){
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        if (velocidade < 0) velocidade = 0;
        this.velocidade = velocidade;
    }
    
    public int getX(){
        return x;
    }
    
    public void setX(int x, int limite) {
        while (x < 0) {
            x += limite;
        }
        this.x = (int) (x % limite);
    }
  
    public int getY(){
        return y;
    }
    public void setY(int y,int limite){
        while(y < 0){
            y += limite;
        }
        this.y = (int) (y % limite);
    }
    
    public int getForca(){
        return forca;
    }
    private int x,y;
    private int velocidade;
    private String cor;
    private int forca;

    
    
}