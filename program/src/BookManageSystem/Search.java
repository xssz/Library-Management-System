
package BookManageSystem;

import java.awt.Color;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Search extends javax.swing.JFrame {
ResultSet rs;
    Statement st;
    String  a[]; 
    public Search() {
        initComponents();
        getContentPane().setBackground(Color.GREEN);
           setLocationRelativeTo(null); //位置居中
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        fns2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("华文楷体", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Book Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));
        getContentPane().add(fns2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 190, 40));

        jButton1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jt2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Book Name", "Author", "Publish", "Location", "Total Number", "Left Number"
            }
        ));
        jScrollPane1.setViewportView(jt2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 580, 220));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/photo8.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
    Connection connect = DBClass.getConnection();
    java.sql.Statement statement = connect.createStatement();
    ResultSet rs = statement.executeQuery("select book_name,author,publishing_house,book_location,total_number,left_num from books where book_name='"+fns2.getText()+"'");
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    DefaultTableModel tm = (DefaultTableModel) jt2.getModel();
    tm.setColumnCount(0);
    tm.setRowCount(0);
    while (rs.next()) 
    {
     for (int i = 1; i <= columnCount; i++ ) 
      {
        tm.addColumn(rsmd.getColumnName(i));
        a = new String[columnCount];
        for(int s = 0; s < columnCount; s++) 
        {
        a[s] = rs.getString(s+1);
        }
      }
        tm.addRow(a);
    }
    if(fns2.getText().length()==0)
    {
      JOptionPane.showMessageDialog(this, "Empty Book Name","Warning",JOptionPane.WARNING_MESSAGE);
    }
   tm.fireTableDataChanged();
   rs.close();
   statement.close();
}
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, "No this book", e.getMessage(), WIDTH, null);
    }
 catch (Exception ex)
 { 
    JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
 }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
    
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Search().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fns2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt2;
    // End of variables declaration//GEN-END:variables
}
