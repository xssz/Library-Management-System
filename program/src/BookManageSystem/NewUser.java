package BookManageSystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class NewUser extends javax.swing.JFrame {

    public NewUser() {
        initComponents();
        getContentPane().setBackground(Color.GREEN);  //设置背景颜色为绿色
        setLocationRelativeTo(null); //位置居中
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jt4 = new javax.swing.JTextField();
        jt2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        p = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));
        getContentPane().add(jt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 170, 30));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jButton1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        jButton2.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 100, -1));

        jLabel5.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Academy");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));
        getContentPane().add(jt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 170, 30));
        getContentPane().add(jt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 170, 30));

        jButton3.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, -1, -1));
        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 170, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/photo6.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Connection con = DBClass.getConnection();  //连接到数据库
            String str = "insert into user (user_name,user_ID,user_Password,acadamy) values(?,?,?,?)";  //将数据插入到数据库
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(str);
            ps.setString(1, jt1.getText());
            ps.setString(2, jt2.getText());
            ps.setString(3, p.getText());
            ps.setString(4, jt4.getText()); //获取输入的值
            if (jt1.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Empty User Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (jt2.getText().length() == 0) {  //检查输入值是否为空
                JOptionPane.showMessageDialog(this, "Empty User ID", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (p.getPassword().length == 0) { //检查密码是否为空
                JOptionPane.showMessageDialog(this, "Empty Password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (jt4.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Empty Academy", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                Pattern m1 = Pattern.compile("\\d{8}");//ID必须为八位整数
                Matcher m2 = m1.matcher(jt2.getText());
                boolean m3 = m2.matches();
                if (m3) {
                    Pattern h1 = Pattern.compile("\\d{4}"); //密码必须为四位整数
                    Matcher h2 = h1.matcher(p.getText());
                    boolean h3 = h2.matches();
                    if (h3) {
                        int ret = ps.executeUpdate();   //输入数据到数据库
                        if (ret > 0) {
                            JOptionPane.showMessageDialog(this, "You must remember your password is '" + p.getText() + "'");
                            JOptionPane.showMessageDialog(this, "You are success");
                            Login l = new Login();  //打开登陆界面
                            l.show();
                            dispose();  //关闭本界面
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong password, Password must 4 numbers", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong ID, ID must 8 numbers", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login l = new Login();
        l.show();
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewUser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt2;
    private javax.swing.JTextField jt4;
    private javax.swing.JPasswordField p;
    // End of variables declaration//GEN-END:variables
}
