/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emp;

import Admin.FileManager;
import java.io.Serializable;
import java.util.ArrayList;

public class DriverRecordFileManager {
    FileManager FManger = new FileManager();
public final String driveRecordFileType ="DriverRecord.bin";
public static ArrayList<DriverRecord> driveRecord =new ArrayList<>();
int x=-1;
    
    public int lastId(){
    readFromFile();
    if(driveRecord.size()==0)return 1;
    return driveRecord.get(driveRecord.size()-1).ID+1;
}
public boolean adddriveRecord(DriverRecord v)
{
 readFromFile();
 driveRecord.add(v);
         return writeInFile();
}
public boolean writeInFile()
{
 return FManger.Write(driveRecordFileType,driveRecord);

}

public void readFromFile() {
      driveRecord = (ArrayList<DriverRecord>) FManger.Read(driveRecordFileType,driveRecord);
    }
public int getdriveRecord(int id)
{
    int i;
  for(i=0;i<driveRecord.size();i++)
  {
  System.out.println("1"+i);
  if(driveRecord.get(i).ID==id)
      
      return i;
      
  }
    return -1;
}
public DriverRecord searchdriveRecord(int id)
{
    readFromFile();
    int index = getdriveRecord(id);
    System.out.println(1);
    if(index!=-1)
    
    {
        return  driveRecord.get(index);
    }
        return null;
    }
public boolean updatedriveRecord(int oldId,DriverRecord v)
{ readFromFile();
int index = getdriveRecord(oldId);
if(index!=-1)
{ driveRecord.set(index, v);
 return writeInFile();

}
return false;
}
public boolean deletedriveRecord(int oldId)
{ readFromFile();
int index = getdriveRecord(oldId);
if(index!=-1)
{ driveRecord.remove(index);
 return writeInFile();

}
return false;
}
 public ArrayList<DriverRecord> arraylistreturn(){
    readFromFile();
  return  driveRecord;   
 }

 public String returnName(){
     readFromFile();
     x++;
    
 return driveRecord.get(x).Name;
 }
     
    

}




class DriverRecord implements Serializable{
    int ID;
    String Name;
    String Gender;
    String Address;
    int PhoneNum;
    int experience;
    String BirthDate;
        public DriverRecord(int ID, String Name, String Gender, String Address, int PhoneNum,  int experience, String BirthDate) {
            this.ID = ID;
            this.Name = Name;
            this.Gender = Gender;
            this.Address = Address;
            this.PhoneNum = PhoneNum;
            this.experience = experience;
            this.BirthDate = BirthDate;
        }

       

    }
    

