package telran.company.service;

import java.nio.channels.IllegalSelectorException;
import java.time.LocalDate;
import java.util.*;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;

public class CompanyServiceImpl implements CompanyService {
	HashMap<Long, Employee> employeesMap = new HashMap<>();
	/***********************************************************/
	HashMap<String, Set<Employee>> employeesDepartment = new HashMap<>();
	//key - department, value- Set of employees working in the department
	/*************************************************************/
	TreeMap<Integer, Set<Employee>> employeesSalary = new TreeMap<>();
	//key - salary, value - set of employees having the salary value
	/****************************************************************/
	TreeMap<LocalDate, Set<Employee>> employeesAge = new TreeMap<>();
	//key birth date; value set of employees born at the date
	/*******************************************************************/
	@Override
	/**
	 * adds new Employee into a company
	 * In the case an employee with the given ID already exists,
	 *  the exception IllegalStateException must be thrown
	 *  returns reference to the being added Employee object
	 */
	public Employee hireEmployee(Employee empl) {
		long id = empl.id();
		if(employeesMap.containsKey(id)){
			throw new IllegalStateException("Employee alreade exists" + id);
		}
		employeesMap.put(id, empl);
		addEmployeeSalary(empl);
		addEmployeeAge(empl);
		addEmployeeDepartment(empl);
		return empl;
	}

	private void addEmployeeDepartment(Employee empl) {
		String department = empl.department();
		Set<Employee> set =  employeesDepartment.computeIfAbsent(department, k -> new HashSet<>());
		set.add(empl);
		
	}

	private void addEmployeeAge(Employee empl) {
		LocalDate birthdate = empl.birthDate();
		Set<Employee> set =  employeesAge.computeIfAbsent(birthdate, k -> new HashSet<>());
		set.add(empl);
		
	}

	private void addEmployeeSalary(Employee empl) {
		Set<Employee> set =  employeesSalary.computeIfAbsent(empl.salary(), k -> new HashSet<>());//делает так, чтобы была одна и та же ссылка на сет, если такая зп уже есть или она новая
		set.add(empl);
	}

	@Override
	/**
	 * removes employee object from company according to a given ID
	 * In the case an employee with the given ID doesn't exist 
	 * the method must throw IllegalStateException
	 */
	public Employee fireEmployee(long id) {
		Employee empl = employeesMap.remove(id);//убирает служащего только из 1 map
		if(empl == null) {
			throw new IllegalStateException("Employee not found" + id);
		}
		removeEmployeeDepartment(empl);
		removeEmployeeSalary(empl);
		removeEmployeeAge(empl);
		return null;
	}

	private void removeEmployeeAge(Employee empl) {
		LocalDate birthdate = empl.birthDate();
		Set<Employee> set = employeesAge.get(birthdate);
		set.remove(empl);//удаляет из сета по дате рождения
		if(set.isEmpty()) {
			employeesAge.remove(birthdate);//удалет из всего map если удалили последнего сотрудника
		}
	}

	private void removeEmployeeSalary(Employee empl) {
		int salary = empl.salary();
		Set<Employee> set = employeesSalary.get(salary);
		set.remove(empl);
		if(set.isEmpty()) {
			employeesSalary.remove(salary);
		}
		
	}

	private void removeEmployeeDepartment(Employee empl) {
		String department = empl.department();
		Set<Employee> set = employeesDepartment.get(department);
		set.remove(empl);
		if(set.isEmpty()) {
			employeesDepartment.remove(department);
		}
		
	}

	@Override
	/**
	 * returns reference to Employee object with a given ID value
	 * in the case employee with the ID doesn't exist
	 * the method returns null
	 */
	public Employee getEmployee(long id) {
		
		return employeesMap.get(id);
	}

	@Override
	/**
	 * returns list of employee objects working in a given department
	 * in the case none employees in the department, the method returns empty list
	 */
	public List<Employee> getEmployeesByDepartment(String department) {
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub O[N]
		return null;
	}

	@Override
	public List<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo) {
		// TODO Auto-generated method stub O[LogN]
		return null;
	}

	@Override
	public List<Employee> getEmployeeByAge(int ageFrom, int ageTo) {
		// TODO Auto-generated method stub O[LogN]
		return null;
	}

	@Override
	public List<DepartmentAvgSalary> salaryDistributionByDepartments() {
		// TODO Auto-generated method stub O[N]
		return null;
	}

	@Override
	public List<SalaryIntervalDistribution> getSalaryDistribution(int interval) {
		// TODO Auto-generated method stub O[N]
		return null;
	}

	@Override
	public Employee updateDepartment(long id, String newDepartment) {
		// TODO Auto-generated method stub O[1]
		return null;
	}

	@Override
	public Employee updateSalary(long id, int newSalary) {
		// TODO Auto-generated method stub O[LogN]
		return null;
	}

	@Override
	public void save(String filePath) {
		// TODO Auto-generated method stub O[N]

	}

	@Override
	public void restore(String filePath) {
		// TODO Auto-generated method stub O[N]

	}

}
