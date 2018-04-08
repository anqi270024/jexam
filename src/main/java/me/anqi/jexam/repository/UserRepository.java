package me.anqi.jexam.repository;

import me.anqi.jexam.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository<User,Long> {

    User findUserByName(String name);

    User findUserByNameAndPasswordAndRole(@Param("name") String name,
                                      @Param("password") String password,
                                      @Param("role") int role);

    List<User> findAllByRole(int role);
}
