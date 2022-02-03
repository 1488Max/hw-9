import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondTask {
    public class User{
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

    }
    public String[] getStrings(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        ArrayList<String> result = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            result.add(line);
            line = reader.readLine();

        }
        return result.toArray(new String[result.size()]);
    }
    public void getUserJson(File file) throws IOException{
        String[] massiveOfString = getStrings(file);
        ArrayList<User> people = new ArrayList<>();
        String result = "";
        for (int i = 0; i < massiveOfString.length;i++){
            String[] separate = massiveOfString[i].split(" ");
            if(!separate[0].equals("name") || !separate[1].equals("age")) {
                User person = new User(separate[0], separate[1]);
                Gson gson =  new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(person);
                result += json + "\n";
            }
        }
        FileWriter file2 = new FileWriter("C:\\Users\\barga\\Documents\\GitHub\\hw-9\\FileOutput.txt");
        file2.write(result);
        file2.close();

    }
    static class SecondTaskTest {


        public static void main(String[] args) throws IOException {

            File file = new File("C:\\Users\\barga\\Documents\\GitHub\\hw-9\\File2.txt");
            SecondTask test = new SecondTask();
            test.getUserJson(file);


        }
    }

}
