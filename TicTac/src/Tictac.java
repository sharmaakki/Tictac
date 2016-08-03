import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Tictac extends JFrame implements ActionListener {
	String s1 = "player 1", s2 = "player 2", stemp1 = "Noname1", stemp2 = "Noname2";
	int i, flag = 0, flag1 = 0, flag3 = 0, count1 = 0, count2 = 0, count3 = 0;
	JTextField tf1, tf2;
	JButton bt[] = new JButton[9];
	JButton bt10, bt11;
	JLabel l1, l2;
    JLabel l_background;
	public Tictac() {
		l_background=new JLabel();
		l_background.setBounds(0, 0, this.WIDTH,this.HEIGHT);
		for (i = 0; i <= 8; i++) {
			bt[i] = new JButton();

		}
		bt10 = new JButton("Start");
		bt11 = new JButton("Go");
		l1 = new JLabel("Welcome");
		l2 = new JLabel("ScoreBoard");
		tf1 = new JTextField("1st player");
		tf2 = new JTextField("2nd player");
		l1.setForeground(Color.BLACK);
		l2.setForeground(Color.BLACK);
		l1.setBackground(Color.RED);
		l2.setBackground(Color.RED);
		tf1.setBounds(50, 50, 110, 30);
		tf2.setBounds(50, 90, 110, 30);
		bt11.setBounds(170, 50, 50, 70);
		bt[0].setBounds(50, 130, 50, 30);
		bt[1].setBounds(110, 130, 50, 30);
		bt[2].setBounds(170, 130, 50, 30);
		bt[3].setBounds(50, 170, 50, 30);
		bt[4].setBounds(110, 170, 50, 30);
		bt[5].setBounds(170, 170, 50, 30);
		bt[6].setBounds(50, 210, 50, 30);
		bt[7].setBounds(110, 210, 50, 30);
		bt[8].setBounds(170, 210, 50, 30);
		bt10.setBounds(50, 250, 170, 50);
		l1.setBounds(50, 310, 200, 30);
		l2.setBounds(50, 350, 200, 30);
		for (i = 0; i <= 8; i++) {
			add(bt[i]);

			bt[i].setEnabled(false);
		}
		add(bt10);
		add(bt11);
		add(tf1);
		add(tf2);
		add(l1);
		add(l2);
		setLayout(null);
		setSize(300, 450);
		setVisible(true);
		bt11.setEnabled(false);
		tf1.setFocusable(false);
		tf2.setFocusable(false);
		for (int i = 0; i <= 8; i++) {
			bt[i].addActionListener(this);

		}
		bt10.addActionListener(this);
		bt11.addActionListener(this);
		tf1.addActionListener(this);
		tf2.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt10) {
			if (flag1 == 0) {
				tf1.setFocusable(true);
				tf2.setFocusable(true);
				bt11.setEnabled(true);
				bt10.setLabel("Restart");
				flag1 = 1;
				l2.setText("Match " + (count1 + count2 + 1) + " in progess");
			} else if (flag1 == 1) {
				tf1.setText(stemp1);
				tf2.setText(stemp2);
				l2.setText("Match " + (count1 + count2 + 1) + " in progess");
				tf1.setFocusable(true);
				tf2.setFocusable(true);
				s1 = tf1.getText();
				s2 = tf2.getText();
				System.out.println(stemp1);
				System.out.println(stemp2);
				if ((!stemp1.equals(s1)) || (!stemp2.equals(s2))) {
					count1 = 0;
					count2 = 0;
				}

				bt11.setEnabled(true);
				for (i = 0; i <= 8; i++) {
					bt[i].setLabel("");
					bt[i].setEnabled(false);
					bt[i].setBackground(Color.YELLOW);
				}
				l1.setText(s1 + "'s turn");
				flag3 = 0;
				flag = 0;
				count3 = 0;

			}
		}
		if (e.getSource() == bt11) {
			s1 = tf1.getText();
			s2 = tf2.getText();
			if ((!stemp1.equals(s1)) || (!stemp2.equals(s2))) {
				count1 = 0;
				count2 = 0;
			}
			stemp1 = s1;
			stemp2 = s2;
			tf1.setFocusable(false);
			tf2.setFocusable(false);
			bt11.setEnabled(false);
			for (i = 0; i <= 8; i++) {
				bt[i].setEnabled(true);
				bt[i].setBackground(Color.YELLOW);
			}
			l1.setText(s1 + "'s turn");
		}
		for (i = 0; i <= 8; i++) {
			if (e.getSource() == bt[i]) {
				if (flag == 0) {
					bt[i].setLabel("X");
					bt[i].setBackground(Color.BLUE);
					l1.setText(s2 + "'s turn");
					flag = 1;
					bt[i].setEnabled(false);
					count3++;

					System.out.println(count3);
					for (int j = 0; j <= 6; j = j + 3) {
						if ("X".equals(bt[j].getLabel()) && "X".equals(bt[j + 1].getLabel())
								&& "X".equals(bt[j + 2].getLabel())) {
							l1.setText(s1 + " wins," + s2 + " looses");
							flag3 = 1;
							count1++;
						}
					}
					for (int k = 0; k <= 2; k++) {
						if ("X".equals(bt[k].getLabel()) && "X".equals(bt[k + 3].getLabel())
								&& "X".equals(bt[k + 6].getLabel())) {
							l1.setText(s1 + " wins," + s2 + " looses");
							flag3 = 1;
							count1++;
						}
					}
					for (int l = 0; l <= 0; l++) {
						if ("X".equals(bt[l].getLabel()) && "X".equals(bt[l + 4].getLabel())
								&& "X".equals(bt[l + 8].getLabel())) {
							l1.setText(s1 + " wins," + s2 + " looses");
							flag3 = 1;
							count1++;
						}
					}
					for (int m = 2; m <= 2; m++) {
						if ("X".equals(bt[m].getLabel()) && "X".equals(bt[m + 2].getLabel())
								&& "X".equals(bt[m + 4].getLabel())) {
							l1.setText(s1 + " wins," + s2 + " looses");
							flag3 = 1;
							count1++;
						}
					}

					l2.setText(s1 + "-" + (count1 + "") + " " + s2 + "-" + (count2 + ""));
					if (count3 == 9) {
						l2.setText("Match Drawn,Play again");
					}
					if (flag3 == 1) {
						for (int i = 0; i <= 8; i++) {
							bt[i].setEnabled(false);
						}
					}
					break;

				}
				if (flag == 1) {
					bt[i].setLabel("0");
					bt[i].setBackground(Color.RED);
					l1.setText(s1 + "'s turn");
					flag = 0;
					bt[i].setEnabled(false);
					count3++;
					System.out.println(count3);
					for (int j = 0; j <= 6; j = j + 3) {
						if ("0".equals(bt[j].getLabel()) && "0".equals(bt[j + 1].getLabel())
								&& "0".equals(bt[j + 2].getLabel())) {
							l1.setText(s2 + " wins," + s1 + " looses");
							flag3 = 1;
							count2++;
						}
					}
					for (int k = 0; k <= 2; k++) {
						if ("0".equals(bt[k].getLabel()) && "0".equals(bt[k + 3].getLabel())
								&& "0".equals(bt[k + 6].getLabel())) {
							l1.setText(s2 + " wins," + s1 + " looses");
							flag3 = 1;
							count2++;
						}
					}
					for (int l = 0; l <= 0; l++) {
						if ("0".equals(bt[l].getLabel()) && "0".equals(bt[l + 4].getLabel())
								&& "0".equals(bt[l + 8].getLabel())) {
							l1.setText(s2 + " wins," + s1 + " looses");
							flag3 = 1;
							count2++;
						}
					}
					for (int m = 2; m <= 2; m++) {
						if ("0".equals(bt[m].getLabel()) && "0".equals(bt[m + 2].getLabel())
								&& "0".equals(bt[m + 4].getLabel())) {
							l1.setText(s2 + " wins," + s1 + " looses");
							flag3 = 1;
							count2++;
						}
					}

					l2.setText(s1 + "-" + (count1 + "") + " " + s2 + "-" + (count2 + ""));
					if (flag3 == 1) {
						for (int i = 0; i <= 8; i++) {
							bt[i].setEnabled(false);
						}
					}

					break;
				}
			}
		}
	}

	public static void main(String args[]) {
		Tictac obj = new Tictac();
	}

}
