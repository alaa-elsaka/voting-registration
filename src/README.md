VOTING REGISTRATION APP

As a User WHEN I want to register to vote THEN my information
is added to the voter roll.
--------------------------------------------------------
As a User WHEN I a person with my Social Security Number is already registered THEN
I should be told "That Voter Is Already Registered, Please Contact
Admin To Update Information If Needed"
-------------------------------------------------------

As a Admin WHEN I search by Social Security Number THEN I retrieve all 
profiles for the user with that number, and see their Full Name, Address,
Social Security Number.
-------------------------------------------------------

As a Admin WHEN I edit OR delete a User Profile THEN I find 
the profile matching that
User with a expirationTimestamp of null, 
and set that field to the current timestamp.
-------------------------------------------------------



As a Admin WHEN I get all users THEN I see a list of
all User Profiles with a null
expirationTimestamp
--------------------------------------------------------

As a Admin WHEN I edit an address on a User Profile THEN I add
a new profile with the updated
Information and a null expirationTimestamp to
the list of registered voters.

As a User WHEN I search by my Social Security Number THEN I retrieve only the User Profile
with a null expirationTimestamp matching my SSN.
