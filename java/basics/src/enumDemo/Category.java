package enumDemo;

public enum Category {
    Phone("Ph", "Android Phone and IPhone"),
    Television("tv", "LCD,Smart Tv"),
    Groceries("gc", "groceries,vegetables");
    private String categoryCode, displayName;

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    Category(String categoryCode, String displayName) {
        this.categoryCode = categoryCode;
        this.displayName = displayName;
    }
}
