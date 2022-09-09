package com.os.controller;

import com.os.entity.ResultEntity;

public interface IController <T>{

    ResultEntity oplog(T arg1);
}
