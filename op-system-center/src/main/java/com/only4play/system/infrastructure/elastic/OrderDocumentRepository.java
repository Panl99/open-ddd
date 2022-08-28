package com.only4play.system.infrastructure.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderDocumentRepository extends ElasticsearchRepository<OrderDocument, String> {

}