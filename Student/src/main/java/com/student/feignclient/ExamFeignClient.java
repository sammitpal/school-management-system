package com.student.feignclient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9003/exam", name = "examfeign")
public interface ExamFeignClient {

	@GetMapping("/showbystandard/{standard}")
	public ResponseEntity<?> showAllExams(@PathVariable int standard);
}
