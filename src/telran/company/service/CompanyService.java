package telran.company.service;

import java.util.List;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;

public interface CompanyService {
	Employee hireEmployee(Employee empl);//функции аппа
	Employee fireEmployee(long id);
	Employee getEmployee(long id);
	List<Employee> getEmployeesByDepartment(String department);//сортировки аппа
	List<Employee> getAllEmployees();
	List<Employee> getEmployeesBySalary(int salaryTo, int salaryFrom);
	List<Employee> getEmployeeByAge(int ageFrom, int ageTo);
	List<DepartmentAvgSalary> salaryDisributionByDepartments();//средняя зп в отделах
	List<SalaryIntervalDistribution> getSalaryDisribution(int intetval);//найти зп в интервале
	Employee updateDepartment(long id, String newDepartment);//для добавления новых сотрудников(?)
	Employee updateSalary(long id, int newSalary);//обновить зп
	void save(String filePath);//сохранить в файл
	void restore(String file);//восстановить из файла
	
	
}
