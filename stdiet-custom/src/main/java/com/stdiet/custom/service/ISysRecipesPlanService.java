package com.stdiet.custom.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stdiet.custom.domain.SysRecipesPlan;
import com.stdiet.custom.domain.SysRecipesPlanListInfo;

/**
 * 食谱计划Service接口
 *
 * @author xzj
 * @date 2021-01-15
 */
public interface ISysRecipesPlanService
{
    /**
     * 查询食谱计划
     *
     * @param id 食谱计划ID
     * @return 食谱计划
     */
    public SysRecipesPlan selectSysRecipesPlanById(Long id);

    /**
     * 查询食谱计划列表
     *
     * @param sysRecipesPlan 食谱计划
     * @return 食谱计划集合
     */
    public List<SysRecipesPlan> selectSysRecipesPlanList(SysRecipesPlan sysRecipesPlan);

    /**
     * 新增食谱计划
     *
     * @param sysRecipesPlan 食谱计划
     * @return 结果
     */
    public int insertSysRecipesPlan(SysRecipesPlan sysRecipesPlan);

    /**
     * 修改食谱计划
     *
     * @param sysRecipesPlan 食谱计划
     * @return 结果
     */
    public int updateSysRecipesPlan(SysRecipesPlan sysRecipesPlan);

    /**
     * 批量删除食谱计划
     *
     * @param ids 需要删除的食谱计划ID
     * @return 结果
     */
    public int deleteSysRecipesPlanByIds(Long[] ids);

    /**
     * 删除食谱计划信息
     *
     * @param id 食谱计划ID
     * @return 结果
     */
    public int deleteSysRecipesPlanById(Long id);

    /**
     * 订单发生更新时(开始时间、服务时长、赠送时长)，重新生成食谱计划
     * @param cusId 客户ID
     * @return 结果
     */
    public void regenerateRecipesPlan(Long cusId);

    /**
     * 根据订单ID删除所有食谱安排计划
     * @param orderIds 订单ID
     * @return
     */
    int delRecipesPlanByOrderId(Long[] orderIds);

    /**
     * 多条件查询食谱计划列表
     * @param sysRecipesPlan
     * @return
     */
    List<SysRecipesPlan> selectPlanListByCondition(SysRecipesPlan sysRecipesPlan);

    /**
     * 根据订单ID查询食谱计划
     * @param sysRecipesPlan
     * @return
     */
    List<SysRecipesPlan> selectPlanListByOrderId(SysRecipesPlan sysRecipesPlan);


    /**
     * 通过outId查询cusId
     * @param outId
     * @return
     */
    Long getCusIdByOutId(String outId);

    /**
     * 根据客户ID查询最后一天食谱计划
     * @param customerId
     * @return
     */
    SysRecipesPlan getLastDayRecipesPlan(Long customerId,  Date orderTime);

    /**
     * 通过outId查询食谱计划简要
     * @param outId
     * @return
     */
    List<SysRecipesPlanListInfo> selectRecipesPlanListInfo(String outId);

    List<SysRecipesPlanListInfo> selectRecipesPlanListInfoByCusId(Long cusId);


    /**
     * 通过客户id查询食谱计划
     * @param cusId
     * @return
     */
    List<SysRecipesPlan> selectPlanListByCusId(Long cusId);

    /**
     * 查询食谱计划中对应食谱存在天数缺失的食谱计划
     * @param cusId
     * @return
     */
    List<Map<String,Object>> getNeedSupplyRecipesByCusId(Long cusId);

}