package tws.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {

        return ResponseEntity.ok(employeeMapper.selectAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable String id) {

        Employee employee = employeeMapper.selectOne(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateOne(@RequestBody Employee employee,@PathVariable String id) {
        employee.setId(id);
        employeeMapper.updateOne(employee,id);
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteOne(@PathVariable String id){
        employeeMapper.deleteOne(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }



    @PostMapping
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employeeMapper.insertOne(employee);
        return ResponseEntity.created(URI.create("/employees"+employee.getId())).body(employee);
    }

}
