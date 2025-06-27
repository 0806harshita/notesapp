package notesapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotesManager {
    private static final String FILE_NAME = "notes.txt";

    public static void writeNote(String note) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) { // true = append mode
            fw.write(note + "\n");
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    public static void readNotes() {
        System.out.println("\n=== Your Notes ===");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean empty = true;
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
                empty = false;
            }
            if (empty) {
                System.out.println("(No notes found)");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes yet. Start writing some!");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    public static void deleteAllNotes() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write(""); // Overwrite file with empty content
            System.out.println("All notes deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error deleting notes: " + e.getMessage());
        }
    }
}
