public enum Beverages {
    Coke(50), Latte(75), IceTea(60), Mocha(65);

    int price;
    int totalBeverageCost=0;

    Beverages(int price)
    {
        this.price = price;
    }
}
