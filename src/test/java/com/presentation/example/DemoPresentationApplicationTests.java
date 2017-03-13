package com.presentation.example;

import com.presentation.example.entities.Gender;
import com.presentation.example.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@DatabaseSetup("/dataset.xml")
public class DemoPresentationApplicationTests {

	private User getUser(Long age) {
		return User.newBuilder()
				.setName("setName")
				.setAge(age)
				.setGender(Gender.FEMALE)
				.setLastName("setLastName")
				.build();
	}

	@Test
	public void optimisticTest() {
		User user = getUser(12L);
		Assert.assertEquals(new Long(12), user.getAge());
	}

	@Test
	public void pessimistTest() {
		User user = getUser(10L);
		Assert.assertNotEquals(new Long(12), user.getAge());
	}

}
