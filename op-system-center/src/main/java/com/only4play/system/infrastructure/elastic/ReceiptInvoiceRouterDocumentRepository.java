package com.only4play.system.infrastructure.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 订单到发票路由
 */
public interface ReceiptInvoiceRouterDocumentRepository extends ElasticsearchRepository<ReceiptInvoiceRouterDocument, String> {

}
