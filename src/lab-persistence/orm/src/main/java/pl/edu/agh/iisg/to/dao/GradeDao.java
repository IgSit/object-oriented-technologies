package lab;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Grade;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;

public class GradeDao extends GenericDao<Grade> {

    public boolean gradeStudent(final Student student, final Course course, final float grade) {
        Grade gradeObject = new Grade(student, course, grade);
        if (student.gradeSet().contains(gradeObject) || course.gradeSet().contains(gradeObject))
            return false;

        StudentDao studentDao = new StudentDao();

        try {
            save(gradeObject);
            student.gradeSet().add(gradeObject);
            course.gradeSet().add(gradeObject);
            update(gradeObject);
            studentDao.update(student);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return true;
    }


}
