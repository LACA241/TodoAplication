package ToDoAplication.Repositories;

import ToDoAplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
List<User> findAllByFirstnameOrSurename(String first_name,String surename);
@Query
List<User>findAllByAnyFirstname(@Param("searchString") String search, Pageable page);

}
