package school_manegement_system;

import java.util.List;

/**
 *Many teachers, many students.
 * ArrayList teachers and students using an ArrayList.
 */
public class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpend;

    /**
     * new school objects is created.
     * @param teachers list of teachers in  the school.
     * @param students list of students in  the school.
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpend = 0;
    }

    /**
     *
     * @return the list of teachers in the school.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Add teacher to the school.
     * @param teacher the teacher to be added.
     */
    public void addTeachers(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     *
     * @return the list of students in the school.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Add students to the school.
     * @param student the students to be added.
     */
    public void addStudents(Student student) {
        students.add(student);
    }

    /**
     *
     * @return the total money earned by the school.
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Adds the total money earned by the school.
     * @param MoneyEarned money that is supposed to be added.
     */
    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    /**
     *
     * @return total money spent by the school.
     */
    public int getTotalMoneySpend() {
        return totalMoneySpend;
    }

    /**
     * update the money that is spent by the school which
     * is the salary given by the school to ist teachers.
     * @param MoneySpend the money spent by school.
     */
    public static void updateTotalMoneySpend(int MoneySpend) {
        totalMoneySpend += MoneySpend;
        totalMoneyEarned -= MoneySpend;
    }
}
