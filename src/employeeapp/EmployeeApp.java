
package employeeapp;

import employeeapp.gui.appView;
import org.hibernate.HibernateException;

public class EmployeeApp {

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new appView().setVisible(true);
            } catch (HibernateException ex) {
                
            }
        });
        
       
        
    }
        
 }
    

