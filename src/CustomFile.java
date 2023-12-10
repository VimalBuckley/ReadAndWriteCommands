import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomFile {
    private File file;
    private long startTime;
    private ArrayList<String> records;
    public CustomFile(String fileName) {
        file = new File(fileName);
        startTime = -1;
        records = new ArrayList<>();
    }
    
    public void record(String key) {
        if (startTime < 0) {
            startTime = Calendar.getInstance().getTimeInMillis();
        }
        double delta = Calendar.getInstance().getTimeInMillis() - startTime;
        records.add(key + "," + delta + ",");
    }

    public void saveRecords() {
        try {
            var writer = new BufferedWriter(new FileWriter(file));
            for (String line : records) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("error in saving records");
            e.printStackTrace();
        }
    }

    public void playbackRecords() {
        double start = Calendar.getInstance().getTimeInMillis();
        try {
            var reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                double timeToPlay = Double.parseDouble(parts[1]);
                double currentTime = Calendar.getInstance().getTimeInMillis() - start;
                while (currentTime < timeToPlay) {
                    currentTime = Calendar.getInstance().getTimeInMillis() - start;
                }
                System.out.println(parts[0]);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
