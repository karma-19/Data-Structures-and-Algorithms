package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringSol {
    static ArrayList<String> allSubsequences = new ArrayList<>();
    static ArrayList<String> allPermutations = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String str = "aabb";
//        System.out.println(remDup(str));
//        getAllPerm(str, "");
//        System.out.println(allPermutations);
//        getAllSubsequences(str, "");
//        System.out.println(allSubsequences);

        //Rabin karp
        search("geek", "geeksforgeeks");
    }

    //rabin karp algo
    static void search(String pat, String txt) {
        int base = 2;
        int mod = 101;
        map.clear();
        for(int i=0; i<26; i++) {
            map.put((char)(i+'a'), i+1);
        }

        int patternHash = createHash(pat, base, mod);
        int currHash = createHash(txt.substring(0, pat.length()), base, mod);
        for(int i=0; i<txt.length()-pat.length()+1; i++) {
            if(currHash == patternHash) {
                int j= 0;
                for(j=0; j<pat.length(); j++) {
                    if(pat.charAt(j) != txt.charAt(i+j)) {
                        break;
                    }
                }
                if(j == pat.length()) {
                    System.out.println("Pattern found at index : " + i);
                }
                if(i < txt.length()-pat.length()) {
                    int sub = txt.charAt(i) * (int)Math.pow(base, pat.length()-1);
                    int add = txt.charAt(i+pat.length()) * (int)Math.pow(base, 0);
                    currHash = (currHash - sub) * base + add;
                }
            }
        }
    }

    public static int createHash(String str, int base, int mod) {
        int h = 0;
        for(int i=str.length()-1; i>=0; i--) {
            h += map.get(str.charAt(i)) * (int)Math.pow(base, i);
            System.out.println("CreateHash: base: " + base + " i: " + i + " val: " + map.get(str.charAt(i)) + " hash: " + h);
        }
        return h;
    }

    //remove duplicates from String with recursion
    public static String remDup(String str) {
        if (str.length() == 1) {
            return str;
        }

        if (str.charAt(0) == str.charAt(1)) {
            return remDup(str.substring(1));
        } else {
            return str.charAt(0) + remDup(str.substring(1));
        }
    }

    //all perm of array 
    public static void getAllperm(int[] arr, int n) {

    }

    //all permutatins of string
    public static void getAllPerm(String str, String ans) {
        if (str.length() == 0) {
            allPermutations.add(ans);
            return;
        } else {
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                String s1 = str.substring(0, i) + str.substring(i + 1);
                getAllPerm(s1, ans + temp);
            }
        }
    }

    // get all subsequences of string
    public static void getAllSubsequences(String str, String ans) {
        if (str.length() == 0) {
            allSubsequences.add(ans);
            return;
        }
        getAllSubsequences(str.substring(1), ans + str.charAt(0));
        getAllSubsequences(str.substring(1), ans);

    }

}