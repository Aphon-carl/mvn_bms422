package org.wsh.dao.developer;

import org.wsh.pojo.DevUser;

public interface DevUserDao {

    //    登录
    public DevUser findByDevName(String devCode);
}
