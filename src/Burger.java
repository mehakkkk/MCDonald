public enum Burger {
    Veg_Burger(60),Chicken_Burger(80),American_Supreme(120),Maharaja_Mac(200);

    int price;
    int totalBurgerCost=0;

    Burger(int price)
    {
        this.price = price;
    }

    private enum Sauces
    {
        None(0),Red_Sauce(10),Spicy_Mayonaise(15),Barbeque_Mayonaise(25);
        int price;

        Sauces(int price)
        {
            this.price = price;
        }
        public int getPrice(String order)
        {
            return Sauces.valueOf(order).price;
        }
    }


    final void displayExtra()
    {
        System.out.println("\n\t\t------Sauces-------\t\t  ------Price----");
        for(Sauces s:Sauces.values())
        {
            System.out.println("\t\t"+s + "\t\t\t\t\t"+s.price);
        }
    }

    int addExtra(String order)
    {
        int price = (Sauces.valueOf(order).price);
        System.out.println(price);
        return price;
    }
}
