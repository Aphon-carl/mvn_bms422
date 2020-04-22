package org.wsh.service.developer.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wsh.dao.developer.DevUserDao;
import org.wsh.pojo.DevUser;
import org.wsh.service.developer.DevUserDaoService;

import javax.annotation.Resource;

@Service
@Transactional
public class DevUserDaoServiceImpl implements DevUserDaoService {

    @Resource
    private DevUserDao devuserDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public DevUser findByDevName(String devCode) {
        return devuserDao.findByDevName(devCode);
    }

}
