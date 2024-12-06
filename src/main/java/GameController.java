import java.util.Random;

public class GameController {

    private final Robot robot;
    private final Robot enemy;
    private final Map map;
    private final View view;


    public GameController(Robot robot, Robot enemy, Map map, View view) {
        this.robot = robot;
        this.enemy = enemy;
        this.map = map;
        this.view = view;
    }

    Item item = new Item(5, 3);
    Item item2 = new Item(5, 6);
    Item item3 = new Item(8, 3);
    Item item4 = new Item(8, 6);
    Item[] items = {item, item2, item3, item4};

    Hindernis hindernis = new Hindernis(2,0);
    Hindernis hindernis2 = new Hindernis(2,1);
    Hindernis[] hindernisse = {hindernis, hindernis2};


    public void createPlayer(Robot robot, char symbol, int x, int y) {
        String blue = "\u001B[34m";
        robot.setName(askName());
        robot.setSymbol(symbol);
        robot.setX(x);
        robot.setY(y);
        robot.setColor(blue);
        setSkillpoints(robot);
    }

    public void createNPC(Robot robot, String name, char symbol, int health, int attackRange, int movementRate, int attackDamage, int x, int y) {
        String red = "\u001B[31m";
        robot.setName(name);
        robot.setSymbol(symbol);
        robot.setHealth(health);
        robot.setAttackRange(attackRange);
        robot.setAttackDamage(attackDamage);
        robot.setMovementRate(movementRate);
        robot.setColor(red);
        robot.setX(x);
        robot.setY(y);
    }

    public String askName() {
        boolean check = false;
        String name = "";

        while (!check) {
            name = view.askName();

            if (name.matches("[a-zA-Zß]+")) {
                check = true;
                view.greeting(name);
            } else {
                view.error();
            }
        }
        return name;
    }

    public void setSkillpoints(Robot robot) {
        int skillpoints = 10;
        boolean check = false;
        int[] values = new int[4];
        String[] attributs = {"Leben", "Bewegungsrate", "Schaden", "Angriffsreichweite"};
        int used = 3;
        int available = skillpoints;

        view.infoSkillpoints(skillpoints);

        for (int i = 0; i <= 3; i++) {
            while (!check) {
                int points = view.askSkillpoints(i, attributs);
                if (points <= skillpoints - used + i) {
                    values[i] = points;
                    used = used + points;
                    available = available - points;
                    check = true;
                } else {
                    view.error();
                }
            }
            check = false;
        }

        robot.setHealth(values[0]);
        robot.setMovementRate(values[1]);
        robot.setAttackDamage(values[2]);
        robot.setAttackRange(values[3]);


        view.viewSkills(attributs, values, available);


//        while(!check) {
//            int answer = view.changeSkills();
//            if(answer == 1){
//                setSkillpoints(robot);
//                check = true;
//            } else if (answer == 2) {
//                check = true;
//            } else{
//                view.error();
//            }
//        }
    }

    public void showBattlefield(Robot robot, Robot enemy) {
        view.viewBattlefield(robot, enemy, map.getColumns(), map.getRows(), map.getMap(), items, hindernisse);
    }

    public void move(Robot robot, Robot enemy) {
        boolean attacked = false;
        for (int i = 1; i <= robot.getMovementRate(); i++) {
            askDirection(robot);
            showBattlefield(robot, enemy);
            view.printPosition(robot);

            //Kontrolle ob schon ein Angriff ausgeführt wurde
            if (!attacked){
                //Kontrolle ob ein Angriff ausgeführt wird oder nicht
                boolean checkAttack = doAttack();
                //Wenn ein Angriff stattgefunden hat wird ein MovementPoint genutzt
                if (checkAttack){
                    i++;
                    attacked = true;
                }
            }

        }
    }

