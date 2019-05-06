/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Shoukry
 */
public class vehicle implements Serializable {
 
public boolean RentState=false;    
public String brand ;
public String model ;

public String use ;  // use  taxi or invd
public String Ac; // Ac or non Ac // 
public String variant; // basemodel ,Econimacmodel or topmodel
    public int num,year,rent_value,engine,sitcap;

FileManager FManger = new FileManager();
public final String vehicleFileType ="vehicle.bin";
public  ArrayList<vehicle> vehicle =new ArrayList<>();


public int lastId(){
    readFromFile();
    if(vehicle.size()==0)return 1;
    return vehicle.get(vehicle.size()-1).num+1;
}
public boolean addvehicle(vehicle v)
{
 readFromFile();
 vehicle.add(this);
         return writeInFile();
}
public boolean writeInFile()
{
 return FManger.Write(vehicleFileType,vehicle);

}


public void readFromFile() {
      vehicle = (ArrayList<vehicle>) FManger.Read(vehicleFileType,vehicle);
    }


public int getvehicleNum(int num)
{
    readFromFile();
    int i;
  for(i=0;i<vehicle.size();i++)
  {
  System.out.println("1"+i);
  if(vehicle.get(i).num==num)
      
      return i;
      
  }
    return -1;
}
public vehicle searchvehicle(int num)
{
    readFromFile();
    int index = getvehicleNum(num);
    System.out.println(1);
    if(index!=-1)
    
    {
        return  vehicle.get(index);
    }
        return null;
    }
public boolean updatevehicle(int oldId,vehicle v)
{ readFromFile();
int index = getvehicleNum(oldId);
if(index!=-1)
{ vehicle.set(index, v);
 return writeInFile();

}
return false;
}
public boolean deletevehicle(int oldId)
{ readFromFile();
int index = getvehicleNum(oldId);
if(index!=-1)
{ vehicle.remove(index);
 return writeInFile();

}
return false;
}

public int[] tablesearch(String brand,String use,boolean State)
{
    readFromFile();
    int c=0;
        int[] indexes=new int[vehicle.size()];
  for(int i=0;i<vehicle.size();i++)
  {
  if( vehicle.get(i).brand.equals(brand) && vehicle.get(i).use.equals(use) && vehicle.get(i).RentState==State )
        {
            indexes[c]=i;
            c++;
            
        }else{
      indexes[c]=-1;
      c++;
  }
  System.out.println(indexes[i]);
  }
    return indexes;
}
public String[][] getTableInfo(String brand,String use,boolean State){
    readFromFile();
    
    int []indexes=tablesearch(brand,use,State);
    
    String x[][]=new String[indexes.length][11]; 
    int c=0;
    for(int i=0;i<indexes.length;i++){
        if(indexes[i]!=-1){
            
        System.out.println(indexes[i]);        
        x[c][0]=vehicle.get(indexes[i]).brand;
        x[c][1]=vehicle.get(indexes[i]).model;
        x[c][2]=vehicle.get(indexes[i]).num+"";
        x[c][3]=vehicle.get(indexes[i]).engine+"";
        x[c][4]=vehicle.get(indexes[i]).sitcap+"";
        x[c][5]=vehicle.get(indexes[i]).year+"";
        x[c][6]=vehicle.get(indexes[i]).RentState+"";
        x[c][7]=vehicle.get(indexes[i]).variant;
        x[c][8]=vehicle.get(indexes[i]).use;
        x[c][9]=vehicle.get(indexes[i]).Ac;
        x[c][10]=vehicle.get(indexes[i]).rent_value+"";
        c++;
        }
    }
   
    return x;
}

public int[] tablesearch(String brand)
{
    readFromFile();
    System.out.println(vehicle.get(0).brand);
    int c=0;
        int[] indexes=new int[vehicle.size()];
  for(int i=0;i<vehicle.size();i++)
  {
  if( vehicle.get(i).brand.equals(brand) && !vehicle.get(i).RentState)
        {
            
            indexes[c]=i;
            
            c++;
            
        }else{
      indexes[c]=-1;
      c++;
  }
  System.out.println(indexes[i]);
  }
    return indexes;
}


public void setvehicleState(int vehNum,boolean update){
    
int index = getvehicleNum(vehNum);
vehicle v=searchvehicle(vehNum);
v.RentState=update;
updatevehicle(vehNum,v);

}

 public ArrayList<vehicle> arraylistreturn(){
    readFromFile();
  return  vehicle;   
 }
 public int getvehvalue(int num)
{
    readFromFile();
    int index = getvehicleNum(num);
    if(index!=-1)
    
    {
        return  vehicle.get(index).rent_value;
    }
        return -1;
    }
        }