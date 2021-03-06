package com.youyue.dao;

import com.youyue.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
/*持久层*/
@Repository
public interface IAccountDao {
    //查询所有
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account(name,money) values(#{name},#{money})")
    public   void saveAccount(Account account);
}
