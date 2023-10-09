package WineService.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AlcoholRepositoryTest {
    AlcoholRepository alcoholRepository = new AlcoholRepository();

    @AfterEach
    void afterEach() {
        alcoholRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Alcohol alcohol = new Alcohol("abc", 12000, 10);

        //when
        Alcohol save = alcoholRepository.save(alcohol);
        //then
        Alcohol tmp = alcoholRepository.findById(save.getId());
        assertThat(tmp).isEqualTo(save);
    }

    @Test
    void findAll() {
        //given
        Alcohol a = new Alcohol("abc", 12000, 10);
        Alcohol b = new Alcohol("abc", 12000, 10);
        alcoholRepository.save(a);
        alcoholRepository.save(b);

        //when
        List<Alcohol> items = alcoholRepository.findAll();
        //then
        assertThat(items.size()).isEqualTo(2);
    }

    @Test
    void update() {
        //given
        Alcohol a = new Alcohol("abc", 12000, 10);
        Alcohol b = new Alcohol("def", 1230, 3);
        Alcohol item = alcoholRepository.save(a);
        //when
        alcoholRepository.update(item.getId(), b);
        //then
        Alcohol tmp = alcoholRepository.findById(item.getId());
        assertThat(tmp.getAlcoholName()).isEqualTo(b.getAlcoholName());
    }

    @Test
    void clearStore() {
    }
}