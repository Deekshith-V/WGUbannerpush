package com.wgu.banner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WguBannerPushApplication {

	public static void main(String[] args) {
		SpringApplication.run(WguBannerPushApplication.class, args);
//		SpringApplication springApplication = new SpringApplication(WguBannerPushApplication.class);
//		springApplication.setAdditionalProfiles("qa");
//		springApplication.run(args);
	}

}
