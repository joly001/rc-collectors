package com.zcsoft.rc.collectors.user.service.impl;


import com.sharingif.cube.support.service.base.impl.BaseServiceImpl;
import com.zcsoft.rc.collectors.user.service.UserService;
import com.zcsoft.rc.user.dao.UserDAO;
import com.zcsoft.rc.user.model.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	private UserDAO userDAO;

	@Resource
	public void setUserDAO(UserDAO userDAO) {
		super.setBaseDAO(userDAO);
		this.userDAO = userDAO;
	}

	@Override
	public User getUserByWristStrapCode(String wristStrapCode) {
		User user = new User();
		user.setWristStrapCode(wristStrapCode);

		return userDAO.query(user);
	}

}
