import com.alibaba.fastjson.JSON;

import java.io.*;

public class MainClass {

   private static String s;
   static File newFile = new File("notes2.txt");

    public static void writeFile(String text) {

        try(FileWriter writer = new FileWriter(newFile, false))
        {
            System.out.println(newFile.getAbsolutePath());
            // запись всей строки
            //String test = "Мама мыла раму, раму мыла мама";
            writer.write(text);
            // запись по символам
           // writer.append('\n');
            //writer.append('E');

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile() {

            try(FileReader reader = new FileReader(newFile))
            {
                // читаем посимвольно
                int c;
                int k = 1;
                while((c=reader.read())!=-1){
                    if(k != 1) {
                        s += ((char) c);
                    }
                    k++;
                    //System.out.print((char)c);
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            return s;
        }

    static String serializeObject(Text cat){
        String json = JSON.toJSONString(cat);
        System.out.println(json);
        return json;
    }

    static Text deserializeObject(String json){
        Text cat =   JSON.parseObject(json, Text.class);
        return cat;
    }

    public static void main(String[] args) {
        //MainClass mClass = new MainClass();
        //writeFile();
        String json = serializeObject(new Text());
        writeFile(json);
        Text a = deserializeObject(readFile());
        System.out.println(a);
    }
}

