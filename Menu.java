package notesapp;

import java.util.Scanner;

public class Menu {
     public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Write a note");
            System.out.println("2. Read all notes");
            System.out.println("3. Delete all notes");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    NotesManager.writeNote(note);
                    break;
                case 2:
                    NotesManager.readNotes();
                    break;
                case 3:
                    NotesManager.deleteAllNotes();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
