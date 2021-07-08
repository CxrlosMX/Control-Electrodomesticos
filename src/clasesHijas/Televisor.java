/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesHijas;

import clasePadre.Electrodomesticos;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 23/06/2021
 *
 */
public class Televisor extends Electrodomesticos {

    private int resolucion;
    private boolean sincronizador;

    public Televisor(int resolucion, boolean sincronizador, double precioBase, String c, char a, double peso) {
        super(precioBase, c, a, peso);
        this.resolucion = resolucion;
        this.sincronizador = sincronizador;
    }

    @Override
    public double obtenerPrecioFinal() {
        double p = super.obtenerPrecioFinal();
        if (this.resolucion > 40) {
            p += super.getPrecioBase() * 0.3;
        }
        if (sincronizador) {
            p += 50;
        }
        return ( p);
    }

    @Override
    public String toString() {
        return super.toString()+"\nResolucion: " + resolucion + "\nSincronizador: " + sincronizador ;
    }
    
    
}
