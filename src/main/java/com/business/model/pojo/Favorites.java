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
@TableName("favorites")
@Schema(title = "用户收藏夹实体类")
public class Favorites {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 标题 */
    private String title;

    /** 描述 */
    private String favoritesDesc;

    /** 创建时间 */
    private LocalDateTime createTime;

    public Favorites(Long userId, String title, String favoritesDesc, LocalDateTime createTime){
        this.userId = userId;
        this.title = title;
        this.favoritesDesc = favoritesDesc;
        this.createTime = createTime;
    }

}
