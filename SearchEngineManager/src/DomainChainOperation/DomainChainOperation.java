
package DomainChainOperation;

import DatabaseOperations.DomainOperations;
import DatabaseOperations.TableOperations;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DomainChainOperation 
{

    public void DomainChainOperation(String Domain)
    {
        new TableOperations().tableCreation("Domain",Domain);
        new DomainOperations().domain_Details_Inserting(Domain);
        new DomainOperations().domain_Terminology_Inserting(Domain,"");
    }

 
}
