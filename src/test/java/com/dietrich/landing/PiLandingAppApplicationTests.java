//package com.dietrich.landing;
//
//import static org.hamcrest.CoreMatchers.any;
//import static org.mockito.Mockito.doNothing;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.dietrich.landing.controller.PiLandingController;
//import com.dietrich.landing.entity.LedEntity;
//import com.dietrich.landing.svc.PiTempCollectorSvc;
//
//@SpringBootTest
//class PiLandingAppApplicationTests {
//
//	@Mock
//	private PiTempCollectorSvc tempCollector;
//	
//	@InjectMocks
//	private PiLandingController classUnderTest;
//	
//	@Test
//	void contextLoads() {
//		doNothing().when(tempCollector).insertDate(Mockito.any(), Mockito.any());
//		classUnderTest.db();
//	}
//
//}
