package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AppCityration;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-12-29
 */
public interface IAppCityrationService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param mId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AppCityration selectAppCityrationByMId(Long mId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param appCityration 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AppCityration> selectAppCityrationList(AppCityration appCityration);

    /**
     * 新增【请填写功能名称】
     * 
     * @param appCityration 【请填写功能名称】
     * @return 结果
     */
    public int insertAppCityration(AppCityration appCityration);

    /**
     * 修改【请填写功能名称】
     * 
     * @param appCityration 【请填写功能名称】
     * @return 结果
     */
    public int updateAppCityration(AppCityration appCityration);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param mIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAppCityrationByMIds(Long[] mIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param mId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAppCityrationByMId(Long mId);
}
