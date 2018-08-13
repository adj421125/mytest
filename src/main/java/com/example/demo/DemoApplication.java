package com.example.demo;

import com.example.demo.util.Recyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Recyle recy = Recyle.getInstan();
		recy.delete("其他文件删除-----------");
	}
}