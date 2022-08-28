package com.only4play.system.infrastructure.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderReceiptDocumentRepository extends ElasticsearchRepository<OrderReceiptDocument,String> {

}
