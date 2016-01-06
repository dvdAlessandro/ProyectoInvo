/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoinvo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Enrique
 */
public class Simulacion{
    private PoliticaInventario poli;
    private Probabilidades probabilidades;
    private Intervalo i;
    
    
    private static int dias = 365;
    private Double costo_total;
    private int nro_ordenes=0;
    private Double costo_faltante=0.0;
    
    
    private ArrayList<Eventos> tabla;
    private int cont=0;
    private Eventos evento;
    private int aux;
   // private boolean ordenPendiente = false;
    AuxOrdenEntrega aux_orden;
    AuxEspera aux_espera;
    ArrayList<AuxEspera> lista_espera = new ArrayList<AuxEspera>();
    
    

    public Simulacion(PoliticaInventario poli, Probabilidades probabilidades) {
        this.poli = poli;
        this.probabilidades = probabilidades;
        this.i = new Intervalo(poli.getCosto_inventario(),poli.getCosto_orden(),poli.getCosto_con_espera(),poli.getCosto_sin_espera(),probabilidades,dias);
    }
    
    public void run(){
        
        tabla = poli.getTabla_eventos();  
        //evento = tabla.get(cont);
        evento = new Eventos();
        evento.invi = poli.getInventario_inicial();
        evento.dia = 1;
        Random rnd = new Random();

       
        while(cont < 365){
           // evento = tabla.get(cont);
            if (cont > 1){//no es el primer dia de simulacion
                evento = new Eventos();
                evento.dia = cont + 1;
                evento.invi = tabla.get(cont-1).invf;
                //chequear si hay orden llegando
                if (aux_orden!=null && aux_orden.llegaOrden(evento.dia)){
                    evento.invi += poli.getQ();
                    aux_orden=null;
                }
                
                for (int i = 0 ; i < lista_espera.size() ; i++){
                    lista_espera.get(i).esperaAgotada(evento.dia);
                    if (!lista_espera.get(i).isValido()){
                        costo_faltante += (lista_espera.get(i).getDemanda_pendiente() * poli.getCosto_sin_espera());
                        lista_espera.remove(i);
                        i=0;//se vuelve a iniciar la iteracion puesto que al eliminar un elemento los indices i de la lista varian y se vuelve un rollo, es decir, solo se puede eliminar un elemento a la vez
                    }
                    else if (evento.invi >= lista_espera.get(i).getDemanda_pendiente()){
                        costo_faltante += (lista_espera.get(i).getDemanda_pendiente() * poli.getCosto_con_espera());
                        evento.invi -= lista_espera.get(i).getDemanda_pendiente();
                        lista_espera.remove(i);
                        i=0;
                    }
                } 
            }
            evento.nro_ale_dem = generarAleatorio(rnd);
            evento.dem = probabilidades.obtenerNumeroDemanda(evento.nro_ale_dem).intValue();
            System.out.println("dem: " +evento.dem);
            aux = evento.invi - evento.dem;
            if (aux <= 0){
                evento.invf = 0;
                if (aux < 0){// si existieron faltantes.
                    evento.fal = aux * (-1);//seteo cuantos faltaron
                    
                    if (aux_orden==null){//no hay orden, genero una
                        nro_ordenes++;
                        evento.nro_orden =nro_ordenes;
                        evento.nro_ale_tent = generarAleatorio(rnd);
                        evento.tent = probabilidades.obtenerNumeroTEntrega(evento.nro_ale_tent).intValue();
                        aux_orden = new AuxOrdenEntrega(evento.nro_orden,evento.tent,evento.dia);     
                    }
                    //genero una espera...
                    evento.nro_ale_tesp = generarAleatorio(rnd);
                    evento.tesp = probabilidades.obtenerNumeroTEspera(evento.nro_ale_tesp).intValue();
                    aux_espera = new AuxEspera(evento.tesp,evento.fal,evento.dia,true);
                    lista_espera.add(aux_espera);//la añado a la lista de espera
                }
            }
            else {
                evento.invf = aux;
            }
            
            evento.invp = (evento.invi + evento.invf)/2;
            poli.getTabla_eventos().add(evento);
            System.out.println("dia :"+ evento.dia);
            cont++;
        }
        
        
        System.out.println("a ver:" + costo_faltante);
        poli.imprimirTabla();
        //verificar que llegue una orden 
        //eliminar faltantes que dejaron de esperar
        //satisfacer faltantes
        //setear inventario inicial (inventario final + ordenn si hay)
        //actualizar el dia
        //generar numero aleatorio para la demanda, traer el numero de acuerdo a las probabilidades...
        //calcular invetario final y promedio
        //Si demanda es mayor que inventario inicial, generar faltante, setear invertario final en 0. generar nro tiempo espera cal costo
        //si iinventario final >= punto de reorden y no hay orden pendiente generar orden con su tiempo de entrega cal costo
    }
    
    private Double generarAleatorio(Random rnd){
        return Math.rint(rnd.nextDouble());
    }
    
    
}
