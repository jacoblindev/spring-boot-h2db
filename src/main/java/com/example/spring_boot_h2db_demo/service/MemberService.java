package com.example.spring_boot_h2db_demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.spring_boot_h2db_demo.model.Member;
import com.example.spring_boot_h2db_demo.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMember() {
        List<Member> members = new ArrayList<Member>();
        memberRepository.findAll().forEach(member -> members.add(member));
        return members;
    }

    public Member getMemberById(int id) {
        return memberRepository.findById(id).get();
    }

    public void saveOrUpdate(Member member) {
        memberRepository.save(member);
    }

    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}
