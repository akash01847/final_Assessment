import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringManipulator {

    public String reverseString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public List<Integer> findDuplicates(int[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                duplicates.add(number);
            }
        }

        return duplicates;
    }

    public int countVowels(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int count = 0;
        String vowels = "aeiouAEIOU";

        for (char ch : input.toCharArray()) {
            if (vowels.contains(String.valueOf(ch))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        StringManipulator sm = new StringManipulator();

        // Reverse string example
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
        String reversed = sm.reverseString(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);

        // Find duplicates example
        System.out.println("\nEnter the number of elements: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter the elements:");

        // Read the elements from the user and store them in the numbers array
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Find the duplicate numbers
        List<Integer> duplicateNumbers = sm.findDuplicates(numbers);
        System.out.println("Duplicate Numbers: " + duplicateNumbers);

        scanner.nextLine(); // Consume the newline character

        // Count number of vowels in String
        System.out.print("Enter a string to count vowels: ");
        String testString = scanner.nextLine();
        int vowelCount = sm.countVowels(testString);
        System.out.println("Number of Vowels in '" + testString + "': " + vowelCount);

        scanner.close();
    }
}
