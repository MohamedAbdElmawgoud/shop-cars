
package Admin;


import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminFileManger {
  public int ReadEnum()throws FileNotFoundException,IOException, ClassNotFoundException{

          ObjectInputStream EFil = new ObjectInputStream(new FileInputStream("employee.bin"));
          int Enum = (int)EFil.readObject();
          EFil.close();
          return Enum;
}
  public ArrayList<Employee> ReadEArray() throws FileNotFoundException, IOException, ClassNotFoundException{

          ObjectInputStream EFil = new ObjectInputStream(new FileInputStream("employee.bin"));
          int  Enumd = (int)EFil.readObject();
          ArrayList<Employee> arr  = (ArrayList<Employee>)EFil.readObject();
          EFil.close();
          return arr;
}  
  public void WriteE(ArrayList<Employee> arr,int Enum) throws FileNotFoundException, IOException{
      
         ObjectOutputStream EF = new ObjectOutputStream(new FileOutputStream("employee.bin"));
         EF.writeObject(Enum);
         EF.writeObject(arr);
         EF.close();
 
  }
}
