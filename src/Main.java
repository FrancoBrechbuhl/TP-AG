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
        Los 20 individuos que se van a usar inicialmente son:
        [1;2]    [1;7]   [2;1]   [2;4]    [3;8]
        [3;10]   [4;3]   [4;6]   [5;5]    [5;7]
        [6;2]    [6;9]   [7;5]   [7;8]    [8;1]
        [8;10]   [9;4]   [9;7]   [10;3]   [10;3]

        se itera para conseguir las 50 generaciones, cuando termina se itera sobre los individuos que quedan en la
        población y el que tenga mejor fitness es la mejor solución (la mejor solución es [ 5 ; 6 ] con fitness de 1685.7171

         */

        //se inicializan los individuos
        Individuo[] individuos = new Individuo[20];

        individuos[0] = new Individuo(1,2);
        individuos[1] = new Individuo(1,7);
        individuos[2] = new Individuo(2,1);
        individuos[3] = new Individuo(2,4);
        individuos[4] = new Individuo(3,8);
        individuos[5] = new Individuo(3,10);
        individuos[6] = new Individuo(4,3);
        individuos[7] = new Individuo(4,6);
        individuos[8] = new Individuo(5,5);
        individuos[9] = new Individuo(5,7);
        individuos[10] = new Individuo(6,2);
        individuos[11] = new Individuo(6,9);
        individuos[12] = new Individuo(7,5);
        individuos[13] = new Individuo(7,8);
        individuos[14] = new Individuo(8,1);
        individuos[15] = new Individuo(8,10);
        individuos[16] = new Individuo(9,4);
        individuos[17] = new Individuo(9,7);
        individuos[18] = new Individuo(10,3);
        individuos[19] = new Individuo(10,6);

        double r = 0;
        double aptitudT = 0;
        double[] fitness = new double[20];
        double[] proporcionIndividuo = new double[20];
        double[] proporcionRelativa = new double[20];
        int[] reproductores = new int[20];

        for (int gen = 0; gen < 20; gen++){
            //SELECCIÓN

            System.out.print("\nGeneración "+gen+":\n\n");

            r = 0;
            aptitudT = 0;

            //cálculo del fitness para cada individuo

            for (int l = 0; l < 20; l++){
                fitness[l] = 0;
                fitness[l] = funcFitness(individuos[l].getPosX(), individuos[l].getPosY());
                System.out.print("Fitness de individuo [ "+individuos[l].getPosX()+" ; "+individuos[l].getPosY()+" ]: "+fitness[l]+"\n");
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

            //se genera un numero r aleatorio entre 0.0 y 1.0
            Random rand = new Random();

            for (int t = 0; t < 20; t++){
                r = rand.nextDouble();

                if (r <= proporcionRelativa[0]){
                    System.out.print("Seleccionado el individuo 0\n");
                    reproductores[t] = 0;
                }
                else if (r <= proporcionRelativa[1]){
                    System.out.print("Seleccionado el individuo 1\n");
                    reproductores[t] = 1;
                }
                else if (r <= proporcionRelativa[2]){
                    System.out.print("Seleccionado el individuo 2\n");
                    reproductores[t] = 2;
                }
                else if (r <= proporcionRelativa[3]){
                    System.out.print("Seleccionado el individuo 3\n");
                    reproductores[t] = 3;
                }
                else if (r <= proporcionRelativa[4]){
                    System.out.print("Seleccionado el individuo 4\n");
                    reproductores[t] = 4;
                }
                else if (r <= proporcionRelativa[5]){
                    System.out.print("Seleccionado el individuo 5\n");
                    reproductores[t] = 5;
                }
                else if (r <= proporcionRelativa[6]){
                    System.out.print("Seleccionado el individuo 6\n");
                    reproductores[t] = 6;
                }
                else if (r <= proporcionRelativa[7]){
                    System.out.print("Seleccionado el individuo 7\n");
                    reproductores[t] = 7;
                }
                else if (r <= proporcionRelativa[8]){
                    System.out.print("Seleccionado el individuo 8\n");
                    reproductores[t] = 8;
                }
                else if (r <= proporcionRelativa[9]){
                    System.out.print("Seleccionado el individuo 9\n");
                    reproductores[t] = 9;
                }
                else if (r <= proporcionRelativa[10]){
                    System.out.print("Seleccionado el individuo 10\n");
                    reproductores[t] = 10;
                }
                else if (r <= proporcionRelativa[11]){
                    System.out.print("Seleccionado el individuo 11\n");
                    reproductores[t] = 11;
                }
                else if (r <= proporcionRelativa[12]){
                    System.out.print("Seleccionado el individuo 12\n");
                    reproductores[t] = 12;
                }
                else if (r <= proporcionRelativa[13]){
                    System.out.print("Seleccionado el individuo 13\n");
                    reproductores[t] = 13;
                }
                else if (r <= proporcionRelativa[14]){
                    System.out.print("Seleccionado el individuo 14\n");
                    reproductores[t] = 14;
                }
                else if (r <= proporcionRelativa[15]){
                    System.out.print("Seleccionado el individuo 15\n");
                    reproductores[t] = 15;
                }
                else if (r <= proporcionRelativa[16]){
                    System.out.print("Seleccionado el individuo 16\n");
                    reproductores[t] = 16;
                }
                else if (r <= proporcionRelativa[17]){
                    System.out.print("Seleccionado el individuo 17\n");
                    reproductores[t] = 17;
                }
                else if (r <= proporcionRelativa[18]){
                    System.out.print("Seleccionado el individuo 18\n");
                    reproductores[t] = 18;
                }
                else if (r <= proporcionRelativa[19]){
                    System.out.print("Seleccionado el individuo 19\n");
                    reproductores[t] = 19;
                }
            }

            //CRUZA

            /*
            Se cruzan el individuo 1 con el 2, el 3 con el 4, 5 con el 6, etc, del vector reproductores[], según el
            orden que se realizó en el proceso de selección.
             */

            for (int repr = 0; repr < 20; repr = repr + 2) {
                //se inicializa los padres
                Individuo padre1 = new Individuo(individuos[reproductores[repr]].getPosX(), individuos[reproductores[repr]].getPosY());
                Individuo padre2 = new Individuo(individuos[reproductores[repr + 1]].getPosX(), individuos[reproductores[repr + 1]].getPosY());

                System.out.print("\nEl padre "+repr+" es el individuo "+reproductores[repr]+": [ "+padre1.getPosX()+" ; "+padre1.getPosY()+ " ]\n");
                System.out.print("El padre "+(repr+1)+" es el individuo "+reproductores[repr + 1]+": [ "+padre2.getPosX()+" ; "+padre2.getPosY()+ " ]\n");

                double probCruza = 0.9;

                // 0 <= r <= probCruza  ---> se cruza
                // probCruza < r <= 1   ---> no se cruza

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

                System.out.print("\nEl hijo "+repr+" es: [ "+hijo1.getPosX()+" ; "+hijo1.getPosY()+" ]\n");
                System.out.print("El hijo "+(repr+1)+" es: [ "+hijo2.getPosX()+" ; "+hijo2.getPosY()+" ]\n");

                //MUTACIÓN

                //en teoría Pm es 1 / nro de genes, en nuestro caso el cromosoma tiene dos genes y sería muy alta
                double probMutacion = 0.1;

                // 0 <= r <= probMutacion  ---> se muta
                // probMutacion < r <= 1   ---> no se muta

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

                System.out.print("\nEl hijo "+repr+" mutado es: [ "+hijo1.getPosX()+" ; "+hijo1.getPosY()+" ]\n");
                System.out.print("El hijo "+(repr+1)+" mutado es: [ "+hijo2.getPosX()+" ; "+hijo2.getPosY()+" ]\n\n");

                //REEMPLAZO

                /*
                Se usa el método de padres débiles, así que hay que calcular el fitness de los padres y de los hijos y quedarse
                con los dos mejores valores
                */

                Individuo[] padresHijos = {padre1, padre2, hijo1, hijo2};
                Individuo[] individuosOrdenados = ordenarIndividuosByFitness(padresHijos);

                //intercambiar los individuos candidatos con los fitness mas altos (por el cambio que se hizo en ruleta)
                individuos[repr] = individuosOrdenados[2];
                individuos[repr + 1] = individuosOrdenados[3];
            }
        }

        Individuo mejorSolucion = individuos[0];

        System.out.print("\nLos individuos finales son:\n");
        for (int g = 0; g < 10; g++){
            System.out.print("\nIndividuo [ "+individuos[g].getPosX()+" ; "+individuos[g].getPosY()+" ] con fitness de "+(5000 - funcFitness(individuos[g].getPosX(), individuos[g].getPosY())));
            if (funcFitness(individuos[g].getPosX(), individuos[g].getPosY()) > funcFitness(mejorSolucion.getPosX(), mejorSolucion.getPosY())){
                mejorSolucion = individuos[g];
            }
        }

        System.out.print("\n\nLa mejor ubicación para colocar la estación de bomberos es en la manzana [ "+mejorSolucion.getPosX()+" ; "+mejorSolucion.getPosY()+" ] con una distancia promedio de "+(5000 - funcFitness(mejorSolucion.getPosX(), mejorSolucion.getPosY())));
    }

    public static double funcFitness(int xfs, int yfs){
        double costo = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                costo = costo + cantIncendios[i - 1][j - 1] * Math.sqrt(Math.pow((i - xfs), 2) + Math.pow((j - yfs), 2));
            }
        }
        /*
        si se devuelve la funcion objetivo tal como está en la ruleta se favorece a los fitness más grandes,
        y son los que no queremos nosotros. Lo que se busca es el fitness más pequeño.
         */
        return 5000 - costo;
    }

    public static Individuo[] ordenarIndividuosByFitness(Individuo[] arrayIndiv){
        Individuo individuosOrd[] = new Individuo[4];
        double arrayFitness[] = new double[4];

        for (int fit = 0; fit < 4; fit++){
            arrayFitness[fit] = funcFitness(arrayIndiv[fit].getPosX(), arrayIndiv[fit].getPosY());
        }

        for (int n = 0; n < 4; n++){
            double min = arrayFitness[0];
            Individuo indMin = arrayIndiv[0];
            int posMin = 0;
            for (int m = 0; m < 4; m++){
                if (arrayFitness[m] < min){
                    min = arrayFitness[m];
                    posMin = m;
                    indMin = arrayIndiv[m];
                }
            }
            individuosOrd[n] = indMin;
            System.out.print("En la posición "+n+" está el individuo [ "+individuosOrd[n].getPosX()+" ; "+individuosOrd[n].getPosY()+" ] con un fitness de "+arrayFitness[posMin]+"\n");
            arrayFitness[posMin] = 5000;
        }
        return individuosOrd;
    }
}