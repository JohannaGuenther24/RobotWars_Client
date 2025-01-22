package Classes;

import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner(System.in);

    public void intro() {
        System.out.println("Willkommen zu Classes.Robot Wars!");
        System.out.println();
        System.out.println("""
                 _______               _______
                |@|@|@|@|             |@|@|@|@|
                |@|@|@|@|    _____    |@|@|@|@|
                |@|@|@|@| /\\_T_T_/\\ |@|@|@|@|
                |@|@|@|@||/\\ T T /\\||@|@|@|@|
                 ~~~~/|~||~\\/~T~\\/~||~T~~T\\~
                   /_,|_| \\(-(O)-)/ |_|__|/");
                  /~\\      \\\\8_8//    |_ |_
                 (O_O)  /~~[_____]~~\\   [(@)|
                       (  |       |  )    ~
                      [~` ]       [ '~]
                      |~~|         |~~|
                      |  |         |  |
                     _<\\/>_       _<\\/>_
                    /_====_\\     /_====_\\
                """);
    }

    public String askName() {
        String name;

        System.out.println("Wie soll dein Roboter heißen?");
        name = sc.nextLine();

        return name;
    }

    public void greeting(String name){
        System.out.println("Willkommen "+name+"!\n");
    }

    public void error(){
        System.out.println("Ungültige Eingabe!");
    }

    public void infoSkillpoints(int skillpoints){
        System.out.println("Verteile dein Skillpunkte:\n" +
                "Insgesamt "+skillpoints +" Skillpunkte stehen dir zur verfügung für dein Leben, Angriffsreichweite, Angriffsschaden und Bewegungsrate.\n" +
                "Jeder Skill muss mindestens einen Punkt haben.\n");
    }

    public int askSkillpoints(int skill, String[] attributs){
        int points;

        System.out.println(attributs[skill]+":");
        points = sc.nextInt();

        return points;
    }

    public void viewSkills(String[] attributs, int[] values, int available) {
        System.out.println("\nDu hast noch " + available + " Skillpunkte übrig.\n");

        System.out.println("Skillpunkte");
        for (int i = 0; i <= attributs.length-1; i++){
            System.out.println(attributs[i]+": "+values[i]);
        }
        System.out.println();
    }

    public int changeSkills(){
        System.out.println("Möchtest du die Skillpunkte ändern? \n1 - Ja\n2 - Nein ");
        return sc.nextInt();
    }


    public void viewBattlefield(Robot robot, Robot enemy, Map map, Item[] items, Hindernis[] hindernisse) {
        String reset = "\u001B[0m";

        for (int y = 0; y < map.getRows(); y++) {
            for (int x = 0; x < map.getColumns(); x++) {
                if (x == robot.getX()-1 && y == robot.getY()-1){
                    System.out.print("[" + robot.getColor() + robot.getSymbol() + reset + "]");
                } else if (x == enemy.getX()-1 && y == enemy.getY()-1){
                    System.out.print("[" + enemy.getColor() + enemy.getSymbol() + reset + "]");
                } else {
                    boolean itemFound = false;
                    for (Item item : items) {
                        if (y == item.getItemY()-1 && x == item.getItemX()-1) {
                            System.out.print("[" + item.getColor() + item.getSymbol() + reset + "]");
                            itemFound = true;
                        }
                    }

                    for (Hindernis hindernis : hindernisse) {
                        if (y == hindernis.getItemY()-1 && x == hindernis.getItemX()-1) {
                            System.out.print("[" + hindernis.getColor() + hindernis.getSymbol() + reset + "]");
                            itemFound = true;
                        }
                    }
                    // Leere Felder anzeigen
                    if (!itemFound) {
                        System.out.print("[ ]");
                    }
                }
            }
            System.out.println();
        }
    }

    public String viewOptions(Robot robot){
        String reset = "\u001B[0m";
        System.out.println(robot.getColor()+robot.getName()+"""
                    ! Du bist am Zug!
                    In welche Richtung möchtest du dich bewegen?\s
                    w = oben
                    a = links
                    s = unten
                    d = rechts
                    x = keinen Zug"""+reset);
        return sc.next().toLowerCase();
    }

    public void directionErrorAbove(){
        System.out.println("Das Spielfeld geht nicht weiter nach oben.\nWähle eine andere Richtung.");
    }

    public void directionErrorRight(){
        System.out.println("Das Spielfeld geht nicht weiter nach rechts.\nWähle eine andere Richtung.");
    }

    public void directionErrorLeft(){
        System.out.println("Das Spielfeld geht nicht weiter nach links.\nWähle eine andere Richtung.");
    }

    public void directionErrorUnderneath(){
        System.out.println("Das Spielfeld geht nicht weiter nach unten.\nWähle eine andere Richtung.");
    }

    public void noMove(){
        System.out.println("Du machst keinen Zug.");
    }

    public void printPosition(Robot robot){
        System.out.println("Du befindest du auf der Position " + robot.getX() + "/" + robot.getY());
    }

    public int questionAttack(){
        System.out.println("Möchtest du einen Angriff ausfuehren?\n1 - Ja\n2 - Nein");
        return sc.nextInt();
    }

    public void viewHealth(Robot enemy){
        System.out.println(enemy.getName()+"'s Leben: "+enemy.getHealth());
    }

    public void viewWinner(Robot robot){
        System.out.println(robot.getColor() + robot.getName() + " hat Gewonnen!");
    }

    public void viewPositivItem(String skill, int value){
        System.out.println("Der Skill '"+skill+"' hat sich um " + value + "temporär erhöht.");
    }

    public void viewNegativItem(String skill, int value){
        System.out.println("Der Skill '"+skill+"' hat sich um " + value + "temporär verringert.");
    }
}
                

