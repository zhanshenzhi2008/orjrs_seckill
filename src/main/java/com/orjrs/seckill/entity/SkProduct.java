package com.orjrs.seckill.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 秒杀产品
 *
 * @author orjrs
 * * @date 2018-06-30 15:06
 */
@Entity
//@Table(name = "SK_PRODUCT")
@Data
public class SkProduct {
    /** 产品ID */
    @Id
    //@Column(name = "PRODUCT_ID")
    private String productId;

    /** 产品描述 */
    //@Column(name = "PRODUCT_DESC")
    private String productDesc;

    /** 库存 */
    //@Column(name = "NUM")
    private long num;

    /** 秒杀开始时间 */
    //@Column(name = "START_TIME")
    private Date startTime;

    /** 秒杀结束时间 */
    //@Column(name = "END_TIME")
    private Date endTime;

    /** 创建时间 */
    //@Column(name = "CREATE_DATE")
    private Date createDate;

    /** 更新时间 */
    //@Column(name = "UPDATE_DATE")
    private Date updateDate;
}
