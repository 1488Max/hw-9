import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class CheckOfRightNumbers{
    public boolean check1(String line){
        if(line.isEmpty()){
            return false;
        }
        for(int i = 0; i<3;i++){
            if(!Character.isDigit(line.charAt(i))){
                return false;
            }
        }
        if(line.charAt(3)!='-'){
            return false;
        }
        for(int i = 4; i<7;i++){
            if(!Character.isDigit(line.charAt(i))){
                return false;
            }
        }
        if(line.charAt(7)!='-'){
            return false;
        }
        for(int i = 8; i<12;i++){
            if(!Character.isDigit(line.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public boolean check2(String line){
        if(line.isEmpty()){
            return false;
        }
        if(line.charAt(0)!='('){
            return false;
        }
        for(int i = 1; i<4;i++){
            if(!Character.isDigit(line.charAt(i))){
                return false;
            }
        }

        if(line.charAt(4)!=')'){
            return false;
        }
        if(line.charAt(5)!=' '){
            return false;
        }
        for(int i = 6; i<9;i++){
            if(!Character.isDigit(line.charAt(i))){
                return false;
            }
        }
        if(line.charAt(9)!='-'){
            return false;
        }
        for(int i = 10; i<14;i++){
            if(!Character.isDigit(line.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public boolean fullCheck(String line){
        return check1(line)||check2(line);
    }
    public String checkOfFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        String result = "";
        while (line != null) {

            if(fullCheck(line)){
                result+=line + "\n";
            }
            line = reader.readLine();

        }
        return result;
    }
}
class FirstTaskTest {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\barga\\Documents\\GitHub\\hw-9\\File.txt");
        CheckOfRightNumbers test = new CheckOfRightNumbers();
        System.out.println(test.checkOfFile(file));


    }
}