# HUJJAT-BUSINESS - Integratsiyasi uchun Yo'riqnoma

## HUJJAT-BUSINESS 

[//]: # (HUJJAT-BUSINESS-SERVER - Organizatsiya yaratgan paytingiz, sizga API-KEY beriladi, ana shu key bilan har qanday so'rovlarni bajarishingiz mumkin bo'ladi.)

### [bussiness.hujjat.uz](https://account.hujjat.uz/signup?referer=https://business.hujjat.uz&refererPath=/auth&redirect=/en-EN) saytga kirib registratsiya bo'limiga o'tiladi: 

![image.png](images%2Fimage.png)

### Registratsiya qilingandan so'ng, login qilib saytga kiriladi: 

![image1.png](images%2Fimage1.png)

### Saytda `Organizations` bo'limini tanlab, yangi organizatsiya yaratiladi: 

![image2.png](images%2Fimage2.png)

### Endi esa `Sozlamalar` bo'limiga o'tib, `API kalitlar`ni tanlansa, barcha yaratilgan organizatsiyalar uchun `API kalitlar`ni ko'rish mumkin:

![image3.png](images%2Fimage3.png)

### Mana shu `API kalitlar` orqali foydalanuvchi `Document`, `Shablon` yaratish va hokazo amaliyotlarni bajara olishi mumkin. 

## HUJJAT-BUSINESS SERVER

### Quyida ana shu amaliyotlarga qisqacha misollarni ko'rishimiz mumkin:

### 1. `/template/create`

##### Shablon yaratish uchun ishlatiladigan metod 

##### CURL orqali so'rovga misol:

```
curl -v -H 'docKey: F32aycX57Lm' -X POST -d '{
    "type":"ftl",
    "name":"ready.ftl",
    "locale": {},
    "template":"PGh0bWw+SGVsbG8gd29ybGQhISE8L2h0bWw+"
}' https://business.hujjat.uz/template/create
```
##### Postman orqali so'rovga misol:
```

```
##### HTTPda - header `docKey` - foydalanuvchini autentifikatsiya qilish uchun kerak bo'lading maxfiy code
##### So'rovni tanasi Shablon yaratish uchun kerak bo'ladigan datadan iborat

##### So'rovga Javob: 

```
{
    "id": "8a654b08-1079-40f8-af32-0f55949ecd52",
    "clientId": "platon_dev",
    "state": "ACTIVE",
    "templateType": "FTL",
    "originalFileName": "factura-test.ftlh",
    "title": "Factura",
    "linkType": "EXPIRE",
    "linkExpireDays": 7
    "version": 0,
    "createdAt": "2021-08-19 23:52:14",
    "updatedAt": "2021-08-19 23:52:14",
    "deleted": false
}
```

##### HTTP 503 - HUJJAT-BUSINESS-SERVER logini ko'ring 
##### HTTP 400 - So'rov parametrlarida xatolik bor. HUJJAT-BUSINESS-SERVER logini ko'ring 
##### HTTP 200 - So'rov muvaffaqiyatli amalga oshirilgan
<br/>

### 2. `/document/create`

##### Document yaratish uchun ishlatiladigan metod

##### CURL orqali so'rovga misol:

```
curl -v -H 'docKey: F32aycX57Lm' -X POST -d '{
  "requestId": "8a654b08-1079-40f8-af32-0f55949ecd52",
  "oldId": "8a654b08-1079-40f8-af32-0f55949ecd52",
  "oldPin": "string",
  "attachments": [
    {
      "title": "Hujjat.uz foydalanuvchi yo'riqnoma",
      "url": "https://hujjat.uz/help/instruction_uz.pdf",
      "extension": "pdf"
    }
  ],
  "attributes": {
    "customAttribute": 2
  },
  "documentType": "FTL_JSON",
  "documentParams": {
    "templateId": "0c8b7c17-bd85-4096-8315-d39bd66f3f4b",
    "lang": "uz",
    "model": {
      "modelField1": "demoField1",
      "modelField2": "demoField2"
    },
    "signTemplateUrls": {
      "authorization": "Basic aHVqamF0OjZMcFRrcEJ6N3I=",
      "create": "https://api.hujjat.uz/ru/facturas/5022699",
      "cancel": null,
      "reject": null
    }
  },
  "signType": "EIMZO",
  "expireAt": "2023-10-08",
  "signParams": {
    "allowLevel": "LEVEL",
    "allows": {
      "0": [
        "503554759"
      ],
      "1": [
        "302986679"
      ],
      "2": [
        "515443866"
      ]
    }
  },
  "additionalDocuments": {
    "8a654b08-1079-40f8-af32-0f55949ecd52": null
  },
  "notice": {
    "0": [
      "998991234567"
    ],
    "1": [
      "998909876543"
    ],
    "2": [
      "998977654321"
    ]
  }
}' https://business.hujjat.uz/document/create
```
##### Postman orqali so'rovga misol:
```

```
##### HTTPda - header `docKey` - foydalanuvchini autentifikatsiya qilish uchun kerak bo'lading maxfiy code
##### So'rovni tanasi Document yaratish uchun kerak bo'ladigan datadan iborat

##### So'rovga Javob:

```
{
    "requestId": "b9e8c658-e0ba-4218-a14f-bdcfc842898e",
    "shortId": "vD1s1Knspd9",
    "id": "28ebae21-2b56-4e2d-9f0b-670c8e2a054f",
    "pin": "yF32vX21",
    "documentUrl": "https://hujjat.uz/document?pin=yF32vX21&id=28ebae21-2b56-4e2d-9f0b-670c8e2a054f",
    "shortLink": "https://urls.uz/XS5QaZz17o",
    "linkExpiredAt": "2024-11-07 10:34:29",
    "expireAt": "2023-11-09T05:34:28.992+00:00"
}
```

##### HTTP 503 - HUJJAT-BUSINESS-SERVER logini ko'ring
##### HTTP 400 - So'rov parametrlarida xatolik bor. HUJJAT-BUSINESS-SERVER logini ko'ring
##### HTTP 200 - So'rov muvaffaqiyatli amalga oshirilgan 