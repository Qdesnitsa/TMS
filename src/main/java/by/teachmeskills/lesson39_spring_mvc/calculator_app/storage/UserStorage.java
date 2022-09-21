package by.teachmeskills.lesson39_spring_mvc.calculator_app.storage;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserStorage {
    static UserStorage userStorage = new UserStorage();

    private Map<String, List<String>> map;

    public UserStorage() {
        map = new HashedMap();
        map.put("tom", new ArrayList<>());
        map.put("bob", new ArrayList<>());
        map.put("sam", new ArrayList<>());
        map.put("alena", new ArrayList<>());
    }

    public Map<String, List<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<String>> map) {
        this.map = map;
    }

    public List<String> addToList(String user, String expression) {
        map.get(user).add(expression);
        return map.get(user);
    }

    public List<String> getList(String user) {
        return map.get(user);
    }
}

