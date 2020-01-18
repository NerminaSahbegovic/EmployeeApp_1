
package employeeapp.gui;

import employeeapp.HibernateUtil;
import employeeapp.employee.Employee;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class appView extends javax.swing.JFrame {
    
   
    public appView()throws HibernateException {
        initComponents();
        showAll();
    }
    
    public List<Employee> getEmployeeList(){
          
          
           Session session = HibernateUtil.createSessionFactory().openSession();
           Transaction tx = null;
           List<Employee> employeeList = null;
        
           try{
             tx = session.beginTransaction();
                
             employeeList = (List<Employee>)session.createQuery("FROM Employee").list();
             tx.commit();
             
           }catch(HibernateException e){
            if (tx != null){
            tx.rollback();
            }
        JOptionPane.showMessageDialog(null, "Error");
        
           }finally{
             HibernateUtil.close();
        }
          return employeeList; 
    }  
       
    
    public void showAll(){
       
           List<Employee> list = getEmployeeList();
           DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
           Object[] row = new Object[5];
           
           for(int i = 0;i<list.size(); i++){
           
           row[0]=list.get(i).getId();
           row[1]=list.get(i).getNameSurname();
           row[2]=list.get(i).getAge();
           row[3]=list.get(i).getAddress();
           row[4]=list.get(i).getIncome();
           
           model.addRow(row);
           
           }
       
       }
        
    public void showSearchRows(List<Employee> l){
       
           DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
           if (model.getRowCount() > 0) {
                    for (int s = model.getRowCount() - 1; s > -1; s--) {
                        model.removeRow(s);
                    }
                    
           Object[] row = new Object[5];
           
           for(int i = 0;i<l.size(); i++){
           
           row[0]=l.get(i).getId();
           row[1]=l.get(i).getNameSurname();
           row[2]=l.get(i).getAge();
           row[3]=l.get(i).getAddress();
           row[4]=l.get(i).getIncome();
          
           model.addRow(row);
          }
        }
    }
      
           public void updateTable(){
       
             DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                showAll();
       }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1_id = new javax.swing.JTextField();
        jTextField2_name = new javax.swing.JTextField();
        jTextField3_age = new javax.swing.JTextField();
        jTextField4_address = new javax.swing.JTextField();
        jTextField5_income = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1_insert = new javax.swing.JButton();
        jButton2_update = new javax.swing.JButton();
        jButton3_delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton_search = new javax.swing.JButton();
        jTextField_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Age");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Address");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Income");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Age", "Address", "Income"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1_insert.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1_insert.setText("INSERT");
        jButton1_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_insertActionPerformed(evt);
            }
        });

        jButton2_update.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton2_update.setText("UPDATE");
        jButton2_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_updateActionPerformed(evt);
            }
        });

        jButton3_delete.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton3_delete.setText("DELETE");
        jButton3_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_deleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Search employees by:");

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "AGE", "ADDRESS", "INCOME" }));

        jButton_search.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton_search.setText("SEARCH");
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_search, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1_insert)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2_update)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3_delete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5_income)
                            .addComponent(jTextField1_id, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2_name)
                            .addComponent(jTextField3_age)
                            .addComponent(jTextField4_address, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5_income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1_insert)
                            .addComponent(jButton2_update)
                            .addComponent(jButton3_delete))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_insertActionPerformed
     
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        
        try{
        tx = session.beginTransaction();
        
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(jTextField1_id.getText()));
        employee.setNameSurname(jTextField2_name.getText());
        employee.setAge(Integer.parseInt(jTextField3_age.getText()));
        employee.setAddress(jTextField4_address.getText());
        employee.setIncome(Integer.parseInt(jTextField5_income.getText()));
        
        session.save(employee);
        tx.commit();
        updateTable();
          
        }catch(HibernateException e){
            if (tx != null){
            tx.rollback();
            }
        JOptionPane.showMessageDialog(null, "Error");
        }
        finally{
             HibernateUtil.close();
        }
        
    }//GEN-LAST:event_jButton1_insertActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        jTextField1_id.setText(model.getValueAt(i, 0).toString());
        jTextField2_name.setText(model.getValueAt(i, 1).toString());
        jTextField3_age.setText(model.getValueAt(i, 2).toString());
        jTextField4_address.setText(model.getValueAt(i, 3).toString());
        jTextField5_income.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_updateActionPerformed
    
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        
        try{
        tx = session.beginTransaction();
        
        Query hqlQuery =session.createQuery("UPDATE Employee e set e.nameSurname=:nameSurname, e.age = :age, e.address= :address,e.income=:income"+" where e.id =:id");
            hqlQuery.setParameter("id",Integer.parseInt(jTextField1_id.getText()));
            hqlQuery.setParameter("nameSurname", jTextField2_name.getText());
            hqlQuery.setParameter("age", Integer.parseInt(jTextField3_age.getText()));
            hqlQuery.setParameter("address", jTextField4_address.getText());
            hqlQuery.setParameter("income", Integer.parseInt(jTextField5_income.getText()));
        
        
        hqlQuery.executeUpdate();
        
        tx.commit();
        updateTable();
            
        }catch(HibernateException e){
            if (tx != null){
            tx.rollback();
            }
        JOptionPane.showMessageDialog(null, "Error");
        }
        finally{
             HibernateUtil.close();
        }
        
    }//GEN-LAST:event_jButton2_updateActionPerformed

    private void jButton3_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_deleteActionPerformed
         
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        
        try{
        tx = session.beginTransaction();
        
        Query hqlQuery =session.createQuery("DELETE from Employee e  where e.id =:id");
        hqlQuery.setParameter("id",Integer.parseInt(jTextField1_id.getText()));
        
        hqlQuery.executeUpdate();
        
        tx.commit();
        updateTable();
            
        }catch(HibernateException e){
            if (tx != null){
            tx.rollback();
            }
        JOptionPane.showMessageDialog(null, "Error");
        }
        finally{
             HibernateUtil.close();
        }
            
    }//GEN-LAST:event_jButton3_deleteActionPerformed

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
       String dataToSearch = jTextField_search.getText();
       String criteria = jComboBox1.getSelectedItem().toString();
       
      // ResultSet rs;
      Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
       try {
          tx = session.beginTransaction();
        
       switch(criteria){
           case "ID":
               Query hqlQuery =session.createQuery("from Employee e  where e.id =:id");
               hqlQuery.setParameter("id",Integer.parseInt(dataToSearch));
        
               List searchList = hqlQuery.list();
               tx.commit();
              
               showSearchRows(searchList);
               break;
         
           case "NAME":
               Query hqlQuery1 =session.createQuery("from Employee e  where e.nameSurname like :nameSurname");
               hqlQuery1.setParameter("nameSurname",'%'+dataToSearch+'%');
        
               List searchList1 = hqlQuery1.list();
               tx.commit();
              
               showSearchRows(searchList1);
               break;    
           case "AGE":
               Query hqlQuery2 =session.createQuery("from Employee e  where e.age =:age");
               hqlQuery2.setParameter("age",Integer.parseInt(dataToSearch));
        
               List searchList2 = hqlQuery2.list();
               tx.commit();
              
               showSearchRows(searchList2);
               break;
           case "ADDRESS":
               Query hqlQuery3 =session.createQuery("from Employee e  where e.address like :address");
               hqlQuery3.setParameter("address",'%'+dataToSearch+'%');
        
               List searchList3 = hqlQuery3.list();
               tx.commit();
              
               showSearchRows(searchList3);
               break;   
              
           case "INCOME":
               Query hqlQuery4 =session.createQuery("from Employee e  where e.income =:income");
               hqlQuery4.setParameter("income",Integer.parseInt(dataToSearch));
        
               List searchList4 = hqlQuery4.list();
               tx.commit();
              
               showSearchRows(searchList4);
               break;
       }
         }catch(HibernateException e){
            if (tx != null){
            tx.rollback();
            }
        JOptionPane.showMessageDialog(null, "Error");
        }
        finally{
             HibernateUtil.close();
        }
      
    }//GEN-LAST:event_jButton_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_insert;
    private javax.swing.JButton jButton2_update;
    private javax.swing.JButton jButton3_delete;
    private javax.swing.JButton jButton_search;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1_id;
    private javax.swing.JTextField jTextField2_name;
    private javax.swing.JTextField jTextField3_age;
    private javax.swing.JTextField jTextField4_address;
    private javax.swing.JTextField jTextField5_income;
    private javax.swing.JTextField jTextField_search;
    // End of variables declaration//GEN-END:variables
}
