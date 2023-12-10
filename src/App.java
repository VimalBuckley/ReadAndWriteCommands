import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var file = new CustomFile("src/test.txt");
        Scanner scanner = new Scanner(System.in);
        file.record("Start");
        file.record(scanner.nextLine());
        file.record(scanner.nextLine());
        scanner.close();
        file.saveRecords();
        file.playbackRecords();
    }
}
