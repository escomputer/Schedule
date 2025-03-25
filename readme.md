API명세서
----

1. 새로운 일정 생성
   1. 메서드 - POST
   2. URL - /schedules
   3. 요청 방식  - @RequestBody
   4. 요청 예시 -
      POST /schedules HTTP/1.1
      Content-Type: application/json
      <br>```
      {
"task": "일정1",
"author": "스파르타",
"password": "1234"
}```

   5. 응답 예시 - HTTP/1.1 201 Created
      Content-Type: application/json<br>
      ```
      {"id": 1,
      "task": "일정1",
      "author": "스파르타",
      "created_at": "2025-03-25T10:00:00",
      "updated_at": "2025-03-25T10:00:00"
      }
      ```

    
2. 전체 일정 조회
    1. 메서드 - GET
    2. URL - /schedules
    3. 요청 방식  - @RequestParam
    4. 요청 예시 -
      POST /schedules HTTP/1.1
      Content-Type: application/json
      <br>```
      {
"task": "일정1",
"author": "스파르타",
"password": "1234"
}```

   5. 응답 예시 - HTTP/1.1 201 Created
      Content-Type: application/json<br>
      ```
      {"id": 1,
      "task": "일정1",
      "author": "스파르타",
      "created_at": "2025-03-25T10:00:00",
      "updated_at": "2025-03-25T10:00:00"
      }
      ```
      
3. 선택 일정 조회
   1. 메서드 - POST
    2. URL - /schedules
    3. 요청 방식  - @RequestBody
   4. 요청 예시 -
      POST /schedules HTTP/1.1
      Content-Type: application/json
      <br>```
      {
"task": "일정1",
"author": "스파르타",
"password": "1234"
}```

   5. 응답 예시 - HTTP/1.1 201 Created
      Content-Type: application/json<br>
      ```
      {"id": 1,
      "task": "일정1",
      "author": "스파르타",
      "created_at": "2025-03-25T10:00:00",
      "updated_at": "2025-03-25T10:00:00"
      }
      ```

4. 선택 일정 수정
    1. 1. 메서드 - POST
    2. URL - /schedules
    3. 요청 방식  - @RequestBody
   4. 요청 예시 -
      POST /schedules HTTP/1.1
      Content-Type: application/json
      <br>```
      {
"task": "일정1",
"author": "스파르타",
"password": "1234"
}```

   5. 응답 예시 - HTTP/1.1 201 Created
      Content-Type: application/json<br>
      ```
      {"id": 1,
      "task": "일정1",
      "author": "스파르타",
      "created_at": "2025-03-25T10:00:00",
      "updated_at": "2025-03-25T10:00:00"
      }
      ```
      
5. 선택 일정 삭제
   1. 1. 메서드 - POST
   2. URL - /schedules
   3. 요청 방식  - @RequestBody
     4. 요청 예시 -
      POST /schedules HTTP/1.1
      Content-Type: application/json
      <br>```
      {
"task": "일정1",
"author": "스파르타",
"password": "1234"
}```

      5. 응답 예시 - HTTP/1.1 201 Created
      Content-Type: application/json<br>
      ```
      {"id": 1,
      "task": "일정1",
      "author": "스파르타",
      "created_at": "2025-03-25T10:00:00",
      "updated_at": "2025-03-25T10:00:00"
      }
      ```
      

ERD 
----
![img.png](readme_file/img.png)
