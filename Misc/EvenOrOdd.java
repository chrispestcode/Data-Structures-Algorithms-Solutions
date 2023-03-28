// Write a program in Java to check if a number is even or odd in Java?
// Time: 2min
// Complexity: O(1) Space: O(1)
// Take away: Practice for outputting useful information even in simple functions
class EvenOrOdd {
    static boolean isEven(int num) {
        if(num % 2 == 0) {
            System.out.println(num + " is Even");
            return true;
        }
        System.out.println(num + " is Odd");
        return false;
    }

    public static void main(String[] args) {
        isEven(3);
        isEven(2);
        isEven(10);
        isEven(1234243);
        isEven(11);
        isEven(53);
        isEven(0);
        isEven(3123418);
    }
}