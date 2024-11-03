package algorithms;

import java.util.HashSet;

public class PrimeNumber {
    private static HashSet<Integer> primes = new HashSet<>() {
        {
            boolean[] isPrime = new boolean[31608];
            for(int i=2; i<31608; i++) {
                if(!isPrime[i]) {
                    add(i);
                    for(int j=2*i; j<31608; j+=i) {
                        isPrime[j] = true;
                    }
                }
            }
        }
    };

    public static void main(String[] args) {
        System.out.println(primes);
    }
}
