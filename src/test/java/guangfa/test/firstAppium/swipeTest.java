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

public class swipeTest {
	
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
				//desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
				//desiredCapabilities.setCapability("appPackage", "com.handsgo.jiakao.android");
				desiredCapabilities.setCapability("appPackage", "com.gf.client");
				//automationName:uiautomator2�������������벻�˵�����
				//�Զ�������
				desiredCapabilities.setCapability("automationName", "uiautomator2");
				//������Ӧ�����ݣ�Ĭ���������
				desiredCapabilities.setCapability("noReset", "true");
				//appActivity������App�������
				//desiredCapabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
				//desiredCapabilities.setCapability("appActivity", "com.handsgo.jiakao.android.splash.Login");
				desiredCapabilities.setCapability("appActivity", "com.gf.mobile.control.LauncherActivity");
				
				//3����������
				//������������
				//��һ��������AppiumͨѶ��ַ
				//�ڶ������������ö���
				androidDriver=new AndroidDriver<WebElement>(new URL("http:/127.0.0.1:4723/wd/hub"),desiredCapabilities);
	}
	
	@Test
	public void testLeftRight() throws InterruptedException
	{
		Thread.sleep(2000);
		//���뵽��Ѷ
		androidDriver.findElementById("com.gf.client:id/radio_chest").click();
		//���һ���
		Thread.sleep(2000);
		TouchAction touchAction=new TouchAction(androidDriver);
		//��ԭʼ����ת����PointOption����
		PointOption startPointOption1=PointOption.point(700, 723);
		PointOption endPointOption1=PointOption.point(10, 723);
		//��ԭʼʱ��ת����Duration����
		Duration duration1=Duration.ofMillis(800);
		//Duration������ת����WaitOptions����
		WaitOptions waitOptions1=WaitOptions.waitOptions(duration1);
		touchAction.press(startPointOption1).waitAction(waitOptions1).moveTo(endPointOption1).release();
		//�û�����Ч
		touchAction.perform();
		Thread.sleep(5000);
		
		PointOption startPointOption2=PointOption.point(10, 723);
		PointOption endPointOption2=PointOption.point(700, 723);
		//��ԭʼʱ��ת����Duration����
		Duration duration2=Duration.ofMillis(800);
		//Duration������ת����WaitOptions����
		WaitOptions waitOptions2=WaitOptions.waitOptions(duration2);
		touchAction.press(startPointOption2).waitAction(waitOptions2).moveTo(endPointOption2).release();
		//�û�����Ч
		touchAction.perform();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		androidDriver.findElementByXPath("//android.widget.TextView[@text='��Ѷ']").click();
		Thread.sleep(2000);
		String expected4="com.gf.mobile.reactnative.RNInformationActivity";
		String actual4=androidDriver.currentActivity();
		Assert.assertEquals(actual4, expected4);
		
	}
	
		
		
		@AfterTest
		public void tearDown()
		{
			//����������������ϣ�������������
			androidDriver.quit();
		}
		
	

}
