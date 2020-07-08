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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author amadeo
 */
public class LeerFile {

    
    /**
     */
    
    
    public LeerFile(){
    }
    
    List TenerFile(File fileName){
        List cellData = new ArrayList();
        try{
            FileInputStream archivo = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(archivo);
            
            XSSFSheet hssfSheet = workbook.getSheetAt(0);
            
            Iterator rowIterator = hssfSheet.rowIterator();
            
            while(rowIterator.hasNext()){
                XSSFRow hssfrow = (XSSFRow) rowIterator.next();
                Iterator i = hssfrow.cellIterator();
                List cellTemp = new ArrayList();
                
                while(i.hasNext()){
                    XSSFCell hssfCell = (XSSFCell) i.next();
                    cellTemp.add(hssfCell);
                }
                
                cellData.add(cellTemp);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(cellData);
        return cellData;
    }
   
}
