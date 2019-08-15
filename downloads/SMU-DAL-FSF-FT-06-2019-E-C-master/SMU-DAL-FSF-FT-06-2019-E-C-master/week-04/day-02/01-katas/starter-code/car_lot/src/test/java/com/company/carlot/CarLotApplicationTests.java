package com.company.carlot;

import com.company.carlot.dao.CarLotRepository;
import com.company.carlot.dto.Car;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarLotApplicationTests {

	@Autowired
    CarLotRepository carLotRepo;

	@Before
	public void setUp() {
		carLotRepo.deleteAll();
	}

	@Test
	public void addGetDeleteCar() {
		Car aCar = new Car();
	
		aCar.setMake("Toyota");
		aCar.setModel("NewAge");
		aCar.setYear("2019");
		aCar.setColor("Orange");

		aCar = carLotRepo.save(aCar);

		List<Car> carList = carLotRepo.findAll();
		assertEquals(1, carList.size());

		carLotRepo.delete(aCar.getId());
		Car car1 = carLotRepo.findOne(aCar.getId());
		assertNull(car1);
	}

	@Test 
	public void updateCar() {
		Car aCar = new Car();
	
		aCar.setMake("Toyota");
		aCar.setModel("NewAge");
		aCar.setYear("2019");
		aCar.setColor("Orange");

		aCar = carLotRepo.save(aCar);

		aCar.setMake("Toyota");
		aCar.setModel("NewAge");
		aCar.setYear("2019");
		aCar.setColor("Red");

		aCar = carLotRepo.save(aCar);

		Car car1 = carLotRepo.findOne(aCar.getId());
		assertEquals(car1, aCar);
	}

	@Test
	public void findByMakeTest() {
		Car aCar = new Car();

		aCar.setMake("Toyota");
		aCar.setModel("NewAge");
		aCar.setYear("2019");
		aCar.setColor("Orange");

		carLotRepo.save(aCar);

		Car aCar2 = new Car();

		aCar2.setMake("Toyota");
		aCar2.setModel("Prius");
		aCar2.setYear("2019");
		aCar2.setColor("Red");

		carLotRepo.save(aCar2);

		Car aCar3 = new Car();

		aCar3.setMake("Ford");
		aCar3.setModel("Fusion");
		aCar3.setYear("2019");
		aCar3.setColor("Orange");

		carLotRepo.save(aCar3);

		List<Car> toyotaList = carLotRepo.findByMake("Toyota");
		assertEquals(2, toyotaList.size());

		List<Car> fordList = carLotRepo.findByMake("Ford");
		assertEquals(1, fordList.size());

		List<Car> chevyList = carLotRepo.findByMake("Chevrolet");
		assertEquals(0, chevyList.size());
	}

	@Test
	public void findByColorTest() {
		Car aCar = new Car();

		aCar.setMake("Toyota");
		aCar.setModel("NewAge");
		aCar.setYear("2019");
		aCar.setColor("Orange");

		carLotRepo.save(aCar);

		Car aCar2 = new Car();

		aCar2.setMake("Toyota");
		aCar2.setModel("Prius");
		aCar2.setYear("2019");
		aCar2.setColor("Red");

		carLotRepo.save(aCar2);

		Car aCar3 = new Car();

		aCar3.setMake("Ford");
		aCar3.setModel("Fusion");
		aCar3.setYear("2019");
		aCar3.setColor("Orange");

		carLotRepo.save(aCar3);

		List<Car> orangeList = carLotRepo.findByColor("Orange");
		assertEquals(2, orangeList.size());

		List<Car> redList = carLotRepo.findByColor("Red");
		assertEquals(1, redList.size());

		List<Car> blue = carLotRepo.findByMake("Blue");
		assertEquals(0, blue.size());
	}

	@Test
	public void findByMakeAndColorTest() {
		Car aCar = new Car();

		aCar.setMake("Toyota");
		aCar.setModel("NewAge");
		aCar.setYear("2019");
		aCar.setColor("Orange");

		carLotRepo.save(aCar);

		Car aCar2 = new Car();

		aCar2.setMake("Toyota");
		aCar2.setModel("Prius");
		aCar2.setYear("2019");
		aCar2.setColor("Red");

		carLotRepo.save(aCar2);

		Car aCar3 = new Car();

		aCar3.setMake("Ford");
		aCar3.setModel("Fusion");
		aCar3.setYear("2019");
		aCar3.setColor("Orange");

		carLotRepo.save(aCar3);

		List<Car> orangeList = carLotRepo.findByMakeAndColor("Toyota", "Orange");
		assertEquals(1, orangeList.size());

	}


}
