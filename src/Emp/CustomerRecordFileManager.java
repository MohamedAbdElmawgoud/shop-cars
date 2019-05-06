package Emp;

import Admin.FileManager;
import Admin.vehicle;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Abdulkader
 */
public class CustomerRecordFileManager {
    FileManager FManger = new FileManager();
public final String cusRecordFileType ="CustomerRecord.bin";
public static ArrayList<CustomerRecord> cusRecord =new ArrayList<>();
    
    public int lastId(){
    readFromFile();
    if(cusRecord.size()==0)return 1;
    return cusRecord.get(cusRecord.size()-1).ID+1;
}
public boolean addcusRecord(CustomerRecord v)
{
 readFromFile();
 cusRecord.add(v);
         return writeInFile();
}
public boolean writeInFile()
{
 return FManger.Write(cusRecordFileType,cusRecord);

}

public void readFromFile() {
      cusRecord = (ArrayList<CustomerRecord>) FManger.Read(cusRecordFileType,cusRecord);
    }
public int getcusRecord(int id)
{
    int i;
  for(i=0;i<cusRecord.size();i++)
  {
  System.out.println("1"+i);
  if(cusRecord.get(i).ID==id)
      
      return i;
      
  }
    return -1;
}
public CustomerRecord searchcusRecord(int id)
{
    readFromFile();
    int index = getcusRecord(id);
    System.out.println(1);
    if(index!=-1)
    
    {
        return  cusRecord.get(index);
    }
        return null;
    }
public boolean updatecusRecord(int oldId,CustomerRecord v)
{ readFromFile();
int index = getcusRecord(oldId);
if(index!=-1)
{ cusRecord.set(index, v);
 return writeInFile();

}
return false;
}
public boolean deletecusRecord(int oldId)
{ readFromFile();
int index = getcusRecord(oldId);
if(index!=-1)
{ cusRecord.remove(index);
 return writeInFile();

}
return false;
}



}


class CustomerRecord implements Serializable{
    int ID;
    String Name;
    String Gender;
    String Address;
    int PhoneNum;
    String UsedAs;
    int NofRentingDays;
    boolean Driver;
    int VehicleNum;
    Date RentDate;
    String DriverName;

    public CustomerRecord(int ID, String Name, String Gender, String Address, int PhoneNum, String UsedAs, int NofRentingDays,int VehicleNum,boolean Driver,String DriverName, Date RentDate) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.PhoneNum = PhoneNum;
        this.UsedAs = UsedAs;
        this.NofRentingDays = NofRentingDays;
        this.RentDate = RentDate;
        this.Driver=Driver;
        this.VehicleNum=VehicleNum;
        this.DriverName=DriverName;
        
    }
    
}
