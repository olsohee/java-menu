package menu.service;

import menu.domain.Coachs;

import java.util.List;

public class Service {

    private static Service service = new Service();
    private Coachs coachs;

    private Service() {
    }

    public static Service getInstance() {
        return service;
    }

    public void createCoach(List<String> names) {
        coachs = new Coachs(names);
    }
}
