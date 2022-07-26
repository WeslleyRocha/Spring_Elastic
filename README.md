# Spring ElasticSearch
API de estudo Bootcamp Meli, consumindo bando de dados noSQL ElasticSearch.


- **Endpoints**

**GET** (ID)<br>
```
curl --location --request GET 'localhost:8080/article/{id}'
```
<br><br>

**POST**
```
curl --location --request POST 'localhost:8080/article' \
--header 'Content-Type: application/json' \
--data-raw '{
     "id": 2,
    "title": "Programando em Java - Spring Elastic",
    "authors":
    [
        {
        "id": 1,
        "name":"Wes"
        }
    ]
}'
```
<br><br>

**PUT**
```
curl --location --request PUT 'localhost:8080/article/{id}' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 3,
    "title": "Programando em UPDATE",
    "authors": [
        {
            "id": 22,
            "name": "WES ROCHA"
        }
    ]
}'
```
<br><br>

**GET (All)**
```
curl --location --request GET 'localhost:8080/article'
```
<br><br>

**GET (byTitle)**
```
curl --location --request GET 'localhost:8080/article/title/{title}'
```
<br><br>

**DELETE (ID)**
```
curl --location --request DELETE 'localhost:8080/article/{id}'
```
<br><br>

**DELETE (ID V1)**
```
curl --location --request DELETE 'localhost:8080/article/v1/{id}'
```
