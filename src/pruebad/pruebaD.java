/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebad;

/**
 *
 * @author AMADEO
 */
// A Java program for Dijkstra's single source shortest path algorithm. 
// The program is for adjacency matrix representation of the graph 
import java.io.*; 
import java.util.Scanner;
  
public class pruebaD { 
    public static void main(String[] args) 
    { 
        
        System.out.println("¿Cuantos vertices tiene el grafo?");
        Scanner sc1=new Scanner(System.in);
        int resp=sc1.nextInt(); 
        
        System.out.println("Elija el vértice de origen: ");
        Scanner sc2=new Scanner(System.in);
        int resp2=sc2.nextInt(); 
        
        File f=new File("C:/Users/asus/Desktop/2020/redes/pruebaD/datos.xlsx");
        
        matrizD a = new matrizD(resp);
        a.ingresoDatos(f);
        
       a.imprimirMatriz(a.matrizAdy);
        
        algoDijkstra base = new algoDijkstra(resp); 
        base.dijkstra(a.matrizAdy, resp2);
    } 
} 
