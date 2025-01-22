package DB;

public interface IRobot {

    //Liste von Robotern; /api/robots
    void getAllRobots();

    //Einen bestimmten Roboter zurückgeben per ID; /api/robots/robot/{id}
    void getRobotById(int id);

    //Neuen Roboter erstellen; /api/robots/robot
    void createRobot(String name, int health, int attackDamage, int attackRange, int movementrate);
}