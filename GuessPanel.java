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
		// TODO �Զ����ɵķ������
		super.paint(g);
		g.drawImage(new ImageIcon("img/background.jpg").getImage(), 0, 0, null);
		g.drawString(s + "", 95, 249);  //��ʾ��

	}

	public GuessPanel() {
		// TODO �Զ����ɵĹ��캯�����
		this.setFocusable(true);
		this.addMouseListener(this);
		text = new JTextField();
		text.setBounds(205, 123, 80, 21);
		text.setFont(new Font("����",Font.BOLD,20));
		//text.setHorizontalAlignment(JTextField.CENTER);
		this.add(text);
		this.text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO �Զ����ɵķ������
				super.keyPressed(e);
				int i = 0;
				if (e.getKeyCode() == 10 && text.getText() != "") {
					try {
						i = Integer.valueOf(text.getText());
					} catch (Exception ex) {
						s = "��������Ч��ֵ";
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
		target = r.nextInt(100);//���������
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		int x = e.getX(), y = e.getY();
		//�رմ���
		if (x > 367 && x < 367 + 24 && y > 5 && y < 5 + 23) {
			System.exit(0);
		}

		//�ж�
		else if (x > 295 && x < 295 + 18 && y > 123 && y <= 123 + 21) {
			int i = 0;

			try {
				i = Integer.valueOf(text.getText());
			} catch (Exception ex) {
				s = "��������Ч��ֵ";
				text.setText("");
				repaint();
				return;
			}
			func(i);
			repaint();

		}

		//�����Ұ�
		if (x > 86 && x < 86 + 80 && y > 163 && y < 163 + 26) {
			//text.setText("");
			s = "���մ���" + target;
			repaint();
		}

		//����һ��
		if (x > 230 && x < 230 + 80 && y > 163 && y < 163 + 26) {
			text.setText("");
			s = "";
			target = r.nextInt(100);
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
	}


	public void func(int num) {
		if (target == num) {
			s = num + "������";
		} else if (target < num) {
			if (target + 10 > num)
				s = num + " �ʹ�һ��";
			else if (target + 20 > num)
				s = num + "�Դ�һЩ";
			else if (target + 30 > num)
				s = num + "��ܶ���";
			else
				s = num + "̫����";
		} else if (target > num) {
			if (target - 10 < num)
				s = num + "��Сһ��";
			else if (target - 20 < num)
				s = num + "��СһЩ";
			else if (target - 30 < num)
				s = num + "С�ܶ���";
			else
				s = num + "̫С��";
		}
	}
}
