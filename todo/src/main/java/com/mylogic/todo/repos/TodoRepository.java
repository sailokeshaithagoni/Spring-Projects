package com.mylogic.todo.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.mylogic.todo.models.Todo;

public interface TodoRepository extends CrudRepository <Todo, Long > {
    List < Todo > findByUserName(String user);
}
