package com.only4play.system.infrastructure.config;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import java.util.Collections;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;

/**
 * @author gim ES 配置类
 */
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

  @Autowired
  private EsProperties esProperties;

  @Override
  public RestHighLevelClient elasticsearchClient() {
    RestHighLevelClient client = new RestHighLevelClient(buildRestClientBuilder());
    return client;
  }

  @Bean
  public RestClientBuilder buildRestClientBuilder() {
    final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider
        .setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(esProperties.getUsername(),
            esProperties.getPassword()));
    HttpHost[] httpHosts = new HttpHost[esProperties.getNodes().size()];
    for (int i = 0; i < esProperties.getNodes().size(); i++) {
      String host = esProperties.getNodes().get(i);
      Iterable<String> nodeStr = Splitter.on(":").split(host);
      HttpHost httpHost = new HttpHost(Iterables.get(nodeStr, 0),
          Integer.parseInt(Iterables.get(nodeStr, 1)));
      httpHosts[i] = httpHost;
    }
    RestClientBuilder builder = RestClient.builder(httpHosts);
    builder.setHttpClientConfigCallback(b -> b.setDefaultCredentialsProvider(credentialsProvider));
    return builder;
  }
  /**
   * 定制converter
   *
   * @return
   */
  @Bean
  @Override
  public ElasticsearchCustomConversions elasticsearchCustomConversions() {
    return new ElasticsearchCustomConversions(Collections.emptyList());
  }

}
