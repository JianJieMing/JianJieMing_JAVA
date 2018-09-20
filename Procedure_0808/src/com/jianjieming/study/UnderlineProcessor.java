package com.jianjieming.study;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;

/**
 * @author 铭
 */
public class UnderlineProcessor extends BasicRowProcessor {

    public UnderlineProcessor() {
        super(new GenerousBeanProcessor());
    }
}
