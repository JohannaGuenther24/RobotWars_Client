public class Main {
    public static void main(String[] args) {
        View view = new View();
        Robot robot = new Robot();
        Robot enemy = new Robot();
        Map map = new Map();
        GameController controller = new GameController(robot, enemy, map, view);
        boolean gameOn = true;

//        view.intro();
//
//        controller.createPlayer(robot, 'o' , 1,1);
//        controller.createNPC(enemy,"Wall-E",'x',7,1,1,1,14,10);

        controller.showBattlefield(robot, enemy);
//        while(gameOn) {
//            controller.move(robot, enemy);
//            gameOn = !enemy.isKnockedOut();
//            if(gameOn){
//                controller.move(enemy, robot);
//                gameOn = !robot.isKnockedOut();
//            }
//        }
    }
}


//ToDo: Ausrichtungen, Aktuelle höchste MovementRate fängt an, Ausrichten kostet MovementPoint
//ToDo: Hindernisse, Angreifen und durchgehen durch Hindernisse darf nicht möglich sein
//ToDo: Itemfunktion noch nicht in der Main eingebunden
