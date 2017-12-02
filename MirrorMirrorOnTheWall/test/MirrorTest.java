import WeatherWidget.WeatherWidget;
import newswidget.NewsWidget;
import trafficwidget.TrafficWidget;
import clockwidget.ClockWidget;
import MirrorMirrorOnTheWall.mirror;
import cs505.group1.state.ButtonState;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;

/**
* @author Emily Park
*/
public class MirrorTest{

 public MirrorTest(){}

 @Before
 public void resetSingleton(){
  Mirror.resetSingleton();
 }
 
 @Test
 public void testAddNull(){
  System.out.println("Add Null Widget");
  Mirror instance = Mirror.getInstance();
  WeatherWidget one = NULL;
  instance.AddWidget(one);
  assertEquals(instance.GetWidget(0), NULL);
 }
@Test
 public void testAddOne(){
  System.out.println("Add One Widget");
  Mirror instance = Mirror.getInstance();
  WeatherWidget one = WeatherWidget.getInstance();
  instance.AddWidget(one);
  assertEquals(instance.GetWidget(0), one);
  instance.RemoveWidget(one);
  assertEquals(instance.GetWidget(0), NULL);
 }
@Test
 public void testAddTwo(){
  System.out.println("Add Two Widgets");
  Mirror instance = Mirror.getInstance();
  WeatherWidget one = WeatherWidget.getInstance();
  TrafficWidget two = TrafficWidget.getInstance();
  instance.AddWidget(one);
  instance.AddWidget(two);
  assertEquals(instance.GetWidget(1), two);
  instance.RemoveWidget(two);
  assertEquals(instance.GetWidget(1), NULL);
 }
@Test
 public void testAddThree(){
  System.out.println("Add Three Widgets");
  Mirror instance = Mirror.getInstance();
  WeatherWidget one = WeatherWidget.getInstance();
  TrafficWidget two = TrafficWidget.getInstance();
  NewsWidget three = NewsWidget.getInstance();
  instance.AddWidget(one);
  instance.AddWidget(two);
  instance.AddWidget(three);
  assertEquals(instance.GetWidget(2), three);
  instance.RemoveWidget(three);
  assertEquals(instance.GetWidget(2), three);
  instance.RemoveWidget(two);
  assertEquals(instance.GetWidget(1), two);
 }
}