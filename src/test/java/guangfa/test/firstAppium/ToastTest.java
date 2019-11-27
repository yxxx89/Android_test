package guangfa.test.firstAppium;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ToastTest {
	
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
				//30s��ʽ�ȴ�
				androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
	@Test
	public void getToast()
	{
		WebElement toastElement=androidDriver.findElementByXPath("//*[contain(@text,'ɾ���ɹ�')]");
		System.out.print(toastElement.getText());
	}
	
		
		
		@AfterTest
		public void tearDown()
		{
			//����������������ϣ�������������
			androidDriver.quit();
		}
		
	

}
