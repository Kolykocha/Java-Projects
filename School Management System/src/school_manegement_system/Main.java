package school_manegement_system;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Teacher lizzy = new Teacher(1,"Lizzy",500);
        Teacher mellisa = new Teacher(2,"Mellisa",700);
        Teacher ivan = new Teacher(3,"Ivan",800);
        Teacher stan = new Teacher(4,"Stan",300);

        List<Teacher> teachersList = new ArrayList<>();
        teachersList.add(lizzy);
        teachersList.add(mellisa);
        teachersList.add(ivan);
        teachersList.add(stan);

        Student maria = new Student(1,"Maria",10);
        Student tamara = new Student(2,"Tamara",11);
        Student anna = new Student(3,"Anna",9);
        Student sofia = new Student(4,"Sofia",8);

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(maria);
        studentsList.add(tamara);
        studentsList.add(anna);
        studentsList.add(sofia);

        School ghs = new School(teachersList,studentsList);
        System.out.println("GHS has earned " + ghs.getTotalMoneyEarned());

        tamara.updateFeesPaid(5000);
        System.out.println("GHS has earned " + ghs.getTotalMoneyEarned());

        anna.updateFeesPaid(500);
        System.out.println("GHS has earned " + ghs.getTotalMoneyEarned());

        System.out.println("---------School pay salary---------");
        lizzy.receiveSalary(lizzy.getSalary());
        System.out.println("GHS has spent fot salary to " + lizzy.getName()+
                " and how has "+ghs.getTotalMoneyEarned());
        System.out.println(anna);
        System.out.println(lizzy);
    }

}
