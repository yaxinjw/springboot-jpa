package org.fage.repository.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.fage.JpaConfiguration;
import org.fage.domain.Department;
import org.fage.domain.Role;
import org.fage.domain.Student;
import org.fage.domain.User;
import org.fage.repository.DepartmentRepository;
import org.fage.repository.RoleRepository;
import org.fage.repository.StudentDao;
import org.fage.repository.UserRepository;
import org.fage.service.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.jdbc.log.LogFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

	private final Logger log = LoggerFactory.getLogger(RepositoryTest.class);


	@Autowired
	StudentDao studentDao;
	@Autowired
	StudentServiceImpl studentServiceImpl;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	public void 测试乐观锁() throws Exception {
		studentServiceImpl.test();
	}

	//	@Before
	public void initData() {
		departmentRepository.deleteAll();
		roleRepository.deleteAll();
		userRepository.deleteAll();

		Department d = new Department();
		d.setName("开发部");
		departmentRepository.save(d);
		Assert.assertNotNull(d.getId());

		Role r = new Role();
		r.setName("部门经理");
		roleRepository.save(r);
		Assert.assertNotNull(r.getId());
		List<Role> roles = new ArrayList<Role>();
		roles.add(r);

		User u = new User();
		u.setUsername("蔡智法");
		u.setCreateDate(new Date());
		u.setDepartment(d);
		u.setRoles(roles);
		userRepository.save(u);
		Assert.assertNotNull(u.getId());
	}

	@Test
	public void testGeneralMethod() {
		System.out.println(userRepository.findByUsernameLike("蔡智法"));
	}


	@Test
	public void testFindPage() {
		//hibernate一对多分页原理：先分页，然后在将id作为引子查询（效率低）
		Pageable pageable = new PageRequest(0, 5, new Sort(Sort.Direction.ASC, "id"));
		Page<Department> page = departmentRepository.findAll(pageable);
		System.out.println(page.getNumberOfElements());
	}

}
