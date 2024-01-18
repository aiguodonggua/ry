package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.entity.play.PlayMessagePush;
import com.ruoyi.system.domain.dto.play.PushOperationDTO;
import com.ruoyi.system.domain.dto.play.QueryRobotDetailDTO;
import com.ruoyi.system.domain.vo.play.QueryRobotDetailVO;
import com.ruoyi.system.domain.vo.play.RobotStatisticsVO;

import java.util.List;

/**
 *
 */
public interface PlayMessagePushService extends IService<PlayMessagePush> {


    List<PlayMessagePush> listByPlayId(Integer playId);

    void operation(PushOperationDTO dto);

    /**
     * 暂停群推送
     *
     * @param pushId
     */
    void pauseGroupPush(Integer pushId);

    void pauseGroupPush(PlayMessagePush playMessagePush);

    /**
     * 继续推送
     *
     * @param pushId
     */
    void resumeGroupPush(Integer pushId);

    void resumeGroupPush(PlayMessagePush playMessagePush);

    /**
     * 创建推送记录
     *
     * @param playId
     */
    void createPush(String playId);

    /**
     * 创建混淆推送详情
     */
    void createPushDetail(String playId);


    RobotStatisticsVO getRobotStatisticsVO(String playId);

    /**
     * 账号明细列表
     * @param dto
     * @return
     */
    List<QueryRobotDetailVO> robotDetails(QueryRobotDetailDTO dto);

}