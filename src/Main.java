public class Main
{
    public static void main(String[] args) {
        McDonald m = new McDonald();
        m.displayOrder();
        m.CreateOrder();

        System.out.println("\nplease wait generating your bill\n");
        System.out.println(m.generateReciept());

    }

}