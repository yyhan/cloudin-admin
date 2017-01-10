package com.cloudin.admin.service.impl;

import com.cloudin.admin.bean.WebUser;
import com.cloudin.admin.dao.WebUserDao;
import com.cloudin.admin.service.api.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YFHan on 2017/1/7 0007.
 */
@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private WebUserDao webUserDao;

    @Override
    public WebUser login(String userName, String password) {
        WebUser webUser = webUserDao.queryByUserName(userName);
        if (webUser.getUserPassword().equals(password))
            return webUser;
        return null;
    }
}
