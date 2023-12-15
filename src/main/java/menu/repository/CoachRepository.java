package menu.repository;

import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.service.RecommendService;

import java.util.ArrayList;
import java.util.List;

public class CoachRepository {

    private static final CoachRepository coachRepository = new CoachRepository();
    private Coaches coaches;

    private CoachRepository() {
    }

    public static CoachRepository getInstance() {
        return coachRepository;
    }

    public void save(Coaches coaches) {
        this.coaches = coaches;
    }

    public Coaches findCoaches() {
        return coaches;
    }
}
