// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("John","Smith");
        /*em1.changePassword("5483gfhjdsJ!");
        System.out.println(em1.getPassword());
        em1.setAlternateEmail("JS@dev.aeycompany.com");
        System.out.println(em1.getAlternateEmail());*/

        System.out.println(em1.showInfo());
    }
}