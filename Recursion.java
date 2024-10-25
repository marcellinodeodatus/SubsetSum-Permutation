// Class Recursion with methods to solve the subset sum and permutation generation problems
public class Recursion {

    // Part I: Subset Sum Problem
    public static boolean subsetSum(int[] values, int target) {
        return subsetSumHelp(values, target, 0);
    }

    // Recursive helper method for subset sum
    // Returns true if a subset starting from startindex adds up to the target
    public static boolean subsetSumHelp(int[] values, int target, int startindex) {
        // Base cases
        if (target == 0) return true;           // If the target is 0, we found a subset
        if (startindex == values.length) return false;  // Reached the end of the array without finding a subset

        // Recursive case: Include or exclude the current element
        return subsetSumHelp(values, target - values[startindex], startindex + 1) || // Include current value
               subsetSumHelp(values, target, startindex + 1);                      // Exclude current value
    }

    // Part II: Generating Permutations
    public static void permute(String s) {
        genPermutations("", s);
    }

    // Recursive helper method to generate permutations
    // Prints all permutations of s with the string prepend added to the front
    public static void genPermutations(String prepend, String s) {
        // Base case: If the string to permute is empty, print the current permutation
        if (s.isEmpty()) {
            System.out.println(prepend);
            return;
        }

        // Recursive case: For each character in s, create permutations
        for (int i = 0; i < s.length(); i++) {
            // Pick a character, remove it from s, and add it to prepend
            String newPrepend = prepend + s.charAt(i);
            String remaining = s.substring(0, i) + s.substring(i + 1);
            genPermutations(newPrepend, remaining);
        }
    }
}
