import java.util.Scanner;

public class TextBasedGame {
    static int xCoordinate = 0;
    static int yCoordinate = 0;
    static int health = 1000;
    static int strength = 1000;

    static int minotaurHealth = 2500;

    static boolean canPunch = true;

    static boolean canKick = true;
    static boolean swordSwing = false;

    static boolean enemyInSight = false;

    static boolean north = true;

    static boolean east = true;

    static boolean south = true;

    static boolean west = true;

    static boolean hpPotionOnGround = false;

    static int hpPotion = 0;

    static boolean strengthPotionOnGround = false;

    static int strengthPotion = 0;

    static boolean swordOnGround = false;

    static boolean minoDead = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🪦 Labyrinth 🪦" + "\n[Enter \"start\" to start the game]");
        String start = scanner.nextLine();
        while (!start.equals("start")) {
            start = scanner.nextLine();
        }
        gameStartC1();
    }

    //Minotaur
    public static void gameStartC1() {

        String sen1 = "You wake up in a dimly lit room.";
        String sen2 = "\nAs your eyes adjust to the low light, you start to make out details of your surroundings.";
        String sen3 = "\nThe air is musty and heavy with dust that tickles your nose.";
        String sen4 = "\nRunning your hands along the rough stone floor, you feel the grit of sand and pebbles.";
        String sen5 = "\nPushing yourself up off the hard ground, your legs wobble a bit as the blood rushes from your head.";
        String sen6 = "\nThe ominous room is deathly silent except for the sound of your own shuffling footsteps and slow breathing.";
        String sen7 = "\nSquinting in the dim light, you can barely make out four doorways, one on each wall - north, south, east and west.";
        String sen8 = "\nEach dark passageway looks identical.";
        String sen9 = "\nThere are no clues as to where any of them may lead.";
        String sen10 = "\n Your goal is to get out of The Labyrinth alive.";
        printString(sen1);
        printString(sen2);
        printString(sen3);
        printString(sen4);
        printString(sen5);
        printString(sen6);
        printString(sen7);
        printString(sen8);
        printString(sen9);
        printString(sen10);
        reqInput();
    }

    public static void printCoordinates() {
        System.out.println("X: " + xCoordinate + "\nY: " + yCoordinate);
        reqInput();
    }// used for tests

    public static void printInstructions() {
        String sen10 = "\n[Direction keys: n e s w]";
        String sen11 = "[Check stats: stats]";
        String sen12 = "[Punch: punch] [Kick: kick] [Swing sword: swing] [Pick up item: pick] [Drink vial: drink]";
        System.out.println(sen10);
        System.out.println(sen11);
        System.out.println(sen12);
    }


    public static void printString(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            wait(15);
        }
    }

    public static void north() {
        if (north) {
            yCoordinate++;
            hpPotionOnGround = false;
            strengthPotionOnGround = false;
            swordOnGround = false;
            enemyInSight = false;
            coordinateCheck();
            checkGameEndWithoutReq();
            printString("You open the door at the north side of the room and enter a nearly identical chamber.");
            printString("\nThe door closes with an ominous \"boom\" behind you.");
            int random = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
            if (random <= 15 && minoDead == false) {
                enemyInSight = true;
                printString("\nAs you creep into the shadowy chamber, a pair of baleful red eyes suddenly glare at you from the darkness.");
                printString("\nWith a guttural growl, the minotaur emerges into a shaft of light, his massive horned head lowered aggressively.");
                printString("\nHot, snorting breaths blast from his nostrils as he paws the debris-strewn floor, never breaking his unblinking crimson stare.");
                printString("\nSinewy muscles ripple under coarse fur as he shifts, blocking the only exit with his towering, intimidating bulk.");
                minotaurAttack();
            } else if (random > 15 && random <= 25) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                hpPotionOnGround = true;
                reqInput();
            } else if (random > 25 && random <= 35) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                strengthPotionOnGround = true;
                reqInput();
            } else if (random > 35 && random <= 50 && !swordSwing) {
                printString("\nStepping warily into the crypt-like chamber, a glint of metal catches your eye.");
                printString("\nLying discarded on the dusty floor is an ancient sword, its blade still keen despite the passing ages.");
                swordOnGround = true;
                reqInput();
            } else {
                reqInput();
            }
        } else {
            System.out.println("You walk north and unfortunately hit your head. ");
            health = health - (int) Math.floor(Math.random() * (20 - 10 + 1) + 10);
            System.out.println("Health: " + health);
            checkGameEnd();
        }
    }

    public static void east() {
        if (east) {
            xCoordinate++;
            hpPotionOnGround = false;
            strengthPotionOnGround = false;
            swordOnGround = false;
            enemyInSight = false;
            coordinateCheck();
            checkGameEndWithoutReq();
            printString("You open the door at the east side of the room and enter a nearly identical chamber.");
            printString("\nThe door closes with an ominous \"boom\" behind you.");
            int random = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
            if (random <= 15 && minoDead == false) {
                enemyInSight = true;
                printString("\nAs you creep into the shadowy chamber, a pair of baleful red eyes suddenly glare at you from the darkness.");
                printString("\nWith a guttural growl, the minotaur emerges into a shaft of light, his massive horned head lowered aggressively.");
                printString("\nHot, snorting breaths blast from his nostrils as he paws the debris-strewn floor, never breaking his unblinking crimson stare.");
                printString("\nSinewy muscles ripple under coarse fur as he shifts, blocking the only exit with his towering, intimidating bulk.");
                minotaurAttack();
            } else if (random > 15 && random <= 25) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                hpPotionOnGround = true;
                reqInput();
            } else if (random > 25 && random <= 35) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                strengthPotionOnGround = true;
                reqInput();
            } else if (random > 35 && random <= 50 && !swordSwing) {
                printString("\nStepping warily into the crypt-like chamber, a glint of metal catches your eye.");
                printString("\nLying discarded on the dusty floor is an ancient sword, its blade still keen despite the passing ages.");
                swordOnGround = true;
                reqInput();
            } else {
                reqInput();
            }
        } else {
            System.out.println("You walk east and unfortunately hit your head. ");
            health = health - (int) Math.floor(Math.random() * (20 - 10 + 1) + 10);
            System.out.println("Health: " + health);
            checkGameEnd();
        }
    }

    public static void south() {
        if (south) {
            yCoordinate--;
            hpPotionOnGround = false;
            strengthPotionOnGround = false;
            swordOnGround = false;
            enemyInSight = false;
            coordinateCheck();
            checkGameEndWithoutReq();
            printString("You open the door at the south side of the room and enter a nearly identical chamber.");
            printString("\nThe door closes with an ominous \"boom\" behind you.");
            int random = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
            if (random <= 15 && minoDead == false) {
                enemyInSight = true;
                printString("\nAs you creep into the shadowy chamber, a pair of baleful red eyes suddenly glare at you from the darkness.");
                printString("\nWith a guttural growl, the minotaur emerges into a shaft of light, his massive horned head lowered aggressively.");
                printString("\nHot, snorting breaths blast from his nostrils as he paws the debris-strewn floor, never breaking his unblinking crimson stare.");
                printString("\nSinewy muscles ripple under coarse fur as he shifts, blocking the only exit with his towering, intimidating bulk.");
                minotaurAttack();
            } else if (random > 15 && random <= 25) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                hpPotionOnGround = true;
                reqInput();
            } else if (random > 25 && random <= 35) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                strengthPotionOnGround = true;
                reqInput();
            } else if (random > 35 && random <= 50 && !swordSwing) {
                printString("\nStepping warily into the crypt-like chamber, a glint of metal catches your eye.");
                printString("\nLying discarded on the dusty floor is an ancient sword, its blade still keen despite the passing ages.");
                swordOnGround = true;
                reqInput();
            } else {
                reqInput();
            }
        } else {
            System.out.println("You walk south and unfortunately hit your head. ");
            health = health - (int) Math.floor(Math.random() * (20 - 10 + 1) + 10);
            System.out.println("Health: " + health);
            checkGameEnd();
        }
    }

    public static void west() {
        if (west) {
            xCoordinate--;
            hpPotionOnGround = false;
            strengthPotionOnGround = false;
            swordOnGround = false;
            enemyInSight = false;
            coordinateCheck();
            checkGameEndWithoutReq();
            printString("You open the door at the west side of the room and enter a nearly identical chamber.");
            printString("\nThe door closes with an ominous \"boom\" behind you.");
            int random = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
            if (random <= 15 && minoDead == false) {
                enemyInSight = true;
                printString("\nAs you creep into the shadowy chamber, a pair of baleful red eyes suddenly glare at you from the darkness.");
                printString("\nWith a guttural growl, the minotaur emerges into a shaft of light, his massive horned head lowered aggressively.");
                printString("\nHot, snorting breaths blast from his nostrils as he paws the debris-strewn floor, never breaking his unblinking crimson stare.");
                printString("\nSinewy muscles ripple under coarse fur as he shifts, blocking the only exit with his towering, intimidating bulk.");
                minotaurAttack();
            } else if (random > 15 && random <= 25) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                hpPotionOnGround = true;
                reqInput();
            } else if (random > 25 && random <= 35) {
                printString("\nYou also notice a vial of mysterious liquid lying on the ground.");
                strengthPotionOnGround = true;
                reqInput();
            } else if (random > 35 && random <= 50 && !swordSwing) {
                printString("\nStepping warily into the crypt-like chamber, a glint of metal catches your eye.");
                printString("\nLying discarded on the dusty floor is an ancient sword, its blade still keen despite the passing ages.");
                swordOnGround = true;
                reqInput();
            } else {
                reqInput();
            }
        } else {
            System.out.println("You walk west and unfortunately hit your head. ");
            health = health - (int) Math.floor(Math.random() * (20 - 10 + 1) + 10);
            System.out.println("Health: " + health);
            checkGameEnd();
        }
    }

    public static void punch() {
        if (canPunch) {
            if (enemyInSight) {
                minotaurHealth = minotaurHealth - (int) (strength * 0.07);
                System.out.println("Minotaur: \"ROARRR!\"");
                System.out.println("Minotaur Health: " + minotaurHealth);
                checkGameEndWithoutReq();
                int minoAttack = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
                if (minoAttack <= 10) {
                    minotaurAttack();
                } else {
                    reqInput();
                }
            } else {
                printString("You throw your fist out in front of you and hit nothing. ");
                strength = strength -= Math.floor(Math.random() * (2 - 0 + 1) + 0);
                System.out.println("\nStrength: " + strength);
                checkGameEnd();
            }
        } else {
            printString("You attempt to raise your arm but it involuntarily drops. ");
            strength = strength - (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            System.out.println("Strength: " + strength);
            health = health - (int) Math.floor(Math.random() * (5 - 3 + 1) + 3);
            System.out.println("Health: " + health);
            checkGameEnd();
        }

    }

    public static void kick() {
        if (canKick) {
            if (enemyInSight) {
                minotaurHealth = minotaurHealth - (int) (strength * 0.1);
                System.out.println("Minotaur: \"ROARRR!\"");
                System.out.println("Minotaur Health: " + minotaurHealth);
                checkGameEndWithoutReq();
                int minoAttack = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
                if (minoAttack <= 13) {
                    minotaurAttack();
                } else {
                    reqInput();
                }
            } else {
                printString("You swing your foot in front of you and hit nothing, making you lose your balance and feel slightly disoriented.");
                strength = strength - (int) Math.floor(Math.random() * (15 - 10 + 1) + 10);
                System.out.println("\nStrength: " + strength);
                checkGameEnd();
            }
        } else {
            printString("You attempt to lift your leg to perform a kick but collapses instead.");
            strength = strength - (int) Math.floor(Math.random() * (15 - 10 + 1) + 10);
            System.out.println("\nStrength: " + strength);
            health = health - (int) Math.floor(Math.random() * (15 - 10 + 1) + 10);
            System.out.println("\nHealth: " + health);
            checkGameEnd();
        }
    }

    public static void swing() {
        if (swordSwing) {
            if (enemyInSight) {
                minotaurHealth = minotaurHealth - (int) (strength * ((Math.floor(Math.random() * (300 - 150 + 1) + 150) / 1000)));
                System.out.println("Minotaur: \"ROARRRRRR\"");
                System.out.println("Minotaur Health: " + minotaurHealth);
                checkGameEndWithoutReq();
                int minoAttack = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
                if (minoAttack <= 24) {
                    minotaurAttack();
                } else {
                    reqInput();
                }
            } else {
                printString("You swing your sword and hear it whoosh through the air.");
                strength = strength - (int) Math.floor(Math.random() * (15 - 10 + 1) + 10);
                System.out.println("\nStrength: " + strength);
                checkGameEnd();
            }
        } else {
            printString("You reach for your sword, but your hand closes on air.");
            strength = strength - (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
            System.out.println("\nStrength: " + strength);
            checkGameEnd();
        }

    }

    public static void pick() {
        if (swordOnGround) {
            printString("You picked up the sword.");
            swordSwing = true;
            swordOnGround = false;
            reqInput();
        } else if (hpPotionOnGround) {
            printString("You picked up a health potion.");
            hpPotion++;
            hpPotionOnGround = false;
            reqInput();
        } else if (strengthPotionOnGround) {
            printString("You picked up a strength potion.");
            strengthPotion++;
            strengthPotionOnGround = false;
            reqInput();
        } else {
            printString("You reach down and hold up a handful of dirt and dust.");
            reqInput();
        }

    }

    public static void drink() {
        int random = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        if (random == 1 && hpPotion > 0) {
            health = health + (int) Math.floor(Math.random() * (200 - 50 + 1) + 50);
            printString("You lift the vial of magical liquid to your lips.");
            printString("\nYou suddenly feel freezing cold, despite the warmth of the torches lighting up the room.");
            printString("\nThe iciness reaches deep inside you, and for a moment you hallucinate that you are surrounded by a howling blizzard at the north pole.");
            System.out.println("\nHealth: " + health);
            reqInput();
        } else if (strengthPotion > 0) {
            strength = strength + (int) Math.floor(Math.random() * (200 - 50 + 1) + 50);
            printString("You lift the vial of magical liquid to your lips.");
            printString("\nThe solution burns in your mouth.");
            printString("\nYou momentarily feel as if you were engulfed in a sea of fire.");
            System.out.println("\nStrength: " + strength);
            reqInput();
        } else {
            printString("You fumble around in your pockets for something to drink, but unfortunately find nothing.");
            printString("\nThe feeling of dryness in your mouth is amplified.");
            reqInput();
        }
    }

    public static void minotaurAttack() {
        printString("The monstrous minotaur bellows, the guttural roar echoing through the shadowy labyrinth.");
        printString("\nHis bulging muscles ripple under coarse fur as he stampedes toward you, cloven hooves pounding the stone floor.");
        printString("\nLowering his colossal horned head, eyes burning with murderous fury, he lunges forth.");
        int rand = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
        if (rand <= 3) {
            canPunch = false;
            printString("\nBlood gushes out from your arm as the monster's horns impales it.");
            health = health - (int) Math.floor(Math.random() * (160 - 50 + 1) + 50);
            strength = strength - (int) Math.floor(Math.random() * (160 - 50 + 1) + 50);
            System.out.println("\nHealth: " + health);
            System.out.println("\nStrength: " + strength);
            checkGameEnd();
        } else if (rand > 3 && rand <= 5) {
            canKick = false;
            printString("\nBlood bursts from your leg as the monster's horns impales it.");
            health = health - (int) Math.floor(Math.random() * (200 - 70 + 1) + 70);
            strength = strength - (int) Math.floor(Math.random() * (200 - 70 + 1) + 70);
            System.out.println("\nHealth: " + health);
            System.out.println("\nStrength: " + strength);
            checkGameEnd();
        } else if (rand > 5 && rand <= 7 && swordSwing) {
            swordSwing = false;
            printString("\nThe Minotaur's horns hits your blade, knocking it out of your hand.");
            swordOnGround = true;
            reqInput();
        } else {
            health = health - (int) Math.floor(Math.random() * (120 - 30 + 1) + 30);
            strength = strength - (int) Math.floor(Math.random() * (120 - 30 + 1) + 30);
            printString("\nThe twisting horns of the minotaur bash against your chest with the force of a battering ram, knocking the wind from your lungs.");
            printString("\nYou are hurled backwards through the musty dungeon air, your body slamming heavily into the rough-hewn stone wall before crumpling to the sandy floor.");
            printString("\nWheezing faintly as you struggle to regain your breath and stand up, the bitter taste of blood seeps into your mouth while pain throbs across your battered back.");
            printString("\nThe hulking beast before you paws at the ground, snorting hot puffs of air as it prepares to charge once more through the dim passage with brutal intent.");
            System.out.println("\nHealth: " + health);
            System.out.println("\nStrength: " + strength);
            checkGameEnd();
        }

    }

    public static void checkGameEnd() {
        if (health < 0) {
            printString("The minotaur charges, his thundering roar echoing through the stone corridors as he bowls you over with crushing force.");
            printString("\nHis fetid breath washes over you as he pins you down, claws and horns rending flesh.");
            printString("\nYou scream in agony as the razor-sharp points gouge into your gut, the beast tearing you asunder in a frenzy.");
            printString("\nYour blood pools on the gritty floor as the light dims, the minotaur's guttural bellows ringing in your ears as oblivion takes you.");
            System.exit(0);
        } else if (minotaurHealth < 0 && !minoDead) {
            printString("The minotaur staggers back with an ear-splitting shriek, black blood streaming from the mortal wound.");
            printString("\nCrumpling to the floor, the fading cries of the minotaur turn into dust, carried off in the dank subterranean breeze.");
            printString("\nOnly twisting horns remain amid scattered powder.");
            enemyInSight = false;
            minoDead = true;
            reqInput();
        } else if (yCoordinate == 3 && xCoordinate == 5) {
            printString("You emerge at last from the tunnels' sinister grasp, blinking against the sudden sunlight.");
            printString("\nFresh air fills your lungs as you stand at the precipice, a grassy world sprawling before you.");
            printString("\nFar below, birds wheel freely through clear skies.");
            printString("\nThe ordeal within the minotaur's lair already seems a lifetime away.");
            printString("\nYou made it through the labyrinth and now, beyond its shadow, the future lies ahead.");
            System.exit(0);
        } else {
            reqInput();
        }
    }

    public static void checkGameEndWithoutReq() {
        if (health < 0) {
            printString("The minotaur charges, his thundering roar echoing through the stone corridors as he bowls you over with crushing force.");
            printString("\nHis fetid breath washes over you as he pins you down, claws and horns rending flesh.");
            printString("\nYou scream in agony as the razor-sharp points gouge into your gut, the beast tearing you asunder in a frenzy.");
            printString("\nYour blood pools on the gritty floor as the light dims, the minotaur's guttural bellows ringing in your ears as oblivion takes you.");
            System.exit(0);
        } else if (minotaurHealth < 0 && !minoDead) {
            printString("The minotaur staggers back with an ear-splitting shriek, black blood streaming from the mortal wound.");
            printString("\nCrumpling to the floor, the fading cries of the minotaur turn into dust, carried off in the dank subterranean breeze.");
            printString("\nOnly twisting horns remain amid scattered powder.");
            enemyInSight = false;
            minoDead = true;
            reqInput();
        } else if (yCoordinate == 3 && xCoordinate == 5) {
            printString("You emerge at last from the tunnels' sinister grasp, blinking against the sudden sunlight.");
            printString("\nFresh air fills your lungs as you stand at the precipice, a grassy world sprawling before you.");
            printString("\nFar below, birds wheel freely through clear skies.");
            printString("\nThe ordeal within the minotaur's lair already seems a lifetime away.");
            printString("\nYou made it through the labyrinth and now, beyond its shadow, the future lies ahead.");
            System.exit(0);
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void coordinateCheck() {
        if (yCoordinate >= 5) {
            north = false;
        } else {
            north = true;
        }
        if (yCoordinate <= -5) {
            south = false;
        } else {
            south = true;
        }
        if (xCoordinate >= 5) {
            east = false;
        } else {
            east = true;
        }
        if (xCoordinate <= -5) {
            west = false;
        } else {
            west = true;
        }
    }


    //Math.floor(Math.random() *(max - min + 1) + min)
    // for random int
    public static void reqInput() {
        printInstructions();
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        String d1 = input.nextLine();
        while (!d1.equals("n") && !d1.equals("e") && !d1.equals("s") && !d1.equals("w") && !d1.equals("punch") && !d1.equals("kick") && !d1.equals("swing") && !d1.equals("pick") && !d1.equals("stats") && !d1.equals("drink") && !d1.equals("coords")) {
            d1 = input.nextLine();
        }
        if (d1.equals("stats")) {
            System.out.println("Health: " + health);
            System.out.println("Strength: " + strength);
            reqInput();
        } else if (d1.equals("n")) {
            north();
        } else if (d1.equals("e")) {
            east();
        } else if (d1.equals("s")) {
            south();
        } else if (d1.equals("w")) {
            west();
        } else if (d1.equals("punch")) {
            punch();
        } else if (d1.equals("kick")) {
            kick();
        } else if (d1.equals("swing")) {
            swing();
        } else if (d1.equals("pick")) {
            pick();
        } else if (d1.equals("drink")) {
            drink();
        } else if (d1.equals("coords")) {
            printString("Hidden command for bug tests, you shouldn't know this!");
            reqInput();
            //printCoordinates();
        }
    }
}