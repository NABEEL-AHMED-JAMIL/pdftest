package com.ballistic.token_test.amazon.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Nabeel on 12/2/2017.
 */
@Component
@ConditionalOnMissingBean(AmazonS3Template.class)
@EnableConfigurationProperties(AmazonProperties.class)
public class S3AutoConfiguration {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AmazonProperties amazonProperties;

    @Bean
    AmazonS3Template amazonS3Template() {
        return new AmazonS3Template(amazonProperties.getS3().getDefaultBucket(),
                amazonProperties.getAws().getAccessKeyId(),
                amazonProperties.getAws().getAccessKeySecret());
    }

}
