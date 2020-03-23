package cn.kilog.cap.securityOAuth2.repository;


import cn.kilog.cap.securityOAuth2.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

   List<User> findByUsername(String username);

}
