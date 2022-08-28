package com.only4play.system.infrastructure.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoicePipelineFacadeServiceImpl implements IInvoicePipeLineFacadeService{

  private final IUserFacadeService userFacadeService;

  private final IOrderFacadeService orderFacadeService;

  private final IInvoiceFacadeService invoiceFacadeService;

  @Override
  public IUserFacadeService getUserFacadeService() {
    return userFacadeService;
  }

  @Override
  public IOrderFacadeService getOrderFacadeService() {
    return orderFacadeService;
  }

  @Override
  public IInvoiceFacadeService getInvoiceFacadeService() {
    return invoiceFacadeService;
  }
}
