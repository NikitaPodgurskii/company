package telran.company.dto;

import java.io.Serializable;//возможность поместить сложный объект в файл и восстановить оттуда

public record DepartmentAvgSalary(String department, int salary) implements Serializable{
	
}
