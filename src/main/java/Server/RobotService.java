package Server;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/robots")
public class RobotService {



    private List<Robot> robots = new ArrayList<>();

    RobotService() {
        robots.add(new Robot("Bot", 5, 5, 5));
        robots.add(new Robot("WALL E", 3, 5, 2));
    }

    @GetMapping
    public List<Robot> getAllRobots() {
        return robots;
    }

    @GetMapping("/{id}/")
    public Robot getRobotById(@PathVariable(value = "id")int id){
        for (Robot robot : robots) {
            if (robot.getId() == id) {
                return robot;
            }
        }
        return null;
    }


    @PostMapping("/robot")
    public void createRobot(@RequestBody Robot r) {
        Robot newRobot = new Robot(r.getName(), r.getAttackRange(), r.getAttackDamage(), r.getMovementRate());
        robots.add(newRobot);
    }
}
