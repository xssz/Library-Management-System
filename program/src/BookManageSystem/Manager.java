package BookManageSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
//定义类时 实现监听接口
public class Manager extends JFrame implements ActionListener {
    JButton b0, b1, b2;//添加三个按钮
    ViewUser v = new ViewUser();//实现用户信息界面
    Viewbook V2 = new Viewbook();//实现书籍信息界面
    NewData n = new NewData();//实现跟新数据jiem
    Panel cardPanel = new Panel();
    Panel controlpaPanel = new Panel();
    CardLayout card = new CardLayout();  //定义卡片布局对象
    String cardName[] = {"0", "1", "2"};   //定义字符数组，为卡片命名
    public Manager() {
        setSize(900, 600);//设置大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);//设置可见
        //设置cardPanel面板对象为卡片布局
        cardPanel.setLayout(card);
        Font f = new Font("宋体", Font.BOLD, 20);//设置字体
        //循环，在cardPanel面板对象中添加3个按钮
        //因为cardPanel面板对象为卡片布局，因此初始时显示最先添加的组件
        for (int i = 0; i < 3; i++) {
            //面板中添加的每个按钮对应设置一个卡片名
            cardPanel.add(cardName[i], new JButton(""));
        }
        //实例化按钮对象
        b0 = new JButton("View Book");//为按钮命名
        b0.setFont(f);//设置字体
        b1 = new JButton("View Users");
        b1.setFont(f);
        b2 = new JButton("Update Book");
        b2.setFont(f);
        //为按钮对象注册监听器
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        controlpaPanel.add(b0);
        controlpaPanel.add(b1);
        controlpaPanel.add(b2);
        //定义容器对象为当前窗体容器对象
        Container container = getContentPane();
        //将 cardPanel面板放置在窗口边界布局的中间，窗口默认为边界布局
        container.add(cardPanel, BorderLayout.CENTER);
        // 将controlpaPanel面板放置在窗口边界布局的南边，
        container.add(controlpaPanel, BorderLayout.NORTH);
    }
    //实现按钮的监听触发时的处理
    public void actionPerformed(ActionEvent e) {
        //用户单击b0按钮时执行的语句
        if (e.getSource() == b0) {
            V2.show();//显示书籍信息
            v.dispose();//关闭其他界面
            n.dispose();
        }
        if (e.getSource() == b1) {
            v.show();//显示用户数据
            V2.dispose();
            n.dispose();//关闭其他界面
        }
        if (e.getSource() == b2) {
            n.show();//显示新数据界面
            V2.dispose();
            v.dispose();//关闭其他界面
        }
    }
    public static void main(String[] args) {
        Manager kapian = new Manager();//实现函数
    }
}
