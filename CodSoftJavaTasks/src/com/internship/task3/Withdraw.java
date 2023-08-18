package com.internship.task3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Withdraw extends JFrame implements ActionListener{
	UserBank user;
	JButton withdraw,back,exit;
	JTextField amount;
	JLabel msg,text;
	Withdraw(UserBank usr){
		user=usr;
		setLayout(null);
		setTitle("ATM Machine");
		
		text=new JLabel("Enter the amount to Withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,100,400,20);
		add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,150,320,25);
		add(amount);
		
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(170,250,150,30);
		withdraw.addActionListener(this);
		add(withdraw);
		
		back=new JButton("Back");
		back.setBounds(355,250,150,30);
		back.addActionListener(this);
		add(back);
		
		exit=new JButton("Exit");
		exit.setBounds(355,285,150,30);
		exit.addActionListener(this);
		add(exit);
		
		getContentPane().setBackground(Color.BLACK);
		setSize(800,450);
		setLocation(300,200);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw) {
			int num=Integer.parseInt(amount.getText());
			if(num<=0)
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
			else {
				String res=user.withdraw(num);
				JOptionPane.showMessageDialog(null,res);
			}
			amount.setText("");
		}else if(e.getSource()==back) {
			setVisible(false);
			new Transactions(user).setVisible(true);;
		}else if(e.getSource()==exit)
			System.exit(0);
	}

}
