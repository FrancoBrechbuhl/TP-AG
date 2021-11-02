import java.util.Random;

public class Main {
    public static int[][] cantIncendios =
            {{5, 2, 4, 8, 9, 0, 3, 3, 8, 7},
            {5, 5, 3, 4, 4, 6, 4, 1, 9, 1},
            {4, 1, 2, 1, 3, 8, 7, 8, 9, 1},
            {1, 7, 1, 6, 9, 3, 1, 9, 6, 9},
            {4, 7, 4, 9, 9, 8, 6, 5, 4, 2},
            {7, 5, 8, 2, 5, 2, 3, 9, 8, 2},
            {1, 4, 0, 6, 8, 4, 0, 1, 2, 1},
            {1, 5, 2, 1, 2, 8, 3, 3, 6, 2},
            {4, 5, 9, 6, 3, 9, 7, 6, 5, 10},
            {0, 6, 2, 8, 7, 1, 2, 1, 5, 3}};

    public static void main(String[] args) {
        int rangos[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        //[1601;1800], [1801;2100], [2001;2200], [2201;2400], [2401;2600], [2601;2800], [2801;3000], [3001;3200], [3201;3400]
        for(int xfs = 1; xfs <= 10; xfs++) {
            for(int yfs = 1; yfs <= 10; yfs++) {
                double costo = 0;

                costo = funcFitness(xfs, yfs);

                /*
                Esto es para ver cuales son los 20 mejores individuos para hacer ruleta, de forma que no haya
                mucha diferencia entre los pesos

                */
                if (costo <= 1800){
                    rangos[0]++;
                    System.out.print("La posición: [ "+xfs+" ; "+yfs+" ] es candidata y tiene un costo de "+costo+"\n");
                }
                else if (costo <= 2000){
                    rangos[1]++;
                    System.out.print("La posición: [ "+xfs+" ; "+yfs+" ] tiene un costo de "+costo+"\n");
                }
                //comentado porque ya no se necesita
                /*
                else if (costo <= 2200){
                    rangos[2]++;
                }
                else if (costo <= 2400){
                    rangos[3]++;
                }
                else if (costo <= 2600){
                    rangos[4]++;
                }
                else if (costo <= 2800){
                    rangos[5]++;
                }
                else if (costo <= 3000){
                    rangos[6]++;
                }
                else if (costo <= 3200){
                    rangos[7]++;
                }
                else if (costo <= 3400){
                    rangos[8]++;
                }
                System.out.print("El costo de la posición "+xfs+", "+yfs+" es: "+ costo+"\n");
                 */
            }
        }
        /*
        System.out.print("En el rango [1601;1800] hay "+rangos[0]+" valores\n");
        System.out.print("En el rango [1801;2000] hay "+rangos[1]+" valores\n");
        System.out.print("En el rango [2001;2200] hay "+rangos[2]+" valores\n");
        System.out.print("En el rango [2201;2400] hay "+rangos[3]+" valores\n");
        System.out.print("En el rango [2401;2600] hay "+rangos[4]+" valores\n");
        System.out.print("En el rango [2601;2800] hay "+rangos[5]+" valores\n");
        System.out.print("En el rango [2801;3000] hay "+rangos[6]+" valores\n");
        System.out.print("En el rango [3001;3200] hay "+rangos[7]+" valores\n");
        System.out.print("En el rango [3201;3400] hay "+rangos[8]+" valores\n");
         */

        /*
        Los 20 individuos que se van a usar son:
        [3;5]   [3;6]   [4;4]   [4;5]   [4;6]
        [4;7]   [5;4]   [5;5]   [5;6]   [5;7]
        [5;8]   [6;4]   [6;5]   [6;6]   [6;7]
        [6;8]   [7;4]   [7;5]   [7;6]   [7;7]

         */

        //SELECCIÓN

        double r = 0;
        double aptitudT = 0;
        double[] fitness = new double[20];
        double[] proporcionIndividuo = new double[20];
        double[] proporcionRelativa = new double[20];

        //cálculo del fitness para cada individuo
        fitness[0] = funcFitness(3,5);
        fitness[1] = funcFitness(3,6);
        fitness[2] = funcFitness(4,4);
        fitness[3] = funcFitness(4,5);
        fitness[4] = funcFitness(4,6);
        fitness[5] = funcFitness(4,7);
        fitness[6] = funcFitness(5,4);
        fitness[7] = funcFitness(5,5);
        fitness[8] = funcFitness(5,6);
        fitness[9] = funcFitness(5,7);
        fitness[10] = funcFitness(5,8);
        fitness[11] = funcFitness(6,4);
        fitness[12] = funcFitness(6,5);
        fitness[13] = funcFitness(6,6);
        fitness[14] = funcFitness(6,7);
        fitness[15] = funcFitness(6,8);
        fitness[16] = funcFitness(7,4);
        fitness[17] = funcFitness(7,5);
        fitness[18] = funcFitness(7,6);
        fitness[19] = funcFitness(7,7);

        //cálculo de aptitud total
        for (int c = 0; c < 20; c++){
            aptitudT = aptitudT + fitness[c];
        }

        //cálculo de la proporción que ocupa cada individuo en la ruleta
        for (int d = 0; d < 20; d++){
            proporcionIndividuo[d] = fitness[d] / aptitudT;
        }

        //cálculo de la proporción acumulada
        for (int e = 0; e < 20; e++){
            double total = 0;
            for (int f = 0; f <= e; f++){
                total = total + proporcionIndividuo[f];
            }
            proporcionRelativa[e] = total;
        }

        System.out.print("AptitudT: "+aptitudT+"\n");

        for (int v = 0; v < 20; v++){
            System.out.print("proporcionIndividuo["+v+"]: "+proporcionIndividuo[v]+"\n");
        }
        for (int w = 0; w < 20; w++){
            System.out.print("proporcionRelativa["+w+"]: "+proporcionRelativa[w]+"\n");
        }

        //se genera un numero r aleatorio entre 0.0 y 1.0
        for (int t = 0; t < 20; t++){
            Random rand = new Random();
            r = rand.nextDouble();
            System.out.print("Random: "+r+"\n");
        }

    }

    public static double funcFitness(int xfs, int yfs){
        double costo = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                costo = costo + cantIncendios[i - 1][j - 1] * Math.sqrt(Math.pow((i - xfs), 2) + Math.pow((j - yfs), 2));
            }
        }
        return costo;
    }
}