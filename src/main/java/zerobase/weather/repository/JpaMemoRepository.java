package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

// JpaRepository(Entity, Key값의 타입)

@Repository
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> {

}
