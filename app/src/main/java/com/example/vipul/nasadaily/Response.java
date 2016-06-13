package com.example.vipul.nasadaily;

import java.util.List;

public class Response {
    /**
     * type : ubernode
     * nid : 384333
     * promoDateTime : 2016-05-13T08:25:00-04:00
     */

    private List<UbernodesBean> ubernodes;

    public List<UbernodesBean> getUbernodes() {
        return ubernodes;
    }

    public void setUbernodes(List<UbernodesBean> ubernodes) {
        this.ubernodes = ubernodes;
    }

    public static class UbernodesBean {
        private String nid;

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }
    }
}
