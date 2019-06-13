package BookManageSystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class NewManager extends javax.swing.JFrame {

    public NewManager() {
        initComponents();
        getContentPane().setBackground(Color.GREEN);//背景颜色
        setLocationRelativeTo(null); //位置居中
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        jt2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        p = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("华文隶书", 1, 36)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("华文隶书", 1, 36)); // NOI18N
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("华文隶书", 1, 36)); // NOI18N
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        getContentPane().add(jt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 140, 30));
        getContentPane().add(jt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 140, 30));

        jButton1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        jButton2.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jButton3.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));
        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 140, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/photo5.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login2 l = new Login2();
        l.show();
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Connection con = DBClass.getConnection();  //实现连接
            String str = "insert into manager values(?,?,?)"; //sql语句，将数据输入到数据库
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(str);
            ps.setString(1, jt1.getText());
            ps.setString(3, p.getText());  //获取输入值
            ps.setString(2, jt2.getText());
            if (jt1.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Empty Manager Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (jt2.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Empty Manager ID", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (p.getPassword().length == 0) { //检查输入值是否为空
                JOptionPane.showMessageDialog(this, "Empty Password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                Pattern m1 = Pattern.compile("\\d{8}");//ID必须为八位整数
                Matcher m2 = m1.matcher(jt2.getText());
                boolean m3 = m2.matches();
                if (m3) {
                    int ret = ps.executeUpdate();//将数据输入到数据库
                    if (ret > 0) {
                        JOptionPane.showMessageDialog(this, "You must remember your password is '" + p.getText() + "'");//确认密码
                        JOptionPane.showMessageDialog(this, "You are success");
                        Login2 l2 = new Login2(); //打开用户登录界面
                        l2.show();
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong ID, ID must 8 numbers", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
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
            java.util.logging.Logger.getLogger(NewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewManager().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt2;
    private javax.swing.JPasswordField p;
    // End of variables declaration//GEN-END:variables
}
