package com.lanou3g.netctoss.information.controller.params;

import java.util.List;

public class RoleParams {
        private String rName;
        private List<Integer> roleModuleIds;

        @Override
        public String toString() {
            return "RoleParams{" +
                    "rName='" + rName + '\'' +
                    ", roleModuleIds=" + roleModuleIds +
                    '}';
        }

        public String getrName() {
            return rName;
        }

        public void setrName(String rName) {
            this.rName = rName;
        }

        public List<Integer> getRoleModuleIds() {
            return roleModuleIds;
        }

        public void setRoleModuleIds(List<Integer> roleModuleIds) {
            this.roleModuleIds = roleModuleIds;
        }

    }

