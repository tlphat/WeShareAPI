## API Documentation

Base URL: https://weshare-api.herokuapp.com/

### User

#### Create a new user

Return the JSON data of new user that has been created

- **URL**

  /users

- **Method**

  `POST`

- **URL Parameters**

  None

- **Data**

  ```json
  {
      "id": "Uxc523UY",
      "email": "sampleemail@domain.com"
  }
  ```

- **Success Response**

  Code: 200

  Content:

  ```json
  {
      "id": "Uxc523UY",
      "email": "sampleemail@domain.com",
      "displayName": null,
      "dob": null,
      "gender": null,
      "statusCode": 1,
      "deleted": false
  }
  ```



#### Retrieve user information

Return the JSON data of the user with specific ID

- **URL**

  /users/:id

- **Method**

  `GET`

- **URL Parameters**

  Required:

  `id = [string]`

- **Data**

  None

- **Success Response**

  Code: 200

  Content:

  ```json
  {
      "id": "Uxc523UY",
      "email": "sampleemail@domain.com",
      "displayName": null,
      "dob": null,
      "gender": null,
      "statusCode": 1,
      "deleted": false
  }
  ```

- **Error Response**

  Code: 404



#### Retrieve user with name

Return the JSON data of the user with specific display name

- **URL**

  /users/name/:name

- **Method**

  `GET`

- **URL Parameters**

  Required:

  `name = [string]`

- **Data**

  None

- **Success Response**

  Code: 200

  Content:

  ```json
  [
      {
          "id": "Uxc523UY",
          "email": "sampleemail@domain.com",
          "displayName": "John Tyson",
          "dob": null,
          "gender": null,
          "statusCode": 1,
          "deleted": false
      },
      {
          "id": "KTYweds233",
          "email": "sampleemailnow@domain.com",
          "displayName": "John Tyson",
          "dob": null,
          "gender": null,
          "statusCode": 1,
          "deleted": false
      }
  ]
  ```

#### Update user

Return the JSON data of the updated user

- **URL**

  /users/:id

- **Method**

  `PUT`

- **URL Parameters**

  Required:

  `id = [string]`

- **Data**

  ```json
  {
      "email": "sampleemail@domain.com",
      "displayName": "Berlin"
  }
  ```

- **Success Response**

  Code: 200

  Content:

  ```json
  {
      "id": "Uxc523UY",
      "email": "sampleemail@domain.com",
      "displayName": "Berlin",
      "dob": null,
      "gender": null,
      "statusCode": 1,
      "deleted": false
  }
  ```

#### Get friends

Retrieve list of users that have contact channel with the current user (represented by ID)

- **URL**

  /users/:id/friends

- **Method**

  `GET`

- **URL Parameters**

  Required:

  `id = [string]`

- **Data**

  None

- **Success Response**

  Code: 200

  Content:

  ```json
  [
      {
          "connectionID": 1,
          "user": {
              "id": "Uxc523UY",
              "email": "sampleemail@domain.com",
              "displayName": "John Tyson",
              "dob": null,
              "gender": null,
              "statusCode": 1,
              "deleted": false
          }
      },
      {
          "connectionID": 2,
          "user": {
              "id": "ZB89CCZ",
              "email": "sampleemail2@domain.com",
              "displayName": "Julia Smith",
              "dob": null,
              "gender": null,
              "statusCode": 1,
              "deleted": false
          }
      }
  ]
  ```

---

### Channel

#### Create a new channel

Return the JSON data of new channel that has been created

- **URL**

  /channels

- **Method**

  `POST`

- **URL Parameters**

  None

- **Data**

  ```json
  {
      "ownerId": "Uxc523UY",
      "personId": "ZB89CCZ"
  }
  ```

- **Success Response**

  Code: 200

  Content:

  ```json
  {
      "id": 1,
      "ownerID": "Uxc523UY",
      "personID": "ZB89CCZ"
  }
  ```