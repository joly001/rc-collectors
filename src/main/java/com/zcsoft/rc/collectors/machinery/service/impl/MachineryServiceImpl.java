package com.zcsoft.rc.collectors.machinery.service.impl;


import com.sharingif.cube.support.service.base.impl.BaseServiceImpl;
import com.zcsoft.rc.collectors.machinery.service.MachineryService;
import com.zcsoft.rc.machinery.dao.MachineryDAO;
import com.zcsoft.rc.machinery.model.entity.Machinery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MachineryServiceImpl extends BaseServiceImpl<Machinery, String> implements MachineryService {
	
	private MachineryDAO machineryDAO;


	@Resource
	public void setMachineryDAO(MachineryDAO machineryDAO) {
		super.setBaseDAO(machineryDAO);
		this.machineryDAO = machineryDAO;
	}

	@Override
	public Machinery getMachineryByWristStrapCode(String wristStrapCode) {
		Machinery machinery = new Machinery();
		machinery.setWristStrapCode(wristStrapCode);

		return machineryDAO.query(machinery);
	}
}
