package com.fastcampus.practice.controller;

import com.fastcampus.practice.service.StringSortService;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

    private final StringSortService stringSortService;

    @GetMapping("/ttt")
    public String ttt() {
        return "this is test";
    }

    @GetMapping("/")
    public List<String> main(@RequestParam List<String> list) {
        log.info("나는 {} 입니다.", list);
        return stringSortService.doSort(list);
    }

    @PostMapping("/student")
    public String student(@RequestBody @Valid Student student) {
        return student.name + ": " + student.age + "살";
    }

    public record Student (
        @NotBlank String name,
        @Digits(fraction = 0, integer = 3) String age
    ) {
    }

//    @RequiredArgsConstructor
//    @Getter
//    @ToString
//    @EqualsAndHashCode
//    public static class StudentClass {
//        @NotBlank private String name;
//        @Digits(fraction = 0, integer = 4) private String age;
//    }
}