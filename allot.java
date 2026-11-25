
public class allot{

    static final int rooms = 10;
    static final int room_max = 2;
    static final int people= 21;

    static int[] roomcount = new int[rooms]; 

    static String[][] studentname = new String[rooms][room_max];

    static String[] names = {
        "Aarav", "rahul", "Aditya", "rohi", "aashish",
        "aman", "Krishna", "kartikey", "Shaurya", "Rohan",
        "Kabir", "gaurav", "harsh", "harshit", "Yash",
        "Rudra", "Karan", "Nikhil", "Siddharth", "Manav",
        "Om"
    };

    static int allotRoom(String name) {
        int room = -1;
        for (int i = 0; i < rooms; i++) {
            if (roomcount[i] < room_max) {
                room = i;
                break;
            }
        }

        if (room == -1) {
            return -1;
        }

        studentname[room][roomcount[room]] = name;
        roomcount[room]++;
        return room;
    }

    public static void main(String[] args) {
        System.out.println("---- Hostel Room Allotment ----");
        System.out.println(rooms + " rooms, " + room_max+ " students per room.\n");

        String notAllotted = null;

        for (int n = 0; n < people; n++) {
            String name = names[n];
            int room = allotRoom(name);

            if (room != -1) {
                System.out.println(">> " + name + " has been allotted Room " + (room + 1));
            } else {
                System.out.println(">> " + name + " could NOT be allotted a room (hostel full)");
                notAllotted = name;
            }
        }

        System.out.println("\n========== FINAL ROOM ALLOTMENT ==========");
        for (int i = 0; i < rooms; i++) {
            System.out.print("Room " + (i + 1) + ": ");
            if (roomcount[i] == 0) {
                System.out.println("Empty");
                continue;
            }
            for (int j = 0; j < roomcount[i]; j++) {
                System.out.print(studentname[i][j]);
                if (j < roomcount[i] - 1) {
                    System.out.print("  &  ");
                }
            }
            System.out.println();
        }
        System.out.println("==========================================");

        System.out.println("\nStudent(s) who did NOT get a room:");
        if (notAllotted != null) {
            System.out.println("- " + notAllotted);
        } else {
            System.out.println("- None, everyone was allotted a room.");
        }
    }
}
