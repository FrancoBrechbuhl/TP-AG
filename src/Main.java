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
                for (int i = 1; i <= 10; i++) {
                    for (int j = 1; j <= 10; j++) {
                        costo = costo + cantIncendios[i - 1][j - 1] * Math.sqrt(Math.pow((i - xfs), 2) + Math.pow((j - yfs), 2));
                    }
                }

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

        //bla bla

    }
}