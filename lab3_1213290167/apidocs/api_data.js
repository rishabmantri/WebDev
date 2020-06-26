define({ "api": [  {    "type": "get",    "url": "PhoneBook/{PhoneBook}",    "title": "Get PhoneBook by ID",    "name": "getPhoneBook",    "group": "PhoneBook",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": "HTTP/1.1 200 OK\n[{\n\t\"PhoneNumber\": \"123\",\n\t\"firstName\": \"Ariel\",\n\t\"lastName\": \"Denham\"\n\t\"PhoneBook\": \"A\",\n}\n {\n\t\"PhoneNumber\": \"324\",\n\t\"firstName\": \"Raam\",\n\t\"lastName\": \"Dan\"\n\t\"PhoneBook\": \"A\",\n}]",          "type": "json"        },        {          "title": "Error-Response:",          "content": "\tHTTP/1.1 404 NOT FOUND\n{\n\t \"Message\" : Sorry! PhoneBook  not present!\n}",          "type": "json"        }      ]    },    "error": {      "examples": [        {          "title": "Error-Response:",          "content": " HTTP/1.1 400 BAD REQUEST\n\t{\n\t\t\"Error\": \"Provide valid input!\"\n\t}",          "type": "json"        },        {          "title": "Error-Response:",          "content": " HTTP/1.1 500 SERVER ERROR\n\t{\n\t\t\"Error\": \"Internal Server Error.\"\n\t}",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneBookResource.java",    "groupTitle": "PhoneBook"  },  {    "type": "get",    "url": "PhoneBook?phonebook={phonebook}&fname={fname}&lname={lname}",    "title": "Get phoneEntry by phonebook and( fname or lname)",    "name": "getPhoneBookSearchEntries",    "group": "PhoneBook",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": "HTTP/1.1 200 OK\n[{\n\t\"PhoneNumber\": 1111,\n\t\"firstName\": \"Ariel\",\n\t\"lastName\": \"Denham\",\n\t\"Phonebook\": \"A\"\n}]",          "type": "json"        },        {          "title": "Error-Response:",          "content": "\tHTTP/1.1 404 NOT FOUND\n{\n\t \"Message\" : Sorry! Phonebook not present!\n}",          "type": "json"        }      ]    },    "error": {      "examples": [        {          "title": "Error-Response:",          "content": " HTTP/1.1 400 BAD REQUEST\n\t{\n\t\t\"Error\": \"Provide valid input!\"\n\t}",          "type": "json"        },        {          "title": "Error-Response:",          "content": " HTTP/1.1 500 SERVER ERROR\n\t{\n\t\t\"Error\": \"Internal Server Error.\"\n\t}",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneBookResource.java",    "groupTitle": "PhoneBook"  },  {    "type": "put",    "url": "PhoneBook/",    "title": "Update an PhoneBook",    "name": "updatePhoneBook",    "group": "PhoneBook",    "description": "<p>PhoneBook can be updated by passing application/json payload(in the body). Text to be sent is of the format: { &quot;PhoneNumber&quot;: id, &quot;PhoneBook&quot;: PhoneBookInStringFormat }</p>",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": " HTTP/1.1 200 OK\n{\n\t\t\"phoneNumber\": 1234,\n\t\t\"PhoneBook\": \"B\"\n}",          "type": "json"        }      ]    },    "error": {      "examples": [        {          "title": "Error-Response:",          "content": " HTTP/1.1 404 NOT FOUND\n\t{\n\t\t\"message\" : \"No such PhoneEntry {PhoneNumber}.\"\n\t}",          "type": "json"        },        {          "title": "Error-Response:",          "content": " HTTP/1.1 500 SERVER ERROR\n\t{\n\t\t\"message\" : \"Internal server error deserializing PhoneBook JSON\"\n\t}",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneBookResource.java",    "groupTitle": "PhoneBook"  },  {    "type": "post",    "url": "PhoneEntry/",    "title": "Create a PhoneEntry",    "name": "createPhoneEntry",    "group": "PhoneEntry",    "description": "<p>PhoneEntry can be created by passing plain/text payload(in the body). Text to be sent is of the format Phone_Number first_name last_name</p>",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": "HTTP/1.1 201 CREATED\n\t[{ \"PhoneEntry\": \"3001723765\" }]",          "type": "json"        }      ]    },    "error": {      "examples": [        {          "title": "Error-Response:",          "content": " HTTP/1.1 400 BAD REQUEST\n\t{\n\t\t\"PROVIDE VALID INPUT!\"\n\t}",          "type": "json"        },        {          "title": "Error-Response:",          "content": " HTTP/1.1 500 SERVER ERROR\n\t{\n\t\t\"EXCEPTION INSERTING INTO DATABASE!\"\n\t}",          "type": "json"        },        {          "title": "Error-Response:",          "content": " HTTP/1.1 500 SERVER ERROR\n\t{\n\t\t\"ERROR INSERTING INTO DATABASE!\"\n\t}",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneEntryResource.java",    "groupTitle": "PhoneEntry"  },  {    "type": "delete",    "url": "PhoneEntry?no={enter_no_here}",    "title": "Delete a PhoneEntry",    "name": "deletePhoneEntry",    "group": "PhoneEntry",    "description": "<p>PhoneEntry can be deleted by passing PhoneNumber as a query parameter as shown: path-to-booktownrest-api.com/PhoneEntry?PhoneNumber={PhoneNumber}</p>",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": "HTTP/1.1 204 NO CONTENT",          "type": "json"        }      ]    },    "error": {      "examples": [        {          "title": "Error-Response:",          "content": "HTTP/1.1 404 NOT FOUND\n{ \"message\" : \"No such PhoneEntry {PhoneNumber}\"}",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneEntryResource.java",    "groupTitle": "PhoneEntry"  },  {    "type": "get",    "url": "PhoneEntry",    "title": "unlisted PhoneEntries",    "name": "getPhoneBooknullEntries",    "group": "PhoneEntry",    "description": "<p>Gets PhoneEntry which are unlisted in any phonebook</p>",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": "\tHTTP/1.1 200 OK\n\t[\n  {\"PhoneNumber\":1111,\"firstName\":\"Robin\",\"lastName\":\"Batman\"},\n  {\"PhoneNumber\":1212,\"firstName\":\"John\",\"lastName\":\"Snow\"}\n ]",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneEntryResource.java",    "groupTitle": "PhoneEntry",    "error": {      "fields": {        "Error 4xx": [          {            "group": "Error 4xx",            "type": "400",            "optional": false,            "field": "BadRequest",            "description": "<p>Bad Request Encountered</p>"          }        ],        "Error 5xx": [          {            "group": "Error 5xx",            "type": "500",            "optional": false,            "field": "InternalServerError",            "description": "<p>Something went wrong at server, Please contact the administrator!</p>"          }        ]      }    }  },  {    "type": "get",    "url": "PhoneEntry/{PhoneNumber}",    "title": "Get PhoneEntry by PhoneNumber",    "name": "getPhoneEntry",    "group": "PhoneEntry",    "description": "<p>Gets PhoneEntry which has the given PhoneNumber</p>",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": "HTTP/1.1 200 OK\n[{\n\t\"Phonenumber\": 1111,\n\t\"firstName\": \"Ariel\",\n\t\"lastName\": \"Denham\"\n}]",          "type": "json"        },        {          "title": "Error-Response:",          "content": "\tHTTP/1.1 404 NOT FOUND\n{\n\t \"Message\" : Sorry! PhoneNumber not present!\n}",          "type": "json"        }      ]    },    "error": {      "examples": [        {          "title": "Error-Response:",          "content": " HTTP/1.1 400 BAD REQUEST\n\t{\n\t\t\"Error\": \"Provide valid input!\"\n\t}",          "type": "json"        },        {          "title": "Error-Response:",          "content": " HTTP/1.1 500 SERVER ERROR\n\t{\n\t\t\"Error\": \"Internal Server Error.\"\n\t}",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneEntryResource.java",    "groupTitle": "PhoneEntry"  },  {    "type": "put",    "url": "PhoneEntry/",    "title": "Update an PhoneEntry",    "name": "updatePhoneEntry",    "group": "PhoneEntry",    "description": "<p>PhoneEntry can be updated by passing application/json payload(in the body). Text to be sent is of the format: { &quot;PhoneNumber&quot;: id, &quot;fName&quot;: firstNameInStringFormat, &quot;lName&quot;: lastNameInStringformat }</p>",    "success": {      "examples": [        {          "title": "Success-Response:",          "content": " HTTP/1.1 200 OK\n{\n\t\"PhoneNumber\": 56498,\n\t\"fName\": \"Rahul\",\n\t\"lName\": \"Rathi\"\"\n}",          "type": "json"        }      ]    },    "error": {      "examples": [        {          "title": "Error-Response:",          "content": " HTTP/1.1 404 NOT FOUND\n\t{\n\t\t\"message\" : \"No such PhoneEntry {PhoneNumber}.\"\n\t}",          "type": "json"        },        {          "title": "Error-Response:",          "content": " HTTP/1.1 500 SERVER ERROR\n\t{\n\t\t\"message\" : \"Internal server error deserializing PhoneEntry JSON\"\n\t}",          "type": "json"        }      ]    },    "version": "0.0.0",    "filename": "src/edu/asupoly/ser422/restexample/api/PhoneEntryResource.java",    "groupTitle": "PhoneEntry"  }] });
