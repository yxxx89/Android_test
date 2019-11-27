package guangfa.test.firstAppium;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTest {
	
	public static AndroidDriver<WebElement> androidDriver;
	/*public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		
		testyijinbao();
		
	}*/
	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		//1���������ö���
				DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
				//2���������
				//deviceName�������ҵ����ǲ��Ե��豸������׿������
				desiredCapabilities.setCapability("deviceName", "Honor 10");
				//platformName������ƽ̨Android or IOS
				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("platformVersion", "9.0.1");
				//appPackage���ҵ�Ҫ���Ե�app
				desiredCapabilities.setCapability("appPackage", "com.gf.client");
				//automationName:uiautomator2�������������벻�˵�����
				//�Զ�������
				desiredCapabilities.setCapability("automationName", "uiautomator2");
				//appActivity������App�������
				desiredCapabilities.setCapability("appActivity", "com.gf.mobile.control.LauncherActivity");
				
				//3����������
				//������������
				//��һ��������AppiumͨѶ��ַ
				//�ڶ������������ö���
				androidDriver=new AndroidDriver<WebElement>(new URL("http:/127.0.0.1:4723/wd/hub"),desiredCapabilities);
	}
	
	
	
		@Test
		public void testyijinbao() throws InterruptedException
		{
			//�ȴ�Ԫ�ؼ������
			Thread.sleep(2000);
			//����app���ʼ����һЩ����
			androidDriver.findElementById("android:id/button1").click();
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/btn_next_page").click();
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/btn_begin").click();
			
			//����2
			Thread.sleep(2000);
			//1���ҵ���λ�����ı������ҵ��
			androidDriver.findElementById("com.gf.client:id/radio_quote").click();
			//2���ҵ���λ�����ѡ���ı������ҵ��
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/addButton").click();
			//3���ҵ���������򣬲�������600000
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/secu_code_input").sendKeys("600000");
			//4���ҵ���������е�600000�ַ����У����ҵ��+����ʾ�Ѹý����ӽ�ȥ
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/favstock_judge").click();
			//��ȡToast��Ϣ�����ѡ�ɹ�
			WebElement toastElement5=androidDriver.findElementByXPath("//*[contains(@text,'�����ѡ�ɹ�')]");
			System.out.print(toastElement5.getText());
			//����
			Thread.sleep(2000);
			String expected5="�����ѡ�ɹ�";
			String actual5=toastElement5.getText();
			Assert.assertEquals(actual5, expected5);
			
			//5�����600000�ַ����к󣬵��ȡ����������һ������
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/cancel_btn").click();
			//6��������Ҫ��֤һ�£����ԣ�ͨ�����������ж���
			Thread.sleep(2000);
			String expected1="com.gf.mobile.module.home.HomeActivity";
			String actual1=androidDriver.currentActivity();
			//String actual=androidDriver.getClass();
			Assert.assertEquals(actual1, expected1);
			
			
			//7������༭
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/btn_right_two").click();
			//8����ѡ600000�ַ�����ǰ���С��ѡ��600000�ַ�����
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/selectBox").click();
			//9��ѡ��ɾ��
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/deleteButton").click();
			//10��ȷ��ɾ��
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/md_buttonDefaultPositive").click();
			//��ȡToast��Ϣɾ���ɹ�
			WebElement toastElement6=androidDriver.findElementByXPath("//*[contains(@text,'ɾ���ɹ�')]");
			System.out.print(toastElement6.getText());
			//����
			Thread.sleep(2000);
			String expected6="ɾ���ɹ�";
			String actual6=toastElement6.getText();
			Assert.assertEquals(actual6, expected6);
			

			Thread.sleep(2000);
			androidDriver.findElementByXPath("//android.widget.ImageButton[@content-desc='ת����һ�㼶']").click();
			
			
			//12��������Ҫ��֤һ��
			Thread.sleep(2000);
			String expected2="com.gf.mobile.module.home.HomeActivity";
			String actual2=androidDriver.currentActivity();
			Assert.assertEquals(actual2, expected2);
			//////////////////////////////////////////
			Thread.sleep(2000);
			//���뵽����
			androidDriver.findElementById("com.gf.client:id/radio_chest").click();
			
			//ȥ����浯��
			Thread.sleep(2000);
			TouchAction touchAction2=new TouchAction(androidDriver);
			PointOption pointOption=PointOption.point(540, 1650);
			touchAction2.press(pointOption).release();
			touchAction2.perform();
			
			//���һ���
			TouchAction touchAction1=new TouchAction(androidDriver);
			//��ԭʼ����ת����PointOption����
			PointOption startPointOption1=PointOption.point(700, 723);
			PointOption endPointOption1=PointOption.point(10, 723);
			//��ԭʼʱ��ת����Duration����
			Duration duration1=Duration.ofMillis(800);
			//Duration������ת����WaitOptions����
			WaitOptions waitOptions1=WaitOptions.waitOptions(duration1);
			Thread.sleep(2000);
			touchAction1.press(startPointOption1).waitAction(waitOptions1).moveTo(endPointOption1).release();
			//�û�����Ч
			Thread.sleep(2000);
			touchAction1.perform();
			Thread.sleep(5000);
			
			touchAction1.press(endPointOption1).waitAction(waitOptions1).moveTo(startPointOption1).release();
			//�û�����Ч
			Thread.sleep(2000);
			touchAction1.perform();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			androidDriver.findElementByXPath("//android.widget.TextView[@text='��Ѷ']").click();
			Thread.sleep(5000);
			String expected4="com.gf.mobile.reactnative.RNInformationActivity";
			String actual4=androidDriver.currentActivity();
			Assert.assertEquals(actual4, expected4);
			Thread.sleep(2000);
			
			
		}
		
		@AfterTest
		public void tearDown()
		{
			//����������������ϣ�������������
			androidDriver.quit();
		}
		
	

}
