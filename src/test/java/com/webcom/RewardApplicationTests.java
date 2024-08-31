package com.webcom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.webcom.RewardApplication;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RewardApplicationTests {

	@Test
	  void main() {
		RewardApplication.main(new String[] {});
	   }
	}
