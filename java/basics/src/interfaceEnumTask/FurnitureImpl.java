package interfaceEnumTask;

public class FurnitureImpl implements IFurniture{
    @Override
    public double discountPrice(Furniture furniture) {
        double discount=0;
         if(furniture.getFurnitureType()==FurnitureType.OFFICE){
            discount= 0.1;
         }
         if(furniture.getFurnitureType()==FurnitureType.HOME){
             discount= 0.05;
         }
        if(furniture.getFurnitureType()==FurnitureType.GARDEN){
            discount= 0.025;
        }
        double discountedPrice= furniture.getPrice()-(furniture.getPrice()*discount);
        return discountedPrice;
    }
}
