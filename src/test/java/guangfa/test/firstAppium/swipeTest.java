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
	}
	
	@Test
	public void testLeftRight() throws InterruptedException
	{
		Thread.sleep(2000);
		//进入到资讯
		androidDriver.findElementById("com.gf.client:id/radio_chest").click();
		//左右滑动
		Thread.sleep(2000);
		TouchAction touchAction=new TouchAction(androidDriver);
		//把原始坐标转换成PointOption类型
		PointOption startPointOption1=PointOption.point(700, 723);
		PointOption endPointOption1=PointOption.point(10, 723);
		//把原始时间转换成Duration类型
		Duration duration1=Duration.ofMillis(800);
		//Duration类型再转换成WaitOptions类型
		WaitOptions waitOptions1=WaitOptions.waitOptions(duration1);
		touchAction.press(startPointOption1).waitAction(waitOptions1).moveTo(endPointOption1).release();
		//让滑动生效
		touchAction.perform();
		Thread.sleep(5000);
		
		PointOption startPointOption2=PointOption.point(10, 723);
		PointOption endPointOption2=PointOption.point(700, 723);
		//把原始时间转换成Duration类型
		Duration duration2=Duration.ofMillis(800);
		//Duration类型再转换成WaitOptions类型
		WaitOptions waitOptions2=WaitOptions.waitOptions(duration2);
		touchAction.press(startPointOption2).waitAction(waitOptions2).moveTo(endPointOption2).release();
		//让滑动生效
		touchAction.perform();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		androidDriver.findElementByXPath("//android.widget.TextView[@text='资讯']").click();
		Thread.sleep(2000);
		String expected4="com.gf.mobile.reactnative.RNInformationActivity";
		String actual4=androidDriver.currentActivity();
		Assert.assertEquals(actual4, expected4);
		
	}
	
		
		
		@AfterTest
		public void tearDown()
		{
			//当测试用例运行完毕，我们销毁驱动
			androidDriver.quit();
		}
		
	

}
