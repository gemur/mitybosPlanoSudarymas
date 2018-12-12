package logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadingFromFile{

    public void readAll() throws IOException {
        readDoctors();
        readDiagnoses();
        readPatients();
        readFood();

    }
    public void readDoctors() throws IOException {
        FileReader fileReader = new FileReader("doctors.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String args[] = line.split(" ");
            Doctor doctor = new Doctor(args[0], args[1], args[2], args[3]);
        }
        bufferedReader.close();
    }

    public void readDiagnoses(){
        Diagnosis sveikas = new Diagnosis("Sveikas", "Norma");
        Diagnosis skrandzioOpa = new Diagnosis("Skrandžio opa", "baltymai");
        Diagnosis cukrinisDiabetas = new Diagnosis("Cukrinis diabetas", "baltymai");
        Diagnosis astma = new Diagnosis("Astma", "baltymai");
        Diagnosis prostatitas = new Diagnosis("Prostatitas", "angliavandeniai");
        Diagnosis kepenuCiroze = new Diagnosis("Kepenu ciroze", "angliavandeniai");
    }


    void readPatients() throws IOException {
        FileReader fileReader = new FileReader("patients.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String args[] = line.split(" ");
            Patient patient = new Patient(args[0], args[1], args[2], args[3], args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6]));
        }
        bufferedReader.close();
    }
    void readFood() throws IOException {
        FileReader fileReader = new FileReader("food.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String args[] = line.split(", ");
            Food food = new Food(args[0], Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), args[4]);
        }
        bufferedReader.close();

    }
}
