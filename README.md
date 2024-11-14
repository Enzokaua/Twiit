# Twiit - Plataforma social pessoal

> Twiit é um desenvolvimento pessoal de como funcionaria o back-end de uma aplicação de mídia social como o Instagram e o Facebook por exemplo. O projeto conta com escopos de segurança e autenticação utilizando geração de tokens
através do JWT e do OAuth2, suas funcionalidades são as necessárias para que este fluxo funcione corretamente. A aplicação tem as principais funcionalidades:
> - Um usuário administrador pode criar outros usuários;
> - Um usuário pode efetuar um login e assim terá um token de autenticação;
> - Todos os usuários logados consegue gerar tweets (Verificacao através do token quando efetuado o login);
> - Todos os usuários logados conseguem ver todos os tweets criados (com paginação)
> - Somente o usuário quem criou o seu tweet, pode deletá-lo;
> - Um usuário Administrador pode criar outros usuários Administradores;
> - Um usuário básico não pode criar usuários;

### 💻 Ajustes e melhorias

O projeto ainda está em desenvolvimento, não possuindo um frontend integrado com a aplicação, tendo que suas requisições sejam acessadas diretamente aos endpoints, sendo eles:

- Login de usuários (Post):
```
Request:
curl --location 'http://XXX.XXX.XXX:XXXX/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "XXXX", 
    "password": "XXXX"
}'

Response:
{
    "accessToken": "XXXXXXXXXXXXX...",
    "expiresIn": XXX
}
```

- Cadastro de usuários (Post):
```
Request:
curl --location 'http://XXX.XXX.XXX:XXXX/users' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer XXXXXXXXXXXX......' \
--data '{
    "username": "XXXXXXXXXX", 
    "password": "XXXXXXXXXX"
}'
```

- Busca usuários (Get):
```
Request:
curl --location --request GET 'http://XXX.XXX.XXX:XXXX/users' \
--header 'Content-Type: application/json' \
--header 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX' \
(Importante!!! o token passado deve ser de um usuário Administrador)

Response:
{
        "userId": "XXXXXXXXXXXXXXXX",
        "username": "XXXXXXXXXXXXXXXXXXX,
        "password": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
        "roles": [
            {
                "idRoles": X,
                "roleName": "BASIC"
            }
        ]
    },
    {
        "userId": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXa",
        "username": "XXXXXXXXX",
        "password": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
        "roles": [
            {
                "idRoles": X,
                "roleName": "ADMIN"
            }
        ]
    }
```

- Posta tweet (Post):
```
Request:
curl --location 'http://XXX.XXX.XXX:XXXX/tweets' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer XXXXXXXXXXXX......' \
--data '{
    "content": "XXXXXXXXXX"
}'
````

- Deleta tweet (Delete):
```
Request:
curl --location 'http://XXX.XXX.XXX:XXXX/tweets/{id_tweet}' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer XXXXXXXXXXXX......' \
````

- Feed de atualizações (Get):
```
Request:
curl --location --request GET 'http://XXX.XXX.XXX:XXXX/feed' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer XXXXXXXXXXXXXXXXXXXXXXXXXXXX' \
'

Response:
        {
            "tweetId": 3,
            "content": "hello word",
            "username": "admin"
        },
        {
            "tweetId": 2,
            "content": "hello word",
            "username": "admin"
        }
````

Em caso de dúvida ou alterações, estou a disposição. Abraços! 👋
