import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VotingSystem {
    private static Map<String, Integer> candidates = new HashMap<>();

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

    private static void viewResults() {
        System.out.println("\n--- Voting Results ---");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println("Candidate: " + entry.getKey() + " - Votes: " + entry.getValue());
        }
    }
}
