public class Main {

    public static void main(String[] args) {
        //MD[5][4]
        int MD[][] = {
                {0, 7, 0, 0},
                {4, 0, 6, 2},
                {0, 0, 0, 0},
                {0, 1, 0, 5},
                {0, 0, 3, 0},
        };

        DispersasF1 MatrizDispersa = new DispersasF1(MD.length, MD[0].length);

        System.out.println("Matriz Dispersa");
        for (int i = 0; i < MD.length; i++) {
            System.out.print("["+"\t");
            for (int j = 0; j < MD[0].length; j++) {
                    System.out.print(MD[i][j]+"\t");
                    if (MD[i][j] != 0){
                        MatrizDispersa.insertarDato(i, j, MD[i][j]);
                    }
            }
            System.out.println("]");
        }

        System.out.println("Matriz Dispersa en Lista Ligada Forma 1");
        MatrizDispersa.mostrar();
    }
}
