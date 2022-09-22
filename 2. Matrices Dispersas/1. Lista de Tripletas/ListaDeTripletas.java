public class Main {
    public static void main(String[] args) {

        //MD[5][7]
        int MD[][] = {
                {0, 0, 0, 7, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 9, 0, 0, 0, -5, 0},
                {0, 0, 3, 0, 8, 0, 0},
                {0, 1, 0, 0, 6, 0, 4},
        };
        //Dimensionar la matriz dispersa
        int NF = MD.length;//5;
        int NC = MD[0].length;//7;


        System.out.println("N° Filas "+NF);
        System.out.println("N° Columnas "+NC);
        int LT[][] = almacenar_MD_en_LT(MD, NF, NC);

        mostrar_MD_en_LT(LT);

        almacenar_LT_en_MD(LT);
    }

    public static void mostrar_MD_en_LT(int LT[][]) {
        System.out.println("Matriz Dispersa en Lista de Tripletas");
        for (int i = 1; i < LT[0][2] + 1; i++) {
            System.out.print("Fila: " + LT[i][0] + "\t");
            System.out.print("Columna: " + LT[i][1] + "\t");
            System.out.println("Dato: " + LT[i][2]);
        }
    }

    public static int[][] almacenar_LT_en_MD(int LT[][]) {
        //MD[5][7]
        int MD[][] = new int[LT[0][0]][LT[0][1]];
        //Arrays.fill(MD,0);
        for (int i = 1; i < LT[0][2] + 1; i++) {
            MD[LT[i][0]][LT[i][1]] = LT[i][2];
        }
        System.out.println("Matriz Dispersa");
        for (int i = 0; i < MD.length; i++) {
            System.out.print("[");
            for (int j = 0; j < MD[0].length; j++) {
                System.out.print(MD[i][j]+","+"\t");
            }
            System.out.println("]");
        }
        return MD;
    }

    public static int[][] almacenar_MD_en_LT(
            int MD[][],
            int NF,
            int NC
    ) {
        //1. Encontrar los datos distintos de cero
        int D = contar_distintos_cero(MD, NF, NC);
        //2. Crear la matriz Lista de Tripletas
        //LT[10][3]
        int LT[][] = new int[D + 1][3];
        //3. Guardar los datos de referencia de la M.D
        LT[0][0] = NF;
        LT[0][1] = NC;
        LT[0][2] = D;
        //4. Almacenar los datos distintos de cero en la LT;
        int K = 1;
        for (int F = 0; F < NF; F++) {
            for (int C = 0; C < NC; C++) {
                if (MD[F][C] != 0) {
                    LT[K][0] = F;
                    LT[K][1] = C;
                    LT[K][2] = MD[F][C];
                    K++;
                }
            }
        }
        return LT;
    }

    public static int contar_distintos_cero(
            int MD[][],
            int NF,
            int NC) {
        int cont = 0;
        for (int F = 0; F < NF; F++) {
            for (int C = 0; C < NC; C++) {
                if (MD[F][C] != 0) {
                    cont++;
                }
            }
        }
        return cont;
    }
}
