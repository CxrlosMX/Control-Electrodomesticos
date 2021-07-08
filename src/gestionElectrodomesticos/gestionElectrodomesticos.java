/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionElectrodomesticos;

import clasePadre.Electrodomesticos;
import clasesHijas.Lavadora;
import clasesHijas.Televisor;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 23/06/2021
 *
 */
public class gestionElectrodomesticos {

    private Electrodomesticos[] arreglo;

    public gestionElectrodomesticos() {
        arreglo = new Electrodomesticos[5];
    }

    public gestionElectrodomesticos(int size) {
        arreglo = new Electrodomesticos[size];
    }

    //Metodo para rellenar los electrodomesticos
    public Electrodomesticos rellenarElectrodomesticos(int i) {
        Electrodomesticos a;
        double precioBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el precio Base", "Agregando valores", 1));
        String color = JOptionPane.showInputDialog(null, "Introduce el color", "Introduciendo color", 1);
        String consumoEnergia = JOptionPane.showInputDialog(null, "Introduce el consumo de energia", "Introduciendo consumo", 1);
        char consumo =(consumoEnergia.charAt(0));
        double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el peso del electrodomestico", "Introduciendo peso del electrodomestico", 1));
        if (i == 1) { //Televisor
            int resolucion = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la resolucion de la pantalla", "Introduciendo resolucion", 1));
            String tieneSin = JOptionPane.showInputDialog(null, "El televisor cuenta con Sincronizador?", "Insertando Sincronizador", 1);
            boolean sin = false;
            if (tieneSin.equalsIgnoreCase("Si")) {
                sin = true;
            }
            a = new Televisor(resolucion, sin, precioBase, color, consumo, peso);

        } else  { //i>1 Lavadora
            int carga = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la capacidad de carga de la lavadora", "Introduciendo capacidad", 1));
            a = new Lavadora(carga, precioBase, color, consumo, peso);
        }
        return a;
    }

    //Metodo para agregar un electrodomestico
    public void agregarElectrodomestico(Electrodomesticos e) {
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = e;
                encontrado = true;
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Electrodomestico agregado Correctamente", "Agregado", 1);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el electrodomestico", "Error al agregar", 0);
        }
    }

    //Calcular los precio de cada instancia}
    public void precioInstancias() {
        double pTele = 0, pLava = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                if (arreglo[i] instanceof Televisor) {
                    pTele += arreglo[i].obtenerPrecioFinal();
                }
                if (arreglo[i] instanceof Lavadora) {
                    pLava += arreglo[i].obtenerPrecioFinal();
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Precio total de las Televisiones: " + pTele, "Precio Televisores", 1);
        JOptionPane.showMessageDialog(null, "Precio total de las Lavadoras: " + pLava, "Precio Lavadoras", 1);
    }

    //Metodo para mostrar electrodomesticos
    public void mostrarElectrodomesticos() {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + "\n" + arreglo[i].toString();
            }
        }
        JOptionPane.showMessageDialog(null, cadena, "Mostrando Electrodomesticos", 1);
    }
}
