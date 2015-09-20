package guess;

import javax.swing.JFrame;

public class GuessFrame extends JFrame{
	public GuessFrame() {
		// TODO 自动生成的构造函数存根
		this.setSize(400, 300);
		this.setLocation(300, 200);
		this.setUndecorated(true);
		MoveUtil mu = new MoveUtil(this);
		// AWTUtilities.setWindowOpaque(this, false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuessPanel panel = new GuessPanel();
		panel.frame = this;
		this.add(panel);
		panel.setLayout(null);
		mu.move();
	//	JLabel label = new JLabel(new ImageIcon("img/background.jpg"));
	//	this.add(panel);b
	//	this.add(label);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		GuessFrame frame = new GuessFrame();
	}
}
