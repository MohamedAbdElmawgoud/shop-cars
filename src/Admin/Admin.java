
package Admin;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Admin extends Staff  {
   
    
    AdminFileManger fm = new AdminFileManger();
    
  public void add(Employee e) throws FileNotFoundException, IOException, ClassNotFoundException
  
   {
       int Enum;
        try {
            Enum = fm.ReadEnum();
           System.out.println(Enum+"Enum");
        }
         catch (IOException  | ClassCastException r) {
            Enum = 0;
            System.out.println(Enum+"Enum");
            }
     
        
       ArrayList<Employee> arr = new ArrayList<Employee>(5) ;
      if(Enum == 0){
            e.id = Enum+1;
            arr.add(e);
            System.out.println( Enum +"index");
            System.out.println( e.id +"id");
            Enum= 1+Enum;
          fm.WriteE(arr, Enum);
       }
       else{
        //  int Enumd = fm.ReadEnum();
             arr = fm.ReadEArray();
             e.id = Enum+1;
             arr.add(e);
             System.out.println( e.id +"id");
             Enum= 1+Enum;
             fm.WriteE(arr, Enum);
     
           }
    }
  
public Employee Search(String us) throws FileNotFoundException, IOException, ClassNotFoundException   {

        // int dcare = fm.ReadEnum();
         ArrayList<Employee> arr =fm.ReadEArray();
              int i=0;
              while( i < arr.size() ){
                   if(arr.get(i).username.equals(us)){
                       return arr.get(i);
                   }
               i++;
              }

           return null   ;
}

     public void modify(int id,Employee e) throws FileNotFoundException, IOException, ClassNotFoundException{
                  

          ObjectInputStream EFil = new ObjectInputStream(new FileInputStream("employee.bin"));
          int Enumd = fm.ReadEnum();
          ArrayList<Employee> arr  = fm.ReadEArray();
        int i;
        for( i=0;i<arr.size();i++){
            if(arr.get(i).id == id){
                break;
            }
        }
        arr.set(i, e);
        
            fm.WriteE(arr, Enumd);
     }
     
    public void delete(int id) throws FileNotFoundException, IOException, ClassNotFoundException{
        

          int Enumd = fm.ReadEnum();
          ArrayList<Employee> arr  = fm.ReadEArray();
        int i;
        for( i=0;i<arr.size();i++){
            if(arr.get(i).id == id){
                break;
            }
        }
        arr.remove(arr.get(i));
         fm.WriteE(arr, Enumd);
}


}