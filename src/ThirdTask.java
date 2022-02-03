import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ThirdTask {
    public void getFrequancy(File file) throws IOException {

        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        HashMap<String, Integer> hashMap = new HashMap<>();
        while (line != null) {
            String[] words = line.split("\\s");
            for(int i = 0; i < words.length;i++){
                if(hashMap.containsKey(words[i])){
                    hashMap.put(words[i],hashMap.get(words[i]) + 1);
                }
                else {
                    hashMap.put(words[i],1);
                }
            }
            line = reader.readLine();
        }
        System.out.println(hashMap);


    }
}
class ThirdTaskTest {


    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\barga\\Documents\\GitHub\\hw-9\\words.txt");
        ThirdTask test = new ThirdTask();
        test.getFrequancy(file);


    }
}
