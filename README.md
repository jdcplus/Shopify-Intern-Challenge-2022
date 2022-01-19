# Shopify-Backend-Intern-Challenge-2022

## Instruction to run the code

### Prequisites
- Get Maven (Refer download and installtion docs given [here](https://maven.apache.org/))
- Get Java 8 or Latest (LTS), instruction can be found [here](https://adoptopenjdk.net/)
- Get MySQL database, instruction can be found [here](https://dev.mysql.com/downloads/) based on your operating system

### Using IDE (Spring Tool Suit)
- Clone the project and open it's root directory in Spring Tool Suit (STS)
- Update the maven dependencies (Right click on project name -> Maven -> Update Project)
- Perform cleanup (Right click on project name -> Run as -> Maven Clean)
- Perform build (Right click on project name -> Run as -> Maven Install) 
- Run the app (Right click on project name -> Run as -> Spring boot app)
- Done, Now application is running on port 8001, You can make HTTP request using Postman or Using CURL

### Using Command line
### Steps
- Clone the project and navigate to it's classpath directory (/InverntoryManagement)
- Open cmd in the given directory and run the following command
```sh
 mvn clean install
 ```
- Once build is successfully run the following command
```sh
 mvn spring-boot:run
 ```
- Done, Now application is running on port 8001, now you can make Http request using POSTMAN or CURL


# API Documentation
# Basic CRUD functionality
# 1. Add Item in Invetory
Add item in the inventory

**URL** : `/create/`

**Method** : `POST`

**Data constraints**

Provide name of Item to be created.
```json
{
    "name": "[unicode 50 chars max]"
}
```
## Success Response
**Condition** : If everything is OK and Item has been given with atleast name as attribute
**Code** : `201 CREATED`
**Content example**
```json
{
    "name": "samsung note 9",
    "description": "old phone with old price",
    "price": 365.96,
    "location": "Kitchner, ON, CA"
}
```
**Output example**
```json
{
    "id": 16,
    "name": "samsung note 9",
    "description": "old phone with old price",
    "price": 365.96,
    "location": "Kitchner, ON, CA",
    "createdAt": "2022-01-19T19:10:00",
    "modifyAt": "2022-01-19T19:10:00"
}
```
## Error Responses
**Condition** : If name is missing or given as blank.
**Code** : `400 BAD REQUEST`
**ErrorMessage** : `Item name is required to add into Inventory.`
**Content example**
```json
{
	"name": "     "
}
```
# 2. View list of items in inventory
Display all items in the inventory
**URL** : `/all/`
**Method** : `GET`
## Success Response
**Code** : `200 OK`
**Output example**
```json
[
    {
        "id": 14,
        "name": "iphone 13 pro max",
        "description": "big phone with big price",
        "price": 1750.65,
        "location": "Waterloo, ON, CA",
        "createdAt": "2021-01-11T11:11:00",
        "modifyAt": "2021-01-12T05:05:00"
    },
    ....
```

# 3. Edit an item in Invetory
Edit an item in the inventory using item id
**URL** : `/edit/{item-id}`
**Method** : `POST`
**Data constraints**
Provide id of Item to be edited and proide the item with edited fields.
**Content example**
```json
{
	"name": "Samsung note 7",
	"description": "good mobile with bad battery",
	"price": "960.36",
	"location": "Toronto, ON"
}
```
## Success Response
**Code** : `200 OK`
**Output example**
```json
{
    "id": 16,
    "name": "Samsung note 7",
    "description": "good mobile with bad battery",
    "price": 960.36,
    "location": "Kitchner, ON, CA",
    "createdAt": "2022-01-14T10:10:00",
    "modifyAt": "2022-01-19T17:49:48.2135444"
}
```
## Error Responses
**Condition** : If Item id is invalid
**Code** : `400 BAD REQUEST`
**ErrorMessage** : `No item exists in the inventory with id {item-id}.`


# 4. Delete an item from the Invetory
Delete an item from the inventory using item id
**URL** : `/delete/{item-id}`
**Method** : `POST`
**Data constraints**
Provide id of Item to be deleted
**Output example**
```json
Item has been deleted
```
## Error Responses
**Condition** : If Item id is invalid
**Code** : `400 BAD REQUEST`
**ErrorMessage** : `No item exists in the inventory with id {item-id}.`

# Feature Choosen (Exporting Product data to a CSV file)
# 5. CSV export of entire inventory
Export all items from inventory as csv file
**URL** : `/export/csv`
**Method** : `GET`
