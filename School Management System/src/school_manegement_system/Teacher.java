package school_manegement_system;

/**
 * This class is responsible for keeping the track
 * of teacher's name, id, salary.
 */
public class Teacher {
    private int id;
    private String name;
    private int salary;

    /**
     * Creates a new Teacher object
     * @param id id for the teacher
     * @param name name for the teacher
     * @param salary salary for the teacher
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     *
     * @return the id for the teacher
     */
    public int getId(){
        return id;
    }
    /**
     *
     * @return the name for the teacher
     */
    public String getName(){
        return name;
    }
    /**
     *
     * @return the salary for the teacher
     */
    public int getSalary(){
        return salary;
    }

    /**
     * Set salary
     * @param salary
     */
    public void setSalary(int salary){
        this.salary = salary;
    }

}



