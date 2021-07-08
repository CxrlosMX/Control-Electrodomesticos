/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasePadre;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 23/06/2021
 *
 */
public class Electrodomesticos {

    //Asignamos valores por defecto
    private final static String COLOR_DEFECTO = "BLANCO";
    private final static char CONSUMO_DEFECTO = 'F';
    private final static double PRECIO_DEFECTO = 100;
    private final static double PESO_DEFECTO = 5;
    //Creamos los atributos
    private double precioBase;
    private String color;
    private char consumoEnergia;
    private double peso;

    public Electrodomesticos(double precioBase, String c, char a, double peso) {
        this.precioBase = precioBase;
        comprobarColor(c);
        comprobarConsumoEnergetico(a);
        this.peso = peso;
    }

    //Metodo para comprobar el color

    private void comprobarColor(String color) {
        boolean encontrado = false;
        String[] colores = {"Negro", "Rojo", "Azul", "Blanco", "Gris"};
        for (int i = 0; i < colores.length && !encontrado; i++) {
            if (color.equalsIgnoreCase(colores[i])) {
                this.color = color;
                encontrado = true;
            }
        }
        if (!encontrado) {
            this.color = COLOR_DEFECTO;
        }
    }

    //Creamos el metodo para comprobar el consumo energetico
    public final void comprobarConsumoEnergetico(char a) {
        if (a >= 65 && a <= 70) {
            this.consumoEnergia = a;
        }
        else{
        this.consumoEnergia = CONSUMO_DEFECTO;}
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(char consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //Metodo para realizar el precio final
    public double obtenerPrecioFinal() {
        double p = 0;
        switch (this.consumoEnergia) {
            case 'A': {
                p += 100;
                break;
            }
            case 'B': {
                p += 80;
                break;
            }
            case 'C': {
                p += 60;
                break;
            }
            case 'D': {
                p += 50;
                break;
            }
            case 'E': {
                p += 30;
                break;
            }
            case 'F': {
                p += 10;
                break;
            }
        }
        if (this.peso >= 0 && this.peso <= 19) {
            p += 10;
            this.setPrecioBase(p);
        } else if (this.peso >= 20 && this.peso <= 49) {
            p += 50;
            this.setPrecioBase(p);
        } else if (this.peso >= 50 && this.peso <= 79) {
            p += 80;
            this.setPrecioBase(p);
        } else {

        }
        return (this.precioBase + p);
    }

    @Override
    public String toString() {
        return "Precio Base: " + precioBase + "\nColor:" + color + "\nConsumo Energia: " + consumoEnergia + "\nPeso: " + peso;
    }

}
