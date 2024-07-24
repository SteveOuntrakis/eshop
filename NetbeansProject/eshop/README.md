Welcome to my TravelCompany project. 

------------------------------------------
Model-Enums
------------------------------------------
First of all , The project has 4 class and 3 enum files.

Basic features:
1. Customer, Itinerary and OrderedTicket classes.
2. AirportCode,CustomerCategory and PaymentMethod enums, which are use from our classes.

Added features:
1. A class named PurchasingTimestamp. Here we insert the customer Id , the itinerary Id, 
    the departure date and the purchasing date and we save them into a file. now we have track of all the purchases.
2. Ticket count on the Itinerary model class. Now we can track how many seats we have available. (If the seats drop to 0 we have a related message).


-----------------------
Data
-----------------------
As an addional feature, All the given data are saved in CSV files. So the :
1. List of Customers is saved to customers.txt.
2. List of Itinerary is saved to itinerary.txt
3. List of OrderedTickets is saved to orderedTickets.txt and 
4. List of purchasingTimestamp is saved to purchasingTimestamp.txt.

Features we may notice are:
1. All of the lists can not ovewritten if the .txt file exists. If we wanna re-use 
    the classes( and start again to our initial tables ) we need to delete the files first.
2. As told , a case where the itinerary doesnt exist when added to the OrderedTicket 
    is being added. When the programm reaches that case, it sends us an error message and then continues with the rest of the data.


-----------------------
Util
-----------------------
Added Features:
There are 3 classes here helping in the program. 
1. Finals : It only has some final Strings in order to keep the code clean from the dublicate Strings.
2. DataManagement: Here all of the work of retrieving and saving data occurs. 
    Generics were used in order to avoid dublicate code for every model class. 
3. Parser : Its only purpuse is to help the DataManagement choose the correct method for parsing data.
    Couldn't avoid calling different methods for parsing data ( they all have different types and numbers),
    but we can manage them more efficient with the Parser.


-----------------------
Services
-----------------------
There are 2 classes:
1. TravelCompanyService. The main class calls directly this service class where 
    the choice is given to us to either 
        a)see the results of the questions in 6.Reporting or 
        b)go to the e-shop.
2. ReportingService. Here we answer all the questions from the .pdf 6.Reporting.
    The answers will be modified based of adding new users or purchasing new tickets.



-----------------------
UI
-----------------------
Here is the Main code for the Eshop.
if the user selects the 2nd option from the Travel company then we open the eshop.
1) Firstly the WelcomeScreen.java is activated. Here the user has the choice to 
    a)validate ( through email) or 
    b)create a new Customer. Note: the CustomerCategory is always Individual, maybe 
        upgrading to business after reaching a goal? ( thought for the future, no further actions ocuured about that)
Of course if a new user is created, it will be saved in the .txt file.
2) Secondly we go to the DestinationChoosing. Now the customer may choose from a list of destinations. 
    Adding new itinerary is not allowed, because this is a work for the admin only. 
    If a destination has more that one itinerary then the programm will give the 
    customer a choice of which itinerary is more suitable for him.
3) Then the CostBreakdown.java is activated. Here the programm sees in which Category 
    our customer is and after giving him the choice of paying with Card/Cash, it returns the final Price back to the customer. 
    Here our work is done.
4) Finally the OrderingTicket.java class was created for additional features. 
    Here we may retrieve the purchasing Timestamp of the ticket and of course update our orderedTickets list.

-----------------------
Exceptions
-----------------------
Here we created some an ExceptionHandler in order to customly handle some Exceptions 
as asked in the .pdf sector 5. Exception handling.

Each exception has a separate class and it was created exactly as shown in the class 
from Mr Efremidis in the WaterTooHot example.

1) InvalidEmailException is being found in the WelcomeScreen class, when we try to create a new customer.
2) Customer not Found and Itinerary not found are being used in the OrderedTicketsImportData.
3) The AirportCodeException is located in the ItineraryImportData.