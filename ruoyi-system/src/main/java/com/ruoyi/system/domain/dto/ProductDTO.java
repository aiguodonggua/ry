package com.ruoyi.system.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProductDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long productId;

    @NotBlank(message="服务名称不能为空")
    @Size(min = 1, max = 64, message = "服务名称长度为1-64字")
    @ApiModelProperty(value = "服务名称")
    private String name;

    /**
     * {@link com.ruoyi.common.enums.AppType}
     */
    @NotNull(message="平台类型不能为空")
    @ApiModelProperty(value = "平台类型: 1-TG")
    private Integer appType;

    /**
     * {@link com.ruoyi.common.enums.ProductCategoryType}
     */
    @NotNull(message="商品类型不能为空")
    @ApiModelProperty(value = "商品类型: 0-拉人进群")
    private Integer categoryId;

    @NotBlank(message="列表图不能为空")
    @ApiModelProperty(value = "服务列表图")
    private String albumPics;

    @NotBlank(message="海报图不能为空")
    @ApiModelProperty(value = "服务海报图")
    private String pic;

    @ApiModelProperty(value = "商品状态:1-未上架 2-上架")
    private Integer status;

    @ApiModelProperty(value = "是否显示:0否 1是")
    private Integer isShow;

    @ApiModelProperty(value = "产品描述信息")
    private String intro;

    @ApiModelProperty(value = "规格:1统一规格 2多规格")
    private Integer specsType;

    private String skuAttr;

    @ApiModelProperty(value = "创建时间")
    private String createDate;

    private String operatorUser;

    private Long operatorUserId;

    @NotEmpty(message = "规格设置不能为空")
    @ApiModelProperty("规格设置")
    private List<ProductSkuDTO> skuList;
}