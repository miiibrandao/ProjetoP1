
package ProjetoP1;

/*
 *
 * @author Michelle
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class Mundo {
    public Mundo(int l, int c) {
        
        this.xMundo = c;
        this.yMundo = l;
        
        terra = new int[l][c];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < c; j++) {
                terra[i][j] = 0;
               
            }
        }
        fabricas(terra);
       }

    public void fabricas(int terra[][]){
        
                terra[6][10] = 2;
                terra[6][11] = 2;
                terra[12][10] = 2;
                terra[12][11] = 2;
                terra[18][10] = 2;
                terra[18][11] = 2;
                terra[6][50] = 2;
                terra[6][51] = 2;
                terra[12][50] = 2;
                terra[12][51] = 2;
                terra[18][50] = 2;
                terra[18][51] = 2;
                
    }
        
   public void criaVeiculo(ArrayList<Veiculo> vetor, int num) {
        Random rand = new Random();
        String[] Tipos = {"nacked", "sport"};
        switch (num) {
            case 1:
               vetor.add(new Bicicleta(this, rand.nextInt(getxMundo()), rand.nextInt(getyMundo())) );
               // cont.incrementaBicicleta(true);
              break;
            case 2:
                vetor.add(new Moto(this,rand.nextInt(getxMundo()), rand.nextInt(getyMundo()), Tipos[rand.nextInt(Tipos.length)]) );
             
                break;
            case 3:
               vetor.add( new Carro(this, rand.nextInt(getxMundo()), rand.nextInt(getyMundo()), rand.nextInt(2)+1) );
               break;
            case 4:
                vetor.add( new Caminhao (this, rand.nextInt(getxMundo()), rand.nextInt(getyMundo()), rand.nextInt(1000)) );
                
               break;
            default:
                break;
        }        
    }

    public void imprimeMundo(ArrayList<Veiculo> vetor) {
        
        String[][] novaTerra = new String[yMundo][xMundo];
        for (int i = 0; i < yMundo; i++) {
            for (int j = 0; j < xMundo; j++) {
                if (terra[i][j] == 0) {
                    novaTerra[i][j] = "\u001B[46m"; //azul
                }
                else if (terra [i][j] == 2){
                    novaTerra[i][j] = "\u001B[43m";//amarelo
                }
            }
        }
        
        
        for (int k = 0; k < vetor.size(); k++) {
            int i = vetor.get(k).getY();
            int j = vetor.get(k).getX();
            novaTerra[i][j] = vetor.get(k).getCor();
        }
        
        
        for (int i = 0; i < yMundo; i++) {
            for (int j = 0; j < xMundo; j++) {
                System.out.print(novaTerra[i][j] + " ");
            }
            System.out.println();
            
        }
        System.out.println("\u001B[0m"); 
    }
    
    public void mover(ArrayList<Veiculo> vetor) {
        for (int i = 0; i < vetor.size(); i++) {
            vetor.get(i).moveVeiculo(this);
            
                
            }
        passaFabrica(vetor);
        
    }
    
   public void passaFabrica(ArrayList<Veiculo> vetor){
       for(int i=0;i<vetor.size();i++){
           if(terra[vetor.get(i).getY()][vetor.get(i).getX()] == 2){
               criaVeiculo(vetor,vetor.get(i).getForca());
           }
       }
   }
    
   
   public void colide(ArrayList<Veiculo> vetor){
       for (int i = 0; i < vetor.size(); i++) {
           ArrayList<Veiculo> temp = new ArrayList<>();
           temp.add(vetor.get(i));
        for (int j = i+1; j < vetor.size(); j++) {
                if (vetor.get(i).getX() == vetor.get(j).getX() && vetor.get(i).getY() == vetor.get(j).getY()) {
                   
                }
            }
   }
   }
   
   public void contador(ArrayList<Veiculo> vetor){
       int bicicleta = 0,carro = 0,moto = 0,caminhao = 0;
       
       for(int i = 0; i< vetor.size(); i++){
           switch (vetor.get(i).getForca()) {
                case 1: 
                    bicicleta = bicicleta + 1;
                    break;
                case 2: 
                    moto = moto + 1;
                    break;
                case 3: 
                    carro = carro + 1;
                    break;
                case 4:
                   caminhao = caminhao + 1;
                    break;
                default:
                    break;
            }
           

       }
           System.out.print("#Bike: " + bicicleta + " ");
           System.out.print("#Moto:  " + moto + " ");
           System.out.print("#Carro:  " + carro + " ");
           System.out.println("#Caminhao:  " + caminhao + " ");
   }
    public int getyMundo(){
        return yMundo;
    }
    public int getxMundo(){
        return xMundo;
    }

    

public int terra[][];
private int xMundo,yMundo;

    
}
