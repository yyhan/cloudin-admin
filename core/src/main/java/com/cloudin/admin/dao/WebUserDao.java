package com.cloudin.admin.dao;

import com.cloudin.admin.bean.WebUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by YFHan on 2017/1/7 0007.
 */
public interface WebUserDao {

    @Select("SELECT userId, userName, userPassword, isValid, createDate, updateDate " +
            "FROM web_user " +
            "WHERE userId=#{userId}")
    WebUser queryByUserId(@Param("userId") int userId);

    @Select("SELECT userId, userName, userPassword, isValid, createDate, updateDate " +
            "FROM web_user " +
            "WHERE userName=#{userName}")
    WebUser queryByUserName(String userName);
}
