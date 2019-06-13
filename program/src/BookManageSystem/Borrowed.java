package BookManageSystem;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Borrowed extends javax.swing.JFrame {

    ResultSet rs;
    Statement st;
    String a[];

    public Borrowed() {
        initComponents();
        getContentPane().setBackground(Color.GREEN);//设置背景颜色
       setLocationRelativeTo(null); //位置居中
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 400));
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Book_Name", "Rent_time", "Back_time"
            }
        ));
        jt1.setName("jt1");
        jt1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jt1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jt1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jt1AncestorAdded
        try {
            Login l = new Login();
            Connection connect = DBClass.getConnection();  //与数据库建立联系
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select book_name,borrow_date,Back_date from user where user_ID='" + l.id + "'");//从数据库中获得借书信息
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();  //获取表格列数
            DefaultTableModel tm = (DefaultTableModel) jt1.getModel();
            tm.setColumnCount(0);
            tm.setRowCount(0);//初始化表格行列数都为0
             for (int i = 1; i <= columnCount; i++) {
                    tm.addColumn(rsmd.getColumnName(i));
                    a = new String[columnCount];}
            while (rs.next()) {
                    for (int s = 0; s < columnCount; s++) {
                        a[s] = rs.getString(s + 1);
                    }
                
                tm.addRow(a); //增加表格行，列数与需要的行，列数相等
            }
            tm.fireTableDataChanged();
            rs.close();
            statement.close(); //结束编译
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e, e.getMessage(), WIDTH, null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
        }
    }//GEN-LAST:event_jt1AncestorAdded

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
            java.util.logging.Logger.getLogger(Borrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Borrowed().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jt1;
    // End of variables declaration//GEN-END:variables
}
