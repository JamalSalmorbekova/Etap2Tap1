package com.company;
import java.util.Random;
public class Chyko {    public int roll() {
    Random r = new Random();
    int x = r.nextInt(1, 6);

    switch (x) {
        case 1:
            System.out.println("""
                        |+-------+
                        |        |
                        |   #    |
                        |        |
                        +--------+""");
            break;
        case 2:
            System.out.println("""
                        |+-------+
                        | #      |
                        |        |
                        |      # |
                        +--------+""");
            break;
        case 3:
            System.out.println("""
                        |+-------+
                        | #      |
                        |   #    |
                        |      # |
                        +--------+""");
            break;
        case 4:
            System.out.println("""
                        |+-------+
                        | #    # |
                        |        |
                        | #    # |
                        +--------+""");
            break;
        case 5:
            System.out.println("""
                        |+-------+
                        | #    # |
                        |   #    |
                        | #    # |
                        +--------+""");
            break;
        case 6:
            System.out.println("""
                        |+-------+
                        | # # #  |
                        |        |
                        | # # #  |
                        +--------+""");
            break;
    }
    return x;
}
}


