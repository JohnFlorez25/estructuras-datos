import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PolF3 {
    //atributos de la clase
    private String nombre;
    private Nodo punta;// atributo que indica donde inicia la lista

    //constructor sin parámetro, encargado de iniciar la lista vacia
    public PolF3(String nombre) {
        this.nombre = nombre;
        punta = null;
    }

    //método encargado de insertar el caracter x, al principio de la lista
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


    public void pintarLista(Graphics g, int x, int y) {
        int ancho = 150, alto = 50;
        Font font1, font2, font3, font4;
        font1 = new Font("Times Roman", Font.BOLD, 14);
        font2 = new Font("Times Roman", Font.BOLD, 12);
        font3 = new Font("Times Roman", Font.BOLD, 16);
        font4 = new Font("Times Roman", Font.BOLD, 18);
        g.setColor(Color.blue);
        g.setFont(font3);
        g.drawString(" " + nombre + " = ", x, y + 20);
        x = x + 50;
        Nodo p, ant;
        if (punta == null) {
            g.drawString("lista vacia ", x, y + 20);
        } else {
            //PARA PINTAR EL POLINOMIO
            String dato;
            g.setFont(font4);
            p = punta;
            int c1 = x;
            while (p != null) {

                g.setColor(Color.blue);
                dato = "" + p.obtenerCoe();
                //pintar el signo
                if (p.obtenerCoe() > 0) {
                    g.drawString(" + ", c1, y - 20);
                    c1 = c1 + 40;
                }
                //pintar el coeficiente
                for (int j = 0; j < dato.length(); j++) {
                    char ch = dato.charAt(j);
                    g.drawString("" + ch, c1, y - 20);
                    c1 = c1 + 20;
                }
                //pintar La variable x
                g.setColor(Color.red);
                g.drawString(" X ", c1, y - 20);
                c1 = c1 + 30;
                //pintando el exponente
                String exp = "" + p.obtenerExp();
                for (int j = 0; j < exp.length(); j++) {
                    char ch = exp.charAt(j);
                    g.drawString("" + ch, c1, y - 25);
                    c1 = c1 + 10;
                }

                p = p.obtenerLiga();

            }

            g.setFont(font3);

            p = punta;
            ant = null;
            while (p != null) {
                g.setColor(Color.yellow);
                g.fillRect(x, y, ancho, alto);
                g.setColor(Color.red);
                g.drawString("coe =" + p.obtenerCoe(), x + 5, y + 20);
                g.drawString("exp =" + p.obtenerExp(), x + 5, y + 40);
                g.setColor(Color.blue);
                g.drawRect(x, y, ancho, alto);
                g.drawLine((int) (x + ancho * 0.7), y, (int) (x + ancho * 0.7), y + alto);
                if (ant != null) {
                    g.drawLine(x - 25, y + alto / 2, x, y + alto / 2);
                }
                x = x + ancho + 10;
                ant = p;
                if (p.obtenerLiga() == null) {
                    g.drawString("\\", x - 28, y + 5 + alto / 2);

                }
                p = p.obtenerLiga();
            }

        }
    }

}
        