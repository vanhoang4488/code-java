package com.os.controller;

import com.os.annotation.OpLog;
import com.os.entity.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oplog")
public class OpLogController implements IController<Integer>{

    @Override
    @OpLog(describe = "oplog")
    @RequestMapping("/1")
    public ResultEntity oplog(@RequestParam Integer arg1) {
        return ResultEntity
                .builder()
                .ok(true)
                .msg(String.valueOf(arg1))
                .build();
    }
}
