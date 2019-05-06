package Admin;

import java.io.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulkader
 */
public class LogingFile{
    
    public boolean Search(String Username,String Password) throws IOException, FileNotFoundException, ClassNotFoundException
    { AdminFileManger find =new AdminFileManger();
        ArrayList <Employee> arr=find.ReadEArray();
        int i=0;
              while( i < arr.size() ){
                   if(arr.get(i).username.equals(Username) && arr.get(i).password.equals(Password)){
                       return true;
                   }
               i++;
              }
              return false;
    }
   }

