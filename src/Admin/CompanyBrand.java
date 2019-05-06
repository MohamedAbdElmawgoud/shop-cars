/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;



/**
 *
 * @author Abdulkader
 */

public class CompanyBrand implements Serializable{
    String Name;
    
    ArrayList <CompanyBrand> comName=new ArrayList<>();
    FileManager FManage =new FileManager();
    public final String CompanyFileType ="CompanyNames.bin";
    
public boolean addCompany(CompanyBrand c)
{
 readFromFile();
 comName.add(this);
         return writeInFile();
}
public boolean writeInFile()
{
 return FManage.Write(CompanyFileType,comName);

}

public void readFromFile() {
      comName = (ArrayList<CompanyBrand>) FManage.Read(CompanyFileType,comName);
    }

public  String[] convertToArray(){
    readFromFile();
    String[] arr=new String[comName.size()];
    for(int i=0;i<comName.size();i++){
        arr[i]=comName.get(i).Name;
    }
    return arr;
}
public ComboBoxModel getComboModel ()
{
  return new  DefaultComboBoxModel (convertToArray());
}

}
