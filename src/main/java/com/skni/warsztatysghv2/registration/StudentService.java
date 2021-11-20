package com.skni.warsztatysghv2.registration;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StudentService {

    private final UUIDStudentIdGenerator studentIdGenerator;
    private final StatusService statusService;
    private final ApplicationFormService applicationFormService;
    private final FileSaver fileSaver;

    public StudentService(UUIDStudentIdGenerator uuidStudentIdGenerator,StatusService statusService, ApplicationFormService applicationFormService,FileSaver fileSaver){
        this.studentIdGenerator = uuidStudentIdGenerator;
        this.statusService= statusService;
        this.applicationFormService=applicationFormService;
        this.fileSaver = fileSaver;
    }

    public void printStudent() {
        Student student = create(applicationFormService.createMock());
        System.out.println(student);
    }
    public void addStudentToFile() throws IOException {
        fileSaver.saveToFile(create(applicationFormService.createMock()));
    }

    public Student create(ApplicationForm applicationForm) {
        String id = studentIdGenerator.getNext();
        String firstName = applicationForm.getFirstName();
        String lastName = applicationForm.getLastName();
        String email = applicationForm.getEmail();
        Status status = statusService.randomStatus();
        return new Student(id, firstName, lastName, email, status); // new allowed here
    }

}
