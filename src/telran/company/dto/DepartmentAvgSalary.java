package telran.company.dto;

import java.io.Serializable;//интерфейс, который дает возможность поместить сложный объект в файл и восстановить оттуда; 
//связано с необходимостью перемещать данные за пределы оперативной памяти (пользователю)

public record DepartmentAvgSalary(String department, int salary) implements Serializable, Comparable<DepartmentAvgSalary>{

	@Override
	//сравнения двух объектов DepartmentAvgSalary по department
	public int compareTo(DepartmentAvgSalary o) {
		
		return department.compareTo(o.department);
	}
	
}
