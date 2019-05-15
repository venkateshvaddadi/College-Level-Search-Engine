/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package LoginForm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginChecking
{
String Name="NoOne",Password="";
public void PreviouslyLogined()
{
    if(isPreviouslyLogined())
    {
    String person="";
    StringTokenizer st=new StringTokenizer(getPasswordFile(),"_");
    Name=st.nextToken();
    Password=st.nextToken();
    }
}
public String NamePreviouslyLogined()
{
    PreviouslyLogined();
    return Name;
}
public String PasswordPreviouslyLogined()
{
    PreviouslyLogined();
    return Password;
}

public boolean isPreviouslyLogined()
{
    if(getPasswordFile().length()>0)
    {
        return true;
    }
    return false;
}
public static void main(String args[])
{
System.out.print(""+new LoginChecking().NamePreviouslyLogined());
System.out.print(""+new LoginChecking().PasswordPreviouslyLogined());

}
public String ActivePerson="";
public boolean Checking(String AdminName,String AdminPassword)
{

String Name[]={"namovenkatesha","venkatesh","leela","mani","shiva"};
String Password[]={"namovenkatesha","11341A1254","11341A1235","11341A1253","shiva"};
for(int i=0;i<Name.length;i++)
{
if(AdminName.equals(Name[i])&&AdminPassword.equals(Password[i]))
{
ActivePerson=Name[i];
System.out.println(Name[i]);
PasswordWrite(AdminName+"_"+AdminPassword);
return true;
}
}
return false;
}
public void PasswordWrite(String Data)
{
try {
FileOutputStream fw=new FileOutputStream("Password.txt");
char buffer[] = new char[Data.length()];
Data.getChars(0, Data.length(), buffer, 0);
for (int i=0; i < buffer.length; i +=1 )
{
fw.write(buffer[i]);
System.out.println(""+buffer[i]);
}
System.out.println("success");
} catch (IOException ex) {
Logger.getLogger(LoginChecking.class.getName()).log(Level.SEVERE, null, ex);
}

}
public String getPasswordFile()
{
String x="";
int c;
try {
FileInputStream fis=new FileInputStream("Password.txt");
while((c=fis.read())!=-1)
{
x=x+(char)c;
}

} catch (IOException ex) {
Logger.getLogger(LoginChecking.class.getName()).log(Level.SEVERE, null, ex);
}
return x;
}
}


