package com.lanou3g.solrdemo;

import com.lanou3g.entity.ItemEntity;
import com.lanou3g.repository.ItemEntityRepository;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrDemoApplicationTests {

    @Resource
    private ItemEntityRepository itemEntityRepository;

    @Resource
    private SolrClient solrClient;

    @Test
    public void contextLoads() throws IOException, SolrServerException {

        List<ItemEntity> items = itemEntityRepository.findAll();
        items.forEach(System.out::println);
        solrClient.addBeans(items);
        solrClient.commit();

    }

}
