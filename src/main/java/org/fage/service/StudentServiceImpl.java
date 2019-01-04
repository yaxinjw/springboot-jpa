package org.fage.service;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.transaction.Transactional;
import org.fage.domain.Student;
import org.fage.repository.DepartmentRepository;
import org.fage.repository.RoleRepository;
import org.fage.repository.StudentDao;
import org.fage.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

/**
 * @Author: 陈胜
 * @Date: 2018/9/14 17:42
 */
@Service
public class StudentServiceImpl {
	@Autowired
	StudentDao studentDao;
	@Autowired
	UserRepository userRepository;

	@Autowired
	EntityManager em;

	@Transactional(rollbackOn = Exception.class)
	public void test() throws Exception {
//		em.setFlushMode(FlushModeType.COMMIT);
		Student db = studentDao.findOne("bf66c74e-6bc1-4d79-9899-f508c82445b8");
		System.out.println("1---version:" + db.getVersion());
		db.setName(System.currentTimeMillis() + "");
		userRepository.count();
//		studentDao.findOne("bf66c74e-6bc1-4d79-9899-f508c82445b8");
//		userRepository.flush();
		System.out.println("2---version:" + db.getVersion());





//
//		db.setName(System.currentTimeMillis() + "");
//		studentDao.updateNameById(System.currentTimeMillis() + "", "bf66c74e-6bc1-4d79-9899-f508c82445b8");





//		studentDao.save(s);

//		throw new Exception("xxoo");
	}
}
