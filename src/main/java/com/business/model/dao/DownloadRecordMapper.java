package com.business.model.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.common.vo.PageResult;
import com.business.controller.mobile.downloadRecord.vo.DownloadRecordPageVO;
import com.business.model.pojo.DownloadRecord;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DownloadRecordMapper extends MPJBaseMapper<DownloadRecord> {

    Page<DownloadRecordPageVO> pageList(Page page, @Param("userId") Long userId);

}
