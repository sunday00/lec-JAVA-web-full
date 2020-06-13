package resolver;

import java.util.HashMap;
import java.util.Map;

public class MapArgumentResolver {
    private Map<String, String> map;

    public MapArgumentResolver() {
        this.map = new HashMap<>();
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setMap(String k, String v) {
        this.map.put(k, v);
    }
}
