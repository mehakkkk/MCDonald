import java.util.Scanner;

public class McDonald
{
    //assign customer number here
    private int id;
    private Scanner sc;
    int total;
    private String reciept;
    McDonald()
    {
        //id = generateID();
        sc = new Scanner(System.in);
        reciept="---------------------MCDonald's-----------------\n------- Product---------\t---------Quanity-------\t----Price-----";
        total =0;
    }

    private int generateID()
    {
        return 4;
    }

    final void displayOrder()
    {
        //display entire menu
        System.out.println("--------------------------------------------------MCDonald's Menu--------------------------------------------------");
        System.out.println("\t\t------Burger-------\t\t------Price----");
        for(Burger b:Burger.values())
        {
            System.out.println("\t\t"+b + "\t\t\t\t\t"+b.price);
        }
        System.out.println("\n\t\t--------Beverages-------  --Small--  --Medium--  --Large--");
        for(Beverages b:Beverages.values())
        {
            System.out.println("\t\t"+b + "\t\t\t\t\t\t"+(b.price+CupSize.Small.price)+"\t\t\t\t"+(b.price+CupSize.Medium.price)+"\t\t\t\t"+(b.price+CupSize.Large.price));
        }
        System.out.println("\n\t\t-------Sides-------  --Small--  --Medium--  --Large--");
        for(SidesEat s: SidesEat.values())
        {
            if(s == SidesEat.Fries)
                System.out.println("\t\t"+s + "\t\t\t\t\t"+(s.price+CupSize.Small.price)+"\t\t\t"+(s.price+CupSize.Medium.price)+"\t\t"+(s.price+CupSize.Large.price));
            else
                System.out.println("\t\t"+s + "\t\t\t\t\t"+(s.price));
        }


    }

    final String generateReciept()
    {
        String rec = new String(reciept);
        return rec;

    }
    private int calculateBurgerBill(String order,int count)
    {

        int tot = (Burger.valueOf(order).price)*count;

        reciept+="\n"+order+"\t\t\t\t\t\t"+count+"\t\t\t\t\t\t"+tot;
        System.out.println("Looking for making your burger more happening try our new sauces");

        sc.reset();
        Burger.valueOf(order).displayExtra();
        System.out.println("do you want to add any of these sauces in your "+order);

        String sauce = sc.next();
        tot=(Burger.valueOf(order).addExtra(sauce))*count;
        reciept+="\n"+sauce+"\t\t\t\t\t\t"+count+"\t\t\t\t\t\t"+tot;
        return tot;
    }

    private int calculateSidesBill(String order,String type,int count)
    {
        int tot;
        if(type!=null)
        {
            tot = ((SidesEat.valueOf(order).price)+CupSize.valueOf(type).price)*count;
            reciept+="\n"+order+"\t\t\t"+count+"\t\t\t"+tot;
            return tot;
        }

        tot = SidesEat.valueOf(order).price*2;
        reciept+="\n"+order+"("+type+")"+"\t\t\t"+count+"\t\t\t"+tot;
        return tot;
    }

    private int calculateBeveragesBill(String order,String type,int count)
    {
        int tot = ((Beverages.valueOf(order).price)+CupSize.valueOf(type).price)*count;
        reciept+="\n"+order+"("+type+")"+"\t\t\t"+count+"\t\t\t"+tot;
        return tot;
    }

    void CreateOrder()
    {

        //local variables
        int anythingElse=0,count;
        String order,size;

        System.out.println("\nEnter 1 to confirm your order or Enter 2 to create order");



        while(anythingElse!=1)
        {
            sc.nextLine();
            System.out.println("Burger/Sides/Beverages: ");
            order = sc.nextLine();
            switch(order)
            {
                case "Burger":
                    System.out.println("Select Burger from menu and specify count:");
                    order = sc.nextLine();
                    count = sc.nextInt();
                    total+=calculateBurgerBill(order,count);
                    break;

                case "Sides":
                    System.out.println("Select Sides from menu and specify count:");
                    order = sc.nextLine();
                    System.out.println(order);
                    size = null;
                    if(order.equals("Fries"))
                    {
                        System.out.println("Select size from menu and specify count:");
                        size = sc.nextLine();
                    }
                    count = sc.nextInt();
                    total+=calculateSidesBill(order,size,count);
                    break;

                case "Beverages":
                    System.out.println("Select Beverages from menu and specify count:");
                    order = sc.nextLine();
                    size = null;
                    System.out.println("Select size from menu and specify count:");
                    size = sc.nextLine();
                    count = sc.nextInt();
                    total+=calculateBeveragesBill(order,size,count);
                    break;

            }

            System.out.println("Antyhing else?");
            anythingElse = sc.nextInt();

        }
        reciept+="\n\n\t\ttotal:\t\t "+total;
    }


}