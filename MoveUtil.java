package guess;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class MoveUtil {
	JFrame f;
	int x, y, ax, ay;

	public MoveUtil(JFrame f) {
		// TODO 自动生成的构造函数存根
		this.f = f;
	}

	public void move() {

		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mousePressed(e);
				x = e.getX();
				y = e.getY();
			}
		});
		f.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseDragged(e);
				ax = e.getX();
				ay = e.getY();
				int dx = ax - x;
				int dy = ay - y;
				f.setLocation(f.getLocation().x +dx, f.getLocation().y+dy);
			}
		});
	}
}
