package com.internship.task2;

import java.util.Scanner;

public class GradeCalculator {
	static String getGrade(double percentage) {
		if(percentage>=90)
			return "A+";
		else if(percentage>=80)
			return "A";
		else if(percentage>=70)
			return "B+";
		else if(percentage>=60)
			return "B";
		else if(percentage>=50)
			return "C+";
		else if(percentage>=40)
			return "C";
		else if(percentage>=33)
			return "D";
		else
			return "F";
	}
	public static void main(String[] args) {
		System.out.println("---------------STUDENT GRADE CALCULATOR--------------\n");
		System.out.print("Enter the number of Subjects: ");
		Scanner scan=new Scanner(System.in);
		int numberOfSubjects=scan.nextInt();
		String subject[]=new String[numberOfSubjects];
		int marks[]=new int[numberOfSubjects];
		int totalMarks=0;
		for(int i=0;i<numberOfSubjects;i++) {
			System.out.print("Enter the name of Subject "+(i+1)+": ");
			subject[i]=scan.next();
			System.out.print("Enter the Marks(Out of 100):");
			marks[i]=scan.nextInt();
			totalMarks+=marks[i];
			System.out.println();
		}
		double percentage=totalMarks/numberOfSubjects;
		String grade=GradeCalculator.getGrade(percentage);
		
		System.out.println("\n\t\t---------------RESULT---------------\n");
		System.out.println("----------------------------------------------------------------");
		System.out.println("\tSUBJECT\t\tTOTAL MARKS\t\tOBTAINED MARKS\t\t");
		System.out.println("----------------------------------------------------------------");
		for(int i=0;i<numberOfSubjects;i++) {
			System.out.println("\t"+subject[i]+"\t\t\t100\t\t"+marks[i]+"\t\t");
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("\t\tPERCENTAGE: "+percentage+"%"+"\t\tGRADE: "+grade);
		System.out.println("----------------------------------------------------------------");
		scan.close();
	}

}
