# 1. Java Collections

## Example(s)

You are playing the `Bulls and Cows` game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

- The number of "bulls", which are digits in the guess that are in the correct position.
- The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

Example 1:

```
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"
```

Example 2:

```
Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
```

**Constraints:**
- `1 <= secret.length, guess.length <= 1000`
- `secret.length == guess.length`
- `secret` and `guess` consist of digits only.

```java
public String getHint(String secret, String guess) {
}
```

```java
import java.util.HashMap;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

    public static String getHint(String secret, String guess) {
        int numberOfBulls = 0;
        int numberOfCows = 0;

        StringBuilder secretBuild = new StringBuilder();
        StringBuilder guessBuild = new StringBuilder();

        HashMap<Character, Integer> myMap = new HashMap();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++numberOfBulls;
            } else {
                secretBuild.append(secret.charAt(i));
                guessBuild.append(guess.charAt(i));
            }
        }
        
        for(int i = 0; i < secretBuild.length(); i++) {
            if(myMap.get(secretBuild.charAt(i)) == null) {
                myMap.put(secretBuild.charAt(i), 1);
            } else {
                myMap.put(secretBuild.charAt(i), myMap.get(secretBuild.charAt(i)) + 1);
            }
        }
        
        for(int i = 0; i < secretBuild.length(); i++) {
            if(myMap.get(guessBuild.charAt(i)) != null && myMap.get(guessBuild.charAt(i)) > 0) {
                ++numberOfCows;
                myMap.put(guessBuild.charAt(i), myMap.get(guessBuild.charAt(i)) - 1);
            }
        }
        
        System.out.println(secretBuild.toString());
        System.out.println(guessBuild.toString());

        return numberOfBulls + "A" + numberOfCows + "B";
    }

}
```