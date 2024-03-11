package com.business.controller.pc.advertising.dto;

import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 19:19
 * @Description: 广告分页列表请求 DTO
 */
@Data
@Schema(description = "广告分页列表请求 DTO")
public class AdvPageReqDTO extends PageDaoEntity {

    @Schema(description = "广告ID", type = "Integer")
    private Integer advId;

}
