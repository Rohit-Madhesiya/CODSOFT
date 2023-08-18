package com.internship.task4;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CurrencyConvertor extends JFrame implements ActionListener{
	JComboBox fromCombo,toCombo;
	JButton submit;
	JTextField amount;
	JLabel resL;
	CurrencyConvertor(){
		setLayout(null);
		
		JLabel heading=new JLabel("CURRENCY CONVERTOR");
		heading.setBounds(200,100,300,30);
		heading.setFont(new Font("Raleway",Font.BOLD,24));
		heading.setForeground(Color.WHITE);
		add(heading);
		
		JLabel fromCr=new JLabel("From Currency ");
		fromCr.setFont(new Font("Raleway",Font.BOLD,20));
		fromCr.setBounds(120,150,200,30);
		fromCr.setForeground(Color.WHITE);
		add(fromCr);
		
		fromCombo=new JComboBox(new String[] {"Choose One..","India(Rupee)-INR","USA(Dollar)-USD","Australia(AUS Dollar)-AUD","NewZealand-NZD","CHINA-CNY","COLOMBIA-COP","EGYPT-EGP","FRANCE-EUR","GERMANY-EUR","ICELAND-ISK","IRAN-IRR","JAPAN-JPY","KOREA-KRW","NEPAL-NPR","PAKISTAN-PKR","RUSSIA-RUB","SAUDI ARABIA-SAR","SINGAPORE-SGD","SOUTH AFRICA-ZAR","SRI LANKA-LKR",""});
		fromCombo.setBounds(120,180,200,25);
		fromCombo.setBackground(Color.WHITE);
		fromCombo.setFont(new Font("Raleway",Font.BOLD,14));
		add(fromCombo);
		
		JLabel toCr=new JLabel("To Currency ");
		toCr.setBounds(350,150,200,30);
		toCr.setForeground(Color.WHITE);
		toCr.setFont(new Font("Raleway",Font.BOLD,20));
		add(toCr);
		
		toCombo=new JComboBox(new String[] {"Choose One..","India(Rupee)-INR","USA(Dollar)-USD","Australia(AUS Dollar)-AUD","NewZealand-NZD","CHINA-CNY","COLOMBIA-COP","EGYPT-EGP","FRANCE-EUR","GERMANY-EUR","ICELAND-ISK","IRAN-IRR","JAPAN-JPY","KOREA-KRW","NEPAL-NPR","PAKISTAN-PKR","RUSSIA-RUB","SAUDI ARABIA-SAR","SINGAPORE-SGD","SOUTH AFRICA-ZAR","SRI LANKA-LKR",""});
		toCombo.setBounds(350,180,200,25);
		toCombo.setBackground(Color.WHITE);
		toCombo.setFont(new Font("Raleway",Font.BOLD,14));
		add(toCombo);
		
		JLabel amountL=new JLabel("Amount");
		amountL.setFont(new Font("Raleway",Font.BOLD,20));
		amountL.setBounds(120,220,180,30);
		amountL.setForeground(Color.WHITE);
		add(amountL);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,14));
		amount.setBounds(230,220,320,25);
		add(amount);
		
		resL=new JLabel("");
		resL.setBounds(120,260,400,30);
		resL.setFont(new Font("Raleway",Font.BOLD,20));
		resL.setForeground(Color.RED);
		
		add(resL);	
		
		submit=new JButton("Submit");
		submit.setBackground(Color.WHITE);
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(300,300,100,30);
		submit.addActionListener(this);
		add(submit);

		getContentPane().setBackground(Color.black);
		setSize(700,500);
		setLocation(350,200);
		setVisible(true);
	}
	public static void main(String args[]) {
		new CurrencyConvertor();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
			String tocr=(String)toCombo.getSelectedItem();
			String fromcr=(String)fromCombo.getSelectedItem();
			int num=Integer.parseInt(amount.getText());
			fromcr=fromcr.substring(fromcr.length()-3,fromcr.length());
			tocr=tocr.substring(tocr.length()-3,tocr.length());
			String data=null;
			System.out.println(tocr+", "+fromcr);
			try {
			data=ExchangeRateService.queryExchangeRates(new String[] {fromcr,tocr});
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			double toresult=ExchangeRateService.parseRate(tocr, data);
			double fromresult=ExchangeRateService.parseRate(fromcr, data);
			if(toresult<0||fromresult<0) {
				resL.setText("Try Again Later...");
				return;
			}
			toresult=(toresult*num)/fromresult;
			String result=num+""+fromcr+" = "+ String.format("%.6f", toresult)+tocr;
			resL.setText(result);
	}

}
