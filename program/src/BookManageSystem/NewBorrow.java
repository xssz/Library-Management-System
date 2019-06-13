package BookManageSystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class NewBorrow extends javax.swing.JFrame {

    public NewBorrow() {
        initComponents();
        getContentPane().setBackground(Color.GREEN);
    setLocationRelativeTo(null); //位置居中

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        fns = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Book ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
        getContentPane().add(fns, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 170, 30));

        jButton1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jButton1.setText("Borrow");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/photo3.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Login l = new Login();
            Connection con = DBClass.getConnection();   //连接到数据库
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); //获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置时间格式
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.MONTH, 1);//将时间增加一个月
            Date dt1 = rightNow.getTime();
            String reStr = sdf.format(dt1);
            String str1 = "insert into user (user_name,user_ID,user_Password,acadamy ,book_name,borrow_date,Back_date,book_id,book_location) select  user_name,user_ID,user_Password,acadamy ,book_name,replace(borrow_date,'2018-07-01','2000-03-06'),replace( Back_date,'2018-07-30','2000-4-3' ),book_id,book_location from user where user_ID='" + l.id + "'";
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate(str1);  //将时间数据输入到数据库         
            String str3 = "update user set book_id='" + fns.getText() + "',borrow_date='" + sqlDate + "',Back_date='" + reStr + "' where user_ID='" + l.id + "' limit 1 ";
            String str4 = "update books set left_num=left_num-1,rent_number=rent_number+1 where id='" + fns.getText() + "'";//将剩下的书的数量减一
            String str5 = "update user ,books set user.book_name=books.book_name,user.book_location=books.book_location WHERE books.id=user.book_id";
            PreparedStatement ps3 = (PreparedStatement) con.prepareStatement(str3);
            PreparedStatement ps4 = (PreparedStatement) con.prepareStatement(str4);
            PreparedStatement ps5 = (PreparedStatement) con.prepareStatement(str5);
            int ret = stmt.executeUpdate(str3);
            ps4.executeUpdate();
            ps5.executeUpdate();

            System.out.println(ret);
            if (ret > 0) {
                JOptionPane.showMessageDialog(this, "You are success");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
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
            java.util.logging.Logger.getLogger(NewBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewBorrow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fns;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
