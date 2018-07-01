package com.orjrs.seckill.repository;


import com.orjrs.seckill.entity.SkProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 秒杀产品DAO
 *
 * @author orjrs
 * @date 2018-06-30 15:07
 */
public interface SkProductRepository extends JpaRepository<SkProduct, String> {
    /**
     * 查看可以开始秒杀商品
     *
     * @param now 开始时间点
     * @return 商品
     */
    List<SkProduct> findAllByStartTimeAfter(Date now);

    /**
     * 减少库存
     *
     * @param id   商品id
     * @param time 秒杀执行的时间
     * @return 操作记录数
     */
    @Modifying
    @Query(value = "UPDATE SK_PRODUCT SET NUM = NUM -1,UPDATE_DATE = CURRENT_TIMESTAMP " +
            "WHERE PRODUCT_ID = ?1 AND NUM >=1 AND END_TIME >=?2 AND START_TIME <=?2", nativeQuery = true)
    int reduceNumber(String id, Date time);
}
