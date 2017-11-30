package com.ballistic.token_test.service;

import com.ballistic.token_test.dto.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Nabeel on 11/30/2017.
 */
@Component
public class CommentPullerScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(CommentPullerScheduledTask.class);

    // default it true but here we change the value as flase
    @Value("${example.scheduledJob.enabled:false}")
    private Boolean scheduledJobEnabled;

    // /tmp/comments
    @Value("${example.incoming.comments.dir}")
    private String commentsDir;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 30000)
    public void pullRandomComment(){
        try {

            if(!scheduledJobEnabled){
                return;
            }
            int min = 1;
            int max = 500;

            Random random = new Random();
            int id = random.nextInt((max-min)+1)+ min;
            String outFileName = createDataFile(id);
            RestTemplate restTemplate = new RestTemplate();
            Comment comment = restTemplate.getForObject
                    ("http://jsonplaceholder.typicode.com/comments/" + id, Comment.class);
            log.info("Pulled comment #" + id + " at " + dateFormat.format(new Date()));
            log.info("Writing to " + outFileName);

            try(PrintStream ps = new PrintStream(outFileName)){
                ps.println( comment.toString()); }
            catch (FileNotFoundException e) {
                log.error("Couldn't write comment file.", e);
            }

        }catch (ResourceAccessException e){
            log.error("Your are not Connect with the Server.");
        }


    }

    private String createDataFile(int id) {

        File dir = new File(commentsDir);
        if(!dir.exists()){
            try{
                if(dir.mkdirs()){
                    System.out.println("File Dir Create");
                }else{
                    System.out.println("File Dir Not Create");
                    System.exit(1);
                }
            }catch (SecurityException se){
                throw se;
            }

        }

        String name =  "comment_" + id + "_"+ new Date().getTime() + ".json";

        return dir.getAbsolutePath() + File.separator + name;
    }

}
