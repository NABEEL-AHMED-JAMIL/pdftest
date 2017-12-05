package com.ballistic.token_test.controller;

import com.amazonaws.services.s3.model.*;
import com.ballistic.token_test.amazon.s3.AmazonS3Template;
import com.ballistic.token_test.vo.CommentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nabeel on 12/2/2017.
 */
@RestController
@RequestMapping(value = "/api/v1/s3")
@Api(value="S3", description="Amazon S3 Operation handling")
public class AmazonS3Controller {

    private AmazonS3Template amazonS3Template;
    private String bucketName;

    @Autowired
    public AmazonS3Controller(
            AmazonS3Template amazonS3Template, @Value("${amazon.s3.default-bucket}") String bucketName) {
        this.amazonS3Template = amazonS3Template;
        this.bucketName = bucketName;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The Data not contain")
    })
    @ApiOperation(value = "Get the Bucket Resource.....")
    @RequestMapping(method = RequestMethod.GET)
    public List<Resource<S3ObjectSummary>> getBucketResources() {

        ObjectListing objectListing = amazonS3Template.getAmazonS3Client()
                .listObjects(new ListObjectsRequest().withBucketName(bucketName));

        return objectListing.getObjectSummaries().stream().map(a -> new Resource<>(a, new Link(
                String.format("https://s3.amazonaws.com/%s/%s", a.getBucketName(), a.getKey())).withRel("url")))
                .collect(Collectors.toList());

    }

    @ApiOperation(value = "Handle File Upload On S3.....", response = String.class)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {

                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentType(file.getContentType());

                // Upload the file for public read
                amazonS3Template.getAmazonS3Client().putObject(
                        new PutObjectRequest(bucketName, name, file.getInputStream(), objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));

                return "You successfully uploaded " + name + "!";

            } catch (Exception e) {

                return "You failed to upload " + name + " => " + e.getMessage();

            }
        } else {

            return "You failed to upload " + name + " because the file was empty.";
        }

    }
}
