package com.example.spring_boot_h2db_demo.controller;

import java.util.List;

import com.example.spring_boot_h2db_demo.model.Member;
import com.example.spring_boot_h2db_demo.model.MemberDTO;
import com.example.spring_boot_h2db_demo.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping(value = "/member")
    public List<Member> getAllMember() {
        return memberService.getAllMember();
    }

    @GetMapping(value = "/member/{id}")
    public Member getMember(@PathVariable("id") int id) {
        return memberService.getMemberById(id);
    }

    @PostMapping(value = "/member")
    public int saveMember(@RequestBody MemberDTO member) {
        Member persistentMember = new Member();
        persistentMember.setId(member.getId());
        persistentMember.setName(member.getName());
        persistentMember.setMobile(member.getMobile());
        persistentMember.setEmail(member.getEmail());
        memberService.saveOrUpdate(persistentMember);
        return member.getId();
    }

    @DeleteMapping(value = "/member/{id}")
    public void deleteMember(@PathVariable("id") int id) {
        memberService.deleteMember(id);
    }
}
