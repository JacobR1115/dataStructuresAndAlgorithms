public class Main {
    public static void main(String[] args) {
        if (args.length == 2 ) {
            Long value1 = Long.valueOf(args[0]);
            Long value2 = Long.valueOf(args[1]);

            double result = karatsubaMultiplication(value1, value2);
            String finalFinal = Double.toString(result);
            System.out.println(value1 + " * " + value2 + " = " + finalFinal);
        }
    }

    public static long karatsubaMultiplication (long x, long y) {
        // If we have divided the values until their minimum length then we multiply
        // Checking only if input is within range
        if (x < 10 && y < 10) {

            // Multiplying the inputs entered
            return x * y;
        }

        // Declaring variables in order to
        // Find length of both integer
        // numbers x and y
        int noOneLength = numLength(x);
        int noTwoLength = numLength(y);

        // Finding maximum length from both numbers
        // using math library max function
        int maxNumLength
                = Math.max(noOneLength, noTwoLength);

        // Rounding up the divided Max length
        Integer halfMaxNumLength
                = (maxNumLength / 2) + (maxNumLength % 2);

        // Multiplier
        long maxNumLengthTen
                = (long)Math.pow(10, halfMaxNumLength);

        // Compute the expressions
        long a = x / maxNumLengthTen;
        long b = x % maxNumLengthTen;
        long c = y / maxNumLengthTen;
        long d = y % maxNumLengthTen;


        // Compute all mutilpying variables
        // needed to get the multiplication
        long z0 = karatsubaMultiplication(a, c);
        long z1 = karatsubaMultiplication(a + b, c + d);
        long z2 = karatsubaMultiplication(b, d);

        long ans = (z0 * (long)Math.pow(10, halfMaxNumLength * 2) +
                ((z1 - z0 - z2) * (long)Math.pow(10, halfMaxNumLength) + z2));

        return ans;

    }


    public static int numLength(long n)
    {
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
        }

        // Returning length of number n
        return noLen;
    }
}
