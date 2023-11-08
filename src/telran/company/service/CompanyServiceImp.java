package telran.company.service;

import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.Set;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;

public class CompanyServiceImp implements CompanyService {
	//HashMap самый оптимальный выбор при сложности алгоритма 1
	HashMap<Long, Employee> employeesMap = new HashMap<>();//для поиска по id
	HashMap<String, Set<Employee>> employeesDepartment = new HashMap<>();//для поиска по отделу, key=department, value=set of empl of dep
	TreeMap<Integer, Set<Employee>> employeesSalary = new TreeMap<>();//TreeMap оптимальный, если нужно получить диапазон, key=salary, value=set of empl having salary value
	TreeMap<LocalDate, Set<Employee>> employeesAge = new TreeMap<>();//key=birth date, value=set of empl born at the date
	//если константное обращение - сложность сразу логарифмическая
	@Override
	//добавляет служащего, но если есть такой же ID - бросить exeption, вернуть
	//ссылку на добавленного служащего
	public Employee hireEmployee(Employee empl) {
		// TODO Auto-generated method stub O[1]
		return null;
	}

	@Override
	//удаляет служащего с данным id
	//если такого ид нет - метод должен бросить IllegalStateException
	public Employee fireEmployee(long id) {
		// TODO  O[1]
		return null;
	}

	@Override
	//возвращает ссылку на Employee по id. Если такого id нет - метод возвращает null
	public Employee getEmployee(long id) {
		// TODO  O[1]
		return null;
	}

	@Override
	//возвращает лист с сотрудниками по отделам
	//если никого из них нет в отделе, вернуть пустой лист
	public List<Employee> getEmployeesByDepartment(String department) {
		// TODO  O[1]
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO O[N]
		return null;
	}

	@Override
	public List<Employee> getEmployeesBySalary(int salaryTo, int salaryFrom) {
		// TODO O[LogN]
		return null;
	}

	@Override
	public List<Employee> getEmployeeByAge(int ageFrom, int ageTo) {
		// TODO O[LogN]
		return null;
	}

	@Override
	public List<DepartmentAvgSalary> salaryDisributionByDepartments() {
		// TODO O[N]
		return null;
	}

	@Override
	public List<SalaryIntervalDistribution> getSalaryDisribution(int intetval) {
		// TODO O[N]
		return null;
	}

	@Override
	public Employee updateDepartment(long id, String newDepartment) {
		// TODO O[1]
		return null;
	}

	@Override
	public Employee updateSalary(long id, int newSalary) {
		// TODO O[LogN]
		return null;
	}

	@Override
	public void save(String filePath) {
		// TODO O[N]

	}

	@Override
	public void restore(String file) {
		// TODO O[N]

	}

}
