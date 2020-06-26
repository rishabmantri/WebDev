note: Delete in oscars does not work properly and put in oscars also creates a new object instead of updating it. 

run command mvn package
deploy the jar using 
java -jar restapilab-0.0.1-SNAPSHOT.jar

you can run the remaining on postman

create director
(post) http://localhost:8080/api/v1/directors/
{
	"name": "rishab",
	"birthDate": "1973-01-01T00:00:00.000+0000",
	"lastname": "mantri"
}


create movie
(post) http://localhost:8080/api/v1/movies/

{
	"title": "Batman",
	"year": "2015",
	"plot": "my",
	"genres": "thriller"
}


create movie with director
(post) http://localhost:8080/api/v1/movies/
{
	"title": "nba",
	"year": "1995",
	"plot": "my",
	"genres": "unknown",
	"directors":[
		{
	"name": "rishab",
	"birthDate": "1973-01-01T00:00:00.000+0000",
	"lastname": "mantri"
}
		]
}

link the oscar to any movie
(post) http://localhost:8080/api/v1/movies/{movieid}/oscars/
{
	"year":2015,
	"category":"best movie",
	"genres":"thriller"
}


(get) http://localhost:8080/api/v1/movies/{movieid}/oscars/{oscarid}
will get oscars for movie with movie id and oscarid given

(get) http://localhost:8080/api/v1/movies/{movieid}/oscars/
will get all oscars for movie with movie id

(get) http://localhost:8080/api/v1/movies/
gets all movies

(get) http://localhost:8080/api/v1/movies/{movieid}
get movie with movie id

(get) http://localhost:8080/api/v1/directors/{id}
get director with id

(get) http://localhost:8080/api/v1/directors/
get all directors

(put) http://localhost:8080/api/v1/directors/{id}
{
	"name": "virat",
	"birthDate": "1973-01-01T00:00:00.000+0000",
	"lastname": "kholi"
}

(delete) http://localhost:8080/api/v1/movies/{id}

(delete) http://localhost:8080/api/v1/directors/{id}

(put) http://localhost:8080/api/v1/movies/
{
	"title": "batman",
	"year": "1995",
	"plot": "my",
	"genres": "unknown",
	"directors":[
		{
	"name": "r",
	"birthDate": "1973-01-01T00:00:00.000+0000",
	"lastname": "m"
}
		]
}

edit oscar details (does not work properly)
(put) http://localhost:8080/api/v1/movies/{movieid}/oscars/
{
	"year":2015,
	"category":"best movie",
	"genres":"thriller"
}

(delete) http://localhost:8080/api/v1/movies/{movieid}/oscars/{oscarid}
this does not work properly. deletes a lot of things.



