package com.ncs.recruit.context.todo.mapper;

import org.springframework.stereotype.Repository;

import com.github.skunk.data.utils.BasisMapper;
import com.ncs.recruit.context.todo.model.ToDoList;

@Repository
public interface ToDoListMapper extends BasisMapper<ToDoList> {

}