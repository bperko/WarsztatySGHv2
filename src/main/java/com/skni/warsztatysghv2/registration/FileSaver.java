package com.skni.warsztatysghv2.registration;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileSaver {

    public void saveToFile(Student student) throws IOException {
        FileOutputStream f = new FileOutputStream("newStudent.txt");
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(student);
        System.out.println("Student "+student+" zapisany do pliku");
    }
}
