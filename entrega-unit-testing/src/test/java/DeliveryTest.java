import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;

import java.time.LocalDate;
import java.util.Date;


@RunWith(PowerMockRunner.class)
public class DeliveryTest {

    @Test
    public void validateStockBreakfastMinimum()
    {
    	
    	//arrange
    	boolean esperado = true; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Breakfast, 5);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    
    @Test
    public void validateStockBreakfastNotExpectedItem()
    {
    	
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Other, 5);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    
    @Test
    public void validateStockBreakfastMaximum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Breakfast, 50);

        //assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void validateStockBreakfastNotAllowMaximum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Breakfast, 51);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    @Test
    public void validateStockBreakfastNotAllowMinimum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Breakfast, 1);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    @Test
    public void validateStockLunchMinimum()
    {
    	//arrange
    	boolean esperado = true; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Lunch, 2);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    @Test
    public void validateStockLunchMaximum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Lunch, 25);

        //assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void validateStockLunchNotAllowMaximum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Lunch, 26);
        
        //assert
        Assert.assertEquals(esperado, atual);
    }
    @Test
    public void validateStockLunchNotAllowMinimum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Lunch, 1);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    @Test
    public void validateStockDinnerMinimum()
    {
    	//arrange
    	boolean esperado = true; 
    	boolean atual = false;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Dinner, 2);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    @Test
    public void validateStockDinnerMaximum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Dinner, 20);

        //assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void validateStockDinnerNotAllowMaximum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Dinner, 21);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    @Test
    public void validateStockDinnerNotAllowMinimum()
    {
    	//arrange
    	boolean esperado = false; 
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.stockVerify(DeliveryItem.Dinner, 1);

        //assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void validateDateNotAllowMinimum()
    {
    	//arrange
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.validateDate(LocalDate.of(2020,10,10));

        //assert
        Assert.assertFalse(atual);
    }

    @Test
    public void validateDateNotAllowMaximum()
    {
    	//arrange
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.validateDate(LocalDate.of(2021,12,10));

        //assert
        Assert.assertFalse(atual);
    }

    @Test
    public void validateDateAllowMinimum()
    {
    	//arrange
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.validateDate(LocalDate.of(2020,11,02));

        //assert
        Assert.assertTrue(atual);
    }

    @Test
    public void validateDateAllowMaximum()
    {
    	//arrange
    	boolean atual;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.validateDate(LocalDate.of(2020,11,29));

        //assert
        Assert.assertTrue(atual);
    }

    @Test
    public void validateDateAllow()
    {
    	//arrange
    	boolean atual = true;
    	
    	//act
        Delivery delivery = new Delivery();
        atual = delivery.validateDate(LocalDate.of(2020,11,6));

        //assert
        Assert.assertTrue(atual );
    }

    @Test
    public void registerDeliverySuccess() throws Exception {
        
    	//arrange     
    	Delivery deliver = new Delivery();
        String esperado = "Delivery registred";
        String atual;
        final String METHOD = "stockVerify";
        

        Delivery spy = PowerMockito.spy(deliver);
        PowerMockito.when(spy, METHOD, DeliveryItem.Breakfast, 10).thenReturn(true);
        
        //act
        atual = spy.registerDelivery(DeliveryItem.Breakfast, 10, LocalDate.of(2020, 11,25));

        //assert
        Assert.assertEquals(esperado,atual);

    }
    
    @Test
    public void deliverLowerThanMinDate() throws Exception {
        
    	//arrange     
        String esperado = "Delivery not allowed for this date";
        String atual;
        
        //act
        Delivery delivery = new Delivery();
        atual = delivery.registerDelivery(DeliveryItem.Breakfast, 10, LocalDate.of(2020, 10,31));

        //assert
        Assert.assertEquals(esperado,atual);

    }
    
    @Test
    public void deliverGreatThanMaxDate() throws Exception {
        
    	//arrange     
        String esperado = "Delivery not allowed for this date";
        String atual;
        
        //act
        Delivery delivery = new Delivery();
        atual = delivery.registerDelivery(DeliveryItem.Breakfast, 10, LocalDate.of(2020, 12, 01));

        //assert
        Assert.assertEquals(esperado,atual);

    }

    
    @Test
    public void registerDeliveryFailed() throws Exception {
        
    	//arrange     
    	Delivery deliver = new Delivery();
        String esperado = "Not Existing this item in stock";
        String atual;
        final String METHOD = "stockVerify";
        

        Delivery spy = PowerMockito.spy(deliver);
        PowerMockito.when(spy, METHOD, DeliveryItem.Breakfast, 1).thenReturn(false);
        
        //act
        atual = spy.registerDelivery(DeliveryItem.Breakfast, 1, LocalDate.of(2020, 11,25));

        //assert
        Assert.assertEquals(esperado,atual);
    }
    

}
