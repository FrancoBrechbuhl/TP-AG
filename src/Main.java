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
        /*
        Los 20 mejores individuos que se van a usar son:
        [3;5]   [3;6]   [4;4]   [4;5]   [4;6]
        [4;7]   [5;4]   [5;5]   [5;6]   [5;7]
        [5;8]   [6;4]   [6;5]   [6;6]   [6;7]
        [6;8]   [7;4]   [7;5]   [7;6]   [7;7]

        se itera para conseguir las 50 generaciones, cuando termina se considera que el primer individuo del array es
        la mejor solución

         */

        //se inicializan los individuos

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

        double r = 0;
        double aptitudT = 0;
        double[] fitness = new double[20];
        double[] proporcionIndividuo = new double[20];
        double[] proporcionRelativa = new double[20];
        int[] poblacion = new int[20];

        for (int gen = 0; gen < 50; gen++){
            //SELECCIÓN

            r = 0;
            aptitudT = 0;

            //cálculo del fitness para cada individuo

            for (int l = 0; l < 20; l++){
                fitness[l] = 0;
                fitness[l] = funcFitness(individuos[l].getPosX(), individuos[l].getPosY());
            }

            //cálculo de aptitud total
            for (int c = 0; c < 20; c++){
                aptitudT = aptitudT + fitness[c];
            }

            //cálculo de la proporción que ocupa cada individuo en la ruleta
            for (int d = 0; d < 20; d++){
                proporcionIndividuo[d] = 0;
                proporcionIndividuo[d] = fitness[d] / aptitudT;
            }

            //cálculo de la proporción acumulada
            for (int e = 0; e < 20; e++){
                double total = 0;
                for (int f = 0; f <= e; f++){
                    total = total + proporcionIndividuo[f];
                }
                proporcionRelativa[e] = 0;
                proporcionRelativa[e] = total;
            }

            System.out.print("\n\nAptitudT: "+aptitudT+"\n\n");

            /*
            for (int v = 0; v < 20; v++){
                System.out.print("proporcionIndividuo["+v+"]: "+proporcionIndividuo[v]+"\n");
            }
            System.out.print("\n");
            for (int w = 0; w < 20; w++){
                System.out.print("proporcionRelativa["+w+"]: "+proporcionRelativa[w]+"\n");
            }

             */
            System.out.print("\n");

            //se genera un numero r aleatorio entre 0.0 y 1.0
            Random rand = new Random();

            for (int t = 0; t < 20; t++){
                r = rand.nextDouble();
                //System.out.print("Random: "+r+"\n");

                if (r <= proporcionRelativa[0]){
                    System.out.print("Seleccionado el individuo 1\n");
                    poblacion[t] = 1;
                }
                else if (r <= proporcionRelativa[1]){
                    System.out.print("Seleccionado el individuo 2\n");
                    poblacion[t] = 2;
                }
                else if (r <= proporcionRelativa[2]){
                    System.out.print("Seleccionado el individuo 3\n");
                    poblacion[t] = 3;
                }
                else if (r <= proporcionRelativa[3]){
                    System.out.print("Seleccionado el individuo 4\n");
                    poblacion[t] = 4;
                }
                else if (r <= proporcionRelativa[4]){
                    System.out.print("Seleccionado el individuo 5\n");
                    poblacion[t] = 5;
                }
                else if (r <= proporcionRelativa[5]){
                    System.out.print("Seleccionado el individuo 6\n");
                    poblacion[t] = 6;
                }
                else if (r <= proporcionRelativa[6]){
                    System.out.print("Seleccionado el individuo 7\n");
                    poblacion[t] = 7;
                }
                else if (r <= proporcionRelativa[7]){
                    System.out.print("Seleccionado el individuo 8\n");
                    poblacion[t] = 8;
                }
                else if (r <= proporcionRelativa[8]){
                    System.out.print("Seleccionado el individuo 9\n");
                    poblacion[t] = 9;
                }
                else if (r <= proporcionRelativa[9]){
                    System.out.print("Seleccionado el individuo 10\n");
                    poblacion[t] = 10;
                }
                else if (r <= proporcionRelativa[10]){
                    System.out.print("Seleccionado el individuo 11\n");
                    poblacion[t] = 11;
                }
                else if (r <= proporcionRelativa[11]){
                    System.out.print("Seleccionado el individuo 12\n");
                    poblacion[t] = 12;
                }
                else if (r <= proporcionRelativa[12]){
                    System.out.print("Seleccionado el individuo 13\n");
                    poblacion[t] = 13;
                }
                else if (r <= proporcionRelativa[13]){
                    System.out.print("Seleccionado el individuo 14\n");
                    poblacion[t] = 14;
                }
                else if (r <= proporcionRelativa[14]){
                    System.out.print("Seleccionado el individuo 15\n");
                    poblacion[t] = 15;
                }
                else if (r <= proporcionRelativa[15]){
                    System.out.print("Seleccionado el individuo 16\n");
                    poblacion[t] = 16;
                }
                else if (r <= proporcionRelativa[16]){
                    System.out.print("Seleccionado el individuo 17\n");
                    poblacion[t] = 17;
                }
                else if (r <= proporcionRelativa[17]){
                    System.out.print("Seleccionado el individuo 18\n");
                    poblacion[t] = 18;
                }
                else if (r <= proporcionRelativa[18]){
                    System.out.print("Seleccionado el individuo 19\n");
                    poblacion[t] = 19;
                }
                else if (r <= proporcionRelativa[19]){
                    System.out.print("Seleccionado el individuo 20\n");
                    poblacion[t] = 20;
                }
            }

            //CRUZA

            /*
            Se cruzan el individuo 1 con el 2 del vector seleccionados[], según el orden que se realizó en el proceso de
            selección. Hay que controlar porque como es ruleta, 1 y 2 podrían ser el mismo individuo, si son se debe cruzar
            1 y 3, o 1 y 4, etc.
             */

            //se chequea que los padres no sean iguales y se los inicializa
            Individuo padre1 = new Individuo(individuos[poblacion[0]].getPosX(), individuos[poblacion[0]].getPosY());
            Individuo padre2 = new Individuo(individuos[poblacion[1]].getPosX(), individuos[poblacion[1]].getPosY());

            int posicionPadre2 = 2;
            while (padre1.getPosX() == padre2.getPosX() && padre1.getPosY() == padre2.getPosY()) {
                padre2 = new Individuo(individuos[poblacion[posicionPadre2]].getPosX(), individuos[poblacion[posicionPadre2]].getPosY());
                posicionPadre2++;
            }
            posicionPadre2--;

            System.out.print("\nEl padre 1 es: [ "+padre1.getPosX()+" ; "+padre1.getPosY()+ " ]\n");
            System.out.print("El padre 2 es: [ "+padre2.getPosX()+" ; "+padre2.getPosY()+ " ]\n");

            double probCruza = 0.9;

            // 0 <= r <= 0.9  ---> se cruza
            // 0.9 < r <= 1   ---> no se cruza

            Individuo hijo1 = new Individuo();
            Individuo hijo2 = new Individuo();

            rand = new Random();
            r = rand.nextDouble();
            if (r <= probCruza) {
                //se cruzan los padres 1 y 2
                hijo1.setPosX(padre1.getPosX());
                hijo1.setPosY(padre2.getPosY());
                hijo2.setPosX(padre2.getPosX());
                hijo2.setPosY(padre1.getPosY());
            }
            else {
                //los hijos son iguales a los padres
                hijo1.setPosX(padre1.getPosX());
                hijo1.setPosY(padre1.getPosY());
                hijo2.setPosX(padre2.getPosX());
                hijo2.setPosY(padre2.getPosY());
            }

            System.out.print("\nEl hijo 1 es: [ "+hijo1.getPosX()+" ; "+hijo1.getPosY()+" ]\n");
            System.out.print("El hijo 2 es: [ "+hijo2.getPosX()+" ; "+hijo2.getPosY()+" ]\n");

            //MUTACIÓN

            //en teoría Pm es 1 / nro de genes, en nuestro caso el cromosoma tiene dos genes y sería muy alta
            double probMutacion = 0.1;

            // 0 <= r <= 0.01  ---> se muta
            // 0.01 < r <= 1   ---> no se muta

            //mutación hijo1
            rand = new Random();
            r = rand.nextDouble();
            if (r <= probMutacion){
                int xhij1 = hijo1.getPosX();
                int yhij1 = hijo1.getPosY();

                hijo1.setPosX(yhij1);
                hijo1.setPosY(xhij1);
            }

            //mutación hijo2
            rand = new Random();
            r = rand.nextDouble();
            if (r <= probMutacion){
                int xhij2 = hijo2.getPosX();
                int yhij2 = hijo2.getPosY();

                hijo2.setPosX(yhij2);
                hijo2.setPosY(xhij2);
            }

            System.out.print("\nEl hijo 1 mutado es: [ "+hijo1.getPosX()+" ; "+hijo1.getPosY()+" ]\n");
            System.out.print("El hijo 2 mutado es: [ "+hijo2.getPosX()+" ; "+hijo2.getPosY()+" ]\n");

            //REEMPLAZO

            /*
            Se usa el método de padres débiles, así que hay que calcular el fitness de los padres y de los hijos y quedarse
            con los dos mejores valores
             */

            double fitPadre1 = funcFitness(padre1.getPosX(), padre1.getPosY());
            double fitPadre2 = funcFitness(padre2.getPosX(), padre2.getPosY());
            double fitHijo1 = funcFitness(hijo1.getPosX(), hijo1.getPosY());
            double fitHijo2 = funcFitness(hijo2.getPosX(), hijo2.getPosY());

            double[] fitPadresHijos = {fitPadre1, fitPadre2, fitHijo1, fitHijo2};
            int[] individuosOrdenados = ordenarIndByFitness(fitPadresHijos);

            //intercambiar los individuos candidatos

            poblacion[0] = individuosOrdenados[0];
            poblacion[posicionPadre2] = individuosOrdenados[1];
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

    public static int[] ordenarIndByFitness(double[] arrayFitness){
        int indOrd[] = new int[4];

        for (int n = 0; n < 4; n++){
            double min = arrayFitness[0];
            int posMin = 0;
            for (int m = 0; m < 4; m++){
                if (arrayFitness[m] < min){
                    min = arrayFitness[m];
                    posMin = m;
                }
            }
            indOrd[n] = posMin;
            System.out.print("\nEn la posición "+n+" está el individuo "+indOrd[n]+" con un fitness de "+arrayFitness[posMin]);
            arrayFitness[posMin] = 3000;
        }
        return indOrd;
    }
}