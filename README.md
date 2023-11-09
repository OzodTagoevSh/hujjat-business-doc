# HUJJAT-BUSINESS - Integratsiyasi uchun yo'riqnoma

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

### Mana shu `API kalitlar` orqali foydalanuvchi `Hujjat`, `Shablon` yaratish va hokazo amaliyotlarni bajara olishi mumkin. 

## HUJJAT-BUSINESS API

### Quyida ana shu amaliyotlarga qisqacha misollarni ko'rishimiz mumkin:

### 1. `/template/create`

Shablon yaratish uchun ishlatiladigan metod 

<strong> CURL orqali so'rovga misol: </strong>

```
curl -v -H 'docKey: 5K2W7Bz5F2A' -X POST -d '{
    "type":"ftl",
    "name":"ready.ftl",
    "locale": {},
    "template":"PGh0bWw+SGVsbG8gd29ybGQhISE8L2h0bWw+..."
}' https://business.hujjat.uz/api/template/create
``` 
<strong> Postman orqali so'rovga misol: </strong>

![image4.png](images%2Fimage4.png)
<br>
<br>
![image5.png](images%2Fimage5.png)

HTTPda - header `docKey` - foydalanuvchini autentifikatsiya qilish uchun kerak bo'lading maxfiy kod

So'rovni tanasi Shablon yaratish uchun kerak bo'ladigan ma'lumotlardan iborat, bunda `type` - hujjatni `doc` yoki `ftl` turini aniqlash uchun,
`template` - .docx yoki .ftl shablonni `Base64` ko'rinishi.

So'rovga Javob:

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

HTTP 503 - Server bilan muammo yuzaga keldi 

HTTP 400 - So'rov parametrlarida xatolik bor. 

HTTP 200 - So'rov muvaffaqiyatli amalga oshirilgan.

<br>

### 2. `/document/create`

Hujjat yaratish uchun ishlatiladigan metod

<strong> CURL orqali so'rovga misol: </strong>

```
curl -v -H 'docKey: nXCAnCp2S4A' -X POST -d '{
    "oldId": null,
    "oldPin": null,
    "pdfView": true,
    "attachments": [],
    "attributes": {
        "type": "application-otm"
    },
    "documentType": "DOC",
    "documentParams": {
        "templateId": "daddc220-4769-4313-a695-bd89f0889052",
        "lang": "uz",
        "model": {
            "name": "Namozov"
        },
        "signTemplateUrls": {
            "authorization": null,
            "create": null,
            "cancel": null,
            "reject": null
        },
        "script": "replaceSigners();replaceQrCode();replaceModel(payload.model);"
    },
    "signType": "EIMZO",
    "signParams": {
        "allowLevel": "ALL",
        "allows": [
            "50409006590040",
            "32301953160023"
        ]
    }
}' https://business.hujjat.uz/api/document/create
```
<strong> Postman orqali so'rovga misol: </strong>

![image6.png](images%2Fimage6.png)
<br>
<br>
![image7.png](images%2Fimage7.png)

HTTPda - header `docKey` - foydalanuvchini autentifikatsiya qilish uchun kerak bo'lading maxfiy kod

So'rovni tanasi Hujjat yaratish uchun kerak bo'ladigan ma'lumotlardan iborat

So'rovga Javob: 

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

HTTP 503 - Server bilan muammo yuzaga keldi

HTTP 400 - So'rov parametrlarida xatolik bor. 

HTTP 200 - So'rov muvaffaqiyatli amalga oshirilgan.

<br>

### 3. `sign-callback`

Foydalanuvchi hujjat bilan biror amaliyotni bajargandan so'ng, `business.hujjat.uz` hujjat holati o'zgarganligi haqida
client tomonidan berilgan `callback-api`ga so'rov jo'natadi

`business.hujjat.uz` dan quyidagi ko'rinishda so'rov yuboriladi
```
{
  "document": {
    "id": "dfa74fc7-5cd3-4c36-ab9d-5765b9a0ef77",
    "pin": "oR92xR98",
    "requestId": "f95ea9cR-8a3a-42ce-904a-e6c22a7d89e2",
    "shortId": "r71CfSi5FL3",
    "clientId": "hujjat",
    "state": "SIGNED",
    "attributes": {
      "type": "social-register-poverty",
      "...": "..."
    },
    "documentLevel": 2,
    "documentType": "FTL_JSON",
    "signType": "EIMZO"
  },
  "event": {
    "documentId": "dfa74fc7-5cd3-4c36-ab9d-5765b9a0ef77",
    "type": "create",
    "note": "Any text",
    "fullName": "String",
    "organizationName": "O`ZBEKISTON RESPUBLIKASI YOSHLAR ISHLARI AGENTLIGI DEHQONOBOD TUMAN BO`LIMI",
    "eventDetails": {
      "uid": "32905333333333",
      "name": "Alisherov Alisher Alisherovich",
      "orgType": "PHYSICAL",
      "signerId": "32905333333333",
      "signMethod": "CREATE",
      "verifiedAt": 1691563542000,
      "...": "..."
    },
    "state": "ACTIVE",
    "verifiedAt": "2022-06-07 12:44:06"
  }
}
```

### `Callback-URL` qanday qilib yaratishni ko'rib chiqamiz

`bussiness.hujjat.uz` saytiga login qilib, `Tashkilotlar` bo'limiga o'tiladi va tanlangan tashkilotni `Sozlamalar` qismiga o'tiladi: 

![image8.png](images%2Fimage8.png)

`Sozlamalar` qismida `Hujjat parametrlari` qismiga o'tiladi: 

![image9.png](images%2Fimage9.png)

`Qaytarish URL manzili`ga `callback-url` beriladi va `Authorization header` turi yoziladi: 

![image10.png](images%2Fimage10.png)
