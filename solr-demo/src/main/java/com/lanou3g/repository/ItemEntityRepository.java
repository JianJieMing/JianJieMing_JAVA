package com.lanou3g.repository;

import com.lanou3g.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 铭
 * 2018/11/14 17:36
 */
public interface ItemEntityRepository extends JpaRepository<ItemEntity, Long> {
}
