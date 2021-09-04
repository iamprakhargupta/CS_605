/*
 * NearlyPerfectNumber.java
 *
 * Version:
 *     16.0.2
 *
 * Revisions:
 *     Nil
 */

package hw1;
 
/**
 * This program implements Nearly perfect Numbers from lower limit 2 to upper limit 1000
 *
 * @author      Prakhar Gupta
 * @author      Urjita Rajendra Bedekar
 */

public class NearlyPerfectNumber {
	 /**
	   * This function returns array of prime numbers till N
	   *
	   * @param    n    Prime number upper limit
	   *
	   * @return        Array of prime numbers till n
	  */

	public static int[] getprime(int n){
		int Prime_Number[]=new int [n];// Array to store prime numbers
		int index =0;
		
		for (int i=2; i<=n; i++)
		{
		
		int flag=1;//Flag for checking prime number 
		for (int j=2;j<=i-1;j++)
		{
		if(i%j==0)
		{
		flag=0;
		break;
		}		
		}
		if(flag==1)
		{
			Prime_Number[index]=i;			
			index=index+1;	
		}}
		return Prime_Number; //Return array of prime numbers
		}	
		
	 	/**
	   * This function is main module to generate nearly perfect number between two limits 
	   *
	   * @param     Command line Arguments
	   *
	
	   	*/
		public static void main(String[] args)
		{
		
			int ulimit =1000;// upper limit argument
			int llimit=2;// lower limit argument
			int[] nprime=getprime(ulimit);//Get prime number
			
			for(int k=0;k<nprime.length-1;k++)
			{	
				String equation = "";// Equation of summation of prime numbers
				int sum=0;//Sum of prime numbers
				for(int j =0;j<=k+1;j++)
				{
					sum=sum+nprime[j];
					if(j==0)
					{
						equation = equation+nprime[0];
					}else
					{
						equation=equation+"+"+nprime[j];
					}							
				}
				if(sum<=ulimit && sum>=llimit)// Checking the prime number limit
				{
				System.out.println(sum+"    is a nearly perfect number. " 
				+equation);
				}else
				{
					break;
				}
			}
			}		
}


/*
 * Syntax References- 
 * 
 *  (https://docs.oracle.com/en/java/javase/16/)
 */
