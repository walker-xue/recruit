package com.ncs.recruit.context.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.todo.mapper.ToDoListMapper;
import com.ncs.recruit.context.todo.model.ToDoList;

/**
 * 待处理事项
 */
@Service
public class ToDoListService extends BaseService<ToDoList> {

    @Autowired
    ToDoListMapper toDoListMapper;

}
