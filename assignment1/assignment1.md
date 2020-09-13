# 1. Design a course management system (Like Canvas);
*-Assignment*

	Data: dueTime, requirement, content
	Behaviors: 
*-Recording*

	Data: link
	Behaviors:
*-Instructor*

	Data: userName, passward
	Behaviors: login, startOnlineClass, teach, answerQuestion, endOnlineClass, uploadRecording,  
				makeAssignment, sendEmailsToStudent, giveGrade
*-Student*

	Data: userName, passward, Grades
	Behaviors: login, attendOnlinceClass, askQuestion, uploadAssignment, watchRecording
*-Course*

	Data: Instructor, Student, Assignment, Recording
	Behaviors: 	
	c++ `scanf()` is useful
## Sequence of invoking behaviors on objects:		
```
Student emma;
Instructor alice;
alice.login(userName, passward);
emma.login(userName, passward);
// instructor is going to start an online calss
alice.startOnlineClass();
emma.attendOnlinceClass();
alice.teach();
// student emma has a question
emma.askQuestion();
alice.answerQuestion();
alice.endOnlineClass();
// online class is over and instructor alice uploads recording
Recording firstRecording = new Recording(link);
alice.uploadRecording(firstRecording);	
if student emma is confused with some part of the lecture
	emma.watchRecording(firstRecording);
// instructor alice assigns assignment
Assignment firstAssignment = new Assignment(dueTime, requirement);
alice.makeAssignment(firstAssignment);
alice.sendEmailsToStudent('first assignemnt is assigned');
// student emma completes assignment
Assignment emmaFirstAssignment = Assignment(firstAssignment, content);
emma.uploadAssignment(emmaFirstAssignment);
// instructor give grade
alice.giveGrade(emma, emmaFirstAssignment);
```


# 2. Design a pet adoption platform 
*-Pet*

	Data: category, age, gender, healthyStatus, vaccineStatus, photo, PetCurrentOwner
	Behaviors:
*-PetCurrentOwner*

	Data: petOwnerCurrentPhone, petCurrentOwnerAddress
	Behaviors: putPetOnPlatform, reply, cancelAdoption
*-PotientialAdopter*

	Data: PotientialAdopterPhone, PotientialAdopterAddress
	Behaviors：search, contactPetCurrentOwner, adopt, cancelAdoption
## Sequence of invoking behaviors on objects:		
```
	PetCurrentOwner alice;
	PotientialAdopter emma;
	// PetCurrentOwner puts her pet on the platform
	Pet cat = alice.putPetOnPlatform(category, age, gender, healthyStatus, vaccineStatus, photo, PetCurrentOwner);
	// PotientialAdopter searches pet
	Pet searchPet = emma.search(category, age, gender, healthyStatus, vaccineStatus, photo, PetCurrentOwner);
	// if the pet emma search is the same one alice puts on the platform
	if searchPet == cat
		if emma scans photos of cat, find the cat is cute and want to adopt the cat
			emma.contactPetCurrentOwner(alice, alice.petOwnerCurrentPhone);
			if alice thinks emma would be a good adopter
				alice.reply('hello, cat's future adopter');
				// emma goes to alice's address to adopt cat
				emma.adopt(alice.petCurrentOwnerAddress);
				if emma does not want to keep the cat
					// emma goes to alice's address to return cat
					emma.cancelAdoption(cat, alice.petCurrentOwnerAddress);
				if alice does regrets to send the cat to emma
					// alice goes to emma's address to get back her cat
					alice.cancelAdoption(cat, emma.PotientialAdopterAddress);
			else
				alice.reply('sorry, maybe you could search another pet');
```

# 3. Design an app to book airline ticket 
*-Ticket*

	Data: time, departure, destination, SeatsAvailable
	Behaviors:
*-Customer*

	Data: userName, passward, customerPhone, creditCard
	Behaviors: login, search, buy, cancelOrder
*-OnlineApp*

	*Data: Ticket
	*Behaviors: checkOut, sendReceipt, informAirplaneCompany, refund, informAirplaneCompanyCancel
*-AirplaneCompany*

	Data: Ticket, flight
	Behaviors: addPassanger, deletePassanger
