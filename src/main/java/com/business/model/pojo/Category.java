package com.business.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("category")
@Schema(title = "分类实体类")
public class Category {

    @TableId
    private Long id;

    /** 分类名称 */
    private String name;

    /** 分类详细信息 */
    private String details;

    /** 创建时间 */
    private LocalDateTime createTime;
    /** 修改时间 */
    private LocalDateTime updateTime;
    /** 创建人ID */
    private Long createId;
    /** 修改人ID */
    private Long updateId;

}
