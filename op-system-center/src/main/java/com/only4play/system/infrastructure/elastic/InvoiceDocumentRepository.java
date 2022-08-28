package com.only4play.system.infrastructure.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 发票 repository
 */
public interface InvoiceDocumentRepository extends ElasticsearchRepository<InvoiceDocument, String> {

}
