package com.ruoyi.jxjs.mapper;

import java.util.List;
import com.ruoyi.jxjs.domain.TsbzJxzxpxpj;

/**
 * 见习之星教师培训评价Mapper接口
 * 
 * @author ruoyi
 * @date 2020-11-09
 */
public interface TsbzJxzxpxpjMapper 
{
    /**
     * 查询见习之星教师培训评价
     * 
     * @param id 见习之星教师培训评价ID
     * @return 见习之星教师培训评价
     */
    public TsbzJxzxpxpj selectTsbzJxzxpxpjById(Long id);

    /**
     * 查询见习之星教师培训评价列表
     * 
     * @param tsbzJxzxpxpj 见习之星教师培训评价
     * @return 见习之星教师培训评价集合
     */
    public List<TsbzJxzxpxpj> selectTsbzJxzxpxpjList(TsbzJxzxpxpj tsbzJxzxpxpj);

    /**
     * 新增见习之星教师培训评价
     * 
     * @param tsbzJxzxpxpj 见习之星教师培训评价
     * @return 结果
     */
    public int insertTsbzJxzxpxpj(TsbzJxzxpxpj tsbzJxzxpxpj);

    /**
     * 修改见习之星教师培训评价
     * 
     * @param tsbzJxzxpxpj 见习之星教师培训评价
     * @return 结果
     */
    public int updateTsbzJxzxpxpj(TsbzJxzxpxpj tsbzJxzxpxpj);

    /**
     * 删除见习之星教师培训评价
     * 
     * @param id 见习之星教师培训评价ID
     * @return 结果
     */
    public int deleteTsbzJxzxpxpjById(Long id);

    /**
     * 批量删除见习之星教师培训评价
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTsbzJxzxpxpjByIds(Long[] ids);
}
