package cse364.project;

import java.io.*;
import java.util.*;

public class ReadDatabase {
    /*public static void main(String[] args){
        ReadDatabase RDB = new ReadDatabase();
        RDB.readCSV();
    }*/

    public List<List<String>> readCSV(String path){
        List<List<String>> csvList = new ArrayList<List<String>>();
        File csv = new File(path);
        BufferedReader buffer = null;
        String line = "";

        try {
            buffer = new BufferedReader(new FileReader(csv));
            while (true) {
                line = buffer.readLine();
                if (line == null) break;
                List<String> LineList = new ArrayList<String>();
                String[] LineParse = line.split("::");
                LineList = Arrays.asList(LineParse);
                csvList.add(LineList);
            }
        } catch(FileNotFoundException ex){
            ex.getMessage();
        } catch(IOException ex){
            ex.getMessage();
        } finally{
            try{
                if(buffer != null){
                    buffer.close();
                }
            } catch(IOException ex){
                ex.getMessage();
            }
        }
        return csvList;
    }
}
