package com.pandahun.querydsl;

import static org.assertj.core.api.Assertions.assertThat;

import com.pandahun.querydsl.entity.Member;
import com.pandahun.querydsl.entity.QMember;
import com.pandahun.querydsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

    @Autowired
    EntityManager em;

    @BeforeEach
    void setUp() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member memberA = new Member("memberA", 10, teamA);
        Member memberB = new Member("memberB", 20, teamA);
        Member memberC = new Member("memberC", 30, teamB);
        Member memberD = new Member("memberD", 40, teamB);

        em.persist(memberA);
        em.persist(memberB);
        em.persist(memberC);
        em.persist(memberD);
    }

    @Test
    void jpqlTest() {
        //find MemberA
        Member findMember = em.createQuery("select m from Member m where m.userName =:userName", Member.class)
            .setParameter("userName", "memberA")
            .getSingleResult();
        assertThat(findMember.getUserName()).isEqualTo("memberA");
    }

    @Test
    void queryDslTest() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QMember member = new QMember("member");

        Member findMember = queryFactory
            .select(member)
            .from(member)
            .where(member.userName.eq("memberA"))
            .fetchOne();
        assertThat(findMember.getUserName()).isEqualTo("memberA");
    }
}
