/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package OtherRequirement;


public class Alphabets {

public static void main(String args[])
{
new Alphabets().returningAlphabets();
}
public String[] returningAlphabets()
{
String Alpha[]=new String[26];
for(int i=0;i<26;i++)
{
Alpha[i]=""+(char)(i+65);
}
return Alpha;
}
}
