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
		//1、创建配置对象
				DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
				//2、添加配置
				//deviceName：可以找到我们测试的设备，即安卓虚拟器
				desiredCapabilities.setCapability("deviceName", "Honor 10");
				//platformName：测试平台Android or IOS
				desiredCapabilities.setCapability("platformName", "Android");
				desiredCapabilities.setCapability("platformVersion", "9.0.1");
				//appPackage：找到要测试的app
				desiredCapabilities.setCapability("appPackage", "com.gf.client");
				//automationName:uiautomator2来解决输入框输入不了的问题
				//自动化引擎
				desiredCapabilities.setCapability("automationName", "uiautomator2");
				//appActivity：测试App启动入口
				desiredCapabilities.setCapability("appActivity", "com.gf.mobile.control.LauncherActivity");
				
				//3、创建驱动
				//传入两个参数
				//第一个参数：Appium通讯地址
				//第二个参数：配置对象
				androidDriver=new AndroidDriver<WebElement>(new URL("http:/127.0.0.1:4723/wd/hub"),desiredCapabilities);
	}
	
	
	
		@Test
		public void testyijinbao() throws InterruptedException
		{
			//等待元素加载完毕
			Thread.sleep(2000);
			//进入app后初始化的一些步骤
			androidDriver.findElementById("android:id/button1").click();
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/btn_next_page").click();
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/btn_begin").click();
			
			//任务2
			Thread.sleep(2000);
			//1、找到定位行情文本，并且点击
			androidDriver.findElementById("com.gf.client:id/radio_quote").click();
			//2、找到定位添加自选股文本，并且点击
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/addButton").click();
			//3、找到代码输入框，并且输入600000
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/secu_code_input").sendKeys("600000");
			//4、找到搜索结果中的600000浦发银行，并且点击+，表示把该结果添加进去
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/favstock_judge").click();
			//获取Toast信息添加自选成功
			WebElement toastElement5=androidDriver.findElementByXPath("//*[contains(@text,'添加自选成功')]");
			System.out.print(toastElement5.getText());
			//断言
			Thread.sleep(2000);
			String expected5="添加自选成功";
			String actual5=toastElement5.getText();
			Assert.assertEquals(actual5, expected5);
			
			//5、添加600000浦发银行后，点击取消，返回上一个界面
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/cancel_btn").click();
			//6、这里需要验证一下，断言，通过类名来进行断言
			Thread.sleep(2000);
			String expected1="com.gf.mobile.module.home.HomeActivity";
			String actual1=androidDriver.currentActivity();
			//String actual=androidDriver.getClass();
			Assert.assertEquals(actual1, expected1);
			
			
			//7、点击编辑
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/btn_right_two").click();
			//8、勾选600000浦发银行前面的小框，选中600000浦发银行
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/selectBox").click();
			//9、选择删除
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/deleteButton").click();
			//10、确认删除
			Thread.sleep(2000);
			androidDriver.findElementById("com.gf.client:id/md_buttonDefaultPositive").click();
			//获取Toast信息删除成功
			WebElement toastElement6=androidDriver.findElementByXPath("//*[contains(@text,'删除成功')]");
			System.out.print(toastElement6.getText());
			//断言
			Thread.sleep(2000);
			String expected6="删除成功";
			String actual6=toastElement6.getText();
			Assert.assertEquals(actual6, expected6);
			

			Thread.sleep(2000);
			androidDriver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
			
			
			//12、这里需要验证一下
			Thread.sleep(2000);
			String expected2="com.gf.mobile.module.home.HomeActivity";
			String actual2=androidDriver.currentActivity();
			Assert.assertEquals(actual2, expected2);
			//////////////////////////////////////////
			Thread.sleep(2000);
			//进入到发现
			androidDriver.findElementById("com.gf.client:id/radio_chest").click();
			
			//去掉广告弹窗
			Thread.sleep(2000);
			TouchAction touchAction2=new TouchAction(androidDriver);
			PointOption pointOption=PointOption.point(540, 1650);
			touchAction2.press(pointOption).release();
			touchAction2.perform();
			
			//左右滑动
			TouchAction touchAction1=new TouchAction(androidDriver);
			//把原始坐标转换成PointOption类型
			PointOption startPointOption1=PointOption.point(700, 723);
			PointOption endPointOption1=PointOption.point(10, 723);
			//把原始时间转换成Duration类型
			Duration duration1=Duration.ofMillis(800);
			//Duration类型再转换成WaitOptions类型
			WaitOptions waitOptions1=WaitOptions.waitOptions(duration1);
			Thread.sleep(2000);
			touchAction1.press(startPointOption1).waitAction(waitOptions1).moveTo(endPointOption1).release();
			//让滑动生效
			Thread.sleep(2000);
			touchAction1.perform();
			Thread.sleep(5000);
			
			touchAction1.press(endPointOption1).waitAction(waitOptions1).moveTo(startPointOption1).release();
			//让滑动生效
			Thread.sleep(2000);
			touchAction1.perform();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			androidDriver.findElementByXPath("//android.widget.TextView[@text='资讯']").click();
			Thread.sleep(5000);
			String expected4="com.gf.mobile.reactnative.RNInformationActivity";
			String actual4=androidDriver.currentActivity();
			Assert.assertEquals(actual4, expected4);
			Thread.sleep(2000);
			
			
		}
		
		@AfterTest
		public void tearDown()
		{
			//当测试用例运行完毕，我们销毁驱动
			androidDriver.quit();
		}
		
	

}
