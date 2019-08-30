package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.dto.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeMapper employeeMapper;

    public EmployeeDTO getEmployeeWithEesc(String id){
        Employee employee = employeeMapper.selectOne(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setName(employee.getName());
        String desc = String.format("name: %s,age:%s",employee.getName(),employee.getAge());
        employeeDTO.setDesc(desc);
        return employeeDTO;
    }

    public List<Employee> getEmployeesBypage(Integer page,Integer pagesize){
        Integer offset = (page-1)*pagesize;
        Integer limit = pagesize;
        List<Employee> employees = employeeMapper.selectAll(offset, limit);
        return employees;
    }
    public List<Employee> getEmployeesByName(String name){

        List<Employee> employees = employeeMapper.selectByName(name);
        return employees;
    }


}
