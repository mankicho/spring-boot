package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // persistence.xml 에 있는 persistence unit name 을 적어준다
        // 애플리케이션 로딩 시점에 한번만 init 되어야 한다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // entityManager 를 꺼내고
        // DB 와의 통신 작업이 있을때마다 entityManager 가 생성되어야 한다.
        // jpa 는 통신 시 트랜잭션단위로 하기 때문에 반드시 트랜잭션을 생성해서 begin, commit 을 해야 한다.
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        // 조회 과정
//        Member findMember = entityManager.find(Member.class,1L);
//        System.out.println(findMember.getId()+"~"+findMember.getName());

        Member findMember = entityManager.find(Member.class,1L);
        findMember.setName("helloJPA");
        // 객체의 값만 바꿔주었는데 DB 에 수정이 적용되었다.
        // 이는 JPA 를 통해 가져온 객체들은 JPA 가 관리하기 때문이다.
        // 트랜잭션이 커밋되는 시점에 JPA 가 가져온 객체들에 변경이 생기면 update 쿼리가 적용된다.
        tx.commit();
//
//        Member member = new Member();
//        member.setId(2);
//        member.setName("helloB");
//
//        entityManager.persist(member);
//
//        tx.commit();


        entityManager.close(); // manager close
        emf.close();


    }
}
