package com.zj.videoservice.service;

import com.zj.videoservice.entity.OutdoorVideoUpdate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.videoservice.entity.vo.NewUpdateVO;
import com.zj.videoservice.entity.vo.UpdateVO;

import java.util.List;

/**
 * <p>
 * UP主动态通知表 服务类
 * </p>
 *
 * @author zj
 * @since 2021-01-11
 */
public interface OutdoorVideoUpdateService extends IService<OutdoorVideoUpdate> {

    // 查阅用户关注up的动态
    List<UpdateVO> listUpdates(Long fanId);

    // 将动态设为已查阅
    void updateChecked(Long fanId);

    // 通知用户更新(即当Up发布视频后，添加更新动态到动态表)
    void insertUpdate(NewUpdateVO newUpdateVo);

}
