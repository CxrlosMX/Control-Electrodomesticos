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
public class Lavadora extends Electrodomesticos {

    private int carga;

    public Lavadora(int carga, double precioBase, String c, char a, double peso) {
        super(precioBase, c, a, peso);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public double obtenerPrecioFinal() {
        double p = super.obtenerPrecioFinal();
        if (carga > 30) {
            p += 50;
        }
        return p;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nCarga: " + carga ;
    }
    
}
