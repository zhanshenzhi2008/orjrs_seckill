package com.orjrs.seckill.repository;


import com.orjrs.seckill.entity.SkItem;
import com.orjrs.seckill.entity.SkProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 秒杀详情DAO
 *
 * @author orjrs
 * @date 2018-06-30 15:05
 */
public interface SkItemRepository extends JpaRepository<SkItem, String> {
    /**
     * 根据商品查看秒杀详情
     *
     * @param now 开始时间点
     * @return 商品
     */
    List<SkItem> findAllByProductId(String productId);

    /**
     * 保存秒杀详情
     *
     * @param id        商品id
     * @param telephone 手机号
     * @param time      秒杀执行的时间
     * @return 操作记录数
     */
    @Modifying
    @Query(value = "insert into  SK_ITEM(product_id, TELEPHONE, KILL_TIME, create_date, update_date) " +
            "values (?1,?2,?3,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)", nativeQuery = true)
    int insertSkItem(String id, String telephone, Date killTime);
}
