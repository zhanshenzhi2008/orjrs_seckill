package com.orjrs.seckill.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 秒杀详情
 *
 * @author orjrs
 * @date 2018-06-30 15:02
 */
@Entity
//@Table(name = "SK_ITEM")
@Data
public class SkItem {
    /** 秒杀明细id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "ITEM_ID")
    private long itemId;

    /** 产品 */
    //@Column(name = "PRODUCT_ID")
    private String productId;

    /** 电话 */
    // @Column(name = "TELEPHONE")
    private long telephone;

    /** 秒杀开始时间 */
    //@Column(name = "KILL_TIME")
    private Date killTime;

    /** 创建时间 */
    //@Column(name = "CREATE_DATE")
    private Date createDate;

    /** 更新时间 */
    //@Column(name = "UPDATE_DATE")
    private Date updateDate;
}
