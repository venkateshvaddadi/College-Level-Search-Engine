package StringFormating;

import java.util.StringTokenizer;

public class StringTokenFormating
{
    public static void main(String args[])
    {
        String Sent="ganesh is  is  Sachin are The so great";
        StringTokenFormating stf=new StringTokenFormating();
        String Sent1=stf.CommonTermsStemmer(Sent);
        System.out.println(Sent1);
    }
public String CommonTermsStemmer(String x)
{
    x=x.toLowerCase();
    String CommonTerms[]={" they "," them "," and ","are"," is "," so "," of "," for "," to "," too "," the "};
    for(int i=0;i<CommonTerms.length;i++) 
    {
        x=x.replaceAll(CommonTerms[i]," ");
}
    return x;
}
    
public String Tokenizing_Formating(String Unformatted)
{
StringTokenizer st=new StringTokenizer(Unformatted,"-,_ .\n\t ");
String Formatted=st.nextToken();
while(st.hasMoreTokens())
{
Formatted=Formatted+"_"+st.nextToken();
}
return Formatted;
}
public String[][] ListOfTokens(String Unformatted)
{
String DDDeatils[][]=new String[100][1];
StringTokenizer st=new StringTokenizer(Unformatted,"_");
int i=0;
while(st.hasMoreTokens())
{
DDDeatils[i++][0]=st.nextToken();
}
String Result[][]=new String[i][2];
for(int j=0;j<i;j++)
{
Result[j][0]=""+j;
Result[j][1]=DDDeatils[j][0];
}

return Result;
}
public String[] Tokens(String Unformatted)
{
String DDDeatils[]=new String[100];
StringTokenizer st=new StringTokenizer(Unformatted," .,");
int i=0;
while(st.hasMoreTokens())
{
DDDeatils[i++]=st.nextToken();
}
String Result[]=new String[i];
for(int j=0;j<i;j++)
{

Result[j]=DDDeatils[j];
}

return Result;
}

}
