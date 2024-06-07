# Voting System
 A voting system project that i make in java


## Explanation of the Code

1. **Imports**
    ```java
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;
    ```
    - `HashMap` and `Map` are used to store the candidates and their votes.
    - `Scanner` is used for reading user input.

2. **Main Class and Variables**
    ```java
    public class VotingSystem {
        private static Map<String, Integer> candidates = new HashMap<>();
    ```
    - `candidates` is a `HashMap` to store candidate names as keys and their vote counts as values.

3. **Main Method**
    ```java
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n----- Voting System -----");
            System.out.println("1. Add a candidate");
            System.out.println("2. Vote for a candidate");
            System.out.println("3. View results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addCandidate(scanner);
                    break;
                case 2:
                    voteForCandidate(scanner);
                    break;
                case 3:
                    viewResults();
                    break;
                case 4:
                    System.out.println("Thank you for using the voting system!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }
    ```
    - A loop is used to display a menu and execute the corresponding options.
    - The user's choice is read using `Scanner`.
    - The loop continues until the user chooses the exit option (4).

4. **addCandidate Method**
    ```java
    private static void addCandidate(Scanner scanner) {
        System.out.print("Enter candidate name: ");
        String name = scanner.nextLine();
        if (candidates.containsKey(name)) {
            System.out.println("Candidate already exists!");
        } else {
            candidates.put(name, 0);
            System.out.println("Candidate added successfully!");
        }
    }
    ```
    - Prompts the user to enter a candidate's name.
    - Checks if the candidate already exists; if not, adds the candidate to the `candidates` map with 0 votes.

5. **voteForCandidate Method**
    ```java
    private static void voteForCandidate(Scanner scanner) {
        System.out.print("Enter candidate name to vote for: ");
        String name = scanner.nextLine();
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1);
            System.out.println("Vote cast successfully!");
        } else {
            System.out.println("Candidate not found!");
        }
    }
    ```
    - Prompts the user to enter the name of the candidate they want to vote for.
    - Checks if the candidate exists; if so, increments their vote count by 1.

6. **viewResults Method**
    ```java
    private static void viewResults() {
        System.out.println("\n--- Voting Results ---");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println("Candidate: " + entry.getKey() + " - Votes: " + entry.getValue());
        }
    }
    ```
    - Prints the voting results by iterating through the `candidates` map and displaying each candidate's name and vote count.