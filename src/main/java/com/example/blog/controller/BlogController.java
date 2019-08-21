package com.example.blog.controller;

import com.example.blog.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BlogController {
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello, hijeong.";
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public Member getInfo() {
        Member member = new Member(1, "hijeong", "hijeong@naver.com");

        return member;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Member> list() {
        List<Member> memberList = Arrays.asList(
                new Member[]{new Member(1, "hijeong1", "hijeong1@naver.com"),
                new Member(2, "hijeong2", "hijeong2@naver.com"),
                new Member(3, "hijeong3", "hijeong3@naver.com"),
                new Member(4, "hijeong4", "hijeong4@naver.com"),
                new Member(5, "hijeong5", "hijeong5@naver.com")}
        );
        long startTime = System.currentTimeMillis();
        for(Member member : memberList) { //for-loop or for-each
            System.out.println(member);
        }
        System.out.println("for-loop:" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        memberList.forEach(System.out::println);
        System.out.println("lamda: "+ (System.currentTimeMillis() - startTime) + "ms");

        //test
        return memberList;

    }
}