import org.example.Student;
import org.example.StudentDAO;

import java.sql.Date;

public class insertStudent {
    public static void main(String[] args) {
        Student student = new Student(
                1,
                "Alice",
                "alice@example.com",
                Date.valueOf("2000-05-10"),
                "CSE",
                Date.valueOf("2018-08-01"),
                3.8
        );

        StudentDAO dao = new StudentDAO();
        boolean success = dao.insertStudent(student);
        System.out.println(success ? "Inserted successfully!" : "Insertion failed.");
    }
}
