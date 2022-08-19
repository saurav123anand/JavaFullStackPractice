package enumDemo;

public class CategoryMain {
    public static void main(String[] args) {
        Category category1 = Category.Phone;
        String categoryCode = category1.getCategoryCode();
        String categoryName = category1.getDisplayName();
        System.out.println("code is " + categoryCode + " display name is " + categoryName);

        System.out.println(" getting all the values");
        Category[] categories = Category.values();
        for (Category category : categories) {
            System.out.println("category code is " + category.getCategoryCode() + " category name is " +
                    category.getDisplayName());
        }
    }

}
