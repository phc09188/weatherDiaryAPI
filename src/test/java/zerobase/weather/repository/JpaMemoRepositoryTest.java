package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import zerobase.weather.domain.Memo;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@EnableScheduling
class JpaMemoRepositoryTest {
    @Autowired
    JpaMemoRepository jpaMemoRepository;
    @Test
    void insertMemoText(){
        //given
        Memo memo = new Memo(10, "jpa new memo");
        //when
        jpaMemoRepository.save(memo);

        //then
        List<Memo> list = jpaMemoRepository.findAll();
        assertTrue(!list.isEmpty());
    }

    @Test
    void findById(){
        //given
        Memo memo = new Memo(10, "new id");

        //when
        Memo memo1 = jpaMemoRepository.save(memo);
        Optional<Memo> result = jpaMemoRepository.findById(memo1.getId());
        //then
        assertEquals(result.get().getText(), "new id");
    }
}