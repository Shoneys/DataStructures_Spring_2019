import java.util.Scanner;

public class Manhatten {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your starting street 1-100");
        int cStreet = in.nextInt();

        System.out.println("Enter your starting avenue 1-10");
        int cAve = in.nextInt();

        System.out.println("Enter your ending street 1-100");
        int eStreet = in.nextInt();
        System.out.println("Enter your ending avenue 1-10");
        int eAve = in.nextInt();
        if (cStreet < 1 || cStreet > 100 || cAve < 1 || cAve > 10 || eStreet < 1 || eStreet > 100 || eAve < 1 || eAve > 10) {
            System.out.println("Please enter a valid number.");
            main(args);
        }

        calculating(eStreet, eAve, cStreet, cAve);
    }

    public static void calculating(int eStreet, int eAve, int cStreet, int cAve) {
        //even streets Westward, even ave Southward
        //the commented print statements are for debug

        while (cStreet != eStreet || cAve != eAve) {
            String dAve = cAve + " Ave";
            String dStreet = cStreet + " Str";
            if (cStreet % 2 == 0) { //if current street is even
                //System.out.println("1Your current area: (" + cStreet + ", " + cAve + ")");
                if (cAve < eAve) { //if current ave is less than end ave
                    cAve++; //go west
                    System.out.println("go left on " + dStreet);
                } else if (cAve > eAve) {
                    if (cAve % 2 == 0) { //if current ave is even
                        //System.out.println("2Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cStreet > eStreet) { //if current street is greater than end street
                            cStreet--; //go south
                            System.out.println("go south on " + dAve);
                        } else if (cStreet < eStreet) {
                            cAve++;
                            System.out.println("go left on " + dStreet);
                        }
                    } else { //if current ave is odd
                        //System.out.println("3Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cStreet < eStreet) { //if current street is less than end street
                            cStreet++; // go north
                            System.out.println("go north on " + dAve);
                        } else if (cStreet > eStreet) {
                            cAve++;
                            System.out.println("go left on " + dStreet);
                        }
                    }
                }
            } else if (cStreet % 2 == 1) { //if current street is odd
                //System.out.println("4Your current area: (" + cStreet + ", " + cAve + ")");
                if (cAve > eAve) {
                    cAve--; //go east
                    System.out.println("go right on " + dStreet);
                } else if (cAve < eAve) {
                    if (cAve % 2 == 0) { //if current ave is even
                        //System.out.println("5Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cStreet > eStreet) { //if current street is greater than end street
                            cStreet--; //go south
                            System.out.println("go south on " + dAve);
                        } else if (cStreet < eStreet) {
                            cAve--;
                            System.out.println("go right on " + dStreet);
                        }
                    }
                    if (cAve % 2 == 1) { //if current ave is odd
                        //System.out.println("6Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cStreet < eStreet) { //if current street is less than end street
                            cStreet++; // go north
                            System.out.println("go north on " + dAve);
                        } else if (cStreet > eStreet) {
                            cAve--;
                            System.out.println("go right on " + dStreet);
                        }
                    }
                }
            }


            if (cAve % 2 == 0) { //if current ave is even
                //System.out.println("7Your current area: (" + cStreet + ", " + cAve + ")" + "(" + eStreet + ", " + eAve + ")");
                if (cStreet > eStreet) { //if current street is greater than end street
                    cStreet--; //go south
                    System.out.println("go south on " + dAve);
                } else if (cStreet < eStreet) {
                    if (cStreet % 2 == 0) { //if current street is even
                        //System.out.println("8Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cAve < eAve) { //if current ave is greater than end ave
                            cAve++; //go west
                            System.out.println("go left on " + dStreet);
                        } else if (cAve > eAve) {
                            cStreet--;
                            System.out.println("go south on " + dAve);
                        }
                    }
                    if (cStreet % 2 == 1) { //if current street is odd
                        //System.out.println("9Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cAve > eAve) { //if current ave is less than end ave
                            cAve--; // go east
                            System.out.println("go right on " + dStreet);
                        } else if (cAve < eAve) {
                            cStreet--;
                            System.out.println("go south on " + dAve);
                        }
                    }
                }
            } else if (cAve % 2 == 1) { //if current ave is odd
                //System.out.println("10Your current area: (" + cStreet + ", " + cAve + ")");
                if (cStreet < eStreet) { //if current street is less than end street
                    cStreet++; // go north
                    System.out.println("go north on " + dAve);
                } else if (cStreet > eStreet) {
                    if (cStreet % 2 == 0) { //if current street is even
                        //System.out.println("11Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cAve < eAve) { //if current ave is greater than end ave
                            cAve++; //go west
                            System.out.println("go left on " + dStreet);
                        } else if (cAve > eAve) {
                            cStreet++;
                            System.out.println("go north on " + dAve);
                        }
                    }
                    if (cStreet % 2 == 1) { //if current street is odd
                        //System.out.println("12Your current area: (" + cStreet + ", " + cAve + ")");
                        if (cAve > eAve) { //if current ave is less than end ave
                            cAve--; // go east
                            System.out.println("go right on " + dStreet);
                        } else if (cAve < eAve) {
                            cStreet++;
                            System.out.println("go north on " + dAve);
                        }
                    }
                }
            }

            //I encountered a bug where if one variable reached its end location too early, the program would be thrown in to infinite loop.
            if (cAve == eAve) {
                if (eAve % 2 == 1) {
                    //System.out.println("1test");
                    if (cStreet > eStreet && cStreet % 2 == 0) {
                        //System.out.println("1test1");
                        cAve++;
                        System.out.println("go left on " + dStreet);
                    } else if (cStreet > eStreet && cStreet % 2 == 1) {
                        //System.out.println("1test2");
                        cAve--;
                        System.out.println("go right on " + dStreet);
                    } else if (cStreet < eStreet) {
                        //System.out.println("1test3");
                        cStreet++;
                        System.out.println("go north on " + dAve);
                    }
                } else if (eAve % 2 == 0) {
                    //System.out.println("2test");
                    if (cStreet < eStreet && cStreet % 2 == 1) {
                        //System.out.println("2test1");
                        cAve--;
                        System.out.println("go right on " + dStreet);
                    } else if (cStreet < eStreet && cStreet % 2 == 0) {
                        //System.out.println("2test2");
                        cAve++;
                        System.out.println("go left on " + dStreet);
                    } else if (cStreet > eStreet) {
                        //System.out.println("2test3");
                        cStreet--;
                        System.out.println("go south on " + dAve);
                    }
                }
            }
            if (cStreet == eStreet) {
                if (eStreet % 2 == 1) {
                    //System.out.println("3test");
                    if (cAve < eAve && cAve % 2 == 0) {
                        //System.out.println("3test1");
                        cStreet--;
                        System.out.println("go south on " + dAve);
                    } else if (cAve < eAve && cAve % 2 == 1) {
                        //System.out.println("3test2");
                        cStreet++;
                        System.out.println("go north on " + dAve);
                    } else if (cAve > eAve) {
                        //System.out.println("3test3");
                        cAve--;
                        System.out.println("go right on " + dStreet);
                    }
                } else if (eStreet % 2 == 0) {
                    //System.out.println("4test");
                    if (cAve > eAve && cAve % 2 == 1) {
                        //System.out.println("4test1");
                        cStreet++;
                        System.out.println("go north on " + dAve);
                        System.out.println("go north on " + dAve);
                    } else if (cAve > eAve && cAve % 2 == 0) {
                        //System.out.println("4test2");
                        cStreet--;
                        System.out.println("go south on " + dAve);
                    } else if (cAve < eAve) {
                        //System.out.println("4test3");
                        cAve++;
                        System.out.println("go west on " + dStreet);
                    }
                }
            }
        }
        System.out.println("You have arrived at your destination: (" + cStreet + " street, " + cAve + " Ave)");
    }
}