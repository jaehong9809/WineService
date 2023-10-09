package WineService.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class AlcoholRepository {
    private static final Map<Long, Alcohol> store = new ConcurrentHashMap<>();
    private static long sequence= 0L;

    public Alcohol save(Alcohol alcohol) {
        alcohol.setId(sequence++);
        store.put(alcohol.getId(), alcohol);
        return alcohol;
    }

    public Alcohol findById(long id) {
        return store.get(id);
    }

    public List<Alcohol> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Alcohol updateAlcohol) {
        Alcohol item = findById(id);
        item.setAlcoholName(updateAlcohol.getAlcoholName());
        item.setPrice(updateAlcohol.getPrice());
        item.setQuantity(updateAlcohol.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
