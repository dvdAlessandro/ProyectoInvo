/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

/**
 *
 * @author Enrique
 */
public class AuxOrdenEntrega {
    private int nro_orden;
    private int tiempo_entrega;
    private int dia_realizada;

    public AuxOrdenEntrega(int nro_orden, int tiempo_entrega, int dia_realizada) {
        this.nro_orden = nro_orden;
        this.tiempo_entrega = tiempo_entrega;
        this.dia_realizada = dia_realizada;
    }

    public int getNro_orden() {
        return nro_orden;
    }

    public int getTiempo_entrega() {
        return tiempo_entrega;
    }

    public int getDia_realizada() {
        return dia_realizada;
    }
    
    public boolean llegaOrden(int dia){
        if (dia == (dia_realizada + tiempo_entrega + 1) )
            return true;
        else
            return false;
    }
    
}
