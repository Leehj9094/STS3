package com.example.app.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {
	
	@Min(value = 10,message = "Id는 10이상 이어야 합니다.")
	@Max(value = 65535,message = "ID는 최대 숫자는 65535 이하이어야 합니다")
	@NotNull(message = "ID는 필수항목입니다")
	private Integer id;
	@NotBlank(message = "메모를 입력하세요")
	private String text;
	@NotBlank(message = "메모를 입력하세요")
	@Email(message = "example@example.com에 맞게 입력해주세요")
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@NotNull(message = "날짜정보를 선택해주세요")
	private LocalDateTime createAt;
	
//	private LocalDate dateTest;
}
