package org.wsh.service.developer;

import org.wsh.pojo.DevUser;

public interface DevUserDaoService {


    //    登录
    public DevUser findByDevName(String devCode);
}
