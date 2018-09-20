import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;

import java.util.List;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> all = studentDao.findAll();
        System.out.println(all);
        System.out.println("***************");
        Student student = studentDao.findById(5);
        System.out.println(student);
    }
}
