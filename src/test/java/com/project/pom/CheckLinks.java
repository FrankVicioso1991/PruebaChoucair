package com.project.pom;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckLinks {

	private WebDriver driver;

	public CheckLinks(WebDriver driver) {
		this.driver = driver;

	}

	public boolean checkListPage() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		String url = "";

		List<String> linksInvalidos = new ArrayList<String>();
		List<String> linksValidos = new ArrayList<String>();

		HttpsURLConnection httpConection = null;
		int reponseCode = 200;
		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println(url + "URL no está configurada o está vacia");
				continue;
			}
			try {
				httpConection = (HttpsURLConnection) (new URL(url).openConnection());
				httpConection.setRequestMethod("HEAD");
				httpConection.connect();
				reponseCode = httpConection.getResponseCode();

				if (reponseCode > 400) {
					System.out.println("Error en el link:   --  " + url);
					linksInvalidos.add(url);
				} else {
					System.out.println("Link Valido: -----   " + url);
					linksValidos.add(url);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

		System.out.println("Links Validos: ---" + linksValidos.size());
		System.out.println("Link Invalidos:---" + linksInvalidos.size());

		if (linksInvalidos.size() > 0) {
			System.out.println("******ERROR*****------------------");
			for (int i = 0; i < linksInvalidos.size(); i++) {
				System.out.println(linksInvalidos.get(i));
			}
			return false;
		} else {
			return true;

		}

	}

}
