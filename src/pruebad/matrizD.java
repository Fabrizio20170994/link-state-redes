/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebad;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author AMADEO
 */
public class matrizD {
    
    //Atributos
    int num_vertices;
    int matrizAdy[][];
    
    //Métodos
    
    //Crear la matriz en función del número de vértices que tenga el grafo 
    public matrizD(int n){
        matrizAdy=new int[n][n];  
    }
    
    //Llenar los datos dentro de la matriz
    public void llenarMatriz(int i, int j, int w){
            matrizAdy[i][j]=w;  
    }
    
    //Imprimir la matriz de adyacencia
    public void imprimirMatriz(int[][]matriz){
      
        String cad1="  ";
        for (int i = 0; i < matriz.length; i++) {
            cad1=cad1+i+" ";
        }
        System.out.println(cad1);
        for (int i = 0; i < matriz.length; i++) {
            String cadena="";
            for (int j = 0; j < matriz[i].length; j++) {
                cadena=cadena+matriz[i][j]+" ";
            }
            System.out.println(i+" "+cadena);
        }
    }
    
    //Ingreso de datos por el usuario 
    public void ingresoDatos(File n){
        LeerFile obj = new LeerFile();
        List a =  obj.TenerFile(n);
        
        int primero=0,segundo=0,tercero=0,limite;
        String linea,dig;
        
        for (int i = 1; i < a.size(); i++) {
            List cellTempList = (List) a.get(i);
            for (int j = 0; j < cellTempList.size(); j++) {
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                String valor = hssfCell.toString();
                
                linea = valor;
                limite=linea.indexOf(".");
                dig=linea.substring(0,limite);
                //Convertimos los datos en String
                if (j==0) {
                    primero=Integer.parseInt(dig);
                }
                else{
                    if (j==1) {
                        segundo=Integer.parseInt(dig);
                    }
                    else{
                        tercero=Integer.parseInt(dig);
                    }
                }     
            }
            
            llenarMatriz(primero,segundo,tercero);
        }
        
            
    }
}
