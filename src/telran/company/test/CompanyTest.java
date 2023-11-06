package telran.company.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.company.dto.Employee;

class CompanyTest {
	private static final long ID1 = 0;
	private static final long ID2 = 0;
	private static final int SALARY1 = 0;
	private static final int SALARY2 = 0;
	private static final String DEPARTMENT1 = null;
	private static final LocalDate DATE1 = null;
	private static final LocalDate DATE2 = null;
	Employee empl1 = new Employee(ID1, "name1", SALARY1, DEPARTMENT1, DATE1);
	Employee empl2 = new Employee(ID2, "name2", SALARY2, DEPARTMENT1, DATE2);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHireEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testFireEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployeesByDepartment() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployeesBySalary() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEmployeeByAge() {
		fail("Not yet implemented");
	}

	@Test
	void testSalaryDisributionByDepartments() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSalaryDisribution() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateDepartment() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSalary() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testRestore() {
		fail("Not yet implemented");
	}

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

}
