package com.project.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Case2 {

	private WebDriver driver;
	Empleos ingresoModulo;
	
	@Before
	public void setUp() throws Exception {
		ingresoModulo = new Empleos(driver);
		driver = ingresoModulo.chromeDriverconnection();
		ingresoModulo.Visit("https://www.choucairtesting.com/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		ingresoModulo.caso2ValidaQueEsChoucair();
	}

}
