package ProjetoP1;

/*
 * Classe MUNDO (tudo)
 * @author Michelle Pereira Brandão
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class Mundo {
/**
 * 
 * @param l numero de linhas da matriz principal
 * @param c numero de colunas da matriz principal
 */
    public Mundo(int l, int c) {
/**
 * criando a matriz
 */
        this.xMundo = c;
        this.yMundo = l;

        terra = new int[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                terra[i][j] = 0;

            }
        }
        /**
         * introduz as 6 fabricas (espaços amarelos)
         */
        fabricas(terra);
    }
    /**
     * 
     * @param terra passa a matriz principal 
     * 
     * Determina cada posicao das fabricas na matriz Terra
     */
    public void fabricas(int terra[][]) {

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
    /**
     * Coloca cada veiculo dentro da lista com posições em números randômicos
     * e adiciona seus tipos e especificações
     * @param vetor recebe uma lista com os veículos
     * @param num 
     */
    public void criaVeiculo(ArrayList<Veiculo> vetor, int num) {
        Random rand = new Random();
        String[] Tipos = {"nacked", "sport"};
        switch (num) {
            case 1:
                vetor.add(new Bicicleta(this, rand.nextInt(getxMundo()), rand.nextInt(getyMundo())));
                // cont.incrementaBicicleta(true);
                break;
            case 2:
                vetor.add(new Moto(this, rand.nextInt(getxMundo()), rand.nextInt(getyMundo()), Tipos[rand.nextInt(Tipos.length)]));

                break;
            case 3:
                vetor.add(new Carro(this, rand.nextInt(getxMundo()), rand.nextInt(getyMundo()), rand.nextInt(2) + 1));
                break;
            case 4:
                vetor.add(new Caminhao(this, rand.nextInt(getxMundo()), rand.nextInt(getyMundo()), rand.nextInt(1000)));

                break;
            default:
                break;
        }
    }
    /**
     * Imprime uma copia do mundo com todos os elementos juntos e criados
     * A nova matriz é de STRING, pois os espaços coloridos exigem que seja do tipo String.
     * O mundo tem cor branca e fábricas amarelas
     *
     * @param vetor 
     */
    public void imprimeMundo(ArrayList<Veiculo> vetor) {

        String[][] novaTerra = new String[yMundo][xMundo];
        for (int i = 0; i < yMundo; i++) {
            for (int j = 0; j < xMundo; j++) {
                if (terra[i][j] == 0) {
                    novaTerra[i][j] = "\u001B[46m"; //azul
                } else if (terra[i][j] == 2) {
                    novaTerra[i][j] = "\u001B[43m";//amarelo
                }
            }
        }
        /**
         * coloca os veículos no mundo
         */
        for (int k = 0; k < vetor.size(); k++) {
            int i = vetor.get(k).getY();
            int j = vetor.get(k).getX();
            novaTerra[i][j] = vetor.get(k).getCor();
        }
        /**
         * Mostra o mundo novo na tela
         */
        for (int i = 0; i < yMundo; i++) {
            for (int j = 0; j < xMundo; j++) {
                System.out.print(novaTerra[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println("\u001B[0m");
    }

    /**
     * Faz o veiculo andar na matriz 
     * @param vetor 
     */
    public void mover(ArrayList<Veiculo> vetor) {
        for (int i = 0; i < vetor.size(); i++) {
            vetor.get(i).moveVeiculo(this);

        }
        /**
         * Verifica se ele passou em uma fábrica
         */
        passaFabrica(vetor);

    }
    /**
     * Função que determina que: quando um veiculo passa por ela surge outro veiculo de mesmo
     * tipo, copiados através da forca do veiculo.
     * @param vetor vetor de veiculos 
     */
    public void passaFabrica(ArrayList<Veiculo> vetor) {
        for (int i = 0; i < vetor.size(); i++) {
            if (terra[vetor.get(i).getY()][vetor.get(i).getX()] == 2) {
                criaVeiculo(vetor, vetor.get(i).getForca());
            }
        }
    }
    /**
     * Função que determina quem prevalece diante de uma colisão
     * Veículos com mais forca prevalecem em relação aos menores (com menor forca)
     * As forcas variam de: <u> 1 a 4 </u>
     * 
     * @param vetor 
     */
    public void colide(ArrayList<Veiculo> vetor) {
        for (int i = 0; i < vetor.size(); i++) {
            ArrayList<Veiculo> temp = new ArrayList<>();
            temp.add(vetor.get(i));
            for (int j = i + 1; j < vetor.size(); j++) {
                if (vetor.get(i).getX() == vetor.get(j).getX() && vetor.get(i).getY() == vetor.get(j).getY()) {
                    temp.add(vetor.get(j));
                    if (temp.get(0).getForca() == temp.get(1).getForca()) {
                        vetor.remove(temp.get(0));
                        vetor.remove(temp.get(1));
                        i--;
                        break;
                    } else if (temp.get(0).getForca() < temp.get(1).getForca()) {
                        vetor.remove(temp.get(0));
                        i--;
                        break;
                    } else {
                        vetor.remove(temp.get(1));
                        j--;
                    }
                }
            }
        }
    }
    /**
     * Esta função tem como objetivo fazer a contagem de veiculos de cada tipo 
     * que estão no mundo em cada iteração através de um switch case
     * 
     * @param vetor 
     */
    public void contador(ArrayList<Veiculo> vetor) {
        int bicicleta = 0, carro = 0, moto = 0, caminhao = 0;

        for (int i = 0; i < vetor.size(); i++) {
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
/**
 * get y do mundo
 * @return 
 */
    public int getyMundo() {
        return yMundo;
    }
/**
 * get x do mundo
 * @return 
 */
    public int getxMundo() {
        return xMundo;
    }

    public int terra[][];
    private int xMundo, yMundo;

}
