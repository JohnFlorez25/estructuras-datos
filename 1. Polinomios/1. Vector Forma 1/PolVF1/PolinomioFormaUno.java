public class PolinomioFormaUno {

    //Atributos de la Clase
    String nombre;
    int n, vec[];

    //Constructor
    public PolinomioFormaUno(String nombre, int vec[]){
        this.nombre = nombre;
        this.vec = vec;
    }

    public PolinomioFormaUno(String nombre, int x){
        this.nombre = nombre;
        this.n = x;
        this.vec = new int[x];
    }

    //Obtener el grado del polinomio
    public int obtenerGrado(){
        return this.vec[0];
    }

    //Obtener dato
    public int obtenerDato(int p){
        return this.vec[p];
    }

    //Asignar un dato - coeficiente -
    public void asignarDato(int p, int d){
        this.vec[p] = d;
    }


    public String mostrar(){
        String polinomio = this.nombre + " = ";
        int exp = 0;
        for(int i = 1; i < vec[0] + 2; i++){
            //Identificar el exponente
            exp = vec[0] + 1 - i;
            //if(vec[i] != 0){
                if(vec[i] >= 0){
                    polinomio = polinomio + " + "+ vec[i] + "Y^" + exp;
                }else {
                    polinomio = polinomio + " - " + (vec[i]*(-1)) + "Y^" + exp;
                }
            //}
        }
        return polinomio;
    }

    public void ajustar(){
        int cont = 0;
        int i = 0;
        if (this.vec[1] == 0){
            i = 1;
            while ((i < this.vec[0] + 2) && (this.vec[i] == 0)){
                cont = cont +1;
                i = i + 1;
            }
            for(int j=i; j < this.vec[0] + 2; j++){
                //Mover los coeficientes ajustados
                this.vec[j-cont] = this.vec[j];
            }
            //Actualizamos el grado del polinomio
            this.vec[0] = this.vec[0] - cont;
        }
    }

    //Sumar
    //1. Cual de los dos polinomios tiene el grado mayor
    //2. Se construye un nuevo polinomio - PolinomioFormaUno-
    //3. Desde que existan datos se verifica lo siguiente
    //----- Identificar exponentes de cada polinomio
    // (expA > expB) , (expA == expB) , (expB > expA)
    public PolinomioFormaUno sumar(PolinomioFormaUno B){
        int k = 1;
        int j = 1;
        int y = 1;
        int mayor = 0;
        int expA = 0;
        int expB = 0;
        int posC = 0;
        //1. Identificar el polinomio de mayor grado
        if (this.vec[0] > B.obtenerDato(0)){
            mayor = this.vec[0];
        }else {
            mayor = B.obtenerDato(0);
        }
        PolinomioFormaUno C = new PolinomioFormaUno("C", mayor+2);

        C.asignarDato(0, mayor);

        while ((k < this.vec[0]+2) && (j < B.obtenerDato(0) + 2)){
            expA = this.vec[0] + 1 - k;
            expB = B.obtenerDato(0) + 1 - j;
            if (expA == expB){
                posC = C.obtenerDato(0) + 1 - expA;
                C.asignarDato(y, this.vec[k] + B.obtenerDato(j));
                k++;
                j++;
            }else if(expA > expB){
                posC = C.obtenerDato(0) + 1 - expA;
                C.asignarDato(y, this.vec[k]);
                k++;
            }else if(expB > expA){
                posC = C.obtenerDato(0) + 1 - expB;
                C.asignarDato(y, B.obtenerDato(j));
                j++;
            }
            y++;
        }
        C.ajustar();
        return C;
    }

    //1. El grado del Polinomio multiplicar es la suma de A + B
    //2. Se contruye el polinomio para guardar el resultado de la multiplicación
    //3. Cada termino de B se multiplica por cada termino A
    //4. Acumular el resultado en el nuevo Polinomio - Multiplicar
    public PolinomioFormaUno multiplicar(PolinomioFormaUno B){
        int expA = 0;
        int expB = 0;
        int expC = 0;
        int coefC = 0;
        int posC = 0;

        PolinomioFormaUno C = new PolinomioFormaUno(
                "M",
                this.vec[0] + B.obtenerDato(0) + 2);

        C.asignarDato(0, this.vec[0] + B.obtenerDato(0));

        for (int j = 1 ; j < B.obtenerDato(0) + 2; j++){
            expB = B.obtenerDato(0) + 1 - j;
            for(int k = 1; k < this.vec[0] + 2; k++){
                expA = this.vec[0] + 1 - k;
                expC = expA + expB;
                coefC = this.vec[k] * B.obtenerDato(j);
                posC = C.obtenerDato(0) + 1 - expC;
                C.asignarDato(posC, C.obtenerDato(posC)+coefC);
            }
        }
        return C;
    }
}
