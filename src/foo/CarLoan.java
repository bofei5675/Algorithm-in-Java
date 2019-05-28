package foo;

public class CarLoan {
	public static void main(String[] args) {

	int carLoan = 10000;
	int loanLength = 3;
	int interstRate = 5;
	int downPayment = 2000;
	if ((loanLength <= 0)||(interstRate <= 0)){
	      System.out.println("you must take a valid car loan");
	    }else if(downPayment>=carLoan){
	      System.out.println("downPayment can not exceed car loan");
	    }else{
	      int remainingBalance=carLoan-downPayment;
	      int months=loanLength*12;
	      int monthlyBalance=remainingBalance/months;
	      int interst = monthlyBalance * interstRate /100;
	      int monthlyPayment=monthlyBalance+interst;
	      System.out.println(monthlyPayment);
	    }
	    

	 }
	}
