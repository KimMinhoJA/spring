package kosta.mvc.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.mvc.model.domain.Student;

@Mapper
public interface StudentMapper {
	/**
	 * ��ü �˻�
	 */
	@Select("select * from student")
	List<Student> selectAll();
	
	/**
	 * ����ϱ�
	 */
	@Insert("insert into student values(#{stNo}, #{stName}, #{stAge}, #{stAddr}, #{stPhone})")
	int isert(Student student);
	
	/**
	 * �ߺ�üũ
	 */
	@Select("<script>select * from student\r\n" + 
			"		<where>\r\n" + 
			"			<if test=\"_parameter != null\">st_no=#{_parameter}</if>\r\n" + 
			"		</where></script>")
	Student selectByStNo(String stNo);
	
	/**
	 * �����ϱ�
	 */
	@Update("<script>update student\r\n" + 
			"		<set>\r\n" + 
			"			<if test=\"stName != null\">st_name = #{stName}, </if>\r\n" + 
			"			<if test=\"stAge > 0\"> st_age = #{stAge}, </if>\r\n" + 
			"			<if test=\"stAddr != null\">st_addr = #{stAddr}, </if>\r\n" + 
			"			<if test=\"stPhone != null\">st_phone = #{stPhone}</if>\r\n" + 
			"		</set>\r\n" + 
			"		where st_no = #{stNo}</script>")
	int update(Student student);
	
	/**
	 * �����ϱ�
	 */
	@Delete("delete student where st_no = #{_parameter}")
	int delete(String stNo);
}
