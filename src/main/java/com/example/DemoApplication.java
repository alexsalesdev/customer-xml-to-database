package com.example;

import com.example.dao.entity.tables.daos.CustomerTblDao;
import com.example.dao.entity.tables.pojos.CustomerTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		Main main = applicationContext.getBean(Main.class);

		main.run();
	}
}
