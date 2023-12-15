package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private List<Result> results = new ArrayList<>();

    public Results(List<Coach> coaches) {
        results = coaches.stream()
                .map(coach -> new Result(coach))
                .collect(Collectors.toList());
    }

    public void recommend(Day day, Category category) {
        for (Result result : results) {
            result.recommend(day, category);
        }

    }
}
