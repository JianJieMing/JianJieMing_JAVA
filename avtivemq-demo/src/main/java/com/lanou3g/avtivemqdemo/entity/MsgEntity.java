package com.lanou3g.avtivemqdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 铭
 * 2018/11/19 14:48
 */
@Data
public class MsgEntity implements Serializable {

    private Long id;
    private String phone;
    private String message;

}
