package com.example.jpamapping;

import com.example.jpamapping.entity.Address;
import com.example.jpamapping.entity.Laptop;
import com.example.jpamapping.entity.Student;
import com.example.jpamapping.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import  java.util.*;

@SpringBootApplication
public class JpamappingApplication  implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpamappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student=new Student();
//		student.setStudentId(1);
//		student.setStudentName("scooby");
//		student.setStudentAge(17);
//
//
//		Laptop laptop=new Laptop();
//		laptop.setLaptopId(10);
//		laptop.setModelName("45fg");
//		laptop.setBrandName("DELL");
//
//		laptop.setStudent(student);
//		student.setLaptop(laptop);
//
//		Student added=studentRepository.save(student);
//		Student studentObj=studentRepository.findById(1).get();
//		System.out.println("name is "+studentObj.getStudentName()+" "+studentObj.getLaptop().getBrandName());


		//ONE TO Many Mapping
		Student student=new Student();
		student.setStudentId(1);
		student.setStudentName("guchhu");
		student.setStudentAge(17);

		Address address1=new Address();
		address1.setAddressId(10);
		address1.setStreet("235/789");
		address1.setCity("Durgapur");
		address1.setStudent(student);

		Address address2=new Address();
		address2.setAddressId(11);
		address2.setStreet("23/789");
		address2.setCity("Kolkata");
		address2.setStudent(student);

		List<Address> addressList=new ArrayList<>();
		addressList.add(address1);
		addressList.add(address2);

		student.setAddressList(addressList);

		Student added=studentRepository.save(student);



	}
}
