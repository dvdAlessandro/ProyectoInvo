/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

import java.util.ArrayList;

/**
 *
 * @author Enrique
 */
public class PoliticaInventario {
    private Double costo_inventario;
    private Double costo_orden;
    private Double costo_con_espera;
    private Double costo_sin_espera;
    private Integer inventario_inicial;
    private ArrayList<Eventos> tabla_eventos;

    public PoliticaInventario(Double costo_inventario, Double costo_orden, Double costo_con_espera, Double costo_sin_espera, Integer inventario_inicial) {
        this.costo_inventario = costo_inventario;
        this.costo_orden = costo_orden;
        this.costo_con_espera = costo_con_espera;
        this.costo_sin_espera = costo_sin_espera;
        this.inventario_inicial = inventario_inicial;
        this.tabla_eventos = new ArrayList<Eventos>();
    }

    public Double getCosto_inventario() {
        return costo_inventario;
    }

    public void setCosto_inventario(Double costo_inventario) {
        this.costo_inventario = costo_inventario;
    }

    public Double getCosto_orden() {
        return costo_orden;
    }

    public void setCosto_orden(Double costo_orden) {
        this.costo_orden = costo_orden;
    }

    public Double getCosto_con_espera() {
        return costo_con_espera;
    }

    public void setCosto_con_espera(Double costo_con_espera) {
        this.costo_con_espera = costo_con_espera;
    }

    public Double getCosto_sin_espera() {
        return costo_sin_espera;
    }

    public void setCosto_sin_espera(Double costo_sin_espera) {
        this.costo_sin_espera = costo_sin_espera;
    }

    public Integer getInventario_inicial() {
        return inventario_inicial;
    }

    public void setInventario_inicial(Integer inventario_inicial) {
        this.inventario_inicial = inventario_inicial;
    }
    
    
    
}
