/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchenginemanager;

import Adders.DomainAdder;
import Adders.DomainDescriptionAdder;
import Adders.DomainTerminologyAdder;
import DatabaseOperations.TableOperations;
import Display.DomainDescriptionDisplay;
import Display.DomainDisplay;
import Display.DomainTerminologyDisplay;
import DomainDecider.DomainDecider;
import LoginForm.LoginChecking;
import LoginForm.LoginFormChecking;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import QueryResultDisplay.QueryResultsDisplay;
/**
 *
 * @author venkatesh
 */
public class SearchEngineManager extends javax.swing.JFrame {

    /**
     * Creates new form SearchEngineManager
     */
    public SearchEngineManager() {

       
        initComponents();
        setResizable(false);
           
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        InputQuery = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SearchEngineManager");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setName(""); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("SODHA");

        InputQuery.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        InputQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputQueryActionPerformed(evt);
            }
        });

        jButton1.setText("search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(InputQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel2)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InputQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jMenu1.setText("Domain");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Create");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("AddTerminology");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("AddDescription");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Display");

        jMenuItem8.setText("DomainDisplay");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("DomainTerminologyDisplay");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem7.setText("DomainDescriptionDisplay");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Update");

        jMenuItem10.setText("NoRecords");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Login");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Login");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Decision");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Logout");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try
        {
        if(loginForm.decision)
        {
        DomainAdder domainCreator=new DomainAdder();
        domainCreator.setVisible(true);
        }
        else
        {
        JOptionPane.showMessageDialog(null,"Please Login First.....");            
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please Activate WAMP server First");
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        try
        {
        if(loginForm.decision)
        {
        DomainTerminologyAdder domainJargonAdder=new DomainTerminologyAdder();
        domainJargonAdder.setVisible(true);
        }
        else
        {
        JOptionPane.showMessageDialog(null,"Please Login First.....");            
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please Activate WAMP server First");
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
  

        try{
        if(loginForm.decision)
        {
        DomainDescriptionAdder domainDetails=new DomainDescriptionAdder();
        domainDetails.setVisible(true);
        } 
        else
        {
        JOptionPane.showMessageDialog(null,"Please Login First.....");            
        }
        }
                catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please Activate WAMP server First");
        }

        
        
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void InputQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputQueryActionPerformed
     
     
    }//GEN-LAST:event_InputQueryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

String Query=InputQuery.getText();
DomainDecider domainDecider=new DomainDecider();
String Domains[]=null;
Domains=domainDecider.RelatedDomains(Query);

String ListOfDomains="List Of Domains:\n";
if(Domains!=null)
{
    for(int i=0;i<Domains.length;i++)
{
    ListOfDomains+=Domains[i]+"\n";
}
 JOptionPane.showMessageDialog(null, ListOfDomains);
QueryResultsDisplay queryResultsDisplay=new QueryResultsDisplay(Query);
queryResultsDisplay.setVisible(true);
}
else
{
    JOptionPane.showMessageDialog(null, "No Domains Found");
}
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        if(loginForm.decision==false)
        {
        loginForm.setVisible(true);
        }
        else
        {
        JOptionPane.showMessageDialog(null,"All Ready "+loginForm.ActivePerson+" Are Logined......");            
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        if(loginForm.decision)
        {
        JOptionPane.showMessageDialog(null,"All Ready "+loginForm.ActivePerson+" Are Logined......");
        }
        else
        {
        JOptionPane.showMessageDialog(null,"No One Is Logined........");
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

    if(loginForm.decision==true)
    {
    loginForm.decision=false;
    JOptionPane.showMessageDialog(null,loginForm.ActivePerson+" are successfully Logoout...");
    loginForm.setTextEmpty();
    loginForm.loginCheck.PasswordWrite(null);
   
    }
    else
    {
    JOptionPane.showMessageDialog(null,"You are Alreay Loggedoout...");
    }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        if(loginForm.decision)
        {
        DomainDescriptionDisplay domainDisplay=new DomainDescriptionDisplay();
        domainDisplay.setVisible(true);
        }
        else
        {
        JOptionPane.showMessageDialog(null,"Please Login First.....");    
        }
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        
        if(loginForm.decision)
        {
        DomainDisplay domainsDisplay=new DomainDisplay();
        domainsDisplay.setVisible(true);
        }
        else
        {
        JOptionPane.showMessageDialog(null,"Please Login First.....");   
        }
                
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        DomainTerminologyDisplay DtDisplay=new DomainTerminologyDisplay();
        DtDisplay.setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        new TableOperations().TotalUpdate();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    public void PasswordWrite(String Data)
{
try 
{
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

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) 
    {
        SearchEngineManager x = null;
        
        try
        {
        x=new SearchEngineManager();
        x.setVisible(true);
        }
        catch(Exception e)
        {
        }

         try
        {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.updateComponentTreeUI(x);
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
         
        }

    }
    LoginFormChecking  loginForm=new LoginFormChecking();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
