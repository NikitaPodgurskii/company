package telran.company.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;
import telran.company.service.CompanyService;
import telran.company.service.CompanyServiceImp;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //для определения порядка тестов
class CompanyTest {
	private static final long ID1 = 123;
	private static final long ID2 = 124;
	private static final int SALARY1 = 5000;
	private static final int SALARY2 = 6000;
	private static final String DEPARTMENT1 = "dep1";
	private static final LocalDate DATE1 = LocalDate.of(1970, 10, 23);
	//Класс LocalDate представляет время с годом, месяцем и днем месяца
	private static final LocalDate DATE2 = LocalDate.of(1975, 1, 1);
	private static final long ID3 = 125;
	private static final long ID4 = 126;
	private static final long ID5 = 127;
	private static final int SALARY3 = 7000;
	private static final int SALARY4 = 8000;
	private static final int SALARY5 = 9000;
	private static final String DEPARTMENT2 = "dep2";
	private static final LocalDate DATE3 = LocalDate.of(1980, 5, 3);
	private static final LocalDate DATE4 = LocalDate.of(1990, 5, 3);
	private static final LocalDate DATE5 = LocalDate.of(2000, 5, 3);
	private static final String DEPARTMENT3 = "dep3";
	private static final long ID6 = 1000;
	private static final String DEPARTMENT6 = "depunknown";
	private static final String FILE_PATH = "test.data";
	Employee empl1 = new Employee(ID1, "name1", SALARY1, DEPARTMENT1, DATE1);
	Employee empl2 = new Employee(ID2, "name2", SALARY2, DEPARTMENT1, DATE2);
	Employee empl3 = new Employee(ID3, "name3", SALARY3, DEPARTMENT2, DATE3);
	Employee empl4 = new Employee(ID4, "name4", SALARY4, DEPARTMENT2, DATE4);
	Employee empl5 = new Employee(ID5, "name5", SALARY5, DEPARTMENT3, DATE5);
	Employee[] employees = {empl1,empl2,empl3,empl4,empl5};
	CompanyService company = null;
	
	
	@BeforeEach
	void setUp() throws Exception {//начинать тесты надо с setUp, чтобы было стандартное тело кода, содержание которого мы точно знаем
		company =  new CompanyServiceImp();//создаем объект из интерфейса
		for(Employee empl: employees)
		{
			company.hireEmployee(empl);
		}
	}

	@Test
	void testHireEmployeeNormal() {
		Employee newEmployee = new Employee(ID6, "name6", SALARY1, DEPARTMENT1, DATE1);//добавялем нового
		assertEquals(newEmployee, company.hireEmployee(newEmployee));//ожидамое значение сравниваем с актуальным - что вернет ссылку на того же
	}
	
	@Test
	void testHireEmployeeException() {
		Employee newEmployee = empl1;//если добавляем уже существующего, должен быть Exception
		//FIXME - команда работает только в эклипсе
		boolean flException = false;//если Exception не брошен, то флаг будет false
		try {
			company.hireEmployee(newEmployee);
		}catch(IllegalStateException e) {
			flException = true;//true есть только в обработке Exception
		}
		//assertEquals(flException, true);
		assertTrue(flException);//более "красивая" проверка для boolean
	}

	@Test
	void testFireEmployeeNormal() {
		assertEquals(empl1, company.fireEmployee(ID1));
		assertEquals(empl1, company.hireEmployee(empl1));//если получится его добавить, значит при первой проверке он действительно был удален
	}
	
	@Test
	void testFireEmployeeException() {
		boolean flException = false;
		try {
			company.fireEmployee(ID6);//удаляем несуществующего пользователя
		}catch(IllegalStateException e){
			flException = true;
		}
		assertTrue(flException);
	}

	@Test
	void testGetEmployee() {
		assertEquals(empl1, company.getEmployee(ID1));
		assertNull(company.getEmployee(ID6));//для несуществующего должен возвращать null
	}

	@Test
	void testGetEmployeesByDepartment() {
		Employee[] expectedDep1 = {empl1, empl2};
		Employee[] expectedDep2 = {empl3, empl4};
		List<Employee> list1 = company.getEmployeesByDepartment(DEPARTMENT1);
		List<Employee> list2 = company.getEmployeesByDepartment(DEPARTMENT2);
		/*
		Employee[] actualDep1 = list1.toArray(new Employee[] {});//из листа1 получить массив 
		Employee[] actualDep2 = list2.toArray(new Employee[] {});
		Arrays.sort(actualDep1);
		Arrays.sort(actualDep2);
		assertArrayEquals(expectedDep1, actualDep1);//проверяем порядок сотрудников здесь и в методе одинаковый
		assertArrayEquals(expectedDep2, actualDep2);
		*/
		assertTrue(company.getEmployeesByDepartment(DEPARTMENT6).isEmpty());//проверяем, что метод вернет пустой список
		runListTest(expectedDep1, list1);//упрощение записи благодаря введенному ниже методу. Полная верся в комментарии выше
		runListTest(expectedDep2, list2);
	}

	@Test
	void testGetAllEmployees() {
		/*
		List<Employee> list =  company.getAllEmployees();
		Employee[] actual = list.toArray(new Employee[] {});
		Arrays.sort(actual);
		assertArrayEquals(employees, actual);
		*/
		runListTest(employees, company.getAllEmployees());
		
		
	}

