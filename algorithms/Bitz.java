package algorithms;

public class Bitz {

    public static void main(String[] args) {
        long x = 2, y = 14;
        System.out.println(x+ " ** " + y + " :" +  power(2, 14));
        System.out.println(x+ " + " + y + " :" + add(x, y));
        System.out.println(x + " - " + y + " :" + sub(x, y));
        System.out.println(x + " * " + y + " :" + mul(x, y));


        System.out.println("left shift by 3 : " + (1<<3));
        System.out.println("neg number in binary: " + Integer.toBinaryString(-2 & 2));
    }
    //record :
    //1. power(x, y)
    //2. add(x, y)

    public static long power(long x, long y) {
        long res  = 1;
        while(y != 0) {
            if((y&1) != 0) {
                res *= x;
            }
            x *= x;
            y >>= 1;
        }
        return res;
    }

    public static long add(long x, long y) {
        //add without carry with XOR
        //then add carry
        while(y > 0) {
            long carry = x&y;

            x = x ^ y;

            y = carry << 1;
        }
        return x;
    }

    public static long sub(long x, long y) {
        while(y != 0) {
            long carry = (~x) & y;
            x = x ^ y;

            y = carry << 1;
        }
        return x;
    }

    public static long mul(long x, long y) {
        long res = 0;
        while(y != 0) {
            if((y&1)!=0) {
                res += x;
            }
            x *= 2;
            y >>= 1;
        }
        return res;
    }

    public static long div(long x, long y) {
        return 1L;//need implementations
    }

    public static long twosComplement(long x) {
        //take negation of number and then add 1
        return add(~x, 1L);
    }
}
