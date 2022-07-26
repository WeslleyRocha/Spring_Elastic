# Spring ElasticSearch
API de estudo, consumindo bando de dados noSQL ElasticSearch.


- **Endpoints**

**GET** (ID)<br>
```
curl --location --request GET 'localhost:8080/article/1'
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
