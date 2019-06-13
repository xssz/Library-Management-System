package BookManageSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

//定义类时 实现监听接口
public class User extends JFrame implements ActionListener {

    JButton b0, b1, b2, b3;//设置四个按钮
    Borrowed b = new Borrowed();
    Search s = new Search(); //实现四个函数
    NewBorrow nb = new NewBorrow();
    Return r = new Return();
    Panel cardPanel = new Panel();
    Panel controlpaPanel = new Panel();
    CardLayout card = new CardLayout(); //定义卡片布局对象
    String cardName[] = {"0", "1", "2", "3"}; //定义字符数组，为卡片命名

    public User() {
        setSize(1000, 600);     //设置窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //位置居中
        setVisible(true);         //实现可见性
        cardPanel.setLayout(card);       //设置cardPanel面板对象为卡片布局
        Font f = new Font("宋体", Font.BOLD, 24);//设置字体
        //循环，在cardPanel面板对象中添加4个按钮
        //因为cardPanel面板对象为卡片布局，因此初始时显示最先添加的组件
        for (int i = 0; i < 4; i++) {
            //面板中添加的每个按钮对应设置一个卡片名
            cardPanel.add(cardName[i], new JButton(""));
        }
        //实例化按钮对象
        b0 = new JButton("Borrowed Book");//为按钮命名
        b0.setFont(f);//设置字体
        b1 = new JButton("Borrow New Book");
        b1.setFont(f);
        b2 = new JButton("Search Book");
        b2.setFont(f);
        b3 = new JButton("Return Book");
        b3.setFont(f);
        //为按钮对象注册监听器
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        controlpaPanel.add(b0);
        controlpaPanel.add(b1);
        controlpaPanel.add(b2);
        controlpaPanel.add(b3);
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
            b.show(); //显示已借阅界面
            nb.dispose();
            r.dispose();//关闭其他界面
            s.dispose();
        }
        if (e.getSource() == b1) {
            nb.show(); //显示借阅界面
            b.dispose();
            r.dispose();//关闭其他界面
            s.dispose();
        }
        if (e.getSource() == b2) {
            s.show();//显示搜索界面
            nb.dispose();
            r.dispose();//关闭其他界面
            b.dispose();
        }
        if (e.getSource() == b3) {
            r.show();//显示还书界面
            nb.dispose();
            b.dispose();//关闭其他界面
            s.dispose();
        }
    }

    public static void main(String[] args) {
        User ka = new User();
    }
}
