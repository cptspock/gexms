package tests;

public class SumOfDigits
{
  public static long SumOfNumbers ( String str ) throws ArithmeticException
  {
    long sum = 0;
    int index = 0;
    int currentNumber = 0;
    int sign = 1;
    if (str == null) return sum;
    while (index < str.length())
    {
      //Check for negative sign
      if ( str.charAt(index) == '-')
      {
        sign = -1;
        index++;
      }
 
      boolean increment = true;
      while (index < str.length() && isDigit(str.charAt(index)))	
      {
        currentNumber *= 10;
        currentNumber += str.charAt(index) - '0'; // diff will give the int value 
        index++;
        increment = false;
      }
       
      sum += currentNumber * sign;
      currentNumber = 0;
      if (increment)
        index++;
      sign = 1;
    }
     
    return sum;
  }
 
  private static boolean isDigit(char c)
  {
    return ( c >= '0' && c <= '9');
  }
 
  public static void main(String[] args)
  {
    String test1 = "abcd1234e5";
    System.out.println(SumOfNumbers(test1));
    String test2 = "dFD$#23+++12@#T1234;/.,10";
    System.out.println(SumOfNumbers(test2));
    String test3 = "abcd";
    System.out.println(SumOfNumbers(test3));
    String test4 = "12345";
    System.out.println(SumOfNumbers(test4));
    String test5 = "1234 5 6";
    System.out.println(SumOfNumbers(test5));
    String test6 = "1234 5-6";
    System.out.println(SumOfNumbers(test6));
 }
}
