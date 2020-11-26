package com.ruoyi.project.benyi.mapper;

import java.util.List;

import com.ruoyi.project.benyi.domain.ByThemeActivity;

/**
 * 主题整合活动Mapper接口
 *
 * @author tsbz
 * @date 2020-07-01
 */
public interface ByThemeActivityMapper {
    /**
     * 查询主题整合活动
     *
     * @param id 主题整合活动ID
     * @return 主题整合活动
     */
    public ByThemeActivity selectByThemeActivityById(Long id);

    /**
     * 查询主题整合活动列表
     *
     * @param byThemeActivity 主题整合活动
     * @return 主题整合活动集合
     */
    public List<ByThemeActivity> selectByThemeActivityList(ByThemeActivity byThemeActivity);

    /**
     * 新增主题整合活动
     *
     * @param byThemeActivity 主题整合活动
     * @return 结果
     */
    public int insertByThemeActivity(ByThemeActivity byThemeActivity);

    /**
     * 修改主题整合活动
     *
     * @param byThemeActivity 主题整合活动
     * @return 结果
     */
    public int updateByThemeActivity(ByThemeActivity byThemeActivity);

    /**
     * 删除主题整合活动
     *
     * @param id 主题整合活动ID
     * @return 结果
     */
    public int deleteByThemeActivityById(Long id);

    /**
     * 批量删除主题整合活动
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteByThemeActivityByIds(Long[] ids);

    /**
     * 查询主题整合活动列表
     *
     * @param ids 主题整合活动
     * @return 主题整合活动集合
     */
    public List<ByThemeActivity> selectByThemeActivityByThemeIds(Long[] ids);

    /**
     * 查询主题整合活动列表
     *
     * @param ids 主题整合活动
     * @return 主题整合活动集合
     */
    public List<ByThemeActivity> selectByThemeActivityByIds(Long[] ids);
}
