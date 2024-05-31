package com.onethinker.activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onethinker.activity.domain.RedEnvelopeDtl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 红包明细Mapper接口
 *
 * @author yangyouqi
 * @date 2023-10-31
 */
public interface RedEnvelopeDtlMapper extends BaseMapper<RedEnvelopeDtl> {
    /**
     * 查询红包明细
     *
     * @param id 红包明细主键
     * @return 红包明细
     */
    public RedEnvelopeDtl selectRedEnvelopeDtlById(Long id);

    /**
     * 查询红包明细列表
     *
     * @param redEnvelopeDtl 红包明细
     * @return 红包明细集合
     */
    public List<RedEnvelopeDtl> selectRedEnvelopeDtlList(RedEnvelopeDtl redEnvelopeDtl);

    /**
     * 新增红包明细
     *
     * @param redEnvelopeDtl 红包明细
     * @return 结果
     */
    public int insertRedEnvelopeDtl(RedEnvelopeDtl redEnvelopeDtl);

    /**
     * 修改红包明细
     *
     * @param redEnvelopeDtl 红包明细
     * @return 结果
     */
    public int updateRedEnvelopeDtl(RedEnvelopeDtl redEnvelopeDtl);

    /**
     * 删除红包明细
     *
     * @param id 红包明细主键
     * @return 结果
     */
    public int deleteRedEnvelopeDtlById(Long id);

    /**
     * 批量删除红包明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRedEnvelopeDtlByIds(Long[] ids);

    /**
     * 批量插入数据
     *
     * @param saveEntitys
     * @return
     */
    int insertRedEnvelopeDtls(@Param("saveEntitys") List<RedEnvelopeDtl> saveEntitys);
}