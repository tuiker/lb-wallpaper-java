package com.business.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("hot_search")
@Schema(title = "热搜关键词信息实体类")
public class HotSearch {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 关键词 */
    private String keyword;

    /** 搜索次数 */
    private Integer searchNum;

}
