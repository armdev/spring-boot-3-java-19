# spring-boot-3-java-19
spring boot 3 integration with springdoc and postgres, Java 19

./run.sh

access: http://localhost:3025/swagger-ui.html



```shell

curl -X 'POST' \
  'http://localhost:3025/api/v2/events/create' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 0,
  "eventType": "YELLOW_EVENT",
  "event": "YELLOW_IN_PROGRESS",
  "recordDate": "2023-02-28T11:01:09.166Z"
}'
```


```shell

curl -X 'GET' \
  'http://localhost:3025/api/v2/events/show/count' \
  -H 'accept: */*'


ab -n 1000 -c 100 http://localhost:3025/api/v2/events/generate
```
