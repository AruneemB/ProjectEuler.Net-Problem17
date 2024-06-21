public class NumberLetterCounts
{
    public static final String[] numbersUpToNineteen =
    {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    public static final String[] numbersTens =
    {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String numberToWords(int number)
    {
        if(number == 1000) return "onethousand";
        else if(number >= 100)
        {
            int hundreds = number/100;
            int remainder = number%100;
            if(remainder == 0) return numbersUpToNineteen[hundreds] + "hundred";
            else return numbersUpToNineteen[hundreds] + "hundredand" + numberToWords(remainder);
        }
        else if(number >= 20)
        {
            int tens = number/10;
            int remainder = number%10;
            if(remainder == 0) return numbersTens[tens];
            else return numbersTens[tens] + numbersUpToNineteen[remainder];
        }
        return numbersUpToNineteen[number];
    }

    public static long numberLetterCounts(int bound)
    {
        long totalLetterCount = 0;

        for(int i = 1; i <= bound; i++) totalLetterCount += numberToWords(i).length();

        return totalLetterCount;
    }

    public static void main(String[] args)
    {
        System.out.println(numberLetterCounts(1000));
    }
}
