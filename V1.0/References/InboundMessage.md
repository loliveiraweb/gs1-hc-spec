# InboundMessage Reference

The InboundMessage is used to package the information to be sent from one partner to another.

### Fields of the Message

|Field|Description|Data Type|Sample|Note|
|-----|-----------|---------|------|----|
|id|The id of the Message|Alphanumeric String|123456978696050595050AAAABBBDDDDD| The ID have to be unique inside the Trading Partner|
|date|The date of the Message Generation|Datetime with Timezone|2021-10-03T22:06:45Z| The date reference is always defined with GMT-0|
|schemaVersion|The version of the GS1 HC Schema used|Double|1.0||
|sender|Sender |Partner (see XSD)|```<sender><partnerKey>CNPJ</partnerKey><partnerValue>15041786000176</partnerValue></sender>```||
|receiver|Receiver|Partner (see XSD)|```<receiver><partnerKey>CNPJ</partnerKey><partnerValue>15041786000176</partnerValue></receiver>```||
|mbrAgt|Authorized Agent|Partner (see XSD)|```<mbrAgt><partnerKey>CNPJ</partnerKey><partnerValue>15041786000176</partnerValue></mbrAgt>```|Use this field if you are sending using the Authorization|
|content|The content of the Message|Content (see XSD)|```<content><fileURL>https://sampleurl.sampledomain.com/fileXXXXXXXX.xml</fileURL></content>```||
|additionalInfo|Tag/Value field to send and receive additional information in the transaction|additionalInfo (see XSD)|```<additionalInfo><info key="AttorneyAuthorization">https://files.xxxx.com/0000000111212.xml</info></additionalInfo>```|----|

##### Sample using fileURL

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<InboundMessage id="123456978696050595050AAAABBBDDDDD" date="2021-10-03T22:06:44Z" xmlns="http://hc.gs1br.org.br/">
    <sender>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15042274000195</partnerValue>
    </sender>
    <receiver>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15041786000176</partnerValue>
    </receiver>
    <carrier>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15042274000195</partnerValue>
    </carrier>
    <content>
        <fileURL>https://sampleurl.sampledomain.com/fileXXXXXXXX.xml</fileURL>
    </content>
