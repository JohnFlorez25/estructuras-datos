import java.util.Scanner;

public class PolF3 {

    //atributos de la clase
    private String nombre;
    private Nodo punta;// atributo que indica donde inicia la lista

    //constructor sin parámetro, encargado de iniciar la lista vacia
    public PolF3(String nombre) {
        this.nombre = nombre;
        punta = null;
    }

    public Nodo obtenerPunta(){
        return punta;
    }

    public void insertarTermino(int coe, int exp) {
        Nodo q, p, ant;

        if (punta == null) {
            q = new Nodo(coe, exp);
            punta = q;
        } else {
            p = punta;
            ant = null;
            while (p != null && p.obtenerExp() > exp) {
                ant = p;
                p = p.obtenerLiga();
            }
            if (p != null && p.obtenerExp() == exp) {
                p.asignarCoe(p.obtenerCoe() + coe);
                if (p.obtenerCoe() == 0) {
                    if (p == punta) {
                        punta = p.obtenerLiga();
                    } else {
                        ant.asignarLiga(p.obtenerLiga());

                    }
                    p = null;
                }

            } else {
                q = new Nodo(coe, exp);
                if (p == punta) {
                    q.asignarLiga(punta);
                    punta = q;
                } else {
                    ant.asignarLiga(q);
                    q.asignarLiga(p);
                }
            }
        }
    }

    public String mostrarPolinomio(){
        boolean band = true;
        Nodo Q = punta;
        String polinomio = "";
        while (Q != null){

            if(Q.obtenerCoe() >= 0){
                if(band){
                    polinomio = polinomio +  Q.obtenerCoe() + "Y^" + Q.obtenerExp() ;
                    band = false;
                }else{
                    polinomio = polinomio + " + "+ Q.obtenerCoe() + "Y^" + Q.obtenerExp() ;
                }

            }else {
                polinomio = polinomio + " - " + (Q.obtenerCoe()*(-1)) + "Y^" + Q.obtenerExp();
            }
            Q = Q.obtenerLiga();
        }

        return polinomio;
    }

    public void crearPolinomio(){

        Scanner sc = new Scanner(System.in);
        Nodo P = null;
        Nodo ULTIMO = null;
        Nodo X;
        int terminos = 0;
        int coef = 0;
        int exp = 0;


        System.out.println("Digite la cantidad de términos");
        terminos = sc.nextInt();

        for (int i = 0; i < terminos ; i++) {
            System.out.println("Digite coeficiente");
            coef = sc.nextInt();
            System.out.println("Digite exponente");
            exp = sc.nextInt();
            X = new Nodo(coef, exp);
            if (punta == null){
                punta = X;
            }else{
                ULTIMO.asignarLiga(X);
            }
            ULTIMO = X;
        }
    }

    public PolF3 sumar(PolF3 B){
        int expA = 0;
        int expB = 0;
        int coefA = 0;
        int coefB = 0;
        Nodo P = null;
        Nodo Q = null;
        PolF3 C = new PolF3("C");
        P = punta;
        Q = B.obtenerPunta();
        while ((P != null) && (Q != null)){
            expA = P.obtenerExp();
            expB = Q.obtenerExp();
            coefA = P.obtenerCoe();
            coefB = Q.obtenerCoe();
            if (expA == expB){
                C.insertarTermino(coefA + coefB, expA);
                P = P.obtenerLiga();
                Q = Q.obtenerLiga();
            }else if (expA > expB){
                C.insertarTermino(coefA, expA);
                P = P.obtenerLiga();
            }else if (expB > expA){
                C.insertarTermino(coefB, expB);
                Q = Q.obtenerLiga();
            }
        }
        while (P != null){
            C.insertarTermino(P.obtenerCoe(), P.obtenerExp());
            P = P.obtenerLiga();
        }
        while (Q != null){
            C.insertarTermino(Q.obtenerCoe(), Q.obtenerExp());
            Q = Q.obtenerLiga();
        }

        return C;
    }

    public PolF3 multiplicar(PolF3 B){
        int expA = 0;
        int expB = 0;
        int coeA = 0;
        int coeB = 0;
        PolF3 C = new PolF3("C");
        Nodo Q = null;
        Nodo R = punta;
        while ( R != null){
            Q = B.obtenerPunta();
            while ( Q != null){
                expA = R.obtenerExp();
                expB = Q.obtenerExp();
                coeA = R.obtenerCoe();
                coeB = Q.obtenerCoe();
                C.insertarTermino(coeA * coeB, expA + expB);
                Q = Q.obtenerLiga();
            }
            R = R.obtenerLiga();
        }
        return  C;
    }
}
