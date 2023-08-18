package com.internship.task3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMMachine extends JFrame implements ActionListener {
	JButton loginBtn,clearBtn,signBtn;
	JTextField cardTextField;
	JPasswordField pinTextField;
	UserBank userAccount;
	ATMMachine(){
		userAccount=new UserBank(75173459,1212);
		
		setLayout(null);
		setTitle("ATM Machine");
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setBounds(200,40,400,40);
		text.setFont(new Font("Osward",Font.BOLD,38));
		add(text);

		JLabel cardno=new JLabel("Account No.:");
		cardno.setBounds(120,150,400,30);
		cardno.setFont(new Font("Osward",Font.BOLD,28));
		add(cardno);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300,150,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("PIN:");
		pin.setBounds(120,220,250,40);
		pin.setFont(new Font("Osward",Font.BOLD,28));
		add(pin);
		
		pinTextField=new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		loginBtn=new JButton("SIGN IN");
		loginBtn.setBounds(300,300,100,30);
		loginBtn.setBackground(Color.BLACK);
		loginBtn.setForeground(Color.WHITE);
		add(loginBtn);
		loginBtn.addActionListener(this);
		
		getContentPane().setBackground(Color.BLACK);
		setSize(800,450);
		setVisible(true);
		setLocation(350,200);
	}
	
	public static void main(String[] args) {
		new ATMMachine();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginBtn) {
			int accNum=Integer.parseInt(cardTextField.getText());
			int pin=Integer.parseInt(new String(pinTextField.getPassword()));
			if((userAccount.getAccountNumber()==accNum)&&(userAccount.getPin()==pin)) {
				setVisible(false);
				new Transactions(userAccount).setVisible(true);
			}else
				JOptionPane.showMessageDialog(null, "Incorrect Account Number or Pin");
		}
	}
}
