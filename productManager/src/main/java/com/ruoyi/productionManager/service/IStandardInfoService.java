package com.ruoyi.productionManager.service;

import java.util.List;
import com.ruoyi.productionManager.domain.StandardInfo;

/**
 * 试验标准管理Service接口
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
public interface IStandardInfoService 
{
    /**
     * 查询试验标准管理
     * 
     * @param standardId 试验标准管理主键
     * @return 试验标准管理
     */
    public StandardInfo selectStandardInfoByStandardId(Long standardId);

    /**
     * 查询试验标准管理列表
     * 
     * @param standardInfo 试验标准管理
     * @return 试验标准管理集合
     */
    public List<StandardInfo> selectStandardInfoList(StandardInfo standardInfo);

    /**
     * 新增试验标准管理
     * 
     * @param standardInfo 试验标准管理
     * @return 结果
     */
    public int insertStandardInfo(StandardInfo standardInfo);

    /**
     * 修改试验标准管理
     * 
     * @param standardInfo 试验标准管理
     * @return 结果
     */
    public int updateStandardInfo(StandardInfo standardInfo);

    /**
     * 批量删除试验标准管理
     * 
     * @param standardIds 需要删除的试验标准管理主键集合
     * @return 结果
     */
    public int deleteStandardInfoByStandardIds(Long[] standardIds);

    /**
     * 删除试验标准管理信息
     * 
     * @param standardId 试验标准管理主键
     * @return 结果
     */
    public int deleteStandardInfoByStandardId(Long standardId);
}
