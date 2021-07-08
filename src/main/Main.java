/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clasePadre.Electrodomesticos;
import clasesHijas.Lavadora;
import clasesHijas.Televisor;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 7/07/2021
 *
 */
public class Main {

    public static void main(String[] args) {
        int op = 0;
        Electrodomesticos[] lista = new Electrodomesticos[1];
        Electrodomesticos a;
        for (int i = 0; i < lista.length;) {
            try {

                op = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU"
                        + "\n1.-Agregar Electrodomestico"
                        + "\n2.-Agregar Lavadora"
                        + "\n3.-Agregar Televisor" + "\nQue desea realizar?", "Menu", 3));
                switch (op) {
                    case 1: {
                        a = Main.rellenarElectrodomesticos(3);
                        lista[i] = a;
                        JOptionPane.showMessageDialog(null, "Electrodomestico Agregado Correctamente", "Agregado con Exito", 1);
                        i++;
                        break;
                    }
                    case 2: {
                        a = Main.rellenarElectrodomesticos(2);
                        lista[i] = a;
                        JOptionPane.showMessageDialog(null, "Lavadora Agregada Correctamente", "Agregado con Exito", 1);
                        i++;
                        break;
                    }
                    case 3: {
                        a = Main.rellenarElectrodomesticos(1);
                        lista[i] = a;
                        JOptionPane.showMessageDialog(null, "Televisor Agregado Correctamente", "Agregado con Exito", 1);
                        i++;
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce valores correctos por favor", "Error", 2);
                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 0);
            }
        }
        Main.mostrar(lista);
        Main.sumaInstancias(lista);
    }

    //Metodo para rellenar los electrodomesticos
    public static Electrodomesticos rellenarElectrodomesticos(int i) {
        Electrodomesticos a;
        double precioBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el precio Base", "Agregando valores", 1));
        String color = JOptionPane.showInputDialog(null, "Introduce el color", "Introduciendo color", 1);
        String consumoEnergia = JOptionPane.showInputDialog(null, "Introduce el consumo de energia", "Introduciendo consumo", 1);
        char consumo = (consumoEnergia.trim().charAt(0));
        double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el peso del electrodomestico", "Introduciendo peso del electrodomestico", 1));
        if (i == 1) { //Televisor
            int resolucion = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la resolucion de la pantalla", "Introduciendo resolucion", 1));
            String tieneSin = JOptionPane.showInputDialog(null, "El televisor cuenta con Sincronizador?", "Insertando Sincronizador", 1);
            boolean sin = false;
            if (tieneSin.equalsIgnoreCase("Si")) {
                sin = true;
            }
            a = new Televisor(resolucion, sin, precioBase, color, consumo, peso);

        } else if (i == 2) { //Si i es igual a 2 nos devuelve un objeto Lavadora
            int carga = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la capacidad de carga de la lavadora", "Introduciendo capacidad", 1));
            a = new Lavadora(carga, precioBase, color, consumo, peso);
        } else { //Electrodomestico
            a = new Electrodomesticos(precioBase, color, consumo, peso);
        }
        return a;
    }

    //Metodo que recorra el arreglo
    public static void mostrar(Electrodomesticos[] arreglo) {
        String cadena = "";
        for (Electrodomesticos i : arreglo) {
            cadena = cadena + "\n" + i + "\n--------------------";
        }
        JOptionPane.showMessageDialog(null, cadena, "Mostrando", 1);
    }

    //Metodo que nos devuelva la suma del precio de cada instancia
    public static void sumaInstancias(Electrodomesticos[] arreglo) {
        double electrodomestico = 0;
        double lavadora = 0;
        double televisor = 0;
        for (Electrodomesticos i : arreglo) {
            if (i instanceof Electrodomesticos) {
                electrodomestico += i.obtenerPrecioFinal();
            } else if (i instanceof Lavadora) {
                lavadora += i.obtenerPrecioFinal();
            } else {
                televisor += i.obtenerPrecioFinal();
            }
        }
        JOptionPane.showMessageDialog(null, "Precios: \n"
                + "Electrodomesticos: " + electrodomestico + "$"
                + "\nLavadora: " + lavadora + "$"
                + "\nTelevisor: " + televisor + "$", "Mostrando Precios Instancias", 1);
    }

}
