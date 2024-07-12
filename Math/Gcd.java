package Math;

public class Gcd {
    public static void main(String[] args) {
        System.out.println(gcd(2, 6));
    }

    public static int gcd(int a, int b) {
        if(a%b == 0) return b;
        else if(b%a == 0) return a;
        return gcd(b, a%b);
    }
}
