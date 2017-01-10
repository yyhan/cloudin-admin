package com.cloudin.admin.service.api;

import com.cloudin.admin.bean.WebUser;

/**
 * Created by YFHan on 2017/1/7 0007.
 */
public interface WebUserService {
    WebUser login(String userName,String password);
}

