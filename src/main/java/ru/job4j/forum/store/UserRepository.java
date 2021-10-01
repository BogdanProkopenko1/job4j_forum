package ru.job4j.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
