import java.io.*;
import java.util.ArrayList;

abstract public class DefaultDataBaseHandler {

    private File file;

    protected DefaultDataBaseHandler(String path, String fileName){
        file = new File(path, fileName);
    }

    protected String getStringOnSubstring(String str){
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                if (getSubString(line).equals(str)) {
                    return line;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> getAllRecords() {
        ArrayList<String> arrayList = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    protected boolean isEnable(String str){
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                if (getSubString(line).equals(str)) {
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
        ArrayList<String> arrayList = getAllRecords();

        for (int i = 0; i < arrayList.size() - 1; i++) {
            String line = arrayList.get(i);
            String subString = getSubString(line);

            if (subString.equals(str)) {
                arrayList.remove(i);
                break;
            }
        }

        try {
            FileWriter f = new FileWriter(file, false);
            f.write("");
            f.flush();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        diffDel(arrayList);

    }

    protected abstract String getSubString(String str);

    protected abstract void diffDel(ArrayList<String> arrayList);
}
