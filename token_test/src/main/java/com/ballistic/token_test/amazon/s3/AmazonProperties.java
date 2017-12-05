package com.ballistic.token_test.amazon.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author  Nabeel on 12/2/2017.
 */
@Configurable
@ConfigurationProperties(prefix = "amazon")
public class AmazonProperties {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @NestedConfigurationProperty
    private Aws aws;

    @NestedConfigurationProperty
    private S3 s3;

    /**
     * A property group for Amazon Web Service (AWS) configurations
     *
     * @return a property group fro AWS configuration
     *
     * */
    public Aws getAws() { return aws; }

    /**
     * A property group for Amazon Web Service (AWS) configurations
     *
     * @param aws a property group fro AWS configuration
     *
     * */
    public void setAws(Aws aws) {
        this.logger.info("Setting the Value of AWS");
        this.aws = aws;
    }

    /**
     * A property group for Amazon Web Service (AWS) configuration
     *
     * @return a property group for Amazon S3 configurations
     *
     * */
    public S3 getS3() { return s3; }

    /**
     * A property group for Amazon Web Service (AWS) configurations
     *
     * @param s3 a property group fro AWS configuration
     *
     * */
    public void setS3(S3 s3) {
        this.logger.info("Setting the Value of S3");
        this.s3 = s3;
    }


    /**
     * A property group for Amazon Web Service (AWS) configurations
     */
    public static class Aws {

        protected Logger logger = LoggerFactory.getLogger(getClass());

        private String accessKeyId;
        private String accessKeySecret;

        /**
         * A valid AWS account's access key id.
         *
         * @return an AWS access key id
         */
        public String getAccessKeyId() { return accessKeyId; }

        /**
         * A valid AWS account's access key id.
         *
         * @param accessKeyId is a valid AWS account's access key id.
         */
        public void setAccessKeyId(String accessKeyId) { this.accessKeyId = accessKeyId; }

        /**
         * A valid AWS account's secret access token.
         *
         * @return an AWS account's secret access key
         */
        public String getAccessKeySecret() { return accessKeySecret; }

        /**
         * A valid AWS account's secret access token.
         *
         * @param accessKeySecret is a valid AWS account's secret access token.
         */
        public void setAccessKeySecret(String accessKeySecret) { this.accessKeySecret = accessKeySecret; }

        @Override
        public String toString() {
            return "Aws{" + "accessKeyId='" + accessKeyId + '\'' + ", accessKeySecret='" + accessKeySecret + '\'' + '}';
        }
    }

    /**
     * A property group for Amazon Web Service (AWS) configurations
     */
    public static class S3 {

        protected Logger logger = LoggerFactory.getLogger(getClass());

        private String defaultBucket;

        /**
         * The Amazon S3 bucket name for this application.
         *
         * @return a default Amazon S3 bucket name for this application.
         */
        public String getDefaultBucket() { return defaultBucket; }

        /**
         * The Amazon S3 bucket name for this application.
         *
         * @param defaultBucket is the default Amazon S3 bucket name for this application.
         */
        public void setDefaultBucket(String defaultBucket) { this.defaultBucket = defaultBucket; }

        @Override
        public String toString() {
            return "S3{" + "defaultBucket='" + defaultBucket + '\'' + '}';
        }
    }


}
