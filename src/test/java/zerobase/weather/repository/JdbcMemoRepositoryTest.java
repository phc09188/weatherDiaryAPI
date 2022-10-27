package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zerobase.weather.domain.Memo;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class JdbcMemoRepositoryTest {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;
    @Test
    void insertMemoTest(){
        //given
        Memo newMemo = new Memo(2, "this is new memo");
        //when
        jdbcMemoRepository.save(newMemo);
        //then
        Optional<Memo> result =  jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText(), "this is new memo");
    }
    @Test
    void findAllMemoTest(){
        //given
        List<Memo> memoList = jdbcMemoRepository.findAll();
        //when

        //then
        assertNotNull(memoList);
    }


}