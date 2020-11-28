import java.time.LocalDate;

public class Delivery {

    private LocalDate dateInitial = LocalDate.of(2020, 11, 01);
    private LocalDate dateFinish = LocalDate.of(2020, 11, 30);;
    private int breakfastStock = 50;
    private int lunchStock = 25;
    private int dinnerStock = 20;

    public boolean stockVerify(DeliveryItem item, int quantity)
    {
        boolean stock = false;

        switch (item)
        {
            case Breakfast:
                if (quantity >= 5 && quantity < breakfastStock)
                    stock = true;
                break;
            case Lunch:
                if (quantity >= 2 && quantity < lunchStock)
                    stock = true;
                break;
            case Dinner:
                if (quantity >= 2 && quantity < dinnerStock)
                    stock = true;
                break;
            default:
                    stock = false;
                break;
        }

        return stock;
    }

    public boolean validateDate(LocalDate dateDelivery)
    {
        if (dateDelivery.isAfter(dateInitial) && dateDelivery.isBefore(dateFinish))
            return true;
        else
            return false;
    }

    public String registerDelivery(DeliveryItem item, int quantity, LocalDate date)
    {
        boolean dateValidated = validateDate(date);

        if (!dateValidated )
            return "Delivery not allowed for this date";

        boolean stockExisting = stockVerify(item, quantity);

        if( !stockExisting) {
            return "Not Existing this item in stock";
        }

        return "Delivery registred";
    }
}

enum DeliveryItem {
    Breakfast,
    Lunch,
    Dinner,
    Other
}

