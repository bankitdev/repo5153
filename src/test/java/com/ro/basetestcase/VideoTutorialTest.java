/**
 * 
 */
package com.ro.basetestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.Base.VideoTutorials;

/**
 * @author Sunil Kashyap
 *
 * Created Date 04-Feb-2019
 */
public class VideoTutorialTest extends LoginPage
{	
	@Test
	public VideoTutorialTest() 
	{
		VideoTutorials videoTutorials= PageFactory.initElements(driver, VideoTutorials.class);
		videoTutorials.videoTutorial();
	}
}
