package com.example.app.domain.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@Data			// 한번에 만들어주는 
@AllArgsConstructor // 모든 파라미터를 받는 생성자
@NoArgsConstructor	// 티폴트 생성자
@Component
@Builder
public class PersonDto {

	private String username;
	private int age;
	private String addr;
	
}
