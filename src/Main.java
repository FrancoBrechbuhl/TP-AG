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
        int[] seleccionados = new int[20];
        Individuo[] individuos = new Individuo[20];

        individuos[0] = new Individuo(3,5);
        individuos[1] = new Individuo(3,6);
        individuos[2] = new Individuo(4,4);
        individuos[3] = new Individuo(4,5);
        individuos[4] = new Individuo(4,6);
        individuos[5] = new Individuo(4,7);
        individuos[6] = new Individuo(5,4);
        individuos[7] = new Individuo(5,5);
        individuos[8] = new Individuo(5,6);
        individuos[9] = new Individuo(5,7);
        individuos[10] = new Individuo(5,8);
        individuos[11] = new Individuo(6,4);
        individuos[12] = new Individuo(6,5);
        individuos[13] = new Individuo(6,6);
        individuos[14] = new Individuo(6,7);
        individuos[15] = new Individuo(6,8);
        individuos[16] = new Individuo(7,4);
        individuos[17] = new Individuo(7,5);
        individuos[18] = new Individuo(7,6);
        individuos[19] = new Individuo(7,7);

        //cálculo del fitness para cada individuo

        for (int l = 0; l < 20; l++){
            fitness[l] = funcFitness(individuos[l].getPosX(), individuos[l].getPosY());
        }

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

            if (r <= proporcionRelativa[0]){
                System.out.print("Seleccionado el individuo 1\n");
                seleccionados[t] = 1;
            }
            else if (r <= proporcionRelativa[1]){
                System.out.print("Seleccionado el individuo 2\n");
                seleccionados[t] = 2;
            }
            else if (r <= proporcionRelativa[2]){
                System.out.print("Seleccionado el individuo 3\n");
                seleccionados[t] = 3;
            }
            else if (r <= proporcionRelativa[3]){
                System.out.print("Seleccionado el individuo 4\n");
                seleccionados[t] = 4;
            }
            else if (r <= proporcionRelativa[4]){
                System.out.print("Seleccionado el individuo 5\n");
                seleccionados[t] = 5;
            }
            else if (r <= proporcionRelativa[5]){
                System.out.print("Seleccionado el individuo 6\n");
                seleccionados[t] = 6;
            }
            else if (r <= proporcionRelativa[6]){
                System.out.print("Seleccionado el individuo 7\n");
                seleccionados[t] = 7;
            }
            else if (r <= proporcionRelativa[7]){
                System.out.print("Seleccionado el individuo 8\n");
                seleccionados[t] = 8;
            }
            else if (r <= proporcionRelativa[8]){
                System.out.print("Seleccionado el individuo 9\n");
                seleccionados[t] = 9;
            }
            else if (r <= proporcionRelativa[9]){
                System.out.print("Seleccionado el individuo 10\n");
                seleccionados[t] = 10;
            }
            else if (r <= proporcionRelativa[10]){
                System.out.print("Seleccionado el individuo 11\n");
                seleccionados[t] = 11;
            }
            else if (r <= proporcionRelativa[11]){
                System.out.print("Seleccionado el individuo 12\n");
                seleccionados[t] = 12;
            }
            else if (r <= proporcionRelativa[12]){
                System.out.print("Seleccionado el individuo 13\n");
                seleccionados[t] = 13;
            }
            else if (r <= proporcionRelativa[13]){
                System.out.print("Seleccionado el individuo 14\n");
                seleccionados[t] = 14;
            }
            else if (r <= proporcionRelativa[14]){
                System.out.print("Seleccionado el individuo 15\n");
                seleccionados[t] = 15;
            }
            else if (r <= proporcionRelativa[15]){
                System.out.print("Seleccionado el individuo 16\n");
                seleccionados[t] = 16;
            }
            else if (r <= proporcionRelativa[16]){
                System.out.print("Seleccionado el individuo 17\n");
                seleccionados[t] = 17;
            }
            else if (r <= proporcionRelativa[17]){
                System.out.print("Seleccionado el individuo 18\n");
                seleccionados[t] = 18;
            }
            else if (r <= proporcionRelativa[18]){
                System.out.print("Seleccionado el individuo 19\n");
                seleccionados[t] = 19;
            }
            else if (r <= proporcionRelativa[19]){
                System.out.print("Seleccionado el individuo 20\n");
                seleccionados[t] = 20;
            }
        }

        //CRUZA

        /*
        Se cruzan el individuo 1 con el 2 del vector seleccionados[], según el orden que se realizó en el proceso de
        selección. Hay que controlar porque como es ruleta, 1 y 2 podrían ser el mismo individuo, si son se debe cruzar
        1 y 3, o 1 y 4, etc.
         */

        //se chequea que los padres no sean iguales y se los inicializa
        Individuo padre1 = new Individuo(individuos[0].getPosX(), individuos[0].getPosY());
        Individuo padre2 = new Individuo(individuos[1].getPosX(), individuos[0].getPosY());

        int p = 2;
        while (padre1.getPosX() == padre2.getPosX() && padre1.getPosY() == padre2.getPosY()) {
            padre2 = new Individuo(individuos[p].getPosX(), individuos[p].getPosY());
            p++;
        }

        //se cruzan los padres 1 y 2
        Individuo hijo1 = new Individuo(padre1.getPosX(), padre2.getPosY());
        Individuo hijo2 = new Individuo(padre2.getPosX(), padre1.getPosY());

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