# Library management

Rejestracja  
POST /register  

```
{
  "username": "user",
  "password": "password"
}
```

Logowanie
/login

## Admin  
- przeglądanie książek /books, /books{book_id}

- usuwanie książek  
DELETE /books/{book_id}


- dodawanie książek  
POST /books/add

```
{
   "title": "Title",
    "author": "Author",
    "category": "Category",
    "bookState": "FREE"
}
```

- przegladanie użytkowników /users , /users/{user_id}

- usuwanie użytkowników 
DELETE /users/{user_id}

## Użytkownik  

- przeglądanie dostępnych książek /books/free
- wypożyczenia użytkownika /loans
- wypożyczenie książki  
POST /loans/{book_id}  
Użytkownik może wypożyczyć jednocześnie max. 5 książek
- zwrot wypożyczonej książki  
DELETE/loans/{book_id}

