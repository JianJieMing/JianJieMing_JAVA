package com.lanou3g.netctoss.admin.controller.params;

import java.util.List;

/**
 * @author 铭
 * 2018/10/12 8:07
 */
public class AdminParams {

    private List<Integer> adminIds;

    @Override
    public String toString() {
        return "AdminParams{" +
                "adminIds=" + adminIds +
                '}';
    }

    public List<Integer> getAdminIds() {
        return adminIds;
    }

    public void setAdminIds(List<Integer> adminIds) {
        this.adminIds = adminIds;
    }
}
