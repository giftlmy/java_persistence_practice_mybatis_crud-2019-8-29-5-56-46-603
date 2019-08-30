package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    void insertOne(@Param("employee") Employee employee);
    Employee selectOne(@Param("id") String id);
    void updateOne(@Param("employee") Employee employee,@Param("id") String id);
    void deleteOne(@Param("id") String id);
    List<Employee> selectAll(@Param("offset") Integer offset, @Param("limit") Integer limit);
    List<Employee> selectByName(@Param("name")String name);
}
