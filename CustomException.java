import java.util.Scanner;

public class CustomException {
    // Custom exception for voting eligibility
    static class VotingError extends RuntimeException {
        public VotingError(String msg) {
            super(msg);
        }
    }

    // Custom exception for name validation
    static class NameError extends RuntimeException {
        public NameError(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) throws NameError  {
        Scanner sc = new Scanner(System.in);

        try {
            synchronized (CustomException.class){
            System.out.print("Enter Your Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Your Age: ");
            int age = sc.nextInt();

            // Validate name length
            if (name.length() < 3) {
                throw new NameError("Name length must be at least 3 characters");
            }

            // Validate age for voting
            if (age < 18) {
                throw new VotingError("Age is not eligible for voting");
            }
            System.out.println("Hello " + name + "! You are eligible for voting!");
            }
        } catch (VotingError ve) {
            System.out.println("Error: " + ve.getMessage());
            ve.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}