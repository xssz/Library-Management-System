package BookManageSystem;

import java.awt.Color;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewUser extends javax.swing.JFrame {

    ResultSet rs;
    Statement st;
    String a[];

    public ViewUser() {
        initComponents();
        getContentPane().setBackground(Color.GREEN);//设置背景颜色
        getContentPane().setLayout(null);//设置布局
         setLocationRelativeTo(null); //位置居中
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane13 = new javax.swing.JScrollPane();
        jt8 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jt8.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
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
                "User name", "User id", "Password", "Rent book", "Borrow time", "Last return time"
            }
        ));
        jt8.setMinimumSize(new java.awt.Dimension(40, 800));
        jt8.setName("jt8");
        jt8.setPreferredSize(new java.awt.Dimension(300, 600));
        jt8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jt8AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane13.setViewportView(jt8);

        getContentPane().add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 260));

        jLabel1.setFont(new java.awt.Font("新宋体", 1, 24)); // NOI18N
        jLabel1.setText("User ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 140, 30));

        jButton1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt8AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jt8AncestorAdded
        try {
            Connection connect = DBClass.getConnection();//连接数据库
            java.sql.Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select user_name,user_ID,user_Password,book_name,borrow_date,Back_date from user ");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();//获得列数
            DefaultTableModel tm = (DefaultTableModel) jt8.getModel();
            tm.setColumnCount(0);
            tm.setRowCount(0);//重置表格行列都为0
            for (int i = 1; i <= columnCount; i++) {
                tm.addColumn(rsmd.getColumnName(i));
                a = new String[columnCount];//增加列数与需要的相等
            }
            while (rs.next()) {

                for (int s = 0; s < columnCount; s++) {
                    a[s] = rs.getString(s + 1);//将内容添加到表格中
                }
                tm.addRow(a);//增加行数
            }

            tm.fireTableDataChanged();
            rs.close();
            statement.close();//结束语句
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e, e.getMessage(), WIDTH, null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, ex.getMessage(), WIDTH, null);
        }
    }//GEN-LAST:event_jt8AncestorAdded

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
     
    }//GEN-LAST:event_formMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            Connection connect = DBClass.getConnection();//连接数据库
            java.sql.Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select user_name,user_ID,user_Password,book_name,borrow_date,Back_date from user where user_ID='"+t2.getText()+"'");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();//获得列数
            DefaultTableModel tm = (DefaultTableModel) jt8.getModel();
            tm.setColumnCount(0);
            tm.setRowCount(0);//重置表格行列都为0
            for (int i = 1; i <= columnCount; i++) {
                tm.addColumn(rsmd.getColumnName(i));
                a = new String[columnCount];//增加列数与需要的相等
            }
            while (rs.next()) {

                for (int s = 0; s < columnCount; s++) {
                    a[s] = rs.getString(s + 1);//将内容添加到表格中
                }
                tm.addRow(a);//增加行数
            }

            tm.fireTableDataChanged();
            rs.close();
            statement.close();//结束语句
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e, e.getMessage(), WIDTH, null);
        } catch (Exception ex) {
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
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewUser().setVisible(true);//可见
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JTable jt8;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
