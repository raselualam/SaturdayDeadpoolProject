package upskill.ebay.pageAction;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import upskill.ebay.pageElements.EbayCartLocators;
import upskill.utilities.SetupDrivers;

public class EbayCartActions {

	EbayCartLocators EbayCartLocatorsObj;
	
	public EbayCartActions(){
		EbayCartLocatorsObj = new EbayCartLocators();
		PageFactory.initElements(SetupDrivers.driver, EbayCartLocatorsObj);
	}

	public void switchNewWindow(){
		for(String winhandle : SetupDrivers.driver.getWindowHandles()){
		SetupDrivers.driver.switchTo().window(winhandle);
		}
	}
	
	public void selectSizeType() throws Exception{
		Thread.sleep(2000);
		Select dropDownObj = new Select(EbayCartLocatorsObj.ddSizeType);
		dropDownObj.selectByVisibleText("Big & Tall");
		Thread.sleep(2000);
	}
	
	public void selectMenSize() throws Exception{
		Select dropDownObj = new Select(EbayCartLocatorsObj.ddMenSize);
		dropDownObj.selectByVisibleText("4XLT");
		Thread.sleep(2000);
	}
	
	public void selectShade() throws Exception{
		Select dropDownObj = new Select(EbayCartLocatorsObj.ddShade);
		dropDownObj.selectByVisibleText("Black");
//		dropDownObj.selectByIndex(4);
//		dropDownObj.selectByValue("15");
		Thread.sleep(2000);
	}
	
	public void enterQuantity() throws Exception{
		EbayCartLocatorsObj.txtbxQty.clear();
		EbayCartLocatorsObj.txtbxQty.sendKeys("5");
		Thread.sleep(2000);
	}
	
	public void addToCart() throws Exception{
		EbayCartLocatorsObj.btnAddCart.click();
		Thread.sleep(5000);
	}
}
