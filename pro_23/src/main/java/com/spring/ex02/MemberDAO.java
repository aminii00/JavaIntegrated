package com.spring.ex02;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.spring.ex01.MemberVO;

public class MemberDAO {
private static SqlSessionFactory sqlMapper = null;
	
	public static SqlSessionFactory getInstance() {
		if (sqlMapper==null) {
			try {
				String resource ="mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public String selectName() {
		sqlMapper =getInstance(); //연동하기
		SqlSession session = sqlMapper.openSession();
		String name = session.selectOne("mapper.member.selectName"); //하나의 값만 갖고온다
		return name;
	}
	
	public String selectPwd() {
		sqlMapper =getInstance();
		SqlSession session = sqlMapper.openSession();
		String pwd = session.selectOne("mapper.member.selectPwd");
		return pwd;
	}
	

}
