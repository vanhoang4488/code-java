package lab.hoangnv.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository<T, ID> {

    List<T> select();
}
