import java.util.*;

class EAPC11F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int pirates = scanner.nextInt() + 1;
            int items = scanner.nextInt();
            int[] lootValue = new int[items];
            for (int i = 0; i < lootValue.length; i++) {
                lootValue[i] = scanner.nextInt();
            }
            Arrays.sort(lootValue);
            if (pirates == items) {
                System.out.println(lootValue[items - 1]);
            } else if (pirates > items) {
                System.out.println("0");
            } else {
                int itemsPer = items / pirates;
                int personalProf = 0;
                for (int i = lootValue.length - itemsPer; i < lootValue.length; i++) {
                    personalProf += lootValue[i];
                }
                System.out.println(personalProf);
            }
        }
    }
}
