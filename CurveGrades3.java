// -------------------------------------------------------------------------------------------------------------------------------------------//
//	CurveGrades3.java 					Author: Debra Ragland 				CPSC 50100														  //
//																																			  //
// Program is designed to iteratively prompt user for student exam and assignment scores (4 each) and compute the average, standard deviation,//
// 	and curved grade based on this information. 																							  //
//																																			  //
//--------------------------------------------------------------------------------------------------------------------------------------------//

import java.util.*;

public class CurveGrades3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double[] exams = new double[4];
		double[] assignments = new double[4];
		double[] totalclasspoints = new double[100];
		double average = 0;
		double indipoints = 0;
		double sd = 0;

		System.out.println("Enter the number of students:");
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println("Enter Scores for Student" + " " + (i + 1)); // prompt for number of students

			for (int j = 0; j < 4; j++) {
				System.out.println("Enter Exam" + " " + (j + 1) + " " + "Score(0-50):"); // prompt exam scores
				exams[j] = scan.nextInt();
			}
			for (int k = 0; k < 4; k++) {
				System.out.println("Enter Assignment" + " " + (k + 1) + " " + "Score(0-75):"); // prompt assignments scores
				assignments[k] = scan.nextInt();
			}

			int examsum = 0;
			for (double value : exams) {
				examsum += value;
			}
			int assnsum = 0;
			for (double value : assignments) {
				assnsum += value;
			}
			indipoints = (examsum + assnsum);
			System.out.println("The total number of points for this student is:" + indipoints); //print the number of points for each student

			if (indipoints >= 450 && indipoints <= 500) {
				System.out.println("The student currently has an A.");
			} else if (indipoints >= 400 && indipoints <= 500) {
				System.out.println("The student currently has a B.");
			} else if (indipoints >= 350 && indipoints <= 500) {
				System.out.println("The student currently has a C.");
			} else if (indipoints >= 300 && indipoints <= 500) {
				System.out.println("The student currently has a D.");
			} else {
				System.out.println("The student currently has a F."); // based on raw point total, print the students' grade based on the standard scale
			}
			totalclasspoints[i] = indipoints;
			double totalnum = 0;
			for (double value : totalclasspoints) {
				totalnum += value;
			}
			System.out.println("The total class points so far are:" + totalnum); 

			average = (totalnum / num);
			System.out.println("The current average is: " + average); //calculate and print the average
		}
		for (int i = 1; i <= num; i++) {

			sd += (indipoints - average) * (indipoints - average);
		}
		sd /= num;
		sd = Math.sqrt(sd);
		System.out.println("The current standard deviation is: " + sd); // calculate and print the standard deviation
	

		for (int i = 0; i < num; i++) {
			System.out.println("For student" + " " + (i + 1));
			if (totalclasspoints[i] >= (average + (2 * sd)) &&  totalclasspoints[i] <= 500) {
				System.out.println("The students' curved grade is A");
			} else if (totalclasspoints[i] >= (average + (1 * sd)) && totalclasspoints[i] <= 500){
				System.out.println("The students' curved grade is B");
			} else if (totalclasspoints[i] >= average && totalclasspoints[i] <= 500){
				System.out.println("The students' curved grade is C");
			} else if (totalclasspoints[i] >= (average - (1 * sd)) && totalclasspoints[i] <= 500){	
				System.out.println("The students' curved grade is D");
			} else {
				System.out.println("The students' curved grade is F"); // for each student, based on the values for the average and standard deviation, print the curved grade for each student
			}
		}
		scan.close();
	}
	
}
