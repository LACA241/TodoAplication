package ToDoApplication.Repositories;

import ToDoApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RepositoryRestResource(path = "users")
@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
    @RestResource(exported = false)
    @Override
    void delete(User entity);
List<User> findAllByFirstnameOrSurename(String firstname,String surename);

@Query
    List<User>findAllByFirstnameContaining(String firstname, Pageable page);
@Query
    List<User>findByEmailAddress(String emailAddress);
@Query
    List<User>findByPhone(Long phone);
}
