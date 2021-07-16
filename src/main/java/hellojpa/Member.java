package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// JPA 가 처음 로딩될때 관리해야할 객체로 인식한다.
@Entity
public class Member {

    @Id // pk 가 뭔지 알려줘야함.
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
