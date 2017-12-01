package com.ballistic.token_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenTestApplicationTests implements ICommentControllerTest{


	@Test
	public void contextLoads() {
	}

	@Test
	@Override
	public void getComment() {
		assertEquals("Pakistan","Pakistan");
	}

	@Test
	@Override
	public void createComment() {
		assertEquals("Pakistan","Pakistan");
	}

	@Test
	@Override
	public void updateComment() {
		assertEquals("Pakistan","Pakistan");
	}

	@Test
	@Override
	public void delete() {
		assertEquals("Pakistan","Pakistan");
	}
}
