package DB.Services;

import DB.Database.Connection;
import DB.Database.RobotEntity;
import DB.IRobot;
import org.hibernate.Session;

import java.util.ArrayList;

public class RobotService implements IRobot {

    @Override
    public void getAllRobots() {
            Session session = Connection.openSession();


            String hql = "SELECT id FROM RobotEntity";
            ArrayList<Integer> ids = (ArrayList<Integer>) session.createQuery(hql, Integer.class).getResultList();


            Integer[] idArray = ids.toArray(new Integer[0]);


            for (Integer id : idArray) {
                RobotEntity data = session.get(RobotEntity.class, id);
                printRobot(data);
            }

            Connection.disconnect(session);
    }

    @Override
    public void getRobotById(int id) {
        Session session = Connection.openSession();


        RobotEntity data = session.get(RobotEntity.class, id);
        RobotService.printRobot(data);


        Connection.disconnect(session);
    }

    @Override
    public void createRobot(String name, int health, int attackDamage, int attackRange, int movementrate) {
        Session session = Connection.openSession();
        session.beginTransaction();

        RobotEntity robot = new RobotEntity();

        robot.setName(name);
        robot.setHealth(health);
        robot.setAttackDamage(attackDamage);
        robot.setAttackRange(attackRange);
        robot.setMovementRate(movementrate);

        session.persist(robot);

        session.getTransaction().commit();
        Connection.disconnect(session);
    }

    public static void printRobot(RobotEntity data){
        System.out.print("RoboterId: " + data.getId() +
                "\nName: " + data.getName() +
                "\nHealth: " + data.getHealth() +
                "\nAttackDamage: " + data.getAttackDamage() +
                "\nAttackRange: " + data.getAttackRange() +
                "\nMovementRate: " + data.getMovementRate());
    }
}
