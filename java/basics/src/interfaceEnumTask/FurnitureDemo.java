package interfaceEnumTask;

public class FurnitureDemo {
    public static void main(String[] args) {
        FurnitureImpl furniture=new FurnitureImpl();
        Table table=new Table("red",234,FurnitureType.OFFICE);
        Sofa sofa=new Sofa("Blue",256,FurnitureType.GARDEN);
        Bookshelf bookshelf=new Bookshelf("Yellow",456,FurnitureType.OFFICE);

        System.out.println("for table************************");
        double discountForTable=furniture.discountPrice(table);
        System.out.println("discounted price : "+discountForTable);
        table.setDiscountedPrice(discountForTable);
        System.out.println("table color is "+table.getColor()+" actual price is "+table.getPrice()+" " +
                "Furniture type is "+table.getFurnitureType()+" discounted price is "+table.getDiscountedPrice());
        System.out.println("for sofa*******************");
        double discountForSofa=furniture.discountPrice(sofa);
        System.out.println("discounted price : "+discountForSofa);
        sofa.setDiscountedPrice(discountForSofa);
        System.out.println("sofa color is "+sofa.getColor()+" actual price is "+sofa.getPrice()+" " +
                "Furniture type is "+sofa.getFurnitureType()+" discounted price is "+sofa.getDiscountedPrice());


    }
}
