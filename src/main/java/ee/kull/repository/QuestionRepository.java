package ee.kull.repository;

import ee.kull.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository <Question,Long> {
@Query(value="select * from questions t where t.topic like %:topic% ", nativeQuery = true)
List<Question> findAllByTopic(@Param("topic") String topic);







}