</InboundMessage>
```


##### Sample using base64 content

```<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<InboundMessage id="123456978696050595050AAAABBBDDDDD" date="2021-10-03T22:06:44Z" schemaVersion="1.0" xmlns="http://hc.gs1br.org.br/">
    <sender>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15042274000195</partnerValue>
    </sender>
    <receiver>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15041786000176</partnerValue>
    </receiver>
    <carrier>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15042274000195</partnerValue>
    </carrier>
    <content format="SNCM" schemaVersion="1.0" encoding="XML">
        <fileContent>PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxyZXRfZXZ0T3V0IElkPSJwZngyNmJiODIzNS0zMTNmLTEyNzAtZTM2Yy0zODExY2FjZWIwZDMiPg0KCTxkb2NJZD5BQUFBQUFBQUFBQkJCQkJCQkJCQjwvZG9jSWQ+DQoJPGRjbHJudD4NCgkJPGNucGo+MDAwMDAwMDAwMDAwMDwvY25waj4NCgk8L2RjbHJudD4NCgk8Y2xudEZybXJUaW1lPjIwMjAtMDctMDhUMDE6MjU6MDlaPC9jbG50RnJtclRpbWU+DQoJPHZlcnNpb24+MjAxOC0wNi0wNzwvdmVyc2lvbj4NCgk8bG9jYWxlPnB0LUJSPC9sb2NhbGU+DQoJPGVudmlyPjI8L2VudmlyPg0KCTxiY2tPZmY+MDE8L2Jja09mZj4NCgk8blJlYz4wMDAwMDAwMDAwMDAwMDAwMDVRQjwvblJlYz4NCgk8cmVzdWx0cz4NCgkJPHJlc3VsdD4NCgkJCTxldnROb3RpZklkPjAwUllHMDBXQzBLT1JaTVlEMFBCPC9ldnROb3RpZklkPg0KCQkJPGV2dElkPjAwMDAwMDBBV1JXQTwvZXZ0SWQ+DQoJCQk8cmVzdWx0RXZ0Q29kZT4wMTkwMjwvcmVzdWx0RXZ0Q29kZT4NCgkJCTxyZXN1bHRFdnREZXNjcmlwdGlvbj5JbnN0w6JuY2lhIGRlIGV2ZW50byBwcm9jZXNzYWRhIGNvbSBzdWNlc3NvPC9yZXN1bHRFdnREZXNjcmlwdGlvbj4NCgkJPC9yZXN1bHQ+DQoJPC9yZXN1bHRzPg0KCTxyZXR1cm5zPg0KCQk8cmV0dXJuPg0KCQkJPHJldHVybkNvZGU+MDAwMDU8L3JldHVybkNvZGU+DQoJCQk8cmV0dXJuRGVzY3JpcHRpb24+Q29uc3VsdGEgZG8gcHJvY2Vzc2FtZW50byBlZmV0dWFkYSBjb20gc3VjZXNzbzwvcmV0dXJuRGVzY3JpcHRpb24+DQoJCTwvcmV0dXJuPg0KCTwvcmV0dXJucz4NCgk8YW5vbT5mYWxzZTwvYW5vbT4NCgk8bm90aWY+ZmFsc2U8L25vdGlmPg0KCTxhY3Rpb24+ZmFsc2U8L2FjdGlvbj4NCgk8U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj4NCgkJPFNpZ25lZEluZm8+DQoJCQk8Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8+DQoJCQk8U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxkc2lnLW1vcmUjcnNhLXNoYTI1NiIvPg0KCQkJPFJlZmVyZW5jZSBVUkk9IiNwZngyNmJiODIzNS0zMTNmLTEyNzAtZTM2Yy0zODExY2FjZWIwZDMiPg0KCQkJCTxUcmFuc2Zvcm1zPg0KCQkJCQk8VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiLz4NCgkJCQkJPFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8+DQoJCQkJPC9UcmFuc2Zvcm1zPg0KCQkJCTxEaWdlc3RNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGVuYyNzaGEyNTYiLz4NCgkJCQk8RGlnZXN0VmFsdWU+eTJob3ExMHNuTmtRRVIwaWtpWXZCYjNyY2dqdk5BTTh0elF1SC9QaDVYRT08L0RpZ2VzdFZhbHVlPg0KCQkJPC9SZWZlcmVuY2U+DQoJCTwvU2lnbmVkSW5mbz4NCgkJPFNpZ25hdHVyZVZhbHVlPm9KNDdDTitoNjhyVWRuRzhobGNvYnFwZTNYeXl5MEZnSUNJeStUVFBSUEUxV3haNnVuNDl2ZWVCNU9OTG4zeFNYN3hvUDF0RUR2bThMZEtSQ0JWLzUzMGZZM016MitPOWp6M2lza3gxQWlNVVRVTXlNRGJKeUN1SEh2M3FGc2pqbTgwNXpjWEJRekVtNXRtbVZFTTJINWREbWpzOW9mNW9rS3RGWGp2T3V6YzlURkVrZFFLM29WM01PVmxLN1ZUblFJT2hOc1J3U3ArVEM2SFRlUkNwU1RpMldBZDZKSlNCcS8yWkVKY2JDalBFK1g1bkNkSWxCZ0VOOXlDUlNuV2RuMHgyOFpraGR1T1B3ZVQzYWRlbDZ5ZWdGYWprTldxLzNPNUIxMy8xWm5USW5lUDlvY3RkLzlLUmN5Z2pDenNxeWg4SjdqRHlaTE41ZG4zK0VacVZpUT09PC9TaWduYXR1cmVWYWx1ZT4NCgkJPEtleUluZm8+DQoJCQk8WDUwOURhdGE+DQoJCQkJPFg1MDlDZXJ0aWZpY2F0ZT5NSUlEOVRDQ0F0MmdBdy4uLi4uLnNIWjU8L1g1MDlDZXJ0aWZpY2F0ZT4NCgkJCTwvWDUwOURhdGE+DQoJCTwvS2V5SW5mbz4NCgk8L1NpZ25hdHVyZT4NCjwvcmV0X2V2dE91dD4NCg==</fileContent>
    </content>
