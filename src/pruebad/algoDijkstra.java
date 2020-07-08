/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMADEO
 */
public class algoDijkstra {
    int numVertices; //numero de vertices
    
    public algoDijkstra (int n) {
        numVertices = n;
    }
    
    //Para ir iterando entre cada nodo el cual no se ha registrado aun
    public int minDistance(int dist[], Boolean verificar[]) 
    { 
        //Inicializamos la minima distancia posible como "infinito" 
        int min = Integer.MAX_VALUE; 
        int min_index = -1; //Prefijo de donde vino el salto  
        for (int v = 0; v < numVertices; v++) 
            if (verificar[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
        //Nodo el cual aun no se ha verificado y tiene la menor distancia acumulada 
        return min_index; 
    } 
  
    //Función imprimir la tabla de enrutamiento final 
    void printSolution(int dist[], int n, int src) 
    { 
        System.out.println("Vertice de origen: "+src);
        System.out.println("Vertice   Distancia desde el origen"); 
        for (int i = 0; i < numVertices; i++){
            if (dist[i]==Integer.MAX_VALUE) {
                System.out.println("   "+i + "          " + "No hay ruta hasta este nodo");
            }
            else{
                System.out.println("   "+i + "          " + dist[i]);
            }
        }
    } 
  
    //Algoritmo completo, basado en el camino más corto desde un vértice hacia otro
    void dijkstra(int graph[][], int src) 
    { 
        long startDijkstra = System.currentTimeMillis();
        int dist[] = new int[numVertices];//Lista que guarda la distancia acumulada menor hasta ese indice
        
      
  
        //Va a ser true cuando el vertice i esté incluido en el camino más corto del arbol
        Boolean verif[] = new Boolean[numVertices]; 
  
        // Inicializamos todas las distancias acumuladas como INFINITO Y ningun vertice aun esta incluido en el arbol
        for (int i = 0; i < numVertices; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            verif[i] = false; 
        } 
  
        // La distancia del vertice de origen siempre es 0 
        dist[src] = 0; 
  
        // Numero de iteraciones que se deben de hacer para validar el algoritmo  
        for (int count = 0; count < numVertices - 1; count++) {         
            /*Se elige el vertice con la menor distancia del conjunto de vertices no procesados aun,
            en la primera iteración el vertice del origen será primero*/
            int u = minDistance(dist, verif); 
         
  
            // Se marca al vertice como ya procesado 
            verif[u] = true; 
         
  
            /* Se va actualizar las distancias hacia los vertices adyacentes al vertice elegido*/
            for (int v = 0; v < numVertices; v++) {
                /*Antes de validar la distancia desde el vertice elegido hasta sus adyacentes y cambiar
                su distancia acumulada actual, primero se va a verificar que que sean adyacentes, es decir
                valor diferente a 0 en la matriz y segundo que la distancia acumulada del vertice elegido
                sea diferente a infinito para evitar perder tiempo*/
                if (!verif[v] && graph[u][v] != 0 &&  
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                
                    dist[v] = dist[u] + graph[u][v]; 
                   
                } /*Solo cambiará la distancia acumulada en cierto vértice cuando la distancia sumada sea menor que la actual*/
         
            }
            
        } 
        
  
        // Imprimimos la tabla de enrutamiento
        long endDijkstra = System.currentTimeMillis();
        System.out.println("Algoritmo Dijkstra procesado en: "+ (endDijkstra-startDijkstra) +" ms");
        printSolution(dist, numVertices,src); 
    }
}
