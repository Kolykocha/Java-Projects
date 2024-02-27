import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private    String email;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";


    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: "+this.firstName+"."+this.lastName);
        this.department = setDepartment();
       // System.out.println("Department: "+this.department);
        this.password = randomPassword(defaultPasswordLength);
       // System.out.println("Your password is: "+this.password);
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
       // System.out.println("Your email is: "+email);
    }
    private String setDepartment(){
        System.out.println("Enter department \n 1 for Sales \n 2for Development \n 3 for Accounting \n 4 for none \n Enter department code:");
        Scanner scanner  = new Scanner(System.in);
        int dep = scanner.nextInt();
        if (dep == 1){
            return "sales";
        }else if (dep == 2){
            return "development";
        }else if (dep == 3 ){
            return "accounting";
        }else {
            return "";
        }
    }
    private String randomPassword (int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ01234567890!@#$%&";
        char[] passwordre = new char[length];
        for (int i=0;i<length;i++){
            int rand = (int)((Math.random())*passwordSet.length());
            passwordre[i] = passwordSet.charAt(rand);
        }

        return passwordre.toString();
    }
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;

    }
    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+"\n" +
                "COMPANY EMAIL"+email+"\n" +
                "MAILBOX CAPACITY"+mailboxCapacity+"mb";
    }
}
