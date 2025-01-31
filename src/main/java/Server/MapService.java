package Server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapService {

    private List<Map> maps = new ArrayList<>();

    MapService() {
        maps.add(new Map(9,45));

    }

    @GetMapping
    public List<Map> getAllMaps() {
        return maps;
    }

    @GetMapping("/{id}/")
    public Map getMapById(@PathVariable(value = "id")int id){
        for (Map map : maps) {
            if (map.getMapId() == id) {
                return map;
            }
        }
        return null;
    }
}
