package com.ncs.recruit.context.system;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.system.mapper.ChangeLogMapper;
import com.ncs.recruit.context.system.model.ChangeLog;
import com.ncs.recruit.infrastructure.utils.common.CoverBeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChangeBeanLogging extends BaseService<ChangeLog> {

    @Autowired
    ChangeLogMapper changeLogMapperDao;
    /**
     * 方法功能：向changeLog表中插入对象的增删改记录，包括更改了哪些值，原来值是什么，修改后的值是什么
     *
     * @param from
     *     新的对象
     * @param to
     *     被修改的对象
     * @param creatorId
     *     操作人的id
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */

    public void changeBeanLog(Object from, Object to, String creatorId)
        throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method fMethod;
        String fValue = null;
        String fValueDeleted = "n";
        String className = from.getClass().getSimpleName();
        String cKey = className + "Id";
        fMethod = from.getClass().getMethod("get" + cKey);// public方法
        fValue = (String) fMethod.invoke(to); // 取getfKey的值
        fMethod = from.getClass().getMethod("getIsDeleted");// public方法
        fValueDeleted = (String) fMethod.invoke(from);// 取getfKey的值
        List<ChangeLog> changeLogList = CoverBeanUtils.coverBean2Bean(from, to);
        for (ChangeLog changeLog : changeLogList) {
            changeLog.setCreatorId(creatorId);
            changeLog.setGmtCreate(new Date());
            if (fValue != null) {
                changeLog.setEntityId(fValue);
                if ("y".equals(fValueDeleted)) {
                    changeLog.setRemark("删除");
                } else {
                    changeLog.setRemark("修改");
                }
            } else {
                changeLog.setRemark("增加");
            }
            changeLog.setEntityName(from.getClass().getName());
            changeLogMapperDao.insertSelective(changeLog);
        }

    }

}
