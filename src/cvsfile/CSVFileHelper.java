package cvsfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHelper {
    public List<String> readLinesFromCSVFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        List<String> results = new ArrayList<>();

        try(BufferedReader buffer = Files.newBufferedReader(filePath, Charset.defaultCharset())){
            String line = "";
            while((line = buffer.readLine()) != null){
                results.add(line);
            }

        }
        return results;
    }

    public void writeLinesToCSVFile(String path, String... lines) throws IOException {
        Path filePath = Paths.get(path);
        try(BufferedWriter buffer =
                    Files.newBufferedWriter(filePath,
                                            Charset.defaultCharset(),
                                            StandardOpenOption.APPEND)){
            buffer.newLine();
            for(String line:lines){
               buffer.append(line);
               buffer.newLine();
            }
        }
    }

    public void writeObjectsToCSVFile(String path, Person... persons) throws IOException {
        Path filePath = Paths.get(path);
        try(BufferedWriter buffer =
                    Files.newBufferedWriter(filePath,
                            Charset.defaultCharset(),
                            StandardOpenOption.APPEND)){
            buffer.newLine();
            for(Person person:persons){
                buffer.append(person.toCsv());
                buffer.newLine();
            }
        }
    }

    private static class Person{
        String name;
        int age;
        String jobTitle;

        Person(String name, int age, String jobTitle){
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
        }

        String toCsv(){
            return name + "," + age + "," + jobTitle;
        }
    }

    public static void main(String[] args) throws IOException {

        new CSVFileHelper().writeObjectsToCSVFile("employees.csv",
                new Person("Marta",32,"Assistant"),
                new Person( "Jessica",35,"Actor"));

        List<String> lines = new CSVFileHelper().readLinesFromCSVFile("employees.csv");

        System.out.println(lines.get(0));
    }
}
