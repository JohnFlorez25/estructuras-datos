public class Main {

    public static void main(String[] args) {

        PolF3 pol1 = new PolF3("A");

        //Insertando terminos 1 a 1
        pol1.insertarTermino(2,100);
        pol1.insertarTermino(4,5);
        pol1.insertarTermino(-2,1);
        pol1.insertarTermino(1,0);

        //Mostrar Polinomio
        System.out.println(pol1.mostrarPolinomio());

        PolF3 pol2 = new PolF3("B");

        //Crear Polinomio con datos de entrada por teclado.
        pol2.crearPolinomio();

        //Mostrar Polinomio
        System.out.println(pol2.mostrarPolinomio());

        //Multiplicar dos polinomios
        PolF3 pol3 = pol1.multiplicar(pol2);

        //Mostrar Polinomio
        System.out.println(pol3.mostrarPolinomio());

        //Sunmar dos polinomios
        PolF3 pol4 = pol1.sumar(pol2);

        //Mostrar Polinomio
        System.out.println(pol4.mostrarPolinomio());


    }
}
