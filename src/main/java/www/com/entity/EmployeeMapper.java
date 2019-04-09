package www.com.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

	public void insert(Employee employee);
	
	public Employee getById(Integer employeeId);
	
	public void update(Employee employee);
	
	public void deleteById(Integer employeeId);
}