## Sequence of invoking behaviors on objects:	
```	
	Customer emma;
	OnlineApp bookingApp;
	emma.login(userName, passward);
	Ticket ticketToBoston = emma.search(time, departure, destination);
	if ticketToBoston.SeatsAvailable is more than 0
		emma.buy(ticketToBoston);
		ticketToBoston.SeatsAvailable - 1;
		bookingApp.checkOut(emma.customerPhone, emma.creditCard);
		bookingApp.sendReceipt(emma.customerAddress, emma.customerPhone);
		AirplaneCompany abcCompany;
		bookingApp.informAirplaneCompany(abcCompany, emma, ticketToBoston);
		abcCompany.addPassanger(emma);
		if emma changes her mind
			ticketToBoston.SeatsAvailable + 1;
			emma.cancelOrder(ticketToBoston)
			bookingApp.refund(ticketToBoston, emma);
			bookingApp.informAirplaneCompanyCancel(abcCompany, emma, ticketToBoston);
			abcCompany.deletePassanger(emma);
	else emma could not book the ticket beacause it soldOut
```

# 4. Design a course registration platform.
*-Student*	

	Data: userName, passward
	Behaviors: login, search, register, cancel
*-Course*

	Data: courseName, courseNumber, meetingTime, instructor, description, enrollmentSeatsAvailable
	Behaviors:
## Sequence of invoking behaviors on objects:	
```
	Student emma;
	emma.login(userName, passward);
	// emma could search course with courseName or courseNumber
	Course ApplicationEngineering = emma.search(courseNumber);
	if ApplicationEngineering's enrollmentSeatsAvailable is equal or more than 1
		emma.register(ApplicationEngineering);
		ApplicationEngineering.enrollmentSeatsAvailable - 1;
		if emma finds that the meetingTime is the same as her another course, she could not take both two courses
			emma.cancel(ApplicationEngineering)
			ApplicationEngineering.enrollmentSeatsAvailable + 1;
		if emma looks carefully at the course description and finds the course is too hard, then she wants to drop
			emma.cancel(ApplicationEngineering)
			ApplicationEngineering.enrollmentSeatsAvailable + 1;
	else
		emma cannot register ApplicationEngineering for it has no seat
```

# 5. Order food in a food delivery app.(Like Uber Eats)	
*-Food*

	Data: foodName, price, ingredients
	Behaviors:
*-OnlineRestaurant*

	Data: restaurantName, Food, restaurantPhone, restaurantBusinessHours		  
	Behaviors: addFood, responseToOrder, refund, callCourier
*-Customer*

	Data: userName, passward, customerAddress, customerPhone, creditCard
	Behaviors: login, search, buy, cancelOrder, writeReview
*-Courier*

	Data: courierName, courierPhone
	Behaviors: deliverFood, contactCustomer
## Sequence of invoking behaviors on objects:
```
	OnlineRestaurant coffeeShop;
    Customer emma;
	emma.login(userName, passward);
	if coffeeShop isInBusiness
		Food Cappuccino = coffeeShop.addFood(foodName, price, ingredients);		
		emma.search(Cappuccino);
		if Cappuccino isInStock
			emma.buy(Cappuccino);
			coffeeShop.responseToOrder(Cappuccino, emma.customerAddress, emma.customerPhone, emma.creditCard);
			if emma looks at Cappuccino.ingredients and finds the Cappuccino has milk but emma is allergic to milk
				emma.cancelOrder(Cappuccino);
				coffeeShop.refund(Cappuccino, emma);
			else
				Courier alice;
				coffeeShop.callCourier(alice.courierPhone, emma.customerAddress, emma.customerPhone);
				alice.deliverFood(Cappuccino, emma.customerAddress, emma.customerPhone);
				if alice knocks at emma's door but emma does not response
					alice.contactCustomer(emma.customerPhone);
				if emma is statisfied with the Food
					emma.writeReview("Cappuccino tastes good")
				else 
					emma.writeReview("Cappuccino tastes not good")
		else Cappuccino soldOut so emma could not order food
	else OnlineRestaurant outOfBusiness so emma could not order food
```