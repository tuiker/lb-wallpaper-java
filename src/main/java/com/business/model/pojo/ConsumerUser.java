package com.business.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("consumer_user")
@Schema(title = "用户信息实体")
public class ConsumerUser {

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 用户昵称 */
    private String nickname;

    /** 头像 */
    private String headImg;

    /** 手机号 */
    private String phone;

    /** 密码 */
    private String password;

    /** 注册时间 */
    private LocalDateTime registerTime;

    /** 最近登录时间 */
    private LocalDateTime recentLoginTime;

    /** 性别，1：男，2：女 */
    private Integer gender;

    /** 生日 */
    private LocalDate birthday;

    /** 签名 */
    private String signature;

}
