package com.example.spring_boot_h2db_demo.repository;

import com.example.spring_boot_h2db_demo.model.Member;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer>{
    
}