	@Test
	void testGetEmployeesBySalary() {
		/*
		List<Employee> listAll = company.getEmployeesBySalary(0, 10000);
		Employee[] actualAll = listAll.toArray(new Employee[] {});
		Arrays.sort(actualAll);
		assertArrayEquals(employees, actualAll);
		List<Employee> listEmpty = company.getEmployeesBySalary(9000, 10000);
		assertTrue(listEmpty.isEmpty());
		List<Employee> list2_3 = company.getEmployeesBySalary(SALARY1, SALARY3);
		Employee[] actual2_3 = list2_3.toArray(new Employee[] {});
		Employee[] expected2_3 = {empl2, empl3};
		Arrays.sort(actual2_3);
		assertArrayEquals(expected2_3, actual2_3);
		*/
		runListTest(employees, company.getEmployeesBySalary(0, Integer.MAX_VALUE));//подходит для всех
		runListTest(new Employee[0], company.getEmployeesBySalary(10000, Integer.MAX_VALUE));//ни для кого, Employee[0] = пустой массив
		runListTest(new Employee[] {empl1, empl2}, company.getEmployeesBySalary(SALARY1, SALARY3));//между двумя
		
		
	}

	@Test
	void testGetEmployeeByAge() {
		/*
		List<Employee> listAll = company.getEmployeeByAge(0, 100);
		Employee[] actualAll = listAll.toArray(new Employee[] {});
		Arrays.sort(actualAll);
		assertArrayEquals(employees, actualAll);//попали все в указанный диапазон, вернет список всех служащих
		List<Employee> listEmpty = company.getEmployeeByAge(90, 100);
		assertTrue(listEmpty.isEmpty());//нет людей в таком диапазоне, вернет пустой список
		List<Employee> list2_3 = company.getEmployeeByAge(getAge(DATE3), getAge(DATE1));//от младше к старше в диапазоне константы
		Employee[] actual2_3 = list2_3.toArray(new Employee[] {});
		Employee[] expected2_3 = {empl2, empl3};
		Arrays.sort(actual2_3);
		assertArrayEquals(expected2_3, actual2_3);
		*/
		runListTest(employees, company.getEmployeeByAge(0, 100));//все
		runListTest(new Employee[0], company.getEmployeeByAge(90, 100));//ни одного
		runListTest(new Employee[] {empl2, empl2}, company.getEmployeeByAge(getAge(DATE3), getAge(DATE1)));//между
	}

	@Test
	void testSalaryDisributionByDepartments() {
		DepartmentAvgSalary[] expectedDisribution = {
				new DepartmentAvgSalary(DEPARTMENT1, (SALARY1 + SALARY2) / 2),
				new DepartmentAvgSalary(DEPARTMENT2, (SALARY3 + SALARY4) / 2),
				new DepartmentAvgSalary(DEPARTMENT3, SALARY5)
		};
		List<DepartmentAvgSalary> listDisribution = company.salaryDisributionByDepartments();
		DepartmentAvgSalary[] actualDisribution = listDisribution.toArray(new DepartmentAvgSalary[] {});
		Arrays.sort(actualDisribution);
		assertArrayEquals(expectedDisribution, actualDisribution);
	}

	@Test
	void testGetSalaryDisribution() { //количество служащих, получающих зп в диапазонах
		int interval = 2000;
		List<SalaryIntervalDistribution> distribution = company.getSalaryDisribution(interval);//задаем диапазон
		SalaryIntervalDistribution[] expectedDistribution = { //ожидаемое распределение
			new SalaryIntervalDistribution(SALARY1, SALARY1 + interval, 2) ,
			new SalaryIntervalDistribution(SALARY3, SALARY3 + interval, 2) ,
			new SalaryIntervalDistribution(SALARY5, SALARY5 + interval, 1)
		};
		assertArrayEquals(expectedDistribution, distribution.toArray(new SalaryIntervalDistribution[0]));
		
	}

	@Test
	void testUpdateDepartment() {
		assertEquals(empl2, company.updateDepartment(ID2, DEPARTMENT2));//вернуть ссылку на служащего, которому сменили отдел
		runListTest(new Employee[] {empl1}, company.getEmployeesByDepartment(DEPARTMENT1));//сравнить обновленное распределение по отделам после перемещения сотрудника
		runListTest(new Employee[] {empl2, empl3, empl4}, company.getEmployeesByDepartment(DEPARTMENT2));
	}

	@Test
	void testUpdateSalary() {
		assertEquals(empl2, company.updateSalary(ID2, SALARY3));//аналогично обновлению отдела
		runListTest(new Employee[] {empl1}, company.getEmployeesBySalary(SALARY1, SALARY3));
		runListTest(new Employee[] {empl2, empl3, empl4}, company.getEmployeesBySalary(SALARY3, SALARY5));
	}

	@Test
	@Order(1) //порядок теста, этот будет первым
	void testSave() {
		company.save(FILE_PATH);//сохраняем все данные в файл
	}

	@Test
	@Order(2)
	void testRestore() {
		CompanyService companySaved = new CompanyServiceImp();
		companySaved.restore(FILE_PATH);//восстанавливаем данные из файла
		runListTest(employees, companySaved.getAllEmployees());//сравниваем текущий массив сотрудников с выгруженным из файла
	}
	
	private int getAge(LocalDate birthdate) {
		int result = (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now()); //в чем будет разница между данными (тут в годах между текущей и годом рождения)
		return result;
	}
	
	private void runListTest(Employee[] expected, List<Employee> list) { //для повторяющихся действий ожидаемых массивов
		//так облегчаем алгоритм для остальных тестов
		Employee[] actual = list.toArray(new Employee[] {});//получаем массив actual
		Arrays.sort(actual);//сортируем
		assertArrayEquals(expected, actual);//сравниваем ожидание/реальность
	}
	
	
	
	/*
	@Test
	void testObject() {
		fail("Not yet implemented");
	}

	@Test
	void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	void testClone() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	void testWait() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalize() {
		fail("Not yet implemented");
	}
	*/
}
