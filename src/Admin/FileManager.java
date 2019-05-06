package Admin;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;





public class FileManager implements  Serializable {
    public boolean Write(String path,Object data)
    {
      try {   
      ObjectOutputStream pr = new ObjectOutputStream (new FileOutputStream(path));
      pr.writeObject(data);
          pr.close();
          return true;
      }catch(IOException e) {
            System.out.println("Can't write ...!\n" + e);
        }

        return false;
    
    
}
public Object Read(String path,Object data)
{ 
 Object Result;
 boolean tfa=false;

        try {
            System.out.println("Reading ! From " + path);

            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(path));

            Result = Reader.readObject();
            Reader.close();
            return Result;

        } catch (IOException e) {
            tfa=Write(path,data);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(tfa){
           Result= Read(path,data);
           return Result;
        }
        return null;


    }


}