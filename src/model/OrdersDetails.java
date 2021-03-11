package model;

public class OrdersDetails {

    private Product product;
    private int amount;
    private Size size;
    private double price;


    public OrdersDetails(Product product, int amount,String size) {
        this.product = product;
        this.amount = amount;
        this.size = Size.valueOf(size);
        price=calculatePrice();
    }


    private double calculatePrice() {
         double price;
        if (size==Size.BIG){
          price=product.getPricePerSizeInt()[1];
        }else{
            price=product.getPricePerSizeInt()[0];
        }
        return amount*price;
    }


    public String getProduct() {
        return this.product.getName();
    }

    public int getAmount() {
        return this.amount;
    }

    public Size getSize() {
        return this.size;
    }

    public double getPrice() {
        return this.price;
    }
    
}
