package telran.company.service;

import java.util.List;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;

public class CompanyServiceImp implements CompanyService {

	@Override
	//добавляет служащего, но если есть такой же ID - бросить exeption, вернуть
	//ссылку на добавленного служащего
	public Employee hireEmployee(Employee empl) {
		
		return null;
	}

	@Override
	//удаляет служащего с данным id
	//если такого ид нет - метод должен бросить IllegalStateException
	public Employee fireEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//возвращает ссылку на Employee по id. Если такого id нет - метод возвращает null
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//возвращает лист с сотрудниками по отделам
	//если никого из них нет в отделе, вернуть пустой лист
	public List<Employee> getEmployeesByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesBySalary(int salaryTo, int salaryFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeByAge(int ageFrom, int ageTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentAvgSalary> salaryDisributionByDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalaryIntervalDistribution> getSalaryDisribution(int intetval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateDepartment(long id, String newDepartment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateSalary(long id, int newSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(String filePath) {
		// TODO Auto-generated method stub

	}

	@Override
	public void restore(String file) {
		// TODO Auto-generated method stub

	}

}
