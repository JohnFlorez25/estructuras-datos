public class Main {
    public static void main(String[] args) {

        // A = 3Y^5 + 9Y^4 - 2Y^2 - 6
        // Grado = 5
        // Datos útiles = A[0] + 2 = 7
        int A [] =  {5, 0, 0, 0, -2, 0, -6};
        //A = - 2Y^2 - 6
        PolinomioFormaUno miPolinomio = new PolinomioFormaUno("A", A );

        System.out.println(miPolinomio.mostrar());
        System.out.println("El grado del Polinomio es " + miPolinomio.obtenerGrado());
        miPolinomio.ajustar();
        System.out.println(miPolinomio.mostrar());
        System.out.println("El grado del Polinomio es " + miPolinomio.obtenerGrado());

        int B [] =  {5, 3, 4, -87, -2, 0, -6};
        PolinomioFormaUno miPolinomioDos = new PolinomioFormaUno("B", B);
        System.out.println(miPolinomioDos.mostrar());

        PolinomioFormaUno C = miPolinomio.sumar(miPolinomioDos);

        System.out.println(C.mostrar());

        PolinomioFormaUno D = miPolinomio.multiplicar(miPolinomioDos);

        System.out.println(D.mostrar());
    }
}
