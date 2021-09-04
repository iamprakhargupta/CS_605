package hw1;

/*
 * Water.java
 *
 * Version:
 * 16.0.2
 *
 * Revisions:  
 * NA
 *
 */



/**
 * This program displays maximum amount of buckets the if no command line arguments are supplied
 *
 * and minimum amount of buckets otherwise.
 *
 * @author Urjita Rajendra Bedekar
 *
 * @author Prakhar Gupta
 */

public class abc
{
int[] myVolumes; //Capacities of buckets available

public static int power(int x,int y)
{
int a=1; //initialize placeholder
for(int i=0;i<y;i++)
{
a=a*x;
}
return a;
}

/**
 * Given the available buckets, generate all the combinations and return them as an integer.
 *
 * @param    myVolumes    Volumes of buckets available
 *
 * @return    combination    Array of all combinations
 */

public static int[] GenerateCombination(int [] myVolumes)
{
   
String[] combination= new String[70]; //array of combinations
String str = new String(); //string of single combination
char[][] ch = new char[70][40]; //character array to represent each bucket
int n = myVolumes.length; //to store number of available buckets

double maxBinary = power(2,n); //total number of combinations
int sum[] = new int[70]; //stores sum of volumes of all buckets in a combination

//getting binary values to represent each combination
for (int i=0;i<maxBinary;i++)
{
if(i<2)
{
str = "00000"+Integer.toBinaryString(i);
} else if(i<4) {
str = "0000"+Integer.toBinaryString(i);
} else if(i<8) {
str = "000"+Integer.toBinaryString(i);
} else if(i<16) {
str = "00"+Integer.toBinaryString(i);
} else if(i<32) {
str = "0"+Integer.toBinaryString(i);
} else {
str = Integer.toBinaryString(i);
}

for(int j=0;j<str.length();j++)
{
ch[i][j]=str.charAt(j);
}
}

for (int i=0;i<maxBinary;i++)
{
for (int j=0;j<6;j++)
{
if(ch[i][j]=='1')
{
    combination[i]=combination[i] + String.valueOf(myVolumes[j]);
}
}
}

for (int i=1;i<maxBinary;i++)
{
combination[i]=combination[i].substring(4);
}

int x1[]=new int[70];

for (int i=0; i<maxBinary; i++)
{
if(combination[i]!= null)
{
int num = Integer.parseInt(combination[i]);
x1[i]=num;
}
}
return x1;
}

/**
 * calculates sum of digits of an integer.
 *
 * @param     n    integer for which sum of digits is calculated
 *
 * @return    sum    sum of digits
 */

public static int getSum(int n)
{    
    int sum = 0; //initializing sum to zero
    while (n != 0)
    {
        sum = sum + n % 10;
        n = n/10;
    }
return sum;
}

/**
 * Counts number of digits in an integer,
 *
 * integer represents combination and the count represents number of buckets
 *
 * @param    n    integer
 *
 * @return    count    number of digits
 */

public static int countDigit(int n)
{
int count=0; //initializing count to zero
while (n!=0)
{
n=n/10;
count=count+1;
}
return count;
}

public static String getSumString(int n)
{
    String str = new String();
    str="";
    String s=new String();
    s="";
   
    int num;
    while (n!=0)
    {
    	if(n>9) {
    		num=n%10;
    		s=String.valueOf(num) + "+";
    		str = str + s;
    		n=n/10;
    	}
    	else {
num=n%10;
s=String.valueOf(num);
str = str + s;
n=n/10;
    }}
    return str;
}

public static int maxLength(int [] a)
{
    int i; //for iterationn over the loop
    int max = a[0];
   
    for (i = 1; i < a.length; i++)
        if (a[i] > max)
            max = a[i];
   
    return max;
}

/**
 * Function which returns maximum amount of buckets.
 *
 * @param    myVolumes    Volumes of available buckets
 *
 * @param    bucketsToFill    Volumes of buckets to fill
 */

public static void maxBuckets(int [] myVolumes, int [] bucketsToFill)
{
int combination[] = new int[64]; // combination of available buckets
int sum[] = new int[70]; //sum of volumes in a single combination
int l[]=new int[70]; //length of combination or number of buckets in a combination
String[] sum_string = new String[70];
int n = myVolumes.length; //length of myVolumes
double m = power(2,n); //total number of combinations

combination=GenerateCombination(myVolumes);

for(int i=0;i<m;i++)
{
int num = combination[i];
sum[i]= getSum(num);
l[i]=countDigit(num);
sum_string[i] = getSumString(num);
}


for(int i=0;i<bucketsToFill.length;i++)
{
int b=bucketsToFill[i]; //volume of bucket to fill
int temp=0; //combination with maximum amount of buckets
int loc=0; //location of combination with maximum amount of buckets

for (int j=0;j<m;j++)
{
//traverse sum array
if (b==sum[j])
{
if (l[j]>temp)
{
//store the max length in temp
temp=l[j];
loc = j;
}
}
}
System.out.println(String.valueOf(bucketsToFill[i])
+"L bucket can be filled with " + getSumString(combination[loc]));
}

}

/**
 * Function which returns minimum amount of buckets.
 *
 * @param    myVolumes    Volumes of available buckets
 *
 * @param    bucketsToFill    Volumes of buckets to fill
 */

public static void minBuckets(int [] myVolumes, int [] bucketsToFill)
{
int combination[] = new int[64]; // combination of available buckets
combination=GenerateCombination(myVolumes); //sum of volumes in a single combination
int sum[] = new int[70]; //length of combination or number of buckets in a combination
int l[]=new int[70]; //length of combination or number of buckets in a combination
int n = myVolumes.length; //length of myVolumes
double m = power(2,n); //total number of combinations

for(int i=0;i<m;i++)
{
int num = combination[i];
sum[i]= getSum(num);
l[i]=countDigit(num);

}


for(int i=0;i<bucketsToFill.length;i++)
{
int b=bucketsToFill[i];
int temp=10;
int loc=0;

for (int j=0;j<m;j++)
{
if (b==sum[j])
{
if (l[j]<temp)
{
temp=l[j];
loc = j;
}
}
}

System.out.println(String.valueOf(bucketsToFill[i])
+"L bucket can be filled with " + getSumString(combination[loc]));
}
}

public static void main(String args[])
{
int[] myVolumes = { 1, 1, 2, 4, 5, 6 }; //volume of buckets available
int[] bucketsToFill = { 1, 2, 3, 4, 6, 7, 8, 9 }; //volume of buckets to fill
boolean largestAmountOfUsedBuckets = true;
if ( args.length > 0 )
largestAmountOfUsedBuckets = false;

if (largestAmountOfUsedBuckets)
{
    maxBuckets(myVolumes,bucketsToFill);
}
else
{
    minBuckets(myVolumes,bucketsToFill);
}
}
}