</InboundMessage>
```

##### Sample with mbrAgt

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<InboundMessage id="123456978696050595050AAAABBBDDDDD" date="2021-10-04T05:42:20Z" schemaVersion="1.0" xmlns="http://hc.gs1br.org.br/">
    <sender>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15042274000195</partnerValue>
    </sender>
    <mbrAgt>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15041786000258</partnerValue>
    </mbrAgt>
    <receiver>
        <partnerKey>CNPJ</partnerKey>
        <partnerValue>15041786000176</partnerValue>
    </receiver>
    <content format="SNCM" schemaVersion="1.0" encoding="XML">
        <fileContent>PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxyZXRfZXZ0T3V0IElkPSJwZngyNmJiODIzNS0zMTNmLTEyNzAtZTM2Yy0zODExY2FjZWIwZDMiPg0KCTxkb2NJZD5BQUFBQUFBQUFBQkJCQkJCQkJCQjwvZG9jSWQ+DQoJPGRjbHJudD4NCgkJPGNucGo+MDAwMDAwMDAwMDAwMDwvY25waj4NCgk8L2RjbHJudD4NCgk8Y2xudEZybXJUaW1lPjIwMjAtMDctMDhUMDE6MjU6MDlaPC9jbG50RnJtclRpbWU+DQoJPHZlcnNpb24+MjAxOC0wNi0wNzwvdmVyc2lvbj4NCgk8bG9jYWxlPnB0LUJSPC9sb2NhbGU+DQoJPGVudmlyPjI8L2VudmlyPg0KCTxiY2tPZmY+MDE8L2Jja09mZj4NCgk8blJlYz4wMDAwMDAwMDAwMDAwMDAwMDVRQjwvblJlYz4NCgk8cmVzdWx0cz4NCgkJPHJlc3VsdD4NCgkJCTxldnROb3RpZklkPjAwUllHMDBXQzBLT1JaTVlEMFBCPC9ldnROb3RpZklkPg0KCQkJPGV2dElkPjAwMDAwMDBBV1JXQTwvZXZ0SWQ+DQoJCQk8cmVzdWx0RXZ0Q29kZT4wMTkwMjwvcmVzdWx0RXZ0Q29kZT4NCgkJCTxyZXN1bHRFdnREZXNjcmlwdGlvbj5JbnN0w6JuY2lhIGRlIGV2ZW50byBwcm9jZXNzYWRhIGNvbSBzdWNlc3NvPC9yZXN1bHRFdnREZXNjcmlwdGlvbj4NCgkJPC9yZXN1bHQ+DQoJPC9yZXN1bHRzPg0KCTxyZXR1cm5zPg0KCQk8cmV0dXJuPg0KCQkJPHJldHVybkNvZGU+MDAwMDU8L3JldHVybkNvZGU+DQoJCQk8cmV0dXJuRGVzY3JpcHRpb24+Q29uc3VsdGEgZG8gcHJvY2Vzc2FtZW50byBlZmV0dWFkYSBjb20gc3VjZXNzbzwvcmV0dXJuRGVzY3JpcHRpb24+DQoJCTwvcmV0dXJuPg0KCTwvcmV0dXJucz4NCgk8YW5vbT5mYWxzZTwvYW5vbT4NCgk8bm90aWY+ZmFsc2U8L25vdGlmPg0KCTxhY3Rpb24+ZmFsc2U8L2FjdGlvbj4NCgk8U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj4NCgkJPFNpZ25lZEluZm8+DQoJCQk8Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8+DQoJCQk8U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxkc2lnLW1vcmUjcnNhLXNoYTI1NiIvPg0KCQkJPFJlZmVyZW5jZSBVUkk9IiNwZngyNmJiODIzNS0zMTNmLTEyNzAtZTM2Yy0zODExY2FjZWIwZDMiPg0KCQkJCTxUcmFuc2Zvcm1zPg0KCQkJCQk8VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiLz4NCgkJCQkJPFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8+DQoJCQkJPC9UcmFuc2Zvcm1zPg0KCQkJCTxEaWdlc3RNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGVuYyNzaGEyNTYiLz4NCgkJCQk8RGlnZXN0VmFsdWU+eTJob3ExMHNuTmtRRVIwaWtpWXZCYjNyY2dqdk5BTTh0elF1SC9QaDVYRT08L0RpZ2VzdFZhbHVlPg0KCQkJPC9SZWZlcmVuY2U+DQoJCTwvU2lnbmVkSW5mbz4NCgkJPFNpZ25hdHVyZVZhbHVlPm9KNDdDTitoNjhyVWRuRzhobGNvYnFwZTNYeXl5MEZnSUNJeStUVFBSUEUxV3haNnVuNDl2ZWVCNU9OTG4zeFNYN3hvUDF0RUR2bThMZEtSQ0JWLzUzMGZZM016MitPOWp6M2lza3gxQWlNVVRVTXlNRGJKeUN1SEh2M3FGc2pqbTgwNXpjWEJRekVtNXRtbVZFTTJINWREbWpzOW9mNW9rS3RGWGp2T3V6YzlURkVrZFFLM29WM01PVmxLN1ZUblFJT2hOc1J3U3ArVEM2SFRlUkNwU1RpMldBZDZKSlNCcS8yWkVKY2JDalBFK1g1bkNkSWxCZ0VOOXlDUlNuV2RuMHgyOFpraGR1T1B3ZVQzYWRlbDZ5ZWdGYWprTldxLzNPNUIxMy8xWm5USW5lUDlvY3RkLzlLUmN5Z2pDenNxeWg4SjdqRHlaTE41ZG4zK0VacVZpUT09PC9TaWduYXR1cmVWYWx1ZT4NCgkJPEtleUluZm8+DQoJCQk8WDUwOURhdGE+DQoJCQkJPFg1MDlDZXJ0aWZpY2F0ZT5NSUlEOVRDQ0F0MmdBdy4uLi4uLnNIWjU8L1g1MDlDZXJ0aWZpY2F0ZT4NCgkJCTwvWDUwOURhdGE+DQoJCTwvS2V5SW5mbz4NCgk8L1NpZ25hdHVyZT4NCjwvcmV0X2V2dE91dD4NCg==</fileContent>
    </content>
    <additionalInfo>
        <info key="AttorneyAuthorization">https://files.xxxx.com/0000000111212.xml</info>
    </additionalInfo>
</InboundMessage>
```