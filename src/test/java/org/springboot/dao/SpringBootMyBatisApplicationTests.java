package org.springboot.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.config.SpringBootMyBatisApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.karle.bean.User;
import com.karle.tk.TkMapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMyBatisApplication.class)
public class SpringBootMyBatisApplicationTests {

	@Autowired
	private UserMapper mapper;

	// 根据唯一编号查询用户(通用Mapper查询)
	@Test
	public void selectByCardNo() {
		User paramBean = new User();
		paramBean.setId(1);
		User dbUser = mapper.selectOne(paramBean);
		if (dbUser != null) {
			System.out.println("数据库用户(通用Mapper查询)：" + dbUser.getUsername());
			return;
		}
		System.out.println("查无此用户");
	}

	@Test
	public void save() {
		User user = new User();
		user.setCtm(new Date());
		user.setAge(18);
		user.setUsername("lucy");
		mapper.insert(user);

	}

	@Test
	public void update() {
		User user = new User();

		user.setId(14);
		user.setUsername("lucy2");
		mapper.updateByPrimaryKeySelective(user);

	}

	// 批量插入记录
	@Test
	public void insertMore() {
		List<User> recordList = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User newUser = new User();
			int cardNo = (int) (Math.random() * 10000000);
			newUser.setAge(26);
			newUser.setCtm(new Date());
			newUser.setUsername(cardNo + "批量插入用户");
			recordList.add(newUser);
		}
		mapper.insertList(recordList);
		System.out.println("批量插入成功");
	}

	// 分页查询用户
	@Test
	public void selectByPage() {
		PageHelper.offsetPage(1, 5);
		List<User> dbUserList = mapper.select(null);
		for (User item : dbUserList) {
			System.out.println("分页用户：" + item.getUsername());
		}
	}

}