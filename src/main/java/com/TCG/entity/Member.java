package com.TCG.entity;

import com.TCG.Dto.MemberFormDto;
import com.TCG.constant.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String adress;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(member.getName());
        member.setEmail(member.getEmail());
        String password =passwordEncoder.encode(member.getPassword());
        member.setAdress(member.getAdress());
        member.role=Role.USER;
        return member;
    }
}
