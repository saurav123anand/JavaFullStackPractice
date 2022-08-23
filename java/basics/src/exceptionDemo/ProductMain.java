package exceptionDemo;

public class ProductMain {
    public static void main(String[] args) {
        ProductMain productMain=new ProductMain();
        System.out.println("adding the product******");
        try{
            productMain.addProduct(1,"samsung",13000);
            try{
                productMain.addProduct(2,"Motorola",-10000);
            }
            catch (InvalidPriceException e){
                System.out.println(e.getMessage());
            }
            productMain.addProduct(3,"xiaomi",12000);
        }
        catch (InvalidPriceException e){
            System.out.println(e.getMessage());
        }


        System.out.println("all products have been added");

    }
    public void addProduct(long id,String name,double price) throws InvalidPriceException {
        if(price<0){
            throw new InvalidPriceException("price is invalid");
        }

        Product product=new Product(id,name,price);
        System.out.println("product has been added "+id+" "+name+" "+price );

    }
}
