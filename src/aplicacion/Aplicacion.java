/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import clasePadre.Electrodomesticos;
import clasesHijas.Lavadora;
import clasesHijas.Televisor;
import gestionElectrodomesticos.gestionElectrodomesticos;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 24/06/2021
 *
 */
public class Aplicacion {

    public static void main(String[] args) {
        gestionElectrodomesticos arreglo = new gestionElectrodomesticos(4);
        Electrodomesticos a;

        int op = 0;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU"
                        + "\n1.- Agregar Televisor"
                        + "\n2.-Agregar Lavadora"
                        + "\n3.-Mostrar Informacion"
                        + "\n4.-Mostrar Precio de Cada Articulo"
                        + "\n5.-Salir"));
                switch (op) {
                    case 1: {
                        a = arreglo.rellenarElectrodomesticos(1);
                        arreglo.agregarElectrodomestico(a);
                        break;
                    }
                    case 2: {
                        a = arreglo.rellenarElectrodomesticos(2);
                        arreglo.agregarElectrodomestico(a);
                        break;
                    }
                    case 3: {
                        arreglo.mostrarElectrodomesticos();
                        break;
                    }
                    case 4: {
                        arreglo.precioInstancias();
                        break;
                    }
                    case 5: {
                        JOptionPane.showMessageDialog(null, "Saliendo","Cerrando programa",2);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce valores validos por favor","Error de valores",0);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", 0);
            }

        } while (op != 5);

    }

}
