package com.example.jpamapping;

import com.example.jpamapping.entity.*;
import com.example.jpamapping.repository.CategoryRepository;
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

	@Autowired
	private CategoryRepository categoryRepository;


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
//		Student student=new Student();
//		student.setStudentId(1);
//		student.setStudentName("guchhu");
//		student.setStudentAge(17);
//
//		Address address1=new Address();
//		address1.setAddressId(10);
//		address1.setStreet("235/789");
//		address1.setCity("Durgapur");
//		address1.setStudent(student);
//
//		Address address2=new Address();
//		address2.setAddressId(11);
//		address2.setStreet("23/789");
//		address2.setCity("Kolkata");
//		address2.setStudent(student);
//
//		List<Address> addressList=new ArrayList<>();
//		addressList.add(address1);
//		addressList.add(address2);
//
//		student.setAddressList(addressList);
//
//		Student added=studentRepository.save(student);

		//MANY TO MANY
//		Product product1=new Product();
//		product1.setProductId(1);
//		product1.setProductName("Samsung");
//
//		Product product2=new Product();
//		product2.setProductId(2);
//		product2.setProductName("smart tv");
//
//		Product product3=new Product();
//		product3.setProductId(3);
//		product3.setProductName("oppo");
//
//		Category category1=new Category();
//		category1.setCategoryId(10);
//		category1.setTitle("Electronics");
//
//		Category category2=new Category();
//		category2.setCategoryId(11);
//		category2.setTitle("Mobile Phone");
//
//		List<Product> products=new ArrayList<>();
//		products.add(product1);
//		products.add(product2);
//		products.add(product3);
//
//		List<Product> products2=new ArrayList<>();
//		products2.add(product1);
//		products2.add(product2);
//
//		category1.setProducts(products);
//		category2.setProducts(products2);
//
//		categoryRepository.save(category1);
//		categoryRepository.save(category2);

		Category category=categoryRepository.findById(10).get();
		System.out.println(category.getCategoryId()+" title is "+category.getTitle());
		System.out.println("bought products");

		List<Product> products=category.getProducts();
		for(Product product:products){
			System.out.println(product.getProductId()+" "+product.getProductName());
		}






	}
}
