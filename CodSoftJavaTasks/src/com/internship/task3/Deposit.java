package com.internship.task3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
	JButton deposit,back,exit;
	JTextField amount;
	JLabel msg,text;
	UserBank user;
	
	public Deposit(UserBank usr) {
		user=usr;
		setLayout(null);
		setTitle("ATM Machine");
		
		text=new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,100,400,20);
		add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,150,320,25);
		add(amount);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(170,250,150,30);
		deposit.addActionListener(this);
		add(deposit);
		
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
		if(e.getSource()==deposit) {
			int num=Integer.parseInt(amount.getText());
			if(num<=0)
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
			else {
				String res=user.deposit(num);
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
