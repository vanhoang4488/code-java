package com.os.entity;

import lombok.Getter;

@Getter
public class ResultEntity {

    private boolean ok;
    private String msg;

    public ResultEntity(Builder builder){
        this.ok = builder.ok;
        this.msg = builder.msg;
    }

    public static Builder builder() { return new Builder();}

    public static class Builder{

        private boolean ok;
        private String msg;

        public Builder ok(boolean ok){
            this.ok = ok;
            return this;
        }

        public Builder msg(String msg){
            this.msg = msg;
            return this;
        }

        public ResultEntity build(){
            return new ResultEntity(this);
        }
    }
}
