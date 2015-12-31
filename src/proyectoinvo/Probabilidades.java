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
public class Probabilidades {
    private int filas = 2;
    private int col_dem = 10;
    private int col_te = 4;
    
    private Double[][] demanda_diaria ;
    private Double[][] tiempo_entrega ;
    private Double[][] tiempo_espera ;

    public Probabilidades() {
        this.demanda_diaria = new Double[filas][col_dem];
        this.tiempo_entrega = new Double[filas][col_te];
        this.tiempo_espera = new Double[filas][col_te+1];
    }
    
    public void setDemanda(Double dem[][]){
        this.demanda_diaria =dem;
    }
    
    public void setTiempoEntrega(Double te[][]){
        this.tiempo_entrega = te;
    }
    public void setTiempoEspera(Double te[][]){
        this.tiempo_espera = te;
    }
    
    public void imprimir(){
        int i ,j;
        System.out.println("DEMANDA DIARIA\n");
        for (i=0; i <demanda_diaria[0].length; i++ ){
           System.out.print(demanda_diaria[0][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <demanda_diaria[1].length; i++ ){
           System.out.print(demanda_diaria[1][i]+"\t");
        }
        System.out.println("\n\n");
        
        System.out.println("TIEMPO ENTREGA\n");
        for (i=0; i <tiempo_entrega[0].length; i++ ){
           System.out.print(tiempo_entrega[0][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <tiempo_entrega[1].length; i++ ){
           System.out.print(tiempo_entrega[1][i]+"\t");
        }
        System.out.println("\n\n");
        
        
        System.out.println("TIEMPO ESPERA\n");
        for (i=0; i <tiempo_espera[0].length; i++ ){
           System.out.print(tiempo_espera[0][i]+"\t");
        }
        System.out.println("\n");
        for (i=0; i <tiempo_espera[1].length; i++ ){
           System.out.print(tiempo_espera[1][i]+"\t");
        }
        System.out.println("\n\n");
    }
    
}
