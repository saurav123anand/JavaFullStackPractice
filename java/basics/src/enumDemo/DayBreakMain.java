package enumDemo;

public class DayBreakMain {
    public static void main(String[] args) {
        DayBreak dayBreak1 = DayBreak.MorningTea;
        String name = dayBreak1.name();
        int ordinal = dayBreak1.ordinal();
        System.out.println("name is " + name + " and ordinal is " + ordinal);

        DayBreak dayBreak2 = DayBreak.EveningSnacks;
        String name2 = dayBreak2.name();
        int ordinal2 = dayBreak2.ordinal();
        System.out.println("name is " + name2 + " and ordinal is " + ordinal2);

        DayBreak dayBreak3 = DayBreak.EveningSnacks;
        System.out.println("checking two enums are equal or not");
        boolean isEquals = dayBreak2 == dayBreak3;
        System.out.println(" is equals " + isEquals);

        System.out.println(" 2nd way of checking equality");
        System.out.println(" is equals " + dayBreak2.equals(dayBreak3));

        // getting all enums
        System.out.println("getting all the enums");
        DayBreak[] dayBreaks = DayBreak.values();
        for (DayBreak dayBreak : dayBreaks) {
            System.out.println("name is " + dayBreak.name() + " and ordinal is " + dayBreak.ordinal());
        }

    }
}
