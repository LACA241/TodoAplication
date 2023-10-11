package ToDoApplication.Repositories;

import ToDoApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
List<User> findAllByFirstnameOrSurename();
@Query
List<User>findByFirstnameOrSurenameLike(String firstname,String surename);
@Query
    List<User>findAllByAnyName(@Param("searchString") String search, Pageable page);
@Query
    List<User>findByEmailAddress();
}