    public void askDirection(Robot robot) {
        int y = robot.getY();
        int x = robot.getX();
        boolean check = false;

        while (!check) {
            String direction = view.viewOptions(robot);
            if (direction.matches("[wasdx]+")) {
                switch (direction) {
                    case "w" -> {
                        if (y > 1) {
                            robot.setY(y - 1);
                            check = true;
                        } else {
                            view.directionErrorAbove();
                        }
                    }
                    case "d" -> {
                        if (x < map.getColumns()) {
                            robot.setX(x + 1);
                            check = true;
                        } else {
                            view.directionErrorRight();
                        }
                    }
                    case "s" -> {
                        if (y < map.getRows()) {
                            robot.setY(y + 1);
                            check = true;
                        } else {
                            view.directionErrorUnderneath();
                        }
                    }
                    case "a" -> {
                        if (x > 1) {
                            robot.setX(x - 1);
                            check = true;
                        } else {
                            view.directionErrorLeft();
                        }
                    }
                    case "x" -> {
                        view.noMove();
                        check = true;
                    }
                }
            } else {
                view.error();
            }
        }
    }


    public boolean doAttack() {
        boolean checkAttack = false;
        for (int x = robot.getX() - robot.getAttackRange(); x <= robot.getX() + robot.getAttackRange(); x++) {
            if (x == enemy.getX() && robot.getY() == enemy.getY()) {
                checkAttack = attack(robot, enemy);
            }
        }
        for (int y = robot.getY() - robot.getAttackRange(); y <= robot.getY() + robot.getAttackRange(); y++) {
            if (y == enemy.getY() && robot.getX() == enemy.getX()) {
                checkAttack = attack(robot, enemy);
            }
        }
        return checkAttack;
    }

    public boolean attack(Robot robot, Robot enemy) {
        boolean check = false;
        boolean checkAttack = false;

        while (!check) {
            int decision = view.questionAttack();
            if (decision == 1) {
                enemy.reduceHealth(robot.getAttackDamage());
                view.viewHealth(enemy);
                boolean knocked = enemy.isKnockedOut();
                if (knocked) {
                    view.viewWinner(robot);
                }
                check = true;
                checkAttack = true;
            } else if (decision == 2) {
                check = true;
            } else {
                view.error();
            }
        }
        return checkAttack;
    }

    public void checkItem(Robot robot) {
        for (Item item : items) {
            if (robot.getX() == item.getItemX() && robot.getY() == item.getItemY()) {
                randomItem();
            }
        }
    }

    public void randomItem() {
        Random random = new Random();

        //Zufällige Zahl wie hoch der positive/negative Effekt sein soll
        int randomNumber = random.nextInt(2) + 1;

        String[] symbols = {"+", "-"};
        //Zufälliges Symbol ob das Item positiv oder negativ sein soll
        String randomSymbol = symbols[random.nextInt(symbols.length)];

        //Zufällige Zahl um einen zufälligen Skill zu ändern; 1: AttackDamage, 2: AttackRange, 3: MovementRate
        int randomSkillNumber = random.nextInt(3) + 1;
        String skill1 = "AttackDamage";
        String skill2 = "AttackRange";
        String skill3 = "Movementrate";


        switch (randomSkillNumber) {
            case 1:
                if (randomSymbol.equals("+")) {
                    robot.setAttackDamage(robot.getAttackDamage() + randomNumber);
                    view.viewPositivItem(skill1, randomNumber);
                } else {
                    robot.setAttackDamage(robot.getAttackDamage() - randomNumber);
                    view.viewNegativItem(skill1, randomNumber);
                }
                break;
            case 2:
                if (randomSymbol.equals("+")) {
                    robot.setAttackRange(robot.getAttackRange() + randomNumber);
                    view.viewPositivItem(skill2, randomNumber);
                } else {
                    robot.setAttackRange(robot.getAttackRange() - randomNumber);
                    view.viewNegativItem(skill2, randomNumber);
                }
                break;
            case 3:
                if (randomSymbol.equals("+")) {
                    robot.setMovementRate(robot.getMovementRate() + randomNumber);
                    view.viewPositivItem(skill3, randomNumber);
                } else {
                    robot.setMovementRate(robot.getMovementRate() - randomNumber);
                    view.viewNegativItem(skill3, randomNumber);
                }
                break;
            default:
        }
    }
}

