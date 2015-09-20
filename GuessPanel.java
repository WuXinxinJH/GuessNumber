package guess;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessPanel extends JPanel implements MouseListener{
	int target;
	Random r = new Random();
	Point location;
	Point p = new Point();
	int x, y;
	String s = "";
	JTextField text;
	GuessFrame frame;

	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		g.drawImage(new ImageIcon("img/background.jpg").getImage(), 0, 0, null);
		g.drawString(s + "", 95, 249);  //提示框

	}

	public GuessPanel() {
		// TODO 自动生成的构造函数存根
		this.setFocusable(true);
		this.addMouseListener(this);
		text = new JTextField();
		text.setBounds(205, 123, 80, 21);
		text.setFont(new Font("宋体",Font.BOLD,20));
		//text.setHorizontalAlignment(JTextField.CENTER);
		this.add(text);
		this.text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				super.keyPressed(e);
				int i = 0;
				if (e.getKeyCode() == 10 && text.getText() != "") {
					try {
						i = Integer.valueOf(text.getText());
					} catch (Exception ex) {
						s = "请输入有效数值";
						text.setText("");
						repaint();
						return;
						
					}
					func(i);
					text.setText("");
					repaint();
				}
				repaint();
			}
		});
		target = r.nextInt(100);//产生随机数
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseDragged(e);
				int px = e.getX();
				int py = e.getY();
				int dx = px - x;
				int dy = py - y;
				frame.setLocation(frame.getLocation().x + dx,
						frame.getLocation().y + dy);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		int x = e.getX(), y = e.getY();
		//关闭窗口
		if (x > 367 && x < 367 + 24 && y > 5 && y < 5 + 23) {
			System.exit(0);
		}

		//判断
		else if (x > 295 && x < 295 + 18 && y > 123 && y <= 123 + 21) {
			int i = 0;

			try {
				i = Integer.valueOf(text.getText());
			} catch (Exception ex) {
				s = "请输入有效数值";
				text.setText("");
				repaint();
				return;
			}
			func(i);
			repaint();

		}

		//告诉我吧
		if (x > 86 && x < 86 + 80 && y > 163 && y < 163 + 26) {
			//text.setText("");
			s = "最终答案是" + target;
			repaint();
		}

		//再来一次
		if (x > 230 && x < 230 + 80 && y > 163 && y < 163 + 26) {
			text.setText("");
			s = "";
			target = r.nextInt(100);
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
	}


	public void func(int num) {
		if (target == num) {
			s = num + "猜中啦";
		} else if (target < num) {
			if (target + 10 > num)
				s = num + " 就大一点";
			else if (target + 20 > num)
				s = num + "略大一些";
			else if (target + 30 > num)
				s = num + "大很多了";
			else
				s = num + "太大了";
		} else if (target > num) {
			if (target - 10 < num)
				s = num + "就小一点";
			else if (target - 20 < num)
				s = num + "略小一些";
			else if (target - 30 < num)
				s = num + "小很多了";
			else
				s = num + "太小了";
		}
	}
}
