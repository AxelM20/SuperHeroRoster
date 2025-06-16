import java.util.Scanner;

public class SuperheroRoster {

    public static void main(String[] args) {
        // 1. Declare and initialize arrays
        String[] heroNames = {"Spider-Man", "Iron Man", "Black Widow", "Thor", "Hulk"};
        String[] abilities = {"Web-slinging", "Flying and high-tech armor", "Stealth and combat", "God of Thunder", "Super strength"};
        int[] powerLevels = {85, 90, 80, 95, 88};

        // 2. Display hero details using loop
        System.out.println("=== Marvel Superhero Roster ===");
        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Name: " + heroNames[i]);
            System.out.println("Ability: " + abilities[i]);
            System.out.println("Power Level: " + powerLevels[i]);
            System.out.println("-------------------------------");
        }

        // 3. Call searchHero
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hero name to search: ");
        String target = scanner.nextLine();
        searchHero(heroNames, abilities, powerLevels, target);

        // 4. Calculate and display average power level
        double avg = calculateAveragePower(powerLevels);
        System.out.println("\nAverage Power Level: " + avg);

        // Bonus: Sorting by power level
        System.out.println("\n=== Sorted by Power Level (Descending) ===");
        sortAndDisplayHeroes(heroNames, abilities, powerLevels);
    }

    // Method: searchHero
    public static void searchHero(String[] names, String[] abilities, int[] powerLevels, String target) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("\nHero found!");
                System.out.println("Name: " + names[i]);
                System.out.println("Ability: " + abilities[i]);
                System.out.println("Power Level: " + powerLevels[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Hero not found.");
        }
    }

    // Method: calculateAveragePower
    public static double calculateAveragePower(int[] powerLevels) {
        int sum = 0;
        for (int level : powerLevels) {
            sum += level;
        }
        return (double) sum / powerLevels.length;
    }

    // Bonus: Sort and display heroes by descending power level
    public static void sortAndDisplayHeroes(String[] names, String[] abilities, int[] powerLevels) {
        for (int i = 0; i < powerLevels.length - 1; i++) {
            for (int j = i + 1; j < powerLevels.length; j++) {
                if (powerLevels[j] > powerLevels[i]) {
                    // Swap power levels
                    int tempPower = powerLevels[i];
                    powerLevels[i] = powerLevels[j];
                    powerLevels[j] = tempPower;

                    // Swap names
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                    // Swap abilities
                    String tempAbility = abilities[i];
                    abilities[i] = abilities[j];
                    abilities[j] = tempAbility;
                }
            }
        }

        for (int i = 0; i < names.length; i++) {
            System.out.println("Name: " + names[i]);
            System.out.println("Ability: " + abilities[i]);
            System.out.println("Power Level: " + powerLevels[i]);
            System.out.println("-------------------------------");
        }
    }
}
