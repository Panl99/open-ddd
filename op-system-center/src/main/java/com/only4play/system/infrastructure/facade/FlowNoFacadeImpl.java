package com.only4play.system.infrastructure.facade;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Service;

@Service
public class FlowNoFacadeImpl implements IFlowNoFacade{
  @Override
  public Long getNextId() {
    return IdUtil.getSnowflake().nextId();
  }
}
