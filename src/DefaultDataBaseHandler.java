import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

abstract public class DefaultDataBaseHandler {

    private File file;

    protected DefaultDataBaseHandler(String path, String fileName){
        file = new File(path, fileName);
    }

    protected void flushFile(){
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print("");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void getAllRecords() {
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                sendDiff(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean isEnable(String str){
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                if (line.equals(str)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void add(String str) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(str);
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void del(String str) {
        try {
            Files.write(file.toPath(), new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8).replace(str, "").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void sendDiff(String line);
}
