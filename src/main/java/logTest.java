import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class logTest {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop\\alpos1.sql")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\alpos2.sql")));


        List<String> newList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            if (!line.startsWith("INSERT INTO `cpos_logger_record`")){
                newList.add(line);
            }
        }
        bufferedReader.close();



        for (String newLine : newList) {
            bufferedWriter.write(newLine+"\r\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
