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
		//1、创建配置对象
				DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
				//2、添加配置
				//deviceName：可以找到我们测试的设备，即安卓虚拟器
				desiredCapabilities.setCapability("deviceName", "Honor 10");
				//platformName：测试平台Android or IOS
				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("platformVersion", "9.0.1");
				//appPackage：找到要测试的app
				//desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
				//desiredCapabilities.setCapability("appPackage", "com.handsgo.jiakao.android");
				desiredCapabilities.setCapability("appPackage", "com.gf.client");
				//automationName:uiautomator2来解决输入框输入不了的问题
				//自动化引擎
				desiredCapabilities.setCapability("automationName", "uiautomator2");
				//不清理应用数据，默认是清理掉
				desiredCapabilities.setCapability("noReset", "true");
				//appActivity：测试App启动入口
				//desiredCapabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
				//desiredCapabilities.setCapability("appActivity", "com.handsgo.jiakao.android.splash.Login");
				desiredCapabilities.setCapability("appActivity", "com.gf.mobile.control.LauncherActivity");
				
				//3、创建驱动
				//传入两个参数
				//第一个参数：Appium通讯地址
				//第二个参数：配置对象
				androidDriver=new AndroidDriver<WebElement>(new URL("http:/127.0.0.1:4723/wd/hub"),desiredCapabilities);
				//30s隐式等待
				androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
	@Test
	public void getToast()
	{
		WebElement toastElement=androidDriver.findElementByXPath("//*[contain(@text,'删除成功')]");
		System.out.print(toastElement.getText());
	}
	
		
		
		@AfterTest
		public void tearDown()
		{
			//当测试用例运行完毕，我们销毁驱动
			androidDriver.quit();
		}
		
	

}
