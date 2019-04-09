package com.zcsoft.rc.collectors.user.service;


import com.sharingif.cube.support.service.base.IBaseService;
import com.zcsoft.rc.collectors.api.zc.entity.ZcReq;
import com.zcsoft.rc.user.model.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService extends IBaseService<User, String> {

    /**
     * 根据手环编号查询用户信息
     * @param wristStrapCode
     * @return
     */
    User getUserByWristStrapCode(String wristStrapCode);

}
