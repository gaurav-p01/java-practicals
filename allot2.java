import java.util.Scanner;

public class allotment {

    static final int rooms = 10;
    static final int room_max = 2;
    static final int people = 21;

    static int[] roomcount = new int[rooms];       
    static char[] roomgender = new char[rooms];     
    static String[] roomcourse = new String[rooms]; 

    static String[][] studentname = new String[rooms][room_max];
    static int[][] studentage = new int[rooms][room_max];

    static int allotRoom(String name, char gender, int age, String course) {
        int room = -1;

        for (int i = 0; i < rooms; i++) {
            if (roomcount[i] == 1 && roomgender[i] == gender && roomcourse[i].equals(course)) {
                room = i;
                break;
            }
        }
        if (room == -1) {
            for (int i = 0; i < rooms; i++) {
                if (roomcount[i] == 0) {
                    room = i;
                    roomgender[i] = gender;
                    roomcourse[i] = course;
                    break;
                }
            }
        }
        if (room == -1) {
            return -1;
        }

        studentname[room][roomcount[room]] = name;
        studentage[room][roomcount[room]] = age;
        roomcount[room]++;
        return room;
    }

    static boolean allRoomsFull() {
        for (int i = 0; i < rooms; i++) {
            if (roomcount[i] < room_max ) {
                return false;
            }
        }
        return true;
    }

    static char readgender(Scanner sc) {
        while (true) {
            System.out.print("Gender (M/F): ");
            String g = sc.nextLine().trim().toUpperCase();
            if (g.equals("M") || g.equals("F")) {
                return g.charAt(0);
            }
            System.out.println("Invalid gender. Enter M or F.");
        }
    }

    static int readage(Scanner sc) {
        while (true) {
            System.out.print("Age: ");
            try {
                int age = Integer.parseInt(sc.nextLine().trim());
                if (age > 0 && age < 100) {
                    return age;
                }
            } catch (NumberFormatException e) {
                // fall through to the error message
            }
            System.out.println("Invalid age. Enter a valid number.");
        }
    }

    static String readcourse(Scanner sc) {
        while (true) {
            System.out.print("Course (UG/PG): ");
            String c = sc.nextLine().trim().toUpperCase();
            if (c.equals("UG") || c.equals("PG")) {
                return c;
            }
            System.out.println("Invalid course. Enter UG or PG.");
        }
    }

    static void printAllotment() {
        System.out.println("\nFINAL ROOM ALLOTMENT ");
        for (int i = 0; i < rooms; i++) {
            System.out.print("Room " + (i + 1) + ": ");
            if (roomcount[i] == 0) {
                System.out.println("Empty");
                continue;
            }
            for (int j = 0; j < roomcount[i]; j++) {
                System.out.print(studentname[i][j] + " (" + roomgender[i] + ", "
                        + studentage[i][j] + ", " + roomcourse[i] + ")");
                if (j < roomcount[i] - 1) {
                    System.out.print("  &  ");
                }
            }
            if (roomcount[i] == 1) {
                System.out.print("  [1 bed vacant]");
            }
            System.out.println();
        }
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---- Hostel Room Allotment ----");
        System.out.println(rooms + " rooms, " + room_max + " students per room.\n");

        for (int n = 1; n <= people; n++) {
            System.out.println("--- Student " + n + " of " + people + " ---");

            System.out.print("Name: ");
            String name = sc.nextLine().trim();
            char gender = readgender(sc);
            int age = readage(sc);
            String course = readcourse(sc);

            int room = allotRoom(name, gender, age, course);

            if (room != -1) {
                System.out.println(">> " + name + " has been allotted Room " + (room + 1) + "\n");
            } else if (allRoomsFull()) {
                System.out.println(">> All rooms are occupied. Please check another hostel.\n");
            } else {
                System.out.println(">> No room available with a matching gender and course. "
                        + "Please check another hostel.\n");
            }
        }

        printAllotment();
        sc.close();
    }
}
