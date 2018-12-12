package logic;

import java.io.FileWriter;
import java.io.IOException;

public class WritingToFile {
    public void writeDoctor(Doctor doctor) throws IOException {
        //irasyti i faila objekto gydytojas visus duomenys
        FileWriter fileWriter = new FileWriter("doctors.txt", true);
        fileWriter.write(doctor.toString()+ "\n");
        fileWriter.close();
    }

    public void writePatient(Patient patient) throws IOException {
        //irasyti i faila objekto  pacientas visus duomenys
        FileWriter fileWriter = new FileWriter("patients.txt", true);
        fileWriter.write(patient.toString()+ "\n");
        fileWriter.close();
    }

    public void writeFood(Food food) throws IOException {
        //irasyti i faila objekto  pacientas visus duomenys
        FileWriter fileWriter = new FileWriter("food.txt", true);
        fileWriter.write(food.toString()+ "\n");
        fileWriter.close();
    }

}
