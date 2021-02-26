package com.project.pom;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Empleos extends Base{

	By linkEmpleos = By.linkText("Empleos");
	By imagenLocalizada = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2019/07/banner.png']");
	
	//Elementos para ingresar a cada opcion del modulo empleo
	By imgQueEsSerChoucair = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/elementor/thumbs/serchazuleMesa-de-trabajo-1-nzblz88m4p4bxdbhw303dezvce7f6561j2nbdlusiw.png']");
	By imgConvocatoria = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/elementor/thumbs/empleosazuleMesa-de-trabajo-1-nzblz96gbj5m8za4qlepxwrbxs2sdu9rv7asuvteco.png']");
	By imgPrepararseParaAplicar = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/elementor/thumbs/empleosazulMesa-de-trabajo-1-nzblzb24p786w77efm7z2wa94jtit8h8jglrtfqm08.png']");

	By empleoDispoible = By.className("elementor-heading-title elementor-size-default");

	//Elementos para buscar Empleos en Convocatoria
	By keywords = By.id("search_keywords");
	By location = By.id("search_location");
	By buscar = By.name("submit");
	
	public Empleos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void smokeTestEmpleo() throws InterruptedException {
		click(linkEmpleos);
		Thread.sleep(2000);
		
		if(isDisplayed(imagenLocalizada)) {
			if(isDisplayed(imgQueEsSerChoucair)) {
				if(isDisplayed(imgConvocatoria)) {
					if (isDisplayed(imgPrepararseParaAplicar)) {
						System.out.print("Cuenta con las Opciones de ¿Qué es ser Choucair?, Convocatorias y Prepararse para aplicar");
					
					}
					
				}
			}
		}else {
			System.out.print("No se encuentran en el modulo Empleo");
		}
		
	}
	
	public void caso2ValidaQueEsChoucair() throws InterruptedException {
		click(linkEmpleos);
		Thread.sleep(2000);
		if(isDisplayed(imagenLocalizada)) {
		click(imgQueEsSerChoucair);	
		}
		else {
			System.out.print("No se pudo ingresar a la opción ¿Qué es ser choucair?");
		}
	}
	
	
	public void caso3ValidaConvocatoria() throws InterruptedException {
		click(linkEmpleos);
		Thread.sleep(2000);
		if(isDisplayed(imagenLocalizada)) {
			click(imgConvocatoria);	
		}
		else {
			System.out.print("No se pudo ingresar a la opción Convocatorias ");
		}
		
	}
	
	public void caso9EmpleoDisponible() throws InterruptedException {
		click(linkEmpleos);
		Thread.sleep(2000);
		if(isDisplayed(imagenLocalizada)) {
		
			type("Automatización", keywords);
			type("Colombia", location);
			click(buscar);
		
		}
		else {
			System.out.print("No se encuentra en el modulo Empleo");
		}
		
	}
	
	public void caso11PrepareseParaAplicar() throws InterruptedException {
		click(linkEmpleos);
		Thread.sleep(2000);
		if(isDisplayed(imagenLocalizada)) {
			click(imgPrepararseParaAplicar);
		
		}
		else {
			System.out.print("No se encuentra en el modulo Empleo");
		}
	}
	
		
}
