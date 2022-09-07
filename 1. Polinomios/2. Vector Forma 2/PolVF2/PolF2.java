import java.awt.*;
import javax.swing.*;
public class PolF2
{
    //*********************************************************
// ATRIBUTOS DE LA CLASE 
// N PARA GUARDAR EL TAMANO DEL VECTOR VEC
//*********************************************************
    String nombre; // PARA GUARDAR EL NOMBRE DEL POLINOMIO
    int n, vec[];

    public PolF2(String nombre)
    {
        this.nombre = nombre;
        n = 1;
        vec= new int[1];
        vec[0]= 0;

    }
    //*********************************************************
// METODO ENCARGADO DE AUMENTAR EL TAMAÑO DEL VECTOR, SI EL 
// PARÁMETRO ES POSITIVO EL VECTOR CRECE EN CASO CONTRARIO DECRECE
//*********************************************************
    public void redimensionar(int x)
    {
        int aux[];
        if( x> 0)
        {
            aux = new int[  n + x];
            for(int i =0 ; i < vec[0]*2+1; i++)
            {
                aux[i]= vec[ i ];
            }
            n = n + x;
            vec= aux;
        }
        else
        {
            if( n + x >= vec[0]*2+1)
            {
                aux = new int[  n + x];
                for(int i =0 ; i < n+x; i++)
                {
                    aux[i]= vec[ i ];
                }
                n = n + x;
                vec= aux;
            }
        }
    }

    //********************************************************
    // MÉTODO QUE REGRESA EL DATO QUE ESTA EN LA POSICON P 
    // DEL VECTOR VEC
    //********************************************************
    public int obtenerDato(int p)
    {
        return vec[p];
    }
    //********************************************************
    // MÉTODO QUE REGRESA EL TAMAÑO DEL VECTOR
    //********************************************************
    public int obtenerN()
    {
        return n;
    }
    public int obtenerGrado()
    {
        return vec[0];
    }

    //********************************************************
// MÉTODO QUE COLOCA EL DATO D EN LA POSICIÓN P DEL VECTOR
//********************************************************
    public void asignarDato(int p, int d)
    {
        vec[p]=d;
    }

    //*******************************************
// ESTE MÉTODO SE ENCARGA DE PINTAR EL PolF2
// CON EL OBJETO GRAPHICS( LAPIZ ) RECIBIDO
// A PARTIR DE LA POSICION RECIBIDA COMO PARAMETRO
//********************************************	
    public void pintar( Graphics g , int c, int f)
    {
        g.setColor(Color.red);
        Font font1,font2,font3,font4;
        font1= new Font( "Times Roman",Font.BOLD, 14);
        font2= new Font( "Times Roman",Font.BOLD, 12);
        font3= new Font( "Times Roman",Font.BOLD, 16);
        font4= new Font( "Times Roman",Font.BOLD, 12);
        f = f+20;
        int i, j,k,c1,f1;
        c1 = c;
        f1= f;
        char ch;
        String exp,dato;
        g.setFont(font1);
        if( nombre!= null)
        {
            for( j =0 ; j < nombre.length(); j++)
            {
                ch=nombre.charAt(j);
                g.drawString (""+ ch,c1,f1);
                c1= c1 + 20;
            }
        }
        g.drawString (" = ",c1,f1);
        c1= c1 + 60;
        //para pintar el polinomio
        if( vec[0] == 0)
        {

            g.setColor(Color.blue);
            g.drawString (" Polinomio vacio ",c1,f1);
        }
        else
        {
            for( i= 1 ; i< vec[0]*2+1 ; i=i+2)
            {


                g.setColor(Color.blue);
                dato = ""+vec[i+1];
                g.setFont(font1);
                //pintar el signo
                if(vec[i+1]>0 && i >1)
                {
                    g.drawString (" + ",c1,f1);
                    c1= c1 + 40;
                }
                //pintar el coeficiente
                for( j =0 ; j < dato.length(); j++)
                {
                    ch=dato.charAt(j);
                    g.drawString (""+ ch,c1,f1);
                    c1= c1 + 20;
                }

                //pintar La variable x
                g.setColor(Color.red);
                g.drawString (" X ",c1,f1);
                c1= c1 + 30;
                //pintando el exponente
                g.setFont(font2);
                exp = ""+(vec[i]);
                for( j =0 ; j < exp.length(); j++)
                {
                    ch=exp.charAt(j);
                    g.drawString (""+ ch,c1,f1-15);
                    c1= c1 + 10;
                }

            }
        }
        //PINTANDO EL VECTOR

        int  alto=40,ancho=60;
        int f11,c11;
        f11=f1 + 40;
        c11= c + 50;

        for(j=0; j< vec.length;j++)
        {
            g.setFont(font3);
            if( j < vec[0]*2+1)
            {
                if( j == 0)
                {
                    g.setColor( Color.white);
                }
                else if( j %2==0)
                {
                    g.setColor( Color.lightGray);
                }
                else
                {
                    g.setColor( Color.yellow);
                }
            }
            else
            {
                g.setColor( Color.white);
            }

            g.fillRect(c11,f11,ancho,alto);
            g.setColor( Color.blue);
            g.drawRect(c11,f11,ancho,alto);
            g.drawString(""+vec[j],c11+10,f11+25);
            g.setFont(font4);
            // PARA COLOCAR LA POSICION DEL VECTOR
            g.setColor( Color.blue);
            g.drawString(""+(j+1),c11+30,f11-10);

            c11= c11+ancho;
        }

    }
    //*******************************************
// ESTE MÉTODO SE ENCARGA DE ISERTAR ELTERMINO
// RECIBIDO COMO PARÁMETRO, SI YA HAY UN TERMINO
// CON EL MISMO EXPONENTE SUMA LOS COEFICIENTES, SI
//LA SUMA DA CERO SE ELIMINA EL TERMINO.
//********************************************	  

    public void insertarTermino(int coe, int exp)
    {

        int i =1;
        while( i < vec[0]*2+1 && vec[i]> exp)
        {
            i= i+2;
        }
        if(i < vec[0]*2+1 && vec[i]==exp  )
        {
            int suma= vec[i+1]+ coe;
            if( suma != 0)
            {
                vec[i+1]= suma;
            }
            else
            {
                for( int j =i +2 ; j< vec[0]*2+1; j++)
                {
                    vec[j-2]=vec[j];
                }
                vec[0]=vec[0]-1;
                redimensionar(-2);
            }
        }
        else
        {
            redimensionar(2);
            for( int j =vec[0]*2; j >=i ; j--)
            {
                vec[j+2]=vec[j];
            }
            vec[i]=exp;
            vec[i+1]= coe;
            vec[0]=vec[0]+1;
        }
    }
}