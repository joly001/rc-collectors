package com.zcsoft.rc.collectors.machinery.service;


import com.sharingif.cube.support.service.base.IBaseService;
import com.zcsoft.rc.machinery.model.entity.Machinery;


public interface MachineryService extends IBaseService<Machinery, String> {

    /**
     * 根据手环编号查询机械信息
     * @param wristStrapCode
     * @return
     */
    Machinery getMachineryByWristStrapCode(String wristStrapCode);
	
}
