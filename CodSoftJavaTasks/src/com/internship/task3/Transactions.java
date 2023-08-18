package com.internship.task3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener{

	JButton deposit,withdraw1,fastcash,ministatement,pinchange,balanceEnq,exit;
	UserBank user;
	public Transactions(UserBank acc) {
		user=acc;
		setLayout(null);
		setTitle("ATM Machine");
		
		JLabel text=new JLabel("Please select your Transaction");
		text.setBounds(200,100,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		add(text);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(170,215,150,30);
		deposit.addActionListener(this);
		add(deposit);
		
		withdraw1=new JButton("Cash Withdraw");
		withdraw1.setBounds(355,215,150,30);
		withdraw1.addActionListener(this);
		add(withdraw1);

		balanceEnq=new JButton("Balance Enquiry");
		balanceEnq.setBounds(170,285,150,30);
		balanceEnq.addActionListener(this);
		add(balanceEnq);
		
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
		if(e.getSource()==exit)
				System.exit(0);
		else if(e.getSource()==balanceEnq)
			JOptionPane.showMessageDialog(null,"Current Available Balance: Rs."+user.getBalance());
		else if(e.getSource()==withdraw1)
		{
			setVisible(false);
			new Withdraw(user).setVisible(true);
		}
		else if(e.getSource()==deposit)
		{
			setVisible(false);
			new Deposit(user).setVisible(true);
		}
	}
}