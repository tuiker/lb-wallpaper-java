package com.business.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("feedback_record")
@Schema(title = "用户反馈记录实体类")
public class FeedbackRecord {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 反馈类型，1：问题，2：建议 */
    private Integer feedbackType;

    /** 反馈内容 */
    private String feedbackContent;

    /** 反馈的图片，数组格式字符串 */
    private String feedbackImgList;

    /** 用户ID */
    private Long userId;

    /** 创建时间 */
    private LocalDateTime createTime;

}
