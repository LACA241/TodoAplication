package ToDoAplication.Repositories;

import ToDoAplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepositories extends JpaRepository<User,Long> {
List<User> findAllByFirst_nameOrSurename(String first_name,String surename);

}
