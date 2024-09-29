public class MathUtil {

    // Static Methods

    /**
     * Checks whether a given number n is prime.
     *
     * n the number to check
     * @return true if n is prime, otherwise false
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime
        if (n == 2) return true;  // 2 is the only even prime number
        if (n % 2 == 0) return false; // Other even numbers are not prime

        // Check for factors from 3 to the square root of n
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false; // Found a factor
        }
        return true; // No factors found, n is prime
    }

    /**
     * Calculates the greatest common divisor of two integers using the Euclidean algorithm.
     *
     * a first integer
     * b second integer
     * @return the GCD of a and b
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // GCD found
    }

    /**
     * Computes the least common multiple of two numbers.
     *
     * a first integer
     * b second integer
     * @return the LCM of a and b
     */
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b); // Use absolute value to avoid negative LCM
    }

    /**
     * Returns the nth Fibonacci number.
     *
     * n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative arguments are not allowed.");
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Using iteration for efficiency
        int a = 0, b = 1, fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib; // Return the nth Fibonacci number
    }

    /**
     * Calculates the factorial of a number n (i.e., n!).
     *
     * n the number to calculate the factorial for
     * @return the factorial of n
     */
    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers do not have factorials.");
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i; // Calculate factorial iteratively
        }
        return result; // Return the factorial
    }

    // Non-static Methods

    /**
     * Determines if the given number n is a perfect number.
     *
     * n the number to check
     * @return true if n is a perfect number, otherwise false
     */
    public boolean isPerfectNumber(int n) {
        int sum = 0;
        // Find divisors and calculate their sum
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i; // Add divisor
            }
        }
        return sum == n; // Check if sum of divisors equals the number
    }

    /**
     * Computes the sum of the digits of the given number n.
     *
     * n the number to compute the sum of digits for
     * @return the sum of the digits of n
     */
    public int sumOfDigits(int n) {
        int sum = 0;
        n = Math.abs(n); // Handle negative numbers
        while (n != 0) {
            sum += n % 10; // Add last digit
            n /= 10; // Remove last digit
        }
        return sum; // Return the sum of digits
    }

    /**
     * Reverses the digits of a number n.
     *
     * n the number to reverse
     * @return the number formed by reversing the digits of n
     */
    public int reverseNumber(int n) {
        int reversed = 0;
        n = Math.abs(n); // Handle negative numbers
        while (n != 0) {
            reversed = reversed * 10 + n % 10; // Build reversed number
            n /= 10; // Remove last digit
        }
        return reversed; // Return the reversed number
    }

    /**
     * Checks if a number is an Armstrong number.
     *
     * n the number to check
     * @return true if n is an Armstrong number, otherwise false
     */
    public boolean isArmstrongNumber(int n) {
        int original = n, sum = 0;
        int digits = String.valueOf(n).length(); // Count digits
        while (n != 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits); // Sum of digits raised to power of number of digits
            n /= 10; // Remove last digit
        }
        return sum == original; // Check if the sum equals the original number
    }

    /**
     * Finds the smallest prime number greater than n.
     *
     * n the number to check
     * @return the next prime number after n
     */
    public int nextPrime(int n) {
        n++; // Start searching from the next number
        while (!isPrime(n)) {
            n++; // Increment until a prime number is found
        }
        return n; // Return the next prime number
    }

    public static void main(String[] args) {
        // Test cases for static methods
        System.out.println("Static Method Tests:");
        System.out.println("isPrime(5): " + MathUtil.isPrime(5)); // true
        System.out.println("isPrime(10): " + MathUtil.isPrime(10)); // false
        System.out.println("isPrime(11): " + MathUtil.isPrime(11)); // true

        System.out.println("gcd(48, 18): " + MathUtil.gcd(48, 18)); // 6
        System.out.println("gcd(56, 98): " + MathUtil.gcd(56, 98)); // 14
        System.out.println("gcd(100, 25): " + MathUtil.gcd(100, 25)); // 25

        System.out.println("lcm(4, 5): " + MathUtil.lcm(4, 5)); // 20
        System.out.println("lcm(3, 7): " + MathUtil.lcm(3, 7)); // 21
        System.out.println("lcm(12, 15): " + MathUtil.lcm(12, 15)); // 60

        System.out.println("fibonacci(7): " + MathUtil.fibonacci(7)); // 13
        System.out.println("fibonacci(0): " + MathUtil.fibonacci(0)); // 0
        System.out.println("fibonacci(10): " + MathUtil.fibonacci(10)); // 55

        System.out.println("factorial(5): " + MathUtil.factorial(5)); // 120
        System.out.println("factorial(0): " + MathUtil.factorial(0)); // 1
        System.out.println("factorial(4): " + MathUtil.factorial(4)); // 24

        // Test cases for non-static methods
        MathUtil util = new MathUtil();
        System.out.println("\nNon-Static Method Tests:");
        System.out.println("isPerfectNumber(28): " + util.isPerfectNumber(28)); // true
        System.out.println("isPerfectNumber(12): " + util.isPerfectNumber(12)); // false
        System.out.println("isPerfectNumber(6): " + util.isPerfectNumber(6)); // true

        System.out.println("sumOfDigits(12345): " + util.sumOfDigits(12345)); // 15
        System.out.println("sumOfDigits(-6789): " + util.sumOfDigits(-6789)); // 30
        System.out.println("sumOfDigits(0): " + util.sumOfDigits(0)); // 0

        System.out.println("reverseNumber(12345): " + util.reverseNumber(12345)); // 54321
        System.out.println("reverseNumber(-54321): " + util.reverseNumber(-54321)); // 12345
        System.out.println("reverseNumber(100): " + util.reverseNumber(100)); // 1

        System.out.println("isArmstrongNumber(153): " + util.isArmstrongNumber(153)); // true
        System.out.println("isArmstrongNumber(123): " + util.isArmstrongNumber(123)); // false
        System.out.println("isArmstrongNumber(370): " + util.isArmstrongNumber(370)); // true

        System.out.println("nextPrime(5): " + util.nextPrime(5)); // 7
        System.out.println("nextPrime(10): " + util.nextPrime(10)); // 11
        System.out.println("nextPrime(14): " + util.nextPrime(14)); // 17
    }
}
