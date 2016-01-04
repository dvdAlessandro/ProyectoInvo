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
public class AuxEspera {
    private int dia_realizada;
    private int tiempo_espera;
    private int demanda_pendiente;
    private boolean valido;

    public AuxEspera( int tiempo_espera, int demanda_pendiente,int dia_realizada, boolean valido) {
        this.dia_realizada = dia_realizada;
        this.tiempo_espera = tiempo_espera;
        this.demanda_pendiente = demanda_pendiente;
        this.valido = valido;
    }

    public int getDia_realizada() {
        return dia_realizada;
    }

    public int getTiempo_espera() {
        return tiempo_espera;
    }

    public int getDemanda_pendiente() {
        return demanda_pendiente;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
    
    
    
}
