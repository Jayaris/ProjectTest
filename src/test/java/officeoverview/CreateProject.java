package officeoverview;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.*;

public class CreateProject extends BaseTest {
	
	
	

@Test
public static void FullSuite() throws InterruptedException {
	//Calls method from BaseTest to log the user in	
	LogIn("system.admin", "password");
	//Uses the config file to concatanate the base url with the specified link
		driver.get(baseUrl + "/project-overview");
	//Calls the Project Details method which calls various methods to complete the Project Creation form. Most fields are defaulted, but it is set up to receive a String for Title. 
	//Same principle can be applied to the other fields, would just depend on which we would determine worthwhile to set.
	ProjectDetails("Budget");
	ProjectDetails("Contract");
	ProjectDetails("Intelligence");
	ProjectDetails("Lead");
	ProjectDetails("Pre Qual");
	ProjectDetails("Tender");
	ProjectDetails("Tender Offer");
}


public static void ProjectDetails(String projectTitle) {	
	//Waits for (using the WaitForClickable BaseTest method) and then opens the Create Project drop down. If you dont check this the driver will try to click it before the page fully loads.
	WaitForClickable(By.cssSelector("#addDocumentSplitButtonElement > .sos-icon-chevron-down")); 
	driver.findElement(By.cssSelector("#addDocumentSplitButtonElement > .sos-icon-chevron-down")).click();
	
	//No wait required as dropdown opens quick
	driver.findElement(By.cssSelector(".menu-section:nth-child(3) > .menu-row:nth-child(3) > p")).click();
	
	//Wait is for the Project Title, but main purpose is to check the Create Project form is open
	WaitForVisible(By.id("dijit_form_ValidationTextBox_7"));
	driver.findElement(By.id("dijit_form_ValidationTextBox_7")).sendKeys(projectTitle);
	
	System.out.println("here.");
	
	//Form has loaded, so entering text into other text fields doesn't require a check.
	driver.findElement(By.cssSelector(".project-description-container > .sos-form-textarea")).sendKeys("Project Description");
	
	setDates();
	
	//Calls methods in this class to set fields as required
	setRunningProject("Spencer Group");
	setClient("Immingham Bulk Terminal");	
	setAddress();
	setStageType(projectTitle);
	setTeam("Bridges");
	setTemplate(projectTitle);
	
	
	//Submits the form
	driver.findElement(By.cssSelector(".sos-btn.sos-btn-confirm.sos-btn-icon.sos-icon-plus.create-project-button")).click();
					
	//Waits for the Success message to appear. Otherwise test would end so quickly that the project creation would be interrupted
	WaitForVisible(By.cssSelector(".sos-notification-success.sos-notification-count-down.sos-notification-inline"));
	
}

public static void BudgetDetails () {
		//Sets the Budget Status
		driver.findElement(By.cssSelector("div[id='uniqName_23_12'] label[class='sos-form-textfield-suffix']")).click();
		WaitForClickable(By.cssSelector("div[title='Abandoned by Client']"));
		driver.findElement(By.cssSelector("div[title='Abandoned by Client']")).click();
		
		driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_0")).clear();
		driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_0")).sendKeys("11111");
		
		//Completes remaining non-dropdown fields
		driver.findElement(By.cssSelector("#detailsTitle")).sendKeys(" - Title");
		driver.findElement(By.cssSelector("#detailsReceivedDate")).sendKeys("06/12/2024");
		driver.findElement(By.cssSelector("#detailsSubmissionDate")).sendKeys("12/12/2024");
		driver.findElement(By.cssSelector("#detailsPreSubmissionNotes")).sendKeys("PreSub");
		driver.findElement(By.cssSelector("#detailsPostSubmissionNotes")).sendKeys("PostSub");
}


public static void ContractDetails() {	
	//Clears the Original Value field and enters a value (the reason for the clear is because entering the value on its own resulted in the default 0 and 25000 figure being concatenated)
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_1")).clear();
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_1")).sendKeys("22222");
	
	//Phase dropdown opens and Delivery is selected
	driver.findElement(By.cssSelector("div[id='widget_detailsPhase'] div[role='presentation']")).click();
	WaitForClickable(By.cssSelector("#detailsPhase_popup1"));
	driver.findElement(By.cssSelector("#detailsPhase_popup1")).click();  
	
	//Completes remaining non-dropdown fields
	driver.findElement(By.cssSelector("#detailsTitle")).sendKeys(" - Title");
	driver.findElement(By.cssSelector("#detailsAwardDate")).sendKeys("06/12/2024");
	driver.findElement(By.cssSelector("#detailsStartDate")).sendKeys("12/12/2024");
	driver.findElement(By.cssSelector("#detailsTargetCompletionDate")).sendKeys("18/12/2024");
	driver.findElement(By.cssSelector("#detailsNotes")).sendKeys("There are the Project Notes");
}

public static void IntelligenceDetails () {
	WaitForClickable(By.xpath("/html[1]/body[1]/div[9]/div[17]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/input[1]"));
	driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[17]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/input[1]")).clear();
	driver.findElement(By.xpath("/html[1]/body[1]/div[9]/div[17]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/input[1]")).sendKeys("33333");
	
	//Clicks and sets the Status field
	driver.findElement(By.cssSelector("div[id='widget_soso_dijit_form_FilteringSelect_0'] div[role='presentation']")).click();
	WaitForClickable(By.cssSelector("#soso_dijit_form_FilteringSelect_0_popup1"));
	driver.findElement(By.cssSelector("#soso_dijit_form_FilteringSelect_0_popup1")).click();
}

public static void LeadDetails () {
	driver.findElement(By.cssSelector("#soso_dijit_form_FilteringSelect_1")).sendKeys("June");
	driver.findElement(By.cssSelector("#soso_dijit_form_FilteringSelect_2")).sendKeys("2024");
	driver.findElement(By.cssSelector("#soso_dijit_form_FilteringSelect_3")).clear();
	driver.findElement(By.cssSelector("#soso_dijit_form_FilteringSelect_3")).sendKeys("Dead");
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_3")).clear();
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_3")).sendKeys("44444");
}

public static void PreQualDetails () {
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_11")).sendKeys("01/01/2023");
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_12")).sendKeys("02/02/2023");
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_13")).sendKeys("03/03/2023");
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_4")).clear();
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_4")).sendKeys("55555");
	
	driver.findElement(By.cssSelector("input[placeholder='Select status...']")).sendKeys("Qualified");
	WaitForClickable(By.cssSelector("div[title='Qualified']"));
	driver.findElement(By.cssSelector("div[title='Qualified']")).click();
	driver.findElement(By.cssSelector("input[placeholder='Select...']")).sendKeys("Partnerships");
	WaitForClickable(By.cssSelector("div[title='Partnerships']"));
	driver.findElement(By.cssSelector("div[title='Partnerships']")).click();
	
	
	driver.findElement(By.cssSelector("textarea[data-dojo-attach-point='preSubmissionNotesNode']")).sendKeys("pre");
	driver.findElement(By.cssSelector("textarea[data-dojo-attach-point='postSubmissionNotesNode']")).sendKeys("post");
}

public static void TenderDetails () {
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_14")).sendKeys("01/01/2023");
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_15")).sendKeys("02/02/2023");
	driver.findElement(By.cssSelector("input[placeholder='Select status...']")).sendKeys("Active");
	WaitForClickable(By.cssSelector("div[title='Active']"));
	driver.findElement(By.cssSelector("div[title='Active']")).click();
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_5")).clear();
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_5")).sendKeys("66666");
	driver.findElement(By.cssSelector("textarea[data-dojo-attach-point='postNotesNode']")).sendKeys("preTender");
	driver.findElement(By.cssSelector("textarea[data-dojo-attach-point='preNotesNode']")).sendKeys("postTender");
}

public static void TenderOfferDetails () {
	driver.findElement(By.cssSelector("#soso_dijit_form_FilteringSelect_4")).sendKeys("Accept");
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_16")).sendKeys("03/04/2023");
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_17")).sendKeys("04/05/2023");
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_6")).clear();
	driver.findElement(By.cssSelector("#dijit_form_NumberSpinner_6")).sendKeys("77777");
	driver.findElement(By.cssSelector("textarea[data-dojo-attach-point='preSubmissionNotesNode']")).sendKeys("preTenderOffer");
	driver.findElement(By.cssSelector("textarea[data-dojo-attach-point='postSubmissionNotesNode']")).sendKeys("postTenderOffer");
}

public static void setDates() {
	//Date Fields (Not a great test, as it wouldn't check whether there was an issue with the pop-up itself)
	WaitForClickable(By.cssSelector("#dijit_form_DateTextBox_10"));
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_10")).sendKeys("24/12/2024");
	
	//Date Fields (Not a great test, as it wouldn't check whether there was an issue with the pop-up itself)
	WaitForClickable(By.cssSelector("#dijit_form_DateTextBox_9"));
	driver.findElement(By.cssSelector("#dijit_form_DateTextBox_9")).sendKeys("12/06/2023");
}

public static void setAddress() {
	//Text Fields (Validated)
		driver.findElement(By.id("dijit_form_ValidationTextBox_1")).sendKeys("Jason's Old House");
		driver.findElement(By.id("dijit_form_ValidationTextBox_2")).sendKeys("Immingham");
		driver.findElement(By.id("dijit_form_ValidationTextBox_3")).sendKeys("DN40 2BL");
		
		//Text Fields (Non-Validated -- using xpath as the other locators are randomly generated and quite complex)
		driver.findElement(By.xpath("(//input[@type='text'])[106]")).sendKeys("First Line of Address");
		driver.findElement(By.xpath("(//input[@type='text'])[109]")).sendKeys("Second Line of Address");
		driver.findElement(By.xpath("(//input[@type='text'])[110]")).sendKeys("Third Line of Address");
		driver.findElement(By.xpath("(//textarea[@data-dojo-attach-point='siteInstruction'])[1]")).sendKeys("Site Instruction Text.");
}


public static void setRunningProject(String organisation) {
	//Emulates keystrokes of the organisation running the project in the relevant field, then waits for autocomplete to display the dropdown and selects the specified option
	driver.findElement(By.cssSelector("input[placeholder='Select company running the project...']")).sendKeys(organisation);
	WaitForClickable(By.cssSelector("div[title='" + organisation + "']"));
	driver.findElement(By.cssSelector("div[title='" + organisation + "']")).click();
}

public static void setClient(String client) {
	//Emulates keystrokes of the clients name in the Client field, then waits for autocomplete to display the dropdown and selects the specified option
	driver.findElement(By.cssSelector("input[placeholder='Select client...']")).sendKeys(client);
	WaitForVisible(By.cssSelector("div[title='" + client + "']"));
	driver.findElement(By.cssSelector("div[title='" + client + "']")).click();
}

public static void setStageType(String projectTitle) {
	int projectType = 0;
	if (projectTitle == "Budget") {
		projectType = 1;
	}
	else if (projectTitle == "Contract") {
		projectType = 2;
	}
	else if (projectTitle == "Intelligence") {
		projectType = 3;
	}
	else if (projectTitle == "Lead") {
		projectType = 4;
	}
	else if (projectTitle == "Pre Qual") {
		projectType = 5;
	}
	else if (projectTitle == "Tender") {
		projectType = 6;
	}
	else if (projectTitle == "Tender Offer") {
		projectType = 7;
	}
	else {
		System.out.println("Project Type is invalid.");
	}
	System.out.println("div[class='project-stage-select-section'] p:nth-child("+ projectType +")");
	
	//Clicks the dropdown for Stage Type then selects the numerically corresponding option on the list
	driver.findElement(By.xpath("(//div[@class='sos-standard-form-select-wrapper'])[1]")).click();
	WaitForVisible(By.cssSelector("div[class='project-stage-select-section'] p:nth-child("+ projectType +")"));
	driver.findElement(By.cssSelector("div[class='project-stage-select-section'] p:nth-child("+ projectType +")")).click();
	
	switch (projectType) {
		case (1):
			BudgetDetails();
			break;
		case (2):
			ContractDetails();
			break;
		case (3):
			IntelligenceDetails();
			break;
		case (4):
			LeadDetails();
			break;
		case (5):
			PreQualDetails();
			break;
		case (6):
			TenderDetails();
			break;
		case (7):
			TenderOfferDetails();
			break;
		}
	}
	
	public static void setTemplate(String template) {
		//Tree Template dropdown opens and the Stage applicable option is selected
		driver.findElement(By.xpath("(//span[@class='sos-icon sos-icon-chevron-down'])[11]")).click();
		WaitForClickable(By.cssSelector("div[title='" + template + "']"));
		driver.findElement(By.cssSelector("div[title='" + template + "']")).click();
	}


	public static void setTeam(String team) {
		//Waits for Stage specific fields to appear, then clicks the Team dropdown
		WaitForVisible(By.xpath("(//span[@class='sos-icon sos-icon-chevron-down'])[10]"));
		driver.findElement(By.xpath("(//span[@class='sos-icon sos-icon-chevron-down'])[10]")).click();
		WaitForClickable(By.xpath("(//div[@title='" + team + "'])[1]"));
		driver.findElement(By.xpath("(//div[@title='" + team + "'])[1]")).click();
	}
}
