package com.business.controller.mobile.downloadRecord.dto;


import com.business.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "下载记录分页列表请求 DTO")
@Data
public class DownloadRecordPageReqDTO extends PageDaoEntity {
}
