/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SearchEngineOptimizer;

import DomainDecider.HighRelatedShowing;

/**
 *
 * @author venkatesh-PC
 */
public class SearchEngineOptimizer {
    
        public String[] HighlyRelated(String Test[])
    {
        String Unique[]=null;
       try
       {
        Unique=new HighRelatedShowing().Unique(Test);
        int freq[]=new int[Unique.length];
        for(int i=0;i<Unique.length;i++)
        {
            freq[i]=new HighRelatedShowing().Frequency(Unique[i], Test);
            System.out.println(Unique[i]+"---"+freq[i]);
        }    
        for(int j=0;j<Unique.length;j++)
        {
        for(int i=0;i<Unique.length-1;i++)
        {
         if(freq[i]<freq[i+1])
         {
             int ITemp=freq[i];
             freq[i]=freq[i+1];
             freq[i+1]=ITemp;
             String STemp=Unique[i];
             Unique[i]=Unique[i+1];
             Unique[i+1]=STemp;
             
         }   
         
        }
        }
        for(int i=0;i<Unique.length;i++)
        {
            System.out.println(""+Unique[i]);
        }
        
        

       }
       catch(Exception e)
       {
       }
        return Unique;
    } 
    
    public int Frequency(String x,String Test[])
    {
        int Unique=0;
        for(int i=0;i<Test.length;i++)
        {
            if(x.equals(Test[i]))
            {
                Unique++;
            }
        }
        return Unique;
    }
    public String[] Unique(String Test[])
    {
    String result[]=new String[Test.length];
    int length=0;
    result[length++]=Test[0];
    for(int i=1;i<Test.length;i++)
    {
        boolean dec=true;
        for(int j=0;j<length;j++)
        {
            if(result[j].equals(Test[i]))
            {
                dec=false;
            }
        }
        if(dec)
        {
            result[length++]=Test[i];
         
        }
    } 
    System.out.println("Unique are :"+length);
    String Target[]=new String[length];
    for(int i=0;i<length;i++)
    {
       // System.out.println(""+result[i]);
        Target[i]=result[i];
    }
    return Target;
    }
    

}
