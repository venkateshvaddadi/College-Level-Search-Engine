package DomainDecider;

import Checking.*;


public class HighRelatedShowing {
    public static void main(String args[])
    {
     String Test[]={"Cinema_Tickets","Currency","Discussion_Forum","Employment","Encyclopedia","Florist","Game_and_Downloads","Magazine","OLXin","onlineshoping","Online_Jobs","Tutorials","onlineshoping"};
     String Result[]=new HighRelatedShowing().HighlyRelated(Test);
     System.out.println("Results is :");
     for(int i=0;i<Result.length;i++)
     {
         System.out.println(""+Result[i]);
     }
    }
    
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